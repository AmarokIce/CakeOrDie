package club.someoneice.cakeordie.common

import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.Block

fun Item.asItemStack(size: Int = 1): ItemStack {
    return ItemStack(this, size)
}

fun Block.asItemStack(size: Int = 1): ItemStack {
    return ItemStack(this, size)
}

fun MobEffect.instance(time: Int, lv: Int = 0): MobEffectInstance {
    return MobEffectInstance(this, time, lv)
}

fun MobEffectInstance.copy(): MobEffectInstance {
    return this.effect.instance(this.duration, this.amplifier)
}

fun ItemStack.setCountWithReturn(size: Int): ItemStack {
    this.count = size
    return this
}