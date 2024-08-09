package com.jerry.mekanismcraftitem.common.registry;

import com.jerry.mekanismcraftitem.MekanismCraftItem;
import com.jerry.mekanismcraftitem.common.CraftLang;
import mekanism.common.registration.impl.CreativeTabDeferredRegister;
import mekanism.common.registration.impl.CreativeTabRegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class CraftCreativeTab {

    public static final CreativeTabDeferredRegister CRAFT_CREATIVE_TABS = new CreativeTabDeferredRegister(MekanismCraftItem.MOD_ID);

    public static final CreativeTabRegistryObject CRAFT_ITEM = CRAFT_CREATIVE_TABS.registerMain(CraftLang.MEKANISM_CRAFT_ITEM, CraftBlocks.CRAFT_BASIC_ENERGY_CUBE, builder ->
        builder.displayItems((displayParameters, output) -> {
            CreativeTabDeferredRegister.addToDisplay(CraftItems.CRAFT_ITEMS, output);
            CreativeTabDeferredRegister.addToDisplay(CraftBlocks.CRAFT_BLOCK, output);
        })
    );

    public static void register(IEventBus eventBus) {
        CRAFT_CREATIVE_TABS.register(eventBus);
    }
}
