package com.chaottic.galaxy.exploration.common.block.entity;

import com.chaottic.galaxy.exploration.common.GalaxyExplorationBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public final class ShipConstructionBlockEntity extends BlockEntity {

    public ShipConstructionBlockEntity(BlockEntityType<?> $$0, BlockPos $$1, BlockState $$2) {
        super($$0, $$1, $$2);
    }

    public ShipConstructionBlockEntity(BlockPos blockPos, BlockState blockState) {
        this(GalaxyExplorationBlockEntityTypes.SHIP_CONSTRUCTION_BLOCK, blockPos, blockState);
    }
}
