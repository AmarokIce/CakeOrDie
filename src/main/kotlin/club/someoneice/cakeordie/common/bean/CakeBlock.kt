package club.someoneice.cakeordie.common.bean

import club.someoneice.cakeordie.init.BlockList
import net.minecraft.core.BlockPos
import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult

open class CakeBlock: Block(Properties.copy(Blocks.CAKE).strength(0.05F).lightLevel { 5 }.noOcclusion()) {
    protected fun restoreHunger(): Boolean = true

    @Deprecated("Deprecated in Java")
    override fun use(state: BlockState, world: Level, pos: BlockPos, player: Player, hand: InteractionHand, hit: BlockHitResult): InteractionResult {
        if (restoreHunger()) player.foodData.eat(3, 0.1F)
        world.playLocalSound(pos, SoundEvents.GENERIC_EAT, SoundSource.BLOCKS, 0.5f, 2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f, false)
        world.setBlock(pos, BlockList.BLOCK_PLANT.defaultBlockState(), 3)
        world.removeBlockEntity(pos)

        return InteractionResult.FAIL
    }
}