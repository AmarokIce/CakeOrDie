package club.someoneice.cakeordie.common.block

import club.someoneice.cakeordie.util.asItemStack
import net.minecraft.core.BlockPos
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.material.FluidState

class BlockBalloon: Block(Properties.of().noOcclusion().strength(0.01F).sound(SoundType.WOOL)) {
    override fun onDestroyedByPlayer(state: BlockState, world: Level, pos: BlockPos, player: Player, willHarvest: Boolean, fluid: FluidState): Boolean {
        super.onDestroyedByPlayer(state, world, pos, player, willHarvest, fluid)

        if (player.mainHandItem.isEmpty)
            world.addFreshEntity(ItemEntity(world, pos.x.toDouble(), pos.y.toDouble() + 0.5, pos.z.toDouble(), this.asItemStack()))

        return true
    }

    override fun stepOn(world: Level, pos: BlockPos, state: BlockState, entity: Entity) {
        world.removeBlock(pos, true)
    }


}