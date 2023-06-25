package club.someoneice.cakeordie.init

import club.someoneice.cakeordie.COD
import club.someoneice.cakeordie.util.asItemStack
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTabs
import net.minecraftforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.forge.registerObject

object CreativeTabList {
    val REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, COD.MODID)

    val TAB_CAKE by REGISTRY.registerObject("cake_or_die.tab") {
        CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup.cake_or_die"))
            .icon { ItemList.CHILI_SAUCE.asItemStack() }
        .displayItems {
                _, output ->
                for (item in ItemList.REGISTRY.entries) output.accept(item.get())
        }.build()
    }
}