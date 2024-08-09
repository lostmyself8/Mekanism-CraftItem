package com.jerry.mekanismcraftitem.common.registry;

import com.jerry.mekanism_extras.common.block.storage.energycube.ExtraTileEntityEnergyCube;
import com.jerry.mekanismcraftitem.MekanismCraftItem;
import com.jerry.mekanismcraftitem.integration.Addons;
import mekanism.common.registration.impl.TileEntityTypeDeferredRegister;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tile.TileEntityEnergyCube;
import mekanism.common.tile.base.TileEntityMekanism;
import net.minecraftforge.eventbus.api.IEventBus;

public class CraftTileEntityTypes {

    private static final TileEntityTypeDeferredRegister CRAFT_TILE_ENTITY_TYPES = new TileEntityTypeDeferredRegister(MekanismCraftItem.MOD_ID);

    //Energy Cubes
    public static final TileEntityTypeRegistryObject<TileEntityEnergyCube> CRAFT_BASIC_ENERGY_CUBE = CRAFT_TILE_ENTITY_TYPES.register(CraftBlocks.CRAFT_BASIC_ENERGY_CUBE, (pos, state) -> new TileEntityEnergyCube(CraftBlocks.CRAFT_BASIC_ENERGY_CUBE, pos, state), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    public static final TileEntityTypeRegistryObject<TileEntityEnergyCube> CRAFT_ADVANCED_ENERGY_CUBE = CRAFT_TILE_ENTITY_TYPES.register(CraftBlocks.CRAFT_ADVANCED_ENERGY_CUBE, (pos, state) -> new TileEntityEnergyCube(CraftBlocks.CRAFT_ADVANCED_ENERGY_CUBE, pos, state), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    public static final TileEntityTypeRegistryObject<TileEntityEnergyCube> CRAFT_ELITE_ENERGY_CUBE = CRAFT_TILE_ENTITY_TYPES.register(CraftBlocks.CRAFT_ELITE_ENERGY_CUBE, (pos, state) -> new TileEntityEnergyCube(CraftBlocks.CRAFT_ELITE_ENERGY_CUBE, pos, state), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);
    public static final TileEntityTypeRegistryObject<TileEntityEnergyCube> CRAFT_ULTIMATE_ENERGY_CUBE = CRAFT_TILE_ENTITY_TYPES.register(CraftBlocks.CRAFT_ULTIMATE_ENERGY_CUBE, (pos, state) -> new TileEntityEnergyCube(CraftBlocks.CRAFT_ULTIMATE_ENERGY_CUBE, pos, state), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient);

    public static final TileEntityTypeRegistryObject<ExtraTileEntityEnergyCube> CRAFT_ABSOLUTE_ENERGY_CUBE = Addons.MEKANISM_EXTRAS.isLoaded() ? CRAFT_TILE_ENTITY_TYPES.register(CraftBlocks.CRAFT_ABSOLUTE_ENERGY_CUBE, (pos, state) -> new ExtraTileEntityEnergyCube(CraftBlocks.CRAFT_ABSOLUTE_ENERGY_CUBE, pos, state), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient) : null;
    public static final TileEntityTypeRegistryObject<ExtraTileEntityEnergyCube> CRAFT_SUPREME_ENERGY_CUBE = Addons.MEKANISM_EXTRAS.isLoaded() ? CRAFT_TILE_ENTITY_TYPES.register(CraftBlocks.CRAFT_SUPREME_ENERGY_CUBE, (pos, state) -> new ExtraTileEntityEnergyCube(CraftBlocks.CRAFT_SUPREME_ENERGY_CUBE, pos, state), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient) : null;
    public static final TileEntityTypeRegistryObject<ExtraTileEntityEnergyCube> CRAFT_COSMIC_ENERGY_CUBE = Addons.MEKANISM_EXTRAS.isLoaded() ? CRAFT_TILE_ENTITY_TYPES.register(CraftBlocks.CRAFT_COSMIC_ENERGY_CUBE, (pos, state) -> new ExtraTileEntityEnergyCube(CraftBlocks.CRAFT_COSMIC_ENERGY_CUBE, pos, state), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient) : null;
    public static final TileEntityTypeRegistryObject<ExtraTileEntityEnergyCube> CRAFT_INFINITE_ENERGY_CUBE = Addons.MEKANISM_EXTRAS.isLoaded() ? CRAFT_TILE_ENTITY_TYPES.register(CraftBlocks.CRAFT_INFINITE_ENERGY_CUBE, (pos, state) -> new ExtraTileEntityEnergyCube(CraftBlocks.CRAFT_INFINITE_ENERGY_CUBE, pos, state), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient) : null;

    public static void register(IEventBus eventBus) {
        CRAFT_TILE_ENTITY_TYPES.register(eventBus);
    }
}
