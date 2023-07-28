package club.someoneice.cakeordie.init

import club.someoneice.cakeordie.COD
import club.someoneice.cakeordie.common.bean.CakeBlock
import club.someoneice.cakeordie.common.bean.FoodBlock
import club.someoneice.cakeordie.common.block.BlockChiliCrop
import club.someoneice.cakeordie.common.block.BlockPinata
import club.someoneice.cakeordie.common.block.cake.CakeChili
import club.someoneice.cakeordie.common.block.cake.CakeRandom
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object BlockList {
    val REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, COD.MODID)

    val BLOCK_PLANT         by REGISTRY.registerObject("plant")                 { Block(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.01F).lightLevel { 1 }.noOcclusion()) }
    val PINATA              by REGISTRY.registerObject("pinata")                { BlockPinata() }
    val CHILI_CROP          by REGISTRY.registerObject("chili_crop")            { BlockChiliCrop() }

    val CAKE_RANDOM         by REGISTRY.registerObject("random_cake")           { CakeRandom() }
    val CAKE_CHOCO          by REGISTRY.registerObject("chocolate_cake")        { CakeBlock() }
    val CAKE_CHILI          by REGISTRY.registerObject("chili_cake")            { CakeChili() }
    val CAKE_APPLE          by REGISTRY.registerObject("apple_cake")            { CakeBlock() }

    val CAKE_RANDOM_BLOCK   by REGISTRY.registerObject("cake_random_block")     { CakeRandom.CakeRandomBlock() }
    val CAKE_CHOCO_BLOCK    by REGISTRY.registerObject("chocolate_cake_block")  { FoodBlock() }
    val CAKE_CHILI_BLOCK    by REGISTRY.registerObject("chili_cake_block")      { CakeChili.BlockCakeChili() }
    val CAKE_APPLE_BLOCK    by REGISTRY.registerObject("apple_cake_block")      { FoodBlock() }

}