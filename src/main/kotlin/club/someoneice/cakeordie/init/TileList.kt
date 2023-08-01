package club.someoneice.cakeordie.init

import club.someoneice.cakeordie.COD
import club.someoneice.cakeordie.common.tile.TileCakeBase
import club.someoneice.cakeordie.common.tile.TileGift
import club.someoneice.cakeordie.common.tile.TilePlant
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object TileList {
    val REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, COD.MODID)

    val TILE_CAKE_BASE: BlockEntityType<TileCakeBase>   by REGISTRY.registerObject("cake_base") { BlockEntityType.Builder.of({ pos, state -> TileCakeBase(pos, state) },  BlockList.CAKE_RANDOM).build(null) }
    val TILE_BOWL     : BlockEntityType<TilePlant>      by REGISTRY.registerObject("bowl")      { BlockEntityType.Builder.of({ pos, state -> TilePlant(pos, state) }, TODO() ).build(null) }
    val TILE_GIFT     : BlockEntityType<TileGift>       by REGISTRY.registerObject("gift")      { BlockEntityType.Builder.of({ pos, state -> TileGift(pos, state) }, TODO() ).build(null) }
}