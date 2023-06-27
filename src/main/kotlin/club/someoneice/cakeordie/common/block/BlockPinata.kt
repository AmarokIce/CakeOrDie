package club.someoneice.cakeordie.common.block

import club.someoneice.cakeordie.init.ItemList
import club.someoneice.cakeordie.init.SoundList
import club.someoneice.cakeordie.util.addParticleColorPaper
import club.someoneice.cakeordie.util.asItemStack
import com.google.common.collect.Lists
import net.minecraft.core.BlockPos
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundSource
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.storage.loot.LootParams
import net.minecraft.world.phys.BlockHitResult
import java.util.ArrayList

class BlockPinata: Block(Properties.copy(Blocks.GLASS).strength(0.4F).sound(SoundType.GLASS)) {
    companion object {
        val PINATA_SOUND_ARRAY: ArrayList<SoundEvent> = Lists.newArrayList<SoundEvent>(SoundList.PINATA_0, SoundList.PINATA_1, SoundList.PINATA_2)
    }

    @Deprecated("Deprecated in Java")
    override fun use(state: BlockState, world: Level, pos: BlockPos, player: Player, hand: InteractionHand, hit: BlockHitResult): InteractionResult {
        if (player.mainHandItem.item != ItemList.PINATA_STICK) return InteractionResult.PASS

        world.playSound(null, pos, PINATA_SOUND_ARRAY[world.random.nextInt(PINATA_SOUND_ARRAY.size)], SoundSource.BLOCKS)
        world.addParticleColorPaper(player.x, player.y, player.z)
        world.removeBlock(pos, true)
        TODO("Not finish yet.")

        return InteractionResult.SUCCESS
    }

    override fun getDrops(state: BlockState, build: LootParams.Builder): MutableList<ItemStack> {
        val list = Lists.newArrayList<ItemStack>(super.getDrops(state, build))
        list.add(this.asItemStack())
        return list
    }
}