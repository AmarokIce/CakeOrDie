package club.someoneice.teaordie

import club.someoneice.teaordie.block.ModBlocks
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(TOD.MODID)
object TOD {
    const val MODID = "teaordie";

    init {
        ModBlocks.REGISTRY.register(MOD_BUS)

    }
}