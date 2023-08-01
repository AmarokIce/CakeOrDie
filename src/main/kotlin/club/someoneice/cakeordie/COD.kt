package club.someoneice.cakeordie

import club.someoneice.cakeordie.common.particle.ColorPaperParticle
import club.someoneice.cakeordie.init.*
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
        SoundList.REGISTRY.register(MOD_BUS)
        EffectList.REGISTRY.register(MOD_BUS)
        ParticleList.REGISTRY.register(MOD_BUS)
        CreativeTabList.REGISTRY.register(MOD_BUS)

        MOD_BUS.register(this)
        MOD_BUS.register(this::initParticleClient)
    }

    @SubscribeEvent @OnlyIn(Dist.CLIENT)
    fun initParticleClient(event: RegisterParticleProvidersEvent) {
        event.registerSpriteSet(ParticleList.PARTY_PAPER_YELLOW) { ColorPaperParticle.Provider(it) }
        event.registerSpriteSet(ParticleList.PARTY_PAPER_BLUE)   { ColorPaperParticle.Provider(it) }
        event.registerSpriteSet(ParticleList.PARTY_PAPER_GREEN)  { ColorPaperParticle.Provider(it) }
    }
}