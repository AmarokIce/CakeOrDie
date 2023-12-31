package club.someoneice.cakeordie.common.bean

import club.someoneice.cakeordie.util.copy
import com.google.common.collect.Lists
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.UseAnim
import net.minecraft.world.level.Level

sealed class ItemBeans(properties: Properties = Properties()): Item(properties) {
    open public class ItemBase(properties: Properties = Properties()): ItemBeans(properties)
    open public class ItemFoodBase(properties: Properties, val isDrink: Boolean = false, private val returnItem: ItemStack = ItemStack.EMPTY, val effects: List<MobEffectInstance> = Lists.newArrayList<MobEffectInstance>()): ItemBeans(properties) {
        constructor(properties: Properties, isDrink: Boolean = false, returnItem: ItemStack = ItemStack.EMPTY, effects: Array<MobEffectInstance>) : this(properties, isDrink, returnItem, effects.asList())

        override fun finishUsingItem(item: ItemStack, world: Level, entity: LivingEntity): ItemStack {
            super.finishUsingItem(item, world, entity)
            if (entity is Player) {
                entity.addItem(returnItem)
                for (effect in effects) entity.addEffect(effect.copy())
            }

            return item
        }

        override fun getUseAnimation(item: ItemStack): UseAnim = if (isDrink) UseAnim.DRINK else UseAnim.EAT
    }
}
