package club.someoneice.cakeordie.init

import club.someoneice.cakeordie.COD
import net.minecraft.core.particles.SimpleParticleType
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object ParticleList {
    val REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, COD.MODID)

    val PARTY_PAPER_YELLOW by REGISTRY.registerObject("party_paper_yellow") { SimpleParticleType(false) }
    val PARTY_PAPER_BLUE   by REGISTRY.registerObject("party_paper_blue")   { SimpleParticleType(false) }
    val PARTY_PAPER_GREEN  by REGISTRY.registerObject("party_paper_green")  { SimpleParticleType(false) }
}