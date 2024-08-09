package com.jerry.mekanismcraftitem.client.render;

import com.jerry.mekanismcraftitem.client.render.item.block.CraftExtraRenderEnergyCubeItem;
import com.jerry.mekanismcraftitem.client.render.item.block.CraftRenderEnergyCubeItem;
import mekanism.client.render.RenderPropertiesProvider;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class CraftRenderPropertiesProvider {
    private CraftRenderPropertiesProvider() {

    }
    public static IClientItemExtensions energyCube() {
        return new RenderPropertiesProvider.MekRenderProperties(CraftRenderEnergyCubeItem.CRAFT_RENDERER);
    }
    public static IClientItemExtensions extraEnergyCube() {
        return new RenderPropertiesProvider.MekRenderProperties(CraftExtraRenderEnergyCubeItem.CRAFT_EXTRA_RENDERER);
    }
}
