package com.jerry.mekanismcraftitem;

import com.jerry.mekanismcraftitem.common.registry.CraftBlocks;
import com.jerry.mekanismcraftitem.common.registry.CraftCreativeTab;
import com.jerry.mekanismcraftitem.common.registry.CraftItems;
import com.jerry.mekanismcraftitem.common.registry.CraftTileEntityTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(MekanismCraftItem.MOD_ID)
public class MekanismCraftItem {
    public static final String MOD_ID = "craftitem";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MekanismCraftItem() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        CraftItems.register(modEventBus);
        CraftBlocks.register(modEventBus);
        CraftTileEntityTypes.register(modEventBus);
        CraftCreativeTab.register(modEventBus);
    }

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MekanismCraftItem.MOD_ID, path);
    }
}
