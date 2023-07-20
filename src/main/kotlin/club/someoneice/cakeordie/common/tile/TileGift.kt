package club.someoneice.cakeordie.common.tile

import club.someoneice.cakeordie.init.TileList
import net.minecraft.core.BlockPos
import net.minecraft.nbt.CompoundTag
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState

class TileGift(pos: BlockPos, state: BlockState): BlockEntity(TileList.TILE_GIFT, pos, state) {
    var item: ItemStack = ItemStack.EMPTY

    override fun load(tag: CompoundTag) {
        super.load(tag)

        this.item = ItemStack.of(tag.getCompound("itemitem"))
    }

    override fun saveAdditional(tag: CompoundTag) {
        tag.put("itemitem", item.save(CompoundTag()))

        super.saveAdditional(tag)
    }
}