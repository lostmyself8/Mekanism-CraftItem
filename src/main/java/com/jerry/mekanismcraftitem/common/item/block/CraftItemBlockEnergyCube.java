package com.jerry.mekanismcraftitem.common.item.block;

import com.jerry.mekanismcraftitem.client.render.CraftRenderPropertiesProvider;
import com.jerry.mekanismcraftitem.common.block.CraftBlockEnergyCube;
import mekanism.common.block.attribute.Attribute;
import mekanism.common.item.block.ItemBlockTooltip;
import mekanism.common.tier.EnergyCubeTier;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class CraftItemBlockEnergyCube extends ItemBlockTooltip<CraftBlockEnergyCube>{
    public CraftItemBlockEnergyCube(CraftBlockEnergyCube block) {
        super(block, new Properties().stacksTo(64));
    }

    @Override
    public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
        consumer.accept(CraftRenderPropertiesProvider.energyCube());
    }

    @Override
    public EnergyCubeTier getTier() {
        return Attribute.getTier(getBlock(), EnergyCubeTier.class);
    }
}
