package club.someoneice.cakeordie.common.item

import club.someoneice.cakeordie.common.bean.ItemBeans
import club.someoneice.cakeordie.init.EffectList
import club.someoneice.cakeordie.init.ItemList
import club.someoneice.cakeordie.util.addParticleColorPaper
import club.someoneice.cakeordie.util.instance
import com.google.common.collect.Lists
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

class ItemCandy: ItemBeans.ItemBase(Properties().food(ItemList.FoodBean(fast = true))) {
    companion object {
        val effects: List<MobEffect> = Lists.newArrayList(
            MobEffects.DIG_SPEED,
            MobEffects.MOVEMENT_SPEED,
            MobEffects.NIGHT_VISION,
            MobEffects.JUMP,
            MobEffects.LUCK,
            EffectList.CANDY_SMILE
        )
    }

    override fun finishUsingItem(item: ItemStack, world: Level, entity: LivingEntity): ItemStack {
        super.finishUsingItem(item, world, entity)

        if (!world.isClientSide) {
            if (world.random.nextDouble() > 0.4) entity.addEffect(effects[world.random.nextInt(effects.size)].instance(20 * 5, 0))
        }
        else world.addParticleColorPaper(entity.x, entity.y, entity.z, 5)

        return item
    }
}