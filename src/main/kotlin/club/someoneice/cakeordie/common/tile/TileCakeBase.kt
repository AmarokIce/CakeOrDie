package club.someoneice.cakeordie.common.tile

import club.someoneice.cakeordie.init.TileList
import net.minecraft.core.BlockPos
import net.minecraft.nbt.CompoundTag
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState

class TileCakeBase(pos: BlockPos, state: BlockState): BlockEntity(TileList.TILE_CAKE_BASE, pos, state) {
    var canEatable = true

    override fun load(tag: CompoundTag) {
        super.load(tag)

        this.canEatable = tag.getBoolean("canEatable")
    }

    override fun saveAdditional(tag: CompoundTag) {
        tag.putBoolean("canEatable", canEatable)

        super.saveAdditional(tag)
    }
}