package com.jerry.mekanismcraftitem.common.registry;

import com.jerry.mekanism_extras.common.api.tier.IAdvanceTier;
import com.jerry.mekanism_extras.common.block.attribute.ExtraAttributeTier;
import com.jerry.mekanism_extras.common.block.storage.energycube.ExtraTileEntityEnergyCube;
import com.jerry.mekanismcraftitem.MekanismCraftItem;
import com.jerry.mekanismcraftitem.common.block.CraftBlockEnergyCube;
import com.jerry.mekanismcraftitem.common.block.CraftExtraBlockEnergyCube;
import com.jerry.mekanismcraftitem.common.content.blocktype.CraftMachine;
import com.jerry.mekanismcraftitem.common.item.block.CraftExtraItemBlockEnergyCube;
import com.jerry.mekanismcraftitem.integration.Addons;
import mekanism.api.tier.ITier;
import mekanism.common.block.attribute.AttributeTier;
import mekanism.common.registration.impl.BlockDeferredRegister;
import mekanism.common.registration.impl.BlockRegistryObject;
import com.jerry.mekanismcraftitem.common.item.block.CraftItemBlockEnergyCube;
import mekanism.common.tile.TileEntityEnergyCube;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.Objects;

public class CraftBlocks {
    public static final BlockDeferredRegister CRAFT_BLOCK = new BlockDeferredRegister(MekanismCraftItem.MOD_ID);

    public static final BlockRegistryObject<CraftBlockEnergyCube, CraftItemBlockEnergyCube> CRAFT_BASIC_ENERGY_CUBE = registerEnergyCube(CraftBlockTypes.CRAFT_BASIC_ENERGY_CUBE);
    public static final BlockRegistryObject<CraftBlockEnergyCube, CraftItemBlockEnergyCube> CRAFT_ADVANCED_ENERGY_CUBE = registerEnergyCube(CraftBlockTypes.CRAFT_ADVANCED_ENERGY_CUBE);
    public static final BlockRegistryObject<CraftBlockEnergyCube, CraftItemBlockEnergyCube> CRAFT_ELITE_ENERGY_CUBE = registerEnergyCube(CraftBlockTypes.CRAFT_ELITE_ENERGY_CUBE);
    public static final BlockRegistryObject<CraftBlockEnergyCube, CraftItemBlockEnergyCube> CRAFT_ULTIMATE_ENERGY_CUBE = registerEnergyCube(CraftBlockTypes.CRAFT_ULTIMATE_ENERGY_CUBE);

    private static BlockRegistryObject<CraftBlockEnergyCube, CraftItemBlockEnergyCube> registerEnergyCube(CraftMachine<TileEntityEnergyCube> type) {
        ITier tier = Objects.requireNonNull(type.get(AttributeTier.class)).tier();
        return CRAFT_BLOCK.register("craft_" + tier.getBaseTier().getLowerName() + "_energy_cube", () -> new CraftBlockEnergyCube(type), CraftItemBlockEnergyCube::new);
    }

    public static void register(IEventBus eventBus) {
        CRAFT_BLOCK.register(eventBus);
    }
}
