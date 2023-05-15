package com.chaottic.galaxy.exploration.common;

import com.chaottic.galaxy.exploration.common.entity.ShipEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public final class GalaxyExplorationEntityTypes {
    public static final EntityType<ShipEntity> SHIP = EntityType.Builder.of(ShipEntity::new, MobCategory.MISC).build("ship");

    private GalaxyExplorationEntityTypes() {}

    public static void registerAll(Registrant<EntityType<?>> registrant) {
        registrant.register("ship", SHIP);
    }
}
