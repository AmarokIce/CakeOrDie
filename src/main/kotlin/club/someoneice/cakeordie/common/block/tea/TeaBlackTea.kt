package club.someoneice.cakeordie.common.block.tea

import club.someoneice.cakeordie.common.bean.TeaBlock
import club.someoneice.cakeordie.init.EffectList
import club.someoneice.cakeordie.util.instance
import net.minecraft.core.BlockPos
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult

class TeaBlackTea: TeaBlock() {
    override fun use(state: BlockState, world: Level, pos: BlockPos, player: Player, hand: InteractionHand, hit: BlockHitResult): InteractionResult {
        player.addEffect(EffectList.DIGESTION.instance(20 * 120, 0))
        return super.use(state, world, pos, player, hand, hit)
    }
}