package club.someoneice.cakeordie

import club.someoneice.cakeordie.init.BlockList
import club.someoneice.cakeordie.init.CreativeTabList
import club.someoneice.cakeordie.init.EffectInit
import club.someoneice.cakeordie.init.ItemList
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(COD.MODID)
object COD {
    const val MODID = "cakeordie"

    init {
        ItemList.REGISTRY.register(MOD_BUS)
        BlockList.REGISTRY.register(MOD_BUS)
        EffectInit.REGISTRY.register(MOD_BUS)
        CreativeTabList.REGISTRY.register(MOD_BUS)
    }

    private fun tabCreate(icon: ItemStack, title: String, itemList: MutableList<ItemStack>? = null): CreativeModeTab {
        val builder = CreativeModeTab.builder()
        builder.icon { icon }
        builder.title(Component.translatable(title))
        builder.displayItems { _, output -> itemList?.let { output.acceptAll(it) } }
        return builder.build()
    }
}