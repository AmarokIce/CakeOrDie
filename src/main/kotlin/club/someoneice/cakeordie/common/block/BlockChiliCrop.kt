package club.someoneice.cakeordie.common.block

import club.someoneice.cakeordie.init.ItemList
import club.someoneice.cakeordie.util.asItemStack
import club.someoneice.cakeordie.util.random
import net.minecraft.core.BlockPos
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.CropBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.storage.loot.LootParams
import net.minecraft.world.phys.BlockHitResult

class BlockChiliCrop : CropBlock(Properties.copy(Blocks.WHEAT)) {
    override fun mayPlaceOn(state: BlockState, getter: BlockGetter, pos: BlockPos): Boolean {
        return state.`is`(Blocks.SOUL_SAND) || state.`is`(Blocks.SOUL_SOIL)
    }

    override fun getMaxAge(): Int = 3

    override fun use(state: BlockState, world: Level, pos: BlockPos, player: Player, hand: InteractionHand, hit: BlockHitResult): InteractionResult {
        if (this.isMaxAge(state)) player.addItem(ItemList.CHILI.asItemStack(random().nextInt(2) + 2))
        return InteractionResult.SUCCESS
    }

    override fun getDrops(state: BlockState, loot: LootParams.Builder): List<ItemStack> {
        val list = super.getDrops(state, loot)
        if (this.isMaxAge(state)) list.add(ItemList.CHILI.asItemStack(random().nextInt(2) + 2))
        return list;
    }
}