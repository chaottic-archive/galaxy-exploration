package com.chaottic.galaxy.exploration.common.block;

import com.chaottic.galaxy.exploration.common.GalaxyExplorationBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public final class ShipConstructionBlock extends Block implements EntityBlock {
    public static final int XZ = 16;
    public static final int Y = 8;

    public ShipConstructionBlock(Properties $$0) {
        super($$0);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return GalaxyExplorationBlockEntityTypes.SHIP_CONSTRUCTION_BLOCK.create(blockPos, blockState);
    }
}
