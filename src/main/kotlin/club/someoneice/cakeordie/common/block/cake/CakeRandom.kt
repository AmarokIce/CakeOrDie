package club.someoneice.cakeordie.common.block.cake

import club.someoneice.cakeordie.common.bean.CakeBlock
import club.someoneice.cakeordie.common.bean.FoodBlock
import club.someoneice.cakeordie.common.tile.TileCakeBase
import club.someoneice.cakeordie.init.BlockList
import club.someoneice.cakeordie.init.ItemList
import net.minecraft.core.BlockPos
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult

class CakeRandom: CakeBlock() {
    override fun use(state: BlockState, world: Level, pos: BlockPos, player: Player, hand: InteractionHand, hit: BlockHitResult): InteractionResult {
        val tile = world.getBlockEntity(pos)
        if (player.mainHandItem.item == ItemList.SUPER_SUGAR && tile is TileCakeBase) {
            tile.canEatable = true
            return InteractionResult.SUCCESS
        }

        super.use(state, world, pos, player, hand, hit)

        val x = pos.x + if (world.random.nextBoolean()) world.random.nextInt(10) else -world.random.nextInt(10)
        val y = pos.y + if (world.random.nextBoolean()) world.random.nextInt(10) else -world.random.nextInt(10)
        val z = pos.z + if (world.random.nextBoolean()) world.random.nextInt(10) else -world.random.nextInt(10)

        player.teleportTo(x.toDouble(), y.toDouble(), z.toDouble())

        return InteractionResult.SUCCESS
    }

    class CakeRandomItem: CakeBlockItem(BlockList.CAKE_RANDOM) {
        override fun finishUsingItem(item: ItemStack, world: Level, entity: LivingEntity): ItemStack {
            val x = entity.x + if (world.random.nextBoolean()) world.random.nextInt(10) else -world.random.nextInt(10)
            val y = entity.y + if (world.random.nextBoolean()) world.random.nextInt(10) else -world.random.nextInt(10)
            val z = entity.z + if (world.random.nextBoolean()) world.random.nextInt(10) else -world.random.nextInt(10)
            entity.teleportTo(x, y, z)

            return super.finishUsingItem(item, world, entity)
        }
    }

    class CakeRandomBlock: FoodBlock() {
        override fun use(state: BlockState, world: Level, pos: BlockPos, player: Player, hand: InteractionHand, hit: BlockHitResult): InteractionResult {
            super.use(state, world, pos, player, hand, hit)
            val x = player.x + if (world.random.nextBoolean()) world.random.nextInt(10) else -world.random.nextInt(10)
            val y = player.y + if (world.random.nextBoolean()) world.random.nextInt(10) else -world.random.nextInt(10)
            val z = player.z + if (world.random.nextBoolean()) world.random.nextInt(10) else -world.random.nextInt(10)
            player.teleportTo(x, y, z)
            return InteractionResult.SUCCESS
        }
    }
}