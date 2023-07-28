package club.someoneice.cakeordie.common.effect

import club.someoneice.cakeordie.util.asItemStack
import club.someoneice.cakeordie.util.random
import com.google.common.collect.Lists
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import java.awt.Color


class EffectDigestion: MobEffect(MobEffectCategory.BENEFICIAL, Color.RED.rgb) {
    override fun isDurationEffectTick(tick: Int, lv: Int): Boolean = true
    override fun getCurativeItems(): MutableList<ItemStack> = Lists.newArrayList(Items.ROTTEN_FLESH.asItemStack(), Items.SPIDER_EYE.asItemStack())
    override fun applyEffectTick(entity : LivingEntity, lv: Int) {
        if (!entity.level().isClientSide && entity is Player) {
            val food = entity.foodData
            val exhaustion = food.exhaustionLevel
            if (exhaustion > 15.0f)
                entity.causeFoodExhaustion(-random.nextFloat(exhaustion))
        }
    }
}