package club.someoneice.cakeordie.init

import club.someoneice.cakeordie.COD
import club.someoneice.cakeordie.common.asItemStack
import club.someoneice.cakeordie.common.bean.ItemBeans
import club.someoneice.cakeordie.common.instance
import club.someoneice.cakeordie.common.item.Invitation
import com.google.common.collect.Lists
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object ItemList {
    val REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, COD.MODID)

    /* Item */
    val INVITATION      by REGISTRY.registerObject("invitation") { Invitation() }

    /* Food */
    val CHILI_SAUCE     by REGISTRY.registerObject("chili_sauce") { ItemBeans.ItemFoodBase(Item.Properties().food(FoodBean(fast = true, alwaysEat = true)), isDrink = true, Items.GLASS_BOTTLE.asItemStack(), Lists.newArrayList(EffectInit.CHILI_FIRE.instance(20 * 20, 0))) }

    /* BlockItem*/
    val BLOCKITEM_PLANT by REGISTRY.registerObject("plant") { BlockItem(BlockList.BLOCK_PLANT, Item.Properties()) }

    fun FoodBean(hunger: Int = 2, saturation: Float = 0.1F, wolf: Boolean = false, fast: Boolean = false, alwaysEat: Boolean = false): FoodProperties {
        val builder = FoodProperties.Builder()
        builder.nutrition(hunger)
        builder.saturationMod(saturation)

        if (wolf) builder.meat()
        if (fast) builder.fast()
        if (alwaysEat) builder.alwaysEat()

        return builder.build()
    }

    // @Suppress("Deprecated")
    // fun registry(item: Item, name: String): Item = Registry.register(BuiltInRegistries.ITEM, ResourceLocation(COD.MODID, name), item)
}