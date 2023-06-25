package club.someoneice.cakeordie.common.effect

import net.minecraft.core.BlockPos
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.level.block.BaseFireBlock
import java.awt.Color
import kotlin.math.floor

class EffectChili: MobEffect(MobEffectCategory.HARMFUL, Color.RED.rgb) {
    override fun applyEffectTick(entity: LivingEntity, lv: Int) {
        super.applyEffectTick(entity, lv)
        entity.setSecondsOnFire(10)
        val world = entity.commandSenderWorld
        val pos = BlockPos(floor(entity.x).toInt(), floor(entity.y).toInt(), floor(entity.z).toInt())
        world.setBlock(pos, BaseFireBlock.getState(world, pos), 11)
    }

    override fun isDurationEffectTick(tick: Int, lv: Int): Boolean = true
}