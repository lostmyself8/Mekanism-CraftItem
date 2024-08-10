package com.jerry.mekanismcraftitem.integration.registry;

import com.jerry.mekanism_extras.common.api.tier.IAdvanceTier;
import com.jerry.mekanism_extras.common.block.attribute.ExtraAttributeTier;
import com.jerry.mekanism_extras.common.block.storage.energycube.ExtraTileEntityEnergyCube;
import com.jerry.mekanismcraftitem.MekanismCraftItem;
import com.jerry.mekanismcraftitem.common.block.CraftBlockEnergyCube;
import com.jerry.mekanismcraftitem.common.block.CraftExtraBlockEnergyCube;
import com.jerry.mekanismcraftitem.common.content.blocktype.CraftMachine;
import com.jerry.mekanismcraftitem.common.item.block.CraftExtraItemBlockEnergyCube;
import com.jerry.mekanismcraftitem.common.item.block.CraftItemBlockEnergyCube;
import com.jerry.mekanismcraftitem.integration.Addons;
import mekanism.api.tier.ITier;
import mekanism.common.block.attribute.AttributeTier;
import mekanism.common.registration.impl.BlockDeferredRegister;
import mekanism.common.registration.impl.BlockRegistryObject;
import mekanism.common.tile.TileEntityEnergyCube;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.Objects;

public class CraftExtraBlocks {
    public static final BlockDeferredRegister CRAFT_EXTRA_BLOCK = new BlockDeferredRegister(MekanismCraftItem.MOD_ID);

    public static final BlockRegistryObject<CraftExtraBlockEnergyCube, CraftExtraItemBlockEnergyCube> CRAFT_ABSOLUTE_ENERGY_CUBE = registerExtraEnergyCube(CraftExtraBlockTypes.CRAFT_ABSOLUTE_ENERGY_CUBE);
    public static final BlockRegistryObject<CraftExtraBlockEnergyCube, CraftExtraItemBlockEnergyCube> CRAFT_SUPREME_ENERGY_CUBE = registerExtraEnergyCube(CraftExtraBlockTypes.CRAFT_SUPREME_ENERGY_CUBE);
    public static final BlockRegistryObject<CraftExtraBlockEnergyCube, CraftExtraItemBlockEnergyCube> CRAFT_COSMIC_ENERGY_CUBE = registerExtraEnergyCube(CraftExtraBlockTypes.CRAFT_COSMIC_ENERGY_CUBE);
    public static final BlockRegistryObject<CraftExtraBlockEnergyCube, CraftExtraItemBlockEnergyCube> CRAFT_INFINITE_ENERGY_CUBE = registerExtraEnergyCube(CraftExtraBlockTypes.CRAFT_INFINITE_ENERGY_CUBE);

    private static BlockRegistryObject<CraftExtraBlockEnergyCube, CraftExtraItemBlockEnergyCube> registerExtraEnergyCube(CraftMachine<ExtraTileEntityEnergyCube> type) {
        IAdvanceTier tier = Objects.requireNonNull(type.get(ExtraAttributeTier.class)).tier();
        return CRAFT_EXTRA_BLOCK.register("craft_" + tier.getAdvanceTier().getLowerName() + "_energy_cube", () -> new CraftExtraBlockEnergyCube(type), CraftExtraItemBlockEnergyCube::new);
    }

    public static void register(IEventBus eventBus) {
        CRAFT_EXTRA_BLOCK.register(eventBus);
    }
}
