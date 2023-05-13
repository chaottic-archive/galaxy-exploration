package com.chaottic.galaxy.exploration.common;

import net.fabricmc.api.ModInitializer;

public final class GalaxyExplorationFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        GalaxyExplorationBlocks.registerAll();
        GalaxyExplorationItems.registerAll();
    }
}
