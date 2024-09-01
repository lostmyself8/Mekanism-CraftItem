package com.jerry.mekanismcraftitem.client;

import com.jerry.mekanism_extras.common.block.attribute.ExtraAttribute;
import com.jerry.mekanism_extras.common.block.storage.energycube.ECTier;
import com.jerry.mekanism_extras.common.block.storage.energycube.EnergyCubeColor;
import com.jerry.mekanismcraftitem.MekanismCraftItem;
import com.jerry.mekanismcraftitem.common.item.block.CraftExtraItemBlockEnergyCube;
import com.jerry.mekanismcraftitem.integration.Addons;
import com.jerry.mekanismcraftitem.integration.registry.CraftExtraBlocks;
import mekanism.client.ClientRegistrationUtil;
import mekanism.client.render.MekanismRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MekanismCraftItem.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CraftClientRegistration {
    @SubscribeEvent
    public static void registerBlockColorHandlers(RegisterColorHandlersEvent.Block event) {
        if (Addons.MEKANISM_EXTRAS.isLoaded()) {
            ClientRegistrationUtil.registerBlockColorHandler(event, (state, word, pos, index) -> {
                        if (index == 1) {
                            ECTier tier = ExtraAttribute.getTier(state.getBlock(), ECTier.class);
                            if (tier != null) {
                                float[] color = EnergyCubeColor.getColor(tier);
                                return MekanismRenderer.getColorARGB(color[0], color[1], color[2], 1);
                            }
                        }
                        return -1;
                    }, CraftExtraBlocks.CRAFT_ABSOLUTE_ENERGY_CUBE, CraftExtraBlocks.CRAFT_SUPREME_ENERGY_CUBE, CraftExtraBlocks.CRAFT_COSMIC_ENERGY_CUBE,
                    CraftExtraBlocks.CRAFT_INFINITE_ENERGY_CUBE);
        }
    }

    @SubscribeEvent
    public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event) {
        if (Addons.MEKANISM_EXTRAS.isLoaded()) {
            ClientRegistrationUtil.registerItemColorHandler(event, (stack, tintIndex) -> {
                        if (tintIndex == 1 && stack.getItem() instanceof CraftExtraItemBlockEnergyCube cube) {
                            float[] color = EnergyCubeColor.getColor(cube.getAdvanceTier());
                            return MekanismRenderer.getColorARGB(color[0], color[1], color[2], 1);
                        }
                        return -1;
                    }, CraftExtraBlocks.CRAFT_ABSOLUTE_ENERGY_CUBE, CraftExtraBlocks.CRAFT_SUPREME_ENERGY_CUBE, CraftExtraBlocks.CRAFT_COSMIC_ENERGY_CUBE,
                    CraftExtraBlocks.CRAFT_INFINITE_ENERGY_CUBE);
        }
    }
}
