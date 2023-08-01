package club.someoneice.cakeordie.client

import club.someoneice.cakeordie.COD
import club.someoneice.cakeordie.init.BlockList
import club.someoneice.cakeordie.init.ItemList
import net.minecraft.client.renderer.ItemBlockRenderTypes
import net.minecraft.client.renderer.RenderType
import net.minecraft.client.renderer.item.ItemProperties
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.EntityRenderersEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent


@Mod.EventBusSubscriber(modid = COD.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
object ClientRenderer {
    @SubscribeEvent
    fun registerRenderers(event: EntityRenderersEvent.RegisterRenderers) {
        // event.registerBlockEntityRenderer(TileList.TILE_BOWL, PlantRender())
    }

    @SubscribeEvent
    fun layout(event: FMLClientSetupEvent) {
        ItemBlockRenderTypes.setRenderLayer(BlockList.BLOCK_PLANT,  RenderType.cutout())
    }

    @SubscribeEvent
    fun propertyOverrideRegistry(event: FMLClientSetupEvent) {
        event.enqueueWork {
            ItemProperties.register(
                ItemList.INVITATION,
                ResourceLocation(COD.MODID, "is_invitation")
            ) { itemStack, _, _, _ ->
                val tag = itemStack.orCreateTag
                if (tag.contains("invitation_pos")) 1.0F else 0.0F
            }
        }
    }
}