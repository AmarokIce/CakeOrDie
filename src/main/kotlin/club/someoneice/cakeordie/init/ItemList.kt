package club.someoneice.cakeordie.init

import club.someoneice.cakeordie.COD
import club.someoneice.cakeordie.common.bean.CakeBlock
import club.someoneice.cakeordie.common.bean.ItemBeans
import club.someoneice.cakeordie.common.block.cake.CakeChili
import club.someoneice.cakeordie.common.block.cake.CakeRandom
import club.someoneice.cakeordie.common.item.*
import club.someoneice.cakeordie.util.asItemStack
import club.someoneice.cakeordie.util.instance
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
    val INVITATION          by REGISTRY.registerObject("invitation")            { ItemInvitation() }
    val COLOR_PAPER         by REGISTRY.registerObject("color_paper")           { ItemBeans.ItemBase() }
    val PINATA_STICK        by REGISTRY.registerObject("pinata_stick")          { ItemBeans.ItemBase() }
    val COLOR_PAPER_CANNON  by REGISTRY.registerObject("color_cannon")          { ItemColorPaperCannon() }
    val SUPER_SUGAR         by REGISTRY.registerObject("super_sugar")           { ItemBeans.ItemBase() }

    /* Food */
    val CHILI               by REGISTRY.registerObject("chili")                 { ItemChili() }
    val CANDY               by REGISTRY.registerObject("candy")                 { ItemCandy() }
    val CHILI_SAUCE         by REGISTRY.registerObject("chili_sauce")           { ItemBeans.ItemFoodBase(Item.Properties().food(FoodBean(fast = true, alwaysEat = true)), isDrink = true, Items.GLASS_BOTTLE.asItemStack(), Lists.newArrayList(EffectList.CHILI_FIRE.instance(20 * 4, 0))) }
    val MEAT                by REGISTRY.registerObject("meat")                  { ItemBeans.ItemFoodBase(Item.Properties().food(FoodBean(6, 0.5F)), isDrink = false) }
    val APPLE_PIE           by REGISTRY.registerObject("apple_pie")             { ItemBeans.ItemFoodBase(Item.Properties().food(FoodBean(8, 0.5F))) }

    val EGGNOG              by REGISTRY.registerObject("eggnog")                { ItemBeans.ItemFoodBase(Item.Properties().food(FoodBean(2, 0.4F, alwaysEat = true)), isDrink = true, Items.GLASS_BOTTLE.asItemStack(), Lists.newArrayList(EffectList.DIGESTION.instance(20 * 30, 0))) }
    val COCO_DRINK          by REGISTRY.registerObject("coco_drink")            { ItemBeans.ItemFoodBase(Item.Properties().food(FoodBean(2, 0.4F, alwaysEat = true)), isDrink = true, Items.GLASS_BOTTLE.asItemStack(), Lists.newArrayList(EffectList.DIGESTION.instance(20 * 30, 0))) }
    val SODA_WATER          by REGISTRY.registerObject("soda_water")            { ItemBeans.ItemFoodBase(Item.Properties().food(FoodBean(2, 0.4F, alwaysEat = true)), isDrink = true, Items.GLASS_BOTTLE.asItemStack(), Lists.newArrayList(EffectList.DIGESTION.instance(20 * 30, 0))) }

    /* BlockItem*/
    val BLOCK_PLANT         by REGISTRY.registerObject("plant")                 { BlockItem(BlockList.BLOCK_PLANT, Item.Properties()) }
    val BLOCK_PINATA        by REGISTRY.registerObject("pinata")                { BlockItem(BlockList.PINATA, Item.Properties()) }
    val BLOCK_BOWL          by REGISTRY.registerObject("bowl")                  { BlockItem(BlockList.BLOCK_BOWL, Item.Properties()) }
    val BLOCK_CHOCO_BOWL    by REGISTRY.registerObject("choco_bowl")            { BlockItem(BlockList.CHOCO_BOWL, Item.Properties()) }
    val BLOCK_EGGNOG_BOWL   by REGISTRY.registerObject("eggnog_bowl")           { BlockItem(BlockList.EGGNOG_BOWL, Item.Properties()) }

    val BLOCK_RANDOM_CAKE   by REGISTRY.registerObject("block_random_cake")     { BlockItem(BlockList.CAKE_RANDOM_BLOCK, Item.Properties()) }
    val BLOCK_CHOCO_CAKE    by REGISTRY.registerObject("block_chocolate_cake")  { BlockItem(BlockList.CAKE_CHOCO_BLOCK, Item.Properties()) }
    val BLOCK_CHILI_CAKE    by REGISTRY.registerObject("block_chili_cake")      { BlockItem(BlockList.CAKE_CHILI_BLOCK, Item.Properties()) }
    val BLOCK_APPLE_CAKE    by REGISTRY.registerObject("block_apple_cake")      { BlockItem(BlockList.CAKE_APPLE_BLOCK, Item.Properties()) }

    /* Cake */
    val RANDOM_CAKE         by REGISTRY.registerObject("random_cake")           { CakeRandom.CakeRandomItem() }
    val CHOCO_CAKE          by REGISTRY.registerObject("chocolate_cake")        { CakeBlock.CakeBlockItem(BlockList.CAKE_CHOCO) }
    val CHILI_CAKE          by REGISTRY.registerObject("chili_cake")            { CakeChili.ItemCakeChili() }
    val APPLE_CAKE          by REGISTRY.registerObject("apple_cake")            { CakeBlock.CakeBlockItem(BlockList.CAKE_APPLE) }

    val EXPLODING_CAKE      by REGISTRY.registerObject("exploding_cale")        { ItemExplodingCake() }

    fun FoodBean(hunger: Int = 2, saturation: Float = 0.1F, wolf: Boolean = false, fast: Boolean = false, alwaysEat: Boolean = false): FoodProperties {
        val builder = FoodProperties.Builder()
        builder.nutrition(hunger)
        builder.saturationMod(saturation)

        if (wolf) builder.meat()
        if (fast) builder.fast()
        if (alwaysEat) builder.alwaysEat()

        return builder.build()
    }
}