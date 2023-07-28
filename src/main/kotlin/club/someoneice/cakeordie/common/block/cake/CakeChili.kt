package club.someoneice.cakeordie.common.block.cake

import club.someoneice.cakeordie.common.bean.CakeBlock
import club.someoneice.cakeordie.common.bean.FoodBlock
import club.someoneice.cakeordie.init.BlockList
import club.someoneice.cakeordie.init.EffectList
import club.someoneice.cakeordie.util.instance
import net.minecraft.core.BlockPos
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult

class CakeChili: CakeBlock() {
    override fun use(state: BlockState, world: Level, pos: BlockPos, player: Player, hand: InteractionHand, hit: BlockHitResult): InteractionResult {
        super.use(state, world, pos, player, hand, hit)
        player.addEffect(EffectList.CHILI_FIRE.instance(20 * 5, 0))
        return InteractionResult.SUCCESS
    }

    class ItemCakeChili: CakeBlockItem(BlockList.CAKE_CHILI) {
        override fun finishUsingItem(item: ItemStack, world: Level, entity: LivingEntity): ItemStack {
            entity.addEffect(EffectList.CHILI_FIRE.instance(20 * 5, 0))
            return super.finishUsingItem(item, world, entity)
        }
    }

    class BlockCakeChili: FoodBlock() {
        override fun use(state: BlockState, world: Level, pos: BlockPos, player: Player, hand: InteractionHand, hit: BlockHitResult): InteractionResult {
            player.addEffect(EffectList.CHILI_FIRE.instance(20 * 5, 0))
            Blocks.WATER
            return super.use(state, world, pos, player, hand, hit)
        }
    }
}