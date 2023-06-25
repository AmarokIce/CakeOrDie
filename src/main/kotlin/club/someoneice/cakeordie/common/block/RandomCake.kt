package club.someoneice.cakeordie.common.block

import club.someoneice.cakeordie.common.bean.CakeBlock
import net.minecraft.core.BlockPos
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult

class RandomCake: CakeBlock() {
    override fun use(state: BlockState, world: Level, pos: BlockPos, player: Player, hand: InteractionHand, hit: BlockHitResult): InteractionResult {
        val x = pos.x + if (world.random.nextBoolean()) world.random.nextInt(10) else -world.random.nextInt(10)
        val y = pos.y + if (world.random.nextBoolean()) world.random.nextInt(10) else -world.random.nextInt(10)
        val z = pos.z + if (world.random.nextBoolean()) world.random.nextInt(10) else -world.random.nextInt(10)

        player.teleportTo(x.toDouble(), y.toDouble(), z.toDouble())

        super.use(state, world, pos, player, hand, hit)
        return InteractionResult.SUCCESS
    }
}