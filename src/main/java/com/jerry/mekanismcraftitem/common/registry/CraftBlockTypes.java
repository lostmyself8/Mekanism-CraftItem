package com.jerry.mekanismcraftitem.common.registry;

import com.jerry.mekanism_extras.common.block.attribute.ExtraAttributeTier;
import com.jerry.mekanism_extras.common.block.attribute.ExtraAttributeUpgradeable;
import com.jerry.mekanism_extras.common.block.storage.energycube.ECTier;
import com.jerry.mekanism_extras.common.block.storage.energycube.ExtraTileEntityEnergyCube;
import com.jerry.mekanismcraftitem.common.CraftLang;
import com.jerry.mekanismcraftitem.common.content.blocktype.CraftMachine;
import com.jerry.mekanismcraftitem.integration.Addons;
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
    // Extra Energy Cubes
    public static final CraftMachine<ExtraTileEntityEnergyCube> CRAFT_ABSOLUTE_ENERGY_CUBE = Addons.MEKANISM_EXTRAS.isLoaded() ? createExtraEnergyCube(ECTier.ABSOLUTE, () -> CraftTileEntityTypes.CRAFT_ABSOLUTE_ENERGY_CUBE, () -> CraftBlocks.CRAFT_SUPREME_ENERGY_CUBE) : null;
    public static final CraftMachine<ExtraTileEntityEnergyCube> CRAFT_SUPREME_ENERGY_CUBE = Addons.MEKANISM_EXTRAS.isLoaded() ? createExtraEnergyCube(ECTier.SUPREME, () -> CraftTileEntityTypes.CRAFT_SUPREME_ENERGY_CUBE, () -> CraftBlocks.CRAFT_COSMIC_ENERGY_CUBE) : null;
    public static final CraftMachine<ExtraTileEntityEnergyCube> CRAFT_COSMIC_ENERGY_CUBE = Addons.MEKANISM_EXTRAS.isLoaded() ? createExtraEnergyCube(ECTier.COSMIC, () -> CraftTileEntityTypes.CRAFT_COSMIC_ENERGY_CUBE, () -> CraftBlocks.CRAFT_INFINITE_ENERGY_CUBE) : null;
    public static final CraftMachine<ExtraTileEntityEnergyCube> CRAFT_INFINITE_ENERGY_CUBE = Addons.MEKANISM_EXTRAS.isLoaded() ? createExtraEnergyCube(ECTier.INFINITE, () -> CraftTileEntityTypes.CRAFT_INFINITE_ENERGY_CUBE, null) : null;

    private static <TILE extends TileEntityEnergyCube> CraftMachine<TILE> createEnergyCube(EnergyCubeTier tier, Supplier<TileEntityTypeRegistryObject<TILE>> tile, Supplier<BlockRegistryObject<?, ?>> upgradeBlock) {
        return CraftMachine.CraftMachineBuilder.createMachine(tile, CraftLang.DESCRIPTION_CRAFT_ENERGY_CUBE)
                .with(new AttributeTier<>(tier), new AttributeUpgradeable(upgradeBlock), new AttributeStateFacing(BlockStateProperties.FACING))
                .without(AttributeParticleFX.class, AttributeStateActive.class, AttributeUpgradeSupport.class)
                .build();
    }
    private static <TILE extends ExtraTileEntityEnergyCube> CraftMachine<TILE> createExtraEnergyCube(ECTier tier, Supplier<TileEntityTypeRegistryObject<TILE>> tile, Supplier<BlockRegistryObject<?, ?>> upgradeBlock) {
        return CraftMachine.CraftMachineBuilder.createMachine(tile, CraftLang.DESCRIPTION_CRAFT_ENERGY_CUBE)
                .with(new ExtraAttributeTier<>(tier), new ExtraAttributeUpgradeable(upgradeBlock), new AttributeStateFacing(BlockStateProperties.FACING))
                .without(AttributeParticleFX.class, AttributeStateActive.class, AttributeUpgradeSupport.class)
                .build();
    }
}
