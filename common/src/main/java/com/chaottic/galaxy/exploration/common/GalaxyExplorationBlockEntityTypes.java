package com.chaottic.galaxy.exploration.common;

import com.chaottic.galaxy.exploration.common.block.entity.ShipConstructionBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public final class GalaxyExplorationBlockEntityTypes {
    public static final BlockEntityType<ShipConstructionBlockEntity> SHIP_CONSTRUCTION_BLOCK = BlockEntityType.Builder.of(ShipConstructionBlockEntity::new, GalaxyExplorationBlocks.SHIP_CONSTRUCTION_BLOCK).build(null);

    private GalaxyExplorationBlockEntityTypes() {}

    public static void registerAll(Registrant<BlockEntityType<?>> registrant) {
        registrant.register("ship_construction_block", SHIP_CONSTRUCTION_BLOCK);
    }
}
