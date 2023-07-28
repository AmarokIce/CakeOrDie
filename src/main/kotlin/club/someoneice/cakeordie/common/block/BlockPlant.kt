package club.someoneice.cakeordie.common.block

import club.someoneice.cakeordie.common.tile.TilePlant
import club.someoneice.cakeordie.util.setCountWithReturn
import net.minecraft.core.BlockPos
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.EntityBlock
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult

class BlockPlant: Block(Properties.copy(Blocks.GLASS)), EntityBlock {
    override fun newBlockEntity(pos: BlockPos, state: BlockState): BlockEntity = TilePlant(pos, state)

    override fun use(state: BlockState, world: Level, pos: BlockPos, player: Player, hand: InteractionHand, hit: BlockHitResult): InteractionResult {
        val tile = world.getBlockEntity(pos)
        if (tile is TilePlant) {
            tile.food = player.mainHandItem.copy().setCountWithReturn(64)
            tile.setChanged()
        }

        return InteractionResult.SUCCESS
    }
}