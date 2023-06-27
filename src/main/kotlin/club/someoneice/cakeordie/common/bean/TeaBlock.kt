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

open class TeaBlock: Block(Properties.copy(Blocks.GLASS).strength(0.02F).lightLevel { 8 }.noOcclusion()) {
    @Deprecated("Deprecated in Java")
    override fun use(state: BlockState, world: Level, pos: BlockPos, player: Player, hand: InteractionHand, hit: BlockHitResult): InteractionResult {
        world.playLocalSound(pos, SoundEvents.GENERIC_DRINK, SoundSource.BLOCKS, 0.5f, 2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f, false)
        world.setBlock(pos, BlockList.BLOCK_PLANT.defaultBlockState(), 3)
        world.removeBlockEntity(pos)

        return InteractionResult.SUCCESS
    }
}