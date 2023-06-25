package club.someoneice.cakeordie

import club.someoneice.cakeordie.init.*
import net.minecraft.client.particle.DragonBreathParticle
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn
import net.minecraftforge.client.event.RegisterParticleProvidersEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS


@Mod(COD.MODID)
object COD {
    const val MODID = "cakeordie"

    init {
        ItemList.REGISTRY.register(MOD_BUS)
        BlockList.REGISTRY.register(MOD_BUS)
        EffectList.REGISTRY.register(MOD_BUS)
        ParticleList.REGISTRY.register(MOD_BUS)
        CreativeTabList.REGISTRY.register(MOD_BUS)

        MOD_BUS.register(this)
    }

    /**
     *  Registry the particle in client.
     *  @see ParticleList
     *  */
    @SubscribeEvent @OnlyIn(Dist.CLIENT)
    fun initParticleClient(event: RegisterParticleProvidersEvent) {
        event.registerSpriteSet(ParticleList.PARTY_PAPER_YELLOW) { DragonBreathParticle.Provider(it) }
    }
}