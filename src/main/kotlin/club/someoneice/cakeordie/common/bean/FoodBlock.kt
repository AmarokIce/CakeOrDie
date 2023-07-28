package club.someoneice.cakeordie.common.bean

import club.someoneice.cakeordie.util.random
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
import net.minecraft.world.level.gameevent.GameEvent
import net.minecraft.world.phys.BlockHitResult

open class FoodBlock: Block(Properties.copy(Blocks.CAKE)) {
    override fun use(state: BlockState, world: Level, pos: BlockPos, player: Player, hand: InteractionHand, hit: BlockHitResult): InteractionResult {
        if (!world.isClientSide) {
            player.foodData.eat(2, 0.1F)
            world.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.BLOCKS)
            if (random().nextDouble() < 0.1) {
                world.removeBlock(pos, false)
                world.gameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Context.of(player, state))
            }
        }
        return InteractionResult.SUCCESS
    }
}