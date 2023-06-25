package club.someoneice.cakeordie.init

import club.someoneice.cakeordie.COD
import club.someoneice.cakeordie.common.effect.EffectChili
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object EffectInit {
    val REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, COD.MODID)

    val CHILI_FIRE by REGISTRY.registerObject("chili_fire") { EffectChili() }

}