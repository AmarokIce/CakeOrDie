package club.someoneice.cakeordie.init

import club.someoneice.cakeordie.COD
import club.someoneice.cakeordie.common.block.BlockPinata
import club.someoneice.cakeordie.common.block.cake.CakeRandom
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object BlockList {
    val REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, COD.MODID)

    val BLOCK_PLANT by REGISTRY.registerObject("plant")  { Block(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.01F).lightLevel { 1 }.noOcclusion()) }
    val PINATA      by REGISTRY.registerObject("pinata") { BlockPinata() }

    val CAKE_RANDOM by REGISTRY.registerObject("random_cake") { CakeRandom() }

}