package com.chaottic.galaxy.exploration.common;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public final class GalaxyExplorationFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        GalaxyExplorationBlocks.registerAll(registrant(BuiltInRegistries.BLOCK));
        GalaxyExplorationItems.registerAll(registrant(BuiltInRegistries.ITEM));
        GalaxyExplorationBlockEntityTypes.registerAll(registrant(BuiltInRegistries.BLOCK_ENTITY_TYPE));
        GalaxyExplorationEntityTypes.registerAll(registrant(BuiltInRegistries.ENTITY_TYPE));
    }

    private <T> Registrant<T> registrant(Registry<T> registry) {
        return (name, t) -> Registry.register(registry, GalaxyExploration.resourceLocation(name), t);
    }
}
