package com.chaottic.galaxy.exploration.common;

import com.chaottic.galaxy.exploration.common.block.ShipConstructionBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public final class GalaxyExplorationBlocks {
    public static final Block SHIP_CONSTRUCTION_BLOCK = new ShipConstructionBlock(Properties.copy(Blocks.STONE));

    private GalaxyExplorationBlocks() {}

    public static void registerAll(Registrant<Block> registrant) {
        registrant.register("ship_construction_block", SHIP_CONSTRUCTION_BLOCK);
    }
}
