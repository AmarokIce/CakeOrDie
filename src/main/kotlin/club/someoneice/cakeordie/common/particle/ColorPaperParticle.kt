package club.someoneice.cakeordie.common.particle

import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.client.particle.*
import net.minecraft.core.particles.SimpleParticleType
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn

class ColorPaperParticle(world: ClientLevel, x: Double, y: Double, z: Double) : TextureSheetParticle(world, x, y, z) {
    init {
        gravity = 0.45f
        friction = 0.999f
        xd *= 0.8
        yd *= 0.8
        zd *= 0.8
        yd = (random.nextFloat() * 0.4f + 0.05f).toDouble()
        quadSize *= random.nextFloat() * 1.4f + 0.2f
        lifetime = (16.0 / (Math.random() * 0.8 + 0.2)).toInt()
    }

    override fun getLightColor(light: Float): Int {
        val i = super.getLightColor(light)
        val k = i shr 16 and 255
        return 240 or (k shl 16)
    }

    override fun getRenderType(): ParticleRenderType = ParticleRenderType.PARTICLE_SHEET_OPAQUE

    @OnlyIn(Dist.CLIENT)
    class Provider(private val sprite: SpriteSet) : ParticleProvider<SimpleParticleType> {
        override fun createParticle(type: SimpleParticleType, world: ClientLevel, x: Double, y: Double, z: Double, dx: Double, dy: Double, dz: Double): Particle {
            val provider = ColorPaperParticle(world, x, y, z)
            provider.pickSprite(sprite)
            return provider
        }
    }
}