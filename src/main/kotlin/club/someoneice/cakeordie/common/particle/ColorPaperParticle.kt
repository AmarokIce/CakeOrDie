package club.someoneice.cakeordie.common.particle

import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.client.particle.*
import net.minecraft.core.particles.SimpleParticleType
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn

class ColorPaperParticle(world: ClientLevel, x: Double, y: Double, z: Double) : TextureSheetParticle(world, x, y, z) {
    init {
        gravity = 0.45f     // 重力，影响粒子坠落速度与上升时阻力
        friction = 0.999f   // 摩擦，刚体运动时的阻力
        xd *= 0.8           // 对点运动速度
        yd *= random.nextDouble() * 0.4 + 0.05
        zd *= 0.8

        // 实际大小，随机值
        quadSize *= random.nextFloat() * 1.4f + 0.2f

        // 存活时间
        lifetime = (16.0 / (Math.random() * 0.8 + 0.2)).toInt()
    }

    // 设置亮度着色器
    override fun getLightColor(light: Float): Int {
        val i = super.getLightColor(light)
        val k = i shr 16 and 255
        return 240 or (k shl 16)
    }

    // 渲染类型：实心（不存在半透明）
    override fun getRenderType(): ParticleRenderType = ParticleRenderType.PARTICLE_SHEET_OPAQUE

    // 供应器注册：供应器会在客户端上提交粒子最终需要的效果
    @OnlyIn(Dist.CLIENT)
    class Provider(private val sprite: SpriteSet) : ParticleProvider<SimpleParticleType> {
        override fun createParticle(type: SimpleParticleType, world: ClientLevel, x: Double, y: Double, z: Double, dx: Double, dy: Double, dz: Double): Particle {
            val provider = ColorPaperParticle(world, x, y, z)
            provider.pickSprite(sprite)
            return provider
        }
    }
}