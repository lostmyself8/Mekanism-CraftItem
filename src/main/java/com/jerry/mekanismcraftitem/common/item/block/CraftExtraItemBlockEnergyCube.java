package com.jerry.mekanismcraftitem.common.item.block;

import com.jerry.mekanism_extras.common.block.attribute.ExtraAttribute;
import com.jerry.mekanism_extras.common.block.storage.energycube.ECTier;
import com.jerry.mekanism_extras.common.item.block.ExtraItemBlockTooltip;
import com.jerry.mekanismcraftitem.client.render.CraftRenderPropertiesProvider;
import com.jerry.mekanismcraftitem.common.block.CraftExtraBlockEnergyCube;
import mekanism.common.tier.EnergyCubeTier;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class CraftExtraItemBlockEnergyCube extends ExtraItemBlockTooltip<CraftExtraBlockEnergyCube> {
    public CraftExtraItemBlockEnergyCube(CraftExtraBlockEnergyCube block) {
        super(block, new Properties().stacksTo(64));
    }

    @Override
    public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
        consumer.accept(CraftRenderPropertiesProvider.extraEnergyCube());
    }

    @Override
    public ECTier getAdvanceTier() {
        return ExtraAttribute.getTier(getBlock(), ECTier.class);
    }
}
