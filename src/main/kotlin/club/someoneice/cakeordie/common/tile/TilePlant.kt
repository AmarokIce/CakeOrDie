package club.someoneice.cakeordie.common.tile

import club.someoneice.cakeordie.init.TileList
import net.minecraft.core.BlockPos
import net.minecraft.nbt.CompoundTag
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState

class TilePlant(pos: BlockPos, state: BlockState): BlockEntity(TileList.TILE_BOWL, pos, state) {
    var food: ItemStack = ItemStack.EMPTY

    override fun load(tag: CompoundTag) {
        super.load(tag)

        this.food = ItemStack.of(tag.getCompound("itemFood"))
    }

    override fun saveAdditional(tag: CompoundTag) {
        tag.put("itemFood", food.save(CompoundTag()))

        super.saveAdditional(tag)
    }

}