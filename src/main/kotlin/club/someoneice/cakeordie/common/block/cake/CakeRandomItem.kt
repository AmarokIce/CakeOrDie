package club.someoneice.cakeordie.common.block.cake

import club.someoneice.cakeordie.init.BlockList
import club.someoneice.cakeordie.init.ItemList
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

class CakeRandomItem: BlockItem(BlockList.CAKE_RANDOM, Properties().food(ItemList.FoodBean(0, 0.0F, alwaysEat = true))) {
    override fun finishUsingItem(item: ItemStack, world: Level, entity: LivingEntity): ItemStack {
        super.finishUsingItem(item, world, entity)


        val x = entity.x + if (world.random.nextBoolean()) world.random.nextInt(10) else -world.random.nextInt(10)
        val y = entity.y + if (world.random.nextBoolean()) world.random.nextInt(10) else -world.random.nextInt(10)
        val z = entity.z + if (world.random.nextBoolean()) world.random.nextInt(10) else -world.random.nextInt(10)

        entity.teleportTo(x, y, z)

        return super.finishUsingItem(item, world, entity)
    }

}