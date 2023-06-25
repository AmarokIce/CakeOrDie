package club.someoneice.cakeordie.common.item

import club.someoneice.cakeordie.common.bean.ItemBeans
import club.someoneice.cakeordie.util.addParticleColorPaper
import net.minecraft.core.Direction
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

class ColorPaperCannon: ItemBeans.ItemBase() {
    override fun use(world: Level, player: Player, hand: InteractionHand): InteractionResultHolder<ItemStack> {
        val item = player.getItemInHand(hand)

        if (!world.isClientSide) {
            when (player.motionDirection) {
                Direction.NORTH -> { world.addParticleColorPaper(player.x, player.y, player.z - 1) }
                Direction.SOUTH -> { world.addParticleColorPaper(player.x, player.y, player.z + 1) }
                Direction.WEST  -> { world.addParticleColorPaper(player.x - 1, player.y, player.z) }
                Direction.EAST  -> { world.addParticleColorPaper(player.x + 1, player.y, player.z) }
                Direction.UP    -> { world.addParticleColorPaper(player.x, player.y - 1, player.z) }
                Direction.DOWN  -> { world.addParticleColorPaper(player.x, player.y + 1, player.z) }
                else            -> { world.addParticleColorPaper(player.x, player.y, player.z) }
            }
            item.shrink(1)
        }
        return InteractionResultHolder.success(item)
    }
}