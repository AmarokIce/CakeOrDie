package club.someoneice.cakeordie.common.block

import club.someoneice.cakeordie.init.ItemList
import club.someoneice.cakeordie.util.asItemStack
import net.minecraft.core.BlockPos
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Items
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult

class BlockBowl(private val drink: Bowl): Block(Properties.copy(Blocks.GLASS).strength(0.1F).lightLevel { 1 }.noOcclusion()) {
    override fun use(state: BlockState, world: Level, pos: BlockPos, player: Player, hand: InteractionHand, hit: BlockHitResult): InteractionResult {
        if (player.mainHandItem.`is`(Items.GLASS_BOTTLE)) {
            player.mainHandItem.shrink(1)
            when (drink) {
                Bowl.CHOCO -> player.addItem(ItemList.COCO_DRINK.asItemStack())
                Bowl.EGGNOG -> player.addItem(ItemList.EGGNOG.asItemStack())
            }
        }

        return InteractionResult.SUCCESS
    }

    companion object {
        enum class Bowl {
            CHOCO,
            EGGNOG
        }
    }
}