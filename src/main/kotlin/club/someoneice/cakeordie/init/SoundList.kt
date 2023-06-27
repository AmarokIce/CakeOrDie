package club.someoneice.cakeordie.init

import club.someoneice.cakeordie.COD
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object SoundList {
    val REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, COD.MODID)

    val PARTY_DRAGON by REGISTRY.registerObject("party_dragon") { SoundEvent.createVariableRangeEvent(ResourceLocation(COD.MODID, "party_damage")) }

    val PINATA_0     by REGISTRY.registerObject("pinata0")      { SoundEvent.createVariableRangeEvent(ResourceLocation(COD.MODID, "pinata0")) }
    val PINATA_1     by REGISTRY.registerObject("pinata1")      { SoundEvent.createVariableRangeEvent(ResourceLocation(COD.MODID, "pinata1")) }
    val PINATA_2     by REGISTRY.registerObject("pinata2")      { SoundEvent.createVariableRangeEvent(ResourceLocation(COD.MODID, "pinata2")) }
}