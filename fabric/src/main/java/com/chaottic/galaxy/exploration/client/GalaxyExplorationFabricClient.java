package com.chaottic.galaxy.exploration.client;

import com.chaottic.galaxy.exploration.client.renderer.ShipRenderer;
import com.chaottic.galaxy.exploration.common.GalaxyExplorationEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public final class GalaxyExplorationFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(GalaxyExplorationEntityTypes.SHIP, ShipRenderer::new);
    }
}
