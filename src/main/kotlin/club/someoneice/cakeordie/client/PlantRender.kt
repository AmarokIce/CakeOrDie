package club.someoneice.cakeordie.client

import club.someoneice.cakeordie.common.tile.TilePlant
import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.item.ItemEntity

class PlantRender<T : TilePlant>: BlockEntityRenderer<T>, BlockEntityRendererProvider<T> {
    private var item: ItemEntity? = null

    override fun create(context: BlockEntityRendererProvider.Context): BlockEntityRenderer<T> {
        return this
    }

    override fun render(entity: T, f: Float, pose: PoseStack, buffer: MultiBufferSource, i: Int, k: Int) {
        if (item == null) item = ItemEntity(entity.level!!, entity.blockPos.x.toDouble(), entity.blockPos.y.toDouble(), entity.blockPos.z.toDouble(), entity.food.copy())
        pose.pushPose()
        pose.translate(0.5, 0.25, 0.5)
        pose.scale(0.8f, 0.8f, 0.8f)
        item?.item = entity.food.copy()
        if (item != null)
            Minecraft.getInstance().entityRenderDispatcher.getRenderer<Entity>(item!!).render(item, f, 0.0F, pose, buffer, i)

        pose.pushPose()
        pose.translate(-0.350, -0.55, -0.74)
        pose.scale(0.4f, 0.4f, 0.1f)

        pose.popPose()
        pose.popPose()
    }
}