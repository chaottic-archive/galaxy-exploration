package com.chaottic.galaxy.exploration.common;

import net.minecraft.resources.ResourceLocation;

public final class GalaxyExploration {
    private static final String MOD_ID = "galaxy_exploration";

    private GalaxyExploration() {}

    public static ResourceLocation resourceLocation(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
