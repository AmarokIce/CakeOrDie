package club.someoneice.cakeordie.common.item

import club.someoneice.cakeordie.common.bean.ItemBeans
import club.someoneice.cakeordie.util.LangInvitation
import club.someoneice.cakeordie.util.setCountWithReturn
import net.minecraft.nbt.CompoundTag
import net.minecraft.network.chat.Component
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.Level
import kotlin.math.floor

class ItemInvitation: ItemBeans.ItemBase() {
    override fun use(world: Level, player: Player, hand: InteractionHand): InteractionResultHolder<ItemStack> {
        val item = player.getItemInHand(hand)
        if (world.isClientSide || hand == InteractionHand.OFF_HAND) return InteractionResultHolder.pass(item)

        val tag = item.orCreateTag
        if (player.isShiftKeyDown) {
            val posNbt = CompoundTag()

            posNbt.putInt("x", floor(player.x).toInt())
            posNbt.putInt("y", floor(player.y).toInt())
            posNbt.putInt("z", floor(player.z).toInt())
            posNbt.putString("compere", player.displayName.string)

            tag.put("invitation_pos", posNbt)

            if (player.offhandItem != ItemStack.EMPTY)
                posNbt.put("gift", player.offhandItem.copy().setCountWithReturn(1).save(CompoundTag()))

            player.offhandItem.shrink(1)

            return InteractionResultHolder.success(item)
        } else if (tag.contains("invitation_pos")) {
            val nbt = tag.getCompound("invitation_pos")
            val x = nbt.getInt("x")
            val y = nbt.getInt("y")
            val z = nbt.getInt("z")

            player.teleportTo(x.toDouble(), y.toDouble(), z.toDouble())
            player.sendSystemMessage(Component.translatable(LangInvitation.InvitationInfoSuccess).append(nbt.getString("compere")))

            val gift = ItemStack.of(nbt.getCompound("gift"))
            player.addItem(gift)
            item.shrink(1)
            return InteractionResultHolder.success(item)
        }

        player.sendSystemMessage(Component.translatable(LangInvitation.InvitationInfoFail))
        return InteractionResultHolder.fail(item)
    }

    override fun appendHoverText(item: ItemStack, world: Level?, list: MutableList<Component>, flag: TooltipFlag) {
        val tag = item.orCreateTag
        if (tag.contains("invitation_pos")) {
            val nbt = tag.getCompound("invitation_pos")
            list.add(Component.translatable(LangInvitation.InvitationInfo))
            list.add(Component.translatable(LangInvitation.InvitationPos).append(nbt.getInt("x").toString() + ", " + nbt.getInt("y").toString() + ", " + nbt.getInt("z")))
            list.add(Component.translatable(LangInvitation.InvitationCompere).append(nbt.getString("compere")))

            if (nbt.contains("gift"))
                list.add(Component.translatable(LangInvitation.InvitationGift))
        }
    }
}