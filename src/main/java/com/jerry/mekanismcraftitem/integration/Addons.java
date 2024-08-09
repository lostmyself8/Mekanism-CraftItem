package com.jerry.mekanismcraftitem.integration;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.LoadingModList;
import net.minecraftforge.fml.loading.moddiscovery.ModInfo;

public enum Addons {
    MEKANISM_EXTRAS("MekanismExtras");
    private final String modName;
    Addons(String modName) {
        this.modName = modName;
    }
    public String getModID() {
        return name().toLowerCase();
    }
    public String getModName() {
        return modName;
    }
    public boolean isLoaded() {
        return ModList.get() != null
                ? ModList.get().isLoaded(getModID())
                : LoadingModList.get().getMods().stream().map(ModInfo::getModId).anyMatch(getModID()::equals);
    }
}
