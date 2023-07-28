package club.someoneice.cakeordie.common.effect

import club.someoneice.cakeordie.util.instance
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.LivingEntity
import java.awt.Color

class EffectCandySmile: MobEffect(MobEffectCategory.BENEFICIAL, Color.YELLOW.rgb) {
    override fun isDurationEffectTick(tick: Int, lv: Int): Boolean = true
    override fun applyEffectTick(entity: LivingEntity, lv: Int) {
        super.applyEffectTick(entity, lv)
        if (entity.hurtMarked) entity.addEffect(MobEffects.MOVEMENT_SPEED.instance(20 * 3, 1))
    }
}