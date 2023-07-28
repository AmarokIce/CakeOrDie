package club.someoneice.cakeordie.util

import club.someoneice.cakeordie.init.ParticleList
import net.minecraft.util.Mth
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import java.util.*
import kotlin.math.abs

fun Item.asItemStack(size: Int = 1): ItemStack {
    return ItemStack(this, size)
}

fun Block.asItemStack(size: Int = 1): ItemStack {
    return ItemStack(this, size)
}

/** Return the effect's instance. */
fun MobEffect.instance(time: Int, lv: Int = 0): MobEffectInstance = MobEffectInstance(this, time, lv)

/** Copy the effect instance, make sure a new object on somewhere. */
fun MobEffectInstance.copy(): MobEffectInstance = this.effect.instance(this.duration, this.amplifier)

/** Set the count inline. */
fun ItemStack.setCountWithReturn(size: Int): ItemStack {
    this.count = size
    return this
}

fun Any.random(): Random = Random()

fun Level.addParticleColorPaper(posX: Double, posY: Double, posZ: Double, size: Int = 50) {
    val rand = Random()
    if (!this.isClientSide) return
    for (i in 0 .. size) {
        val x = if (rand.nextBoolean()) (rand.nextDouble(1.6) + Mth.floor(posX)) else (-rand.nextDouble(1.6) + Mth.floor(posX))
        val z = if (rand.nextBoolean()) (rand.nextDouble(1.6) + Mth.floor(posZ)) else (-rand.nextDouble(1.6) + Mth.floor(posZ))

        val dx = if (rand.nextBoolean()) rand.nextDouble(0.2) else -rand.nextDouble(0.2)
        val dy = -(abs(rand.nextDouble() - rand.nextDouble()) + 0.1)
        val dz = if (rand.nextBoolean()) rand.nextDouble(0.2) else -rand.nextDouble(0.2)

        this.addParticle(ParticleList.PARTY_PAPER_YELLOW,   x, posY, z, dx + rand.nextDouble(0.4), dy, dz + rand.nextDouble(0.4))
        this.addParticle(ParticleList.PARTY_PAPER_YELLOW,   x, posY, z, dx - rand.nextDouble(0.4), dy, dz + rand.nextDouble(0.4))
        this.addParticle(ParticleList.PARTY_PAPER_YELLOW,   x, posY, z, dx + rand.nextDouble(0.4), dy, dz - rand.nextDouble(0.4))

        this.addParticle(ParticleList.PARTY_PAPER_BLUE,     x, posY, z, dx + rand.nextDouble(0.4), dy, dz + rand.nextDouble(0.4))
        this.addParticle(ParticleList.PARTY_PAPER_BLUE,     x, posY, z, dx - rand.nextDouble(0.4), dy, dz + rand.nextDouble(0.4))
        this.addParticle(ParticleList.PARTY_PAPER_BLUE,     x, posY, z, dx + rand.nextDouble(0.4), dy, dz - rand.nextDouble(0.4))

        this.addParticle(ParticleList.PARTY_PAPER_GREEN,    x, posY, z, dx + rand.nextDouble(0.4), dy, dz + rand.nextDouble(0.4))
        this.addParticle(ParticleList.PARTY_PAPER_GREEN,    x, posY, z, dx - rand.nextDouble(0.4), dy, dz + rand.nextDouble(0.4))
        this.addParticle(ParticleList.PARTY_PAPER_GREEN,    x, posY, z, dx + rand.nextDouble(0.4), dy, dz - rand.nextDouble(0.4))

        // TODO
    }

    fun Level.addParticleColorPaper(x: Double, y: Double, z: Double, size: Int, dx: Double, dy: Double, dz: Double) {
        for (o in 0 .. size) {
            this.addParticle(ParticleList.PARTY_PAPER_YELLOW, x, y, z, dx + rand.nextDouble(0.4), dy, dz + rand.nextDouble(0.4))
            this.addParticle(ParticleList.PARTY_PAPER_YELLOW, x, y, z, dx - rand.nextDouble(0.4), dy, dz + rand.nextDouble(0.4))
            this.addParticle(ParticleList.PARTY_PAPER_YELLOW, x, y, z, dx + rand.nextDouble(0.4), dy, dz - rand.nextDouble(0.4))

            this.addParticle(ParticleList.PARTY_PAPER_BLUE,   x, y, z, dx + rand.nextDouble(0.4), dy, dz + rand.nextDouble(0.4))
            this.addParticle(ParticleList.PARTY_PAPER_BLUE,   x, y, z, dx - rand.nextDouble(0.4), dy, dz + rand.nextDouble(0.4))
            this.addParticle(ParticleList.PARTY_PAPER_BLUE,   x, y, z, dx + rand.nextDouble(0.4), dy, dz - rand.nextDouble(0.4))

            this.addParticle(ParticleList.PARTY_PAPER_GREEN,  x, y, z, dx + rand.nextDouble(0.4), dy, dz + rand.nextDouble(0.4))
            this.addParticle(ParticleList.PARTY_PAPER_GREEN,  x, y, z, dx - rand.nextDouble(0.4), dy, dz + rand.nextDouble(0.4))
            this.addParticle(ParticleList.PARTY_PAPER_GREEN,  x, y, z, dx + rand.nextDouble(0.4), dy, dz - rand.nextDouble(0.4))
        }
    }
}

