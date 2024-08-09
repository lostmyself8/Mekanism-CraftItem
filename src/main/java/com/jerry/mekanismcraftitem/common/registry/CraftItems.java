package com.jerry.mekanismcraftitem.common.registry;

import com.jerry.mekanismcraftitem.MekanismCraftItem;
import mekanism.common.registration.impl.ItemDeferredRegister;
import mekanism.common.registration.impl.ItemRegistryObject;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;

public class CraftItems {
    private CraftItems() {

    }
    public static final ItemDeferredRegister CRAFT_ITEMS = new ItemDeferredRegister(MekanismCraftItem.MOD_ID);
    public static final ItemRegistryObject<Item> CRAFT_ALLOY_INFUSED = CRAFT_ITEMS.register("craft_alloy_infused", properties -> new Item(properties.rarity(Rarity.UNCOMMON)));
    public static final ItemRegistryObject<Item> CRAFT_ENERGY_TABLET = CRAFT_ITEMS.register("craft_energy_tablet", properties -> new Item(properties.rarity(Rarity.UNCOMMON)));

    public static void register(IEventBus eventBus) {
        CRAFT_ITEMS.register(eventBus);
    }
}
