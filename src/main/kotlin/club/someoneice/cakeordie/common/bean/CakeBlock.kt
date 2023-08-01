package club.someoneice.cakeordie.common.bean

import club.someoneice.cakeordie.common.tile.TileCakeBase
import club.someoneice.cakeordie.init.BlockList
import club.someoneice.cakeordie.init.ItemList
import net.minecraft.core.BlockPos
import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.EntityBlock
import net.minecraft.world.level.block.SimpleWaterloggedBlock
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult

open class CakeBlock: Block(Properties.copy(Blocks.CAKE).strength(0.05F).lightLevel { 5 }.noOcclusion()), EntityBlock, SimpleWaterloggedBlock {
    protected fun restoreHunger(): Boolean = true

    override fun use(state: BlockState, world: Level, pos: BlockPos, player: Player, hand: InteractionHand, hit: BlockHitResult): InteractionResult {
        val tile = world.getBlockEntity(pos)
        if (player.mainHandItem.item == ItemList.SUPER_SUGAR && tile is TileCakeBase) {
            tile.canEatable = true
            return InteractionResult.SUCCESS
        }

        if (restoreHunger()) player.foodData.eat(3, 0.1F)
        world.playLocalSound(pos, SoundEvents.GENERIC_EAT, SoundSource.BLOCKS, 0.5f, 2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f, false)
        world.setBlock(pos, BlockList.BLOCK_PLANT.defaultBlockState(), 3)
        world.removeBlockEntity(pos)
        Items.SPYGLASS

        return InteractionResult.SUCCESS
    }

    override fun newBlockEntity(pos: BlockPos, state: BlockState): BlockEntity = TileCakeBase(pos, state)

    // open class CakeBlockItem(block: Block, properties: Properties = Properties().food(ItemList.FoodBean(3, 0.1F, alwaysEat = true))): BlockItem(block, properties)
    open class CakeBlockItem(block: Block, properties: Properties = Properties().food(ItemList.FoodBean(3, 0.1F, alwaysEat = true))): Item(properties)
}