package com.jerry.mekanismcraftitem.common.registry;

import com.jerry.mekanismcraftitem.common.CraftLang;
import com.jerry.mekanismcraftitem.common.content.blocktype.CraftMachine;
import mekanism.common.block.attribute.*;
import mekanism.common.registration.impl.BlockRegistryObject;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tier.EnergyCubeTier;
import mekanism.common.tile.TileEntityEnergyCube;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.function.Supplier;

public class CraftBlockTypes {

    // Energy Cubes
    public static final CraftMachine<TileEntityEnergyCube> CRAFT_BASIC_ENERGY_CUBE = createEnergyCube(EnergyCubeTier.BASIC, () -> CraftTileEntityTypes.CRAFT_BASIC_ENERGY_CUBE, () -> CraftBlocks.CRAFT_ADVANCED_ENERGY_CUBE);
    public static final CraftMachine<TileEntityEnergyCube> CRAFT_ADVANCED_ENERGY_CUBE = createEnergyCube(EnergyCubeTier.ADVANCED, () -> CraftTileEntityTypes.CRAFT_ADVANCED_ENERGY_CUBE, () -> CraftBlocks.CRAFT_ELITE_ENERGY_CUBE);
    public static final CraftMachine<TileEntityEnergyCube> CRAFT_ELITE_ENERGY_CUBE = createEnergyCube(EnergyCubeTier.ELITE, () -> CraftTileEntityTypes.CRAFT_ELITE_ENERGY_CUBE, () -> CraftBlocks.CRAFT_ULTIMATE_ENERGY_CUBE);
    public static final CraftMachine<TileEntityEnergyCube> CRAFT_ULTIMATE_ENERGY_CUBE = createEnergyCube(EnergyCubeTier.ULTIMATE, () -> CraftTileEntityTypes.CRAFT_ULTIMATE_ENERGY_CUBE, null);

    private static <TILE extends TileEntityEnergyCube> CraftMachine<TILE> createEnergyCube(EnergyCubeTier tier, Supplier<TileEntityTypeRegistryObject<TILE>> tile, Supplier<BlockRegistryObject<?, ?>> upgradeBlock) {
        return CraftMachine.CraftMachineBuilder.createMachine(tile, CraftLang.DESCRIPTION_CRAFT_ENERGY_CUBE)
                .with(new AttributeTier<>(tier), new AttributeUpgradeable(upgradeBlock), new AttributeStateFacing(BlockStateProperties.FACING))
                .without(AttributeParticleFX.class, AttributeStateActive.class, AttributeUpgradeSupport.class)
                .build();
    }
}
