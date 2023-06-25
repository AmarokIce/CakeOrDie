package club.someoneice.cakeordie.common.block

import club.someoneice.cakeordie.util.addParticleColorPaper
import net.minecraft.core.BlockPos
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult

class Pinata: Block(Properties.copy(Blocks.GLASS)) {
    override fun use(state: BlockState, world: Level, pos: BlockPos, player: Player, hand: InteractionHand, hit: BlockHitResult): InteractionResult {
        if (!world.isClientSide) {
            world.addParticleColorPaper(player.x, player.y, player.z, 50)
            TODO("Not yet.")
        }
        return InteractionResult.SUCCESS
    }
}