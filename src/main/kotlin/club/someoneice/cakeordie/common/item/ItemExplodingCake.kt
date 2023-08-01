package club.someoneice.cakeordie.common.item

import club.someoneice.cakeordie.common.bean.ItemBeans
import club.someoneice.cakeordie.init.ItemList.FoodBean
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Explosion
import net.minecraft.world.level.Level
import net.minecraft.world.level.Level.ExplosionInteraction

class ItemExplodingCake: ItemBeans.ItemFoodBase(Properties().food(FoodBean(1, 0.2F))) {
    override fun finishUsingItem(item: ItemStack, world: Level, entity: LivingEntity): ItemStack {
        world.explode(entity, entity.x, entity.y, entity.z, 3.0F, ExplosionInteraction.NONE)
        return super.finishUsingItem(item, world, entity)
    }
}