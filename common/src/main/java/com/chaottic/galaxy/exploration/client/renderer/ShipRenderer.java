package com.chaottic.galaxy.exploration.client.renderer;

import com.chaottic.galaxy.exploration.common.entity.ShipEntity;
import com.google.common.collect.ImmutableSet;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.Pair;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.chunk.VisGraph;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Set;

public final class ShipRenderer extends EntityRenderer<ShipEntity> {

    public ShipRenderer(EntityRendererProvider.Context $$0) {
        super($$0);
    }

    @Override
    public void render(ShipEntity $$0, float $$1, float $$2, PoseStack $$3, MultiBufferSource $$4, int $$5) {

        var set = ImmutableSet.of(
                Pair.of(new BlockPos(0, 0, 0), Blocks.DIRT.defaultBlockState()),
                Pair.of(new BlockPos(0, 1, 0), Blocks.DIRT.defaultBlockState()),
                Pair.of(new BlockPos(0, -1, 0), Blocks.DIRT.defaultBlockState()),
                Pair.of(new BlockPos(0, -1, 1), Blocks.DIRT.defaultBlockState())
        );

        upload(set, $$0.level, $$3, $$4, 0, $$5);
    }

    public void upload(Set<Pair<BlockPos, BlockState>> set, BlockAndTintGetter blockAndTintGetter, PoseStack poseStack, MultiBufferSource source, long l, int i) {
        var blockRenderer = Minecraft.getInstance().getBlockRenderer();

        ModelBlockRenderer.enableCaching();

        set.forEach(pair -> {
            var blockPos = pair.left();
            var blockState = pair.right();

            poseStack.pushPose();
            poseStack.translate(blockPos.getX(), blockPos.getY(), blockPos.getZ());

            var renderType = ItemBlockRenderTypes.getChunkRenderType(blockState);

            var consumer = source.getBuffer(renderType);

            blockRenderer.renderBatched(blockState, blockPos, blockAndTintGetter, poseStack, consumer, true, RandomSource.create());

            poseStack.popPose();
        });

        ModelBlockRenderer.clearCache();
    }

    @Override
    public ResourceLocation getTextureLocation(ShipEntity shipEntity) {
        return null;
    }
}
