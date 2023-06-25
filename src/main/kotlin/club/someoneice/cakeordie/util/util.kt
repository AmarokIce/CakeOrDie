package club.someoneice.cakeordie.util

import club.someoneice.cakeordie.init.ParticleList
import net.minecraft.util.Mth
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import java.util.Random

fun Item.asItemStack(size: Int = 1): ItemStack {
    return ItemStack(this, size)
}

fun Block.asItemStack(size: Int = 1): ItemStack {
    return ItemStack(this, size)
}

/** Return the effect's instance. */
fun MobEffect.instance(time: Int, lv: Int = 0): MobEffectInstance {
    return MobEffectInstance(this, time, lv)
}

/** Copy the effect instance, make sure a new object on somewhere. */
fun MobEffectInstance.copy(): MobEffectInstance {
    return this.effect.instance(this.duration, this.amplifier)
}

/** Set the count inline. */
fun ItemStack.setCountWithReturn(size: Int): ItemStack {
    this.count = size
    return this
}

fun Level.addParticleColorPaper(posX: Double, posY: Double, posZ: Double, size: Int = 40) {
    val rand = Random()
    for (i in 0 .. size) {
        val x = if (rand.nextBoolean()) (rand.nextInt(3) + Mth.floor(posX)).toDouble() else (-rand.nextInt(3) + Mth.floor(posX)).toDouble()
        val y = if (rand.nextBoolean()) (rand.nextInt(3) + Mth.floor(posY)).toDouble() else (-rand.nextInt(3) + Mth.floor(posY)).toDouble()
        val z = if (rand.nextBoolean()) (rand.nextInt(3) + Mth.floor(posZ)).toDouble() else (-rand.nextInt(3) + Mth.floor(posZ)).toDouble()

        val dx = (rand.nextDouble() - rand.nextDouble() + 1.0) * 5
        val dy = (rand.nextDouble() - rand.nextDouble() + 1.0) * 5
        val dz = (rand.nextDouble() - rand.nextDouble() + 1.0) * 5

        this.addParticle(ParticleList.PARTY_PAPER_YELLOW, x, y, z, dx, dy, dz)
        this.addParticle(ParticleList.PARTY_PAPER_YELLOW, x, y, z, dx, dy, dz)
        this.addParticle(ParticleList.PARTY_PAPER_YELLOW, x, y, z, dx, dy, dz)
        // TODO
    }
}

