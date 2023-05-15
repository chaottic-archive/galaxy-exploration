package com.chaottic.galaxy.exploration.common;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public final class GalaxyExplorationItems {
    public static final Item SHIP_CONSTRUCTION_BLOCK = new BlockItem(GalaxyExplorationBlocks.SHIP_CONSTRUCTION_BLOCK, new Item.Properties());

    private GalaxyExplorationItems() {}

    public static void registerAll(Registrant<Item> registrant) {
        registrant.register("ship_construction_block", SHIP_CONSTRUCTION_BLOCK);
    }
}
