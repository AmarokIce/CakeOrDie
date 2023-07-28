package club.someoneice.cakeordie.init

import club.someoneice.cakeordie.COD
import club.someoneice.cakeordie.common.effect.EffectCandySmile
import club.someoneice.cakeordie.common.effect.EffectChili
import club.someoneice.cakeordie.common.effect.EffectDigestion
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object EffectList {
    val REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, COD.MODID)

    val CHILI_FIRE  by REGISTRY.registerObject("chili_fire")  { EffectChili() }
    val CANDY_SMILE by REGISTRY.registerObject("candy_smile") { EffectCandySmile() }
    val DIGESTION   by REGISTRY.registerObject("digestion")   { EffectDigestion() }
}