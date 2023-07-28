package club.someoneice.cakeordie.client

import club.someoneice.cakeordie.init.BlockList
import club.someoneice.cakeordie.init.TileList
import net.minecraft.client.renderer.ItemBlockRenderTypes
import net.minecraft.client.renderer.RenderType
import net.minecraftforge.client.event.EntityRenderersEvent
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent

object ClientRenderer {
    fun registerRenderers(event: EntityRenderersEvent.RegisterRenderers) {
        event.registerBlockEntityRenderer(TileList.TILE_BOWL, PlantRender())
    }

    fun layout(event: FMLClientSetupEvent) {
        ItemBlockRenderTypes.setRenderLayer(BlockList.BLOCK_PLANT,  RenderType.cutout())
    }
}