package club.someoneice.cakeordie.common.item

import club.someoneice.cakeordie.init.BlockList
import club.someoneice.cakeordie.init.EffectList
import club.someoneice.cakeordie.init.ItemList
import club.someoneice.cakeordie.util.instance
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

class ItemChili: BlockItem(BlockList.CHILI_CROP, Properties().food(ItemList.FoodBean(fast = false, alwaysEat = true))) {
    override fun finishUsingItem(item: ItemStack, world: Level, entity: LivingEntity): ItemStack {
        super.finishUsingItem(item, world, entity)
        entity.addEffect(EffectList.CHILI_FIRE.instance(20 * 2, 0))
        return item;
    }
}