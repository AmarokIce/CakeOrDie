package club.someoneice.cakeordie.client

import club.someoneice.cakeordie.COD
import club.someoneice.cakeordie.init.BlockList
import club.someoneice.cakeordie.init.ItemList
import club.someoneice.cakeordie.init.TileList
import club.someoneice.cakeordie.util.asItemStack
import net.minecraft.client.renderer.ItemBlockRenderTypes
import net.minecraft.client.renderer.ItemModelShaper
import net.minecraft.client.renderer.RenderType
import net.minecraft.client.renderer.block.model.ItemOverride
import net.minecraft.client.renderer.block.model.ItemOverrides
import net.minecraft.client.renderer.item.ItemProperties
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ItemStack
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.EntityRenderersEvent
import net.minecraftforge.client.model.generators.ItemModelBuilder
import net.minecraftforge.client.model.generators.ItemModelProvider
import net.minecraftforge.client.model.generators.loaders.ItemLayerModelBuilder
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