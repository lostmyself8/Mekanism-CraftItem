package com.jerry.mekanismcraftitem.integration.registry;

import com.jerry.mekanism_extras.common.block.storage.energycube.ExtraTileEntityEnergyCube;
import com.jerry.mekanismcraftitem.MekanismCraftItem;
import com.jerry.mekanismcraftitem.integration.Addons;
import mekanism.common.registration.impl.TileEntityTypeDeferredRegister;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tile.TileEntityEnergyCube;
import mekanism.common.tile.base.TileEntityMekanism;
import net.minecraftforge.eventbus.api.IEventBus;

public class CraftExtraTileEntityTypes {
    private static final TileEntityTypeDeferredRegister CRAFT_EXTRA_TILE_ENTITY_TYPES = new TileEntityTypeDeferredRegister(MekanismCraftItem.MOD_ID);

    public static final TileEntityTypeRegistryObject<ExtraTileEntityEnergyCube> CRAFT_ABSOLUTE_ENERGY_CUBE = Addons.MEKANISM_EXTRAS.isLoaded() ? CRAFT_EXTRA_TILE_ENTITY_TYPES.register(CraftExtraBlocks.CRAFT_ABSOLUTE_ENERGY_CUBE, (pos, state) -> new ExtraTileEntityEnergyCube(CraftExtraBlocks.CRAFT_ABSOLUTE_ENERGY_CUBE, pos, state), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient) : null;
    public static final TileEntityTypeRegistryObject<ExtraTileEntityEnergyCube> CRAFT_SUPREME_ENERGY_CUBE = Addons.MEKANISM_EXTRAS.isLoaded() ? CRAFT_EXTRA_TILE_ENTITY_TYPES.register(CraftExtraBlocks.CRAFT_SUPREME_ENERGY_CUBE, (pos, state) -> new ExtraTileEntityEnergyCube(CraftExtraBlocks.CRAFT_SUPREME_ENERGY_CUBE, pos, state), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient) : null;
    public static final TileEntityTypeRegistryObject<ExtraTileEntityEnergyCube> CRAFT_COSMIC_ENERGY_CUBE = Addons.MEKANISM_EXTRAS.isLoaded() ? CRAFT_EXTRA_TILE_ENTITY_TYPES.register(CraftExtraBlocks.CRAFT_COSMIC_ENERGY_CUBE, (pos, state) -> new ExtraTileEntityEnergyCube(CraftExtraBlocks.CRAFT_COSMIC_ENERGY_CUBE, pos, state), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient) : null;
    public static final TileEntityTypeRegistryObject<ExtraTileEntityEnergyCube> CRAFT_INFINITE_ENERGY_CUBE = Addons.MEKANISM_EXTRAS.isLoaded() ? CRAFT_EXTRA_TILE_ENTITY_TYPES.register(CraftExtraBlocks.CRAFT_INFINITE_ENERGY_CUBE, (pos, state) -> new ExtraTileEntityEnergyCube(CraftExtraBlocks.CRAFT_INFINITE_ENERGY_CUBE, pos, state), TileEntityMekanism::tickServer, TileEntityMekanism::tickClient) : null;

    public static void register(IEventBus eventBus) {
        CRAFT_EXTRA_TILE_ENTITY_TYPES.register(eventBus);
    }
}
