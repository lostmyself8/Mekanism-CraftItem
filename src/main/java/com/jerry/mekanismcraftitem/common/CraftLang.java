package com.jerry.mekanismcraftitem.common;

import com.jerry.mekanismcraftitem.MekanismCraftItem;
import mekanism.api.text.ILangEntry;
import net.minecraft.Util;
import org.jetbrains.annotations.NotNull;

public enum CraftLang implements ILangEntry {
    MEKANISM_CRAFT_ITEM("constants", "mod_name"),
    DESCRIPTION_CRAFT_ENERGY_CUBE("description", "craft_energy_cube");

    private final String key;

    CraftLang(String type, String path) {
        this(Util.makeDescriptionId(type, MekanismCraftItem.rl(path)));
    }

    CraftLang(String key) {
        this.key = key;
    }

    @Override
    public @NotNull String getTranslationKey() {
        return key;
    }
}
