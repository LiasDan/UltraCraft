package com.liasdan.ultracraft.entity.footsoldier;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class ShadowEntity extends BaseFootsoldierEntity {

    public ShadowEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="shadow";
    }
}