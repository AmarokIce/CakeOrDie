package club.someoneice.cakeordie.common.item

import club.someoneice.cakeordie.common.bean.ItemBeans
import club.someoneice.cakeordie.init.EffectList
import club.someoneice.cakeordie.init.ItemList
import club.someoneice.cakeordie.init.ParticleList
import club.someoneice.cakeordie.util.instance
import com.google.common.collect.Lists
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

class Candy: ItemBeans.ItemBase(Properties().food(ItemList.FoodBean(fast = true))) {
    companion object {
        val effects: List<MobEffect> = Lists.newArrayList(
            MobEffects.DIG_SPEED,
            MobEffects.MOVEMENT_SPEED,
            MobEffects.NIGHT_VISION,
            MobEffects.JUMP,
            MobEffects.LUCK,
            MobEffects.UNLUCK,
            EffectList.CHILI_FIRE,
            EffectList.CANDY_SMILE
        )
    }

    override fun finishUsingItem(item: ItemStack, world: Level, entity: LivingEntity): ItemStack {
        super.finishUsingItem(item, world, entity)
        if (!world.isClientSide) {
            if (entity is Player) {
                if (world.random.nextDouble() > 0.4) entity.addEffect(effects[world.random.nextInt(effects.size)].instance(20 * 5, 0))
            }

            for (i in 0 .. 20) {
                val x = (world.random.nextDouble() - world.random.nextDouble() + 1.0) * 5
                val y = (world.random.nextDouble() - world.random.nextDouble() + 1.0) * 5
                val z = (world.random.nextDouble() - world.random.nextDouble() + 1.0) * 5
                world.addParticle(ParticleList.PARTY_PAPER_YELLOW, entity.x, entity.y, entity.z, (world.random.nextDouble() - world.random.nextDouble() + 1.0) * 5, (world.random.nextDouble() - world.random.nextDouble() + 1.0) * 5, (world.random.nextDouble() - world.random.nextDouble() + 1.0) * 5)
                world.addParticle(ParticleList.PARTY_PAPER_YELLOW, entity.x, entity.y, entity.z, (world.random.nextDouble() - world.random.nextDouble() + 1.0) * 5, (world.random.nextDouble() - world.random.nextDouble() + 1.0) * 5, (world.random.nextDouble() - world.random.nextDouble() + 1.0) * 5)
                world.addParticle(ParticleList.PARTY_PAPER_YELLOW, entity.x, entity.y, entity.z, (world.random.nextDouble() - world.random.nextDouble() + 1.0) * 5, (world.random.nextDouble() - world.random.nextDouble() + 1.0) * 5, (world.random.nextDouble() - world.random.nextDouble() + 1.0) * 5)
            }
        }
        return item
    }
}