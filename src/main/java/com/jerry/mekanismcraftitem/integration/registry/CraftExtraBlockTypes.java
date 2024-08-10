package com.jerry.mekanismcraftitem.integration.registry;

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

public class CraftExtraBlockTypes {
    // Extra Energy Cubes
    public static final CraftMachine<ExtraTileEntityEnergyCube> CRAFT_ABSOLUTE_ENERGY_CUBE = createExtraEnergyCube(ECTier.ABSOLUTE, () -> CraftExtraTileEntityTypes.CRAFT_ABSOLUTE_ENERGY_CUBE, () -> CraftExtraBlocks.CRAFT_SUPREME_ENERGY_CUBE);
    public static final CraftMachine<ExtraTileEntityEnergyCube> CRAFT_SUPREME_ENERGY_CUBE = createExtraEnergyCube(ECTier.SUPREME, () -> CraftExtraTileEntityTypes.CRAFT_SUPREME_ENERGY_CUBE, () -> CraftExtraBlocks.CRAFT_COSMIC_ENERGY_CUBE);
    public static final CraftMachine<ExtraTileEntityEnergyCube> CRAFT_COSMIC_ENERGY_CUBE = createExtraEnergyCube(ECTier.COSMIC, () -> CraftExtraTileEntityTypes.CRAFT_COSMIC_ENERGY_CUBE, () -> CraftExtraBlocks.CRAFT_INFINITE_ENERGY_CUBE);
    public static final CraftMachine<ExtraTileEntityEnergyCube> CRAFT_INFINITE_ENERGY_CUBE = createExtraEnergyCube(ECTier.INFINITE, () -> CraftExtraTileEntityTypes.CRAFT_INFINITE_ENERGY_CUBE, null);
    private static <TILE extends ExtraTileEntityEnergyCube> CraftMachine<TILE> createExtraEnergyCube(ECTier tier, Supplier<TileEntityTypeRegistryObject<TILE>> tile, Supplier<BlockRegistryObject<?, ?>> upgradeBlock) {
        return CraftMachine.CraftMachineBuilder.createMachine(tile, CraftLang.DESCRIPTION_CRAFT_ENERGY_CUBE)
                .with(new ExtraAttributeTier<>(tier), new ExtraAttributeUpgradeable(upgradeBlock), new AttributeStateFacing(BlockStateProperties.FACING))
                .without(AttributeParticleFX.class, AttributeStateActive.class, AttributeUpgradeSupport.class)
                .build();
    }
}
