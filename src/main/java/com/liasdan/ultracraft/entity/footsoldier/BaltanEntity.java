package com.liasdan.ultracraft.entity.footsoldier;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class BaltanEntity extends BaseFootsoldierEntity {

    public BaltanEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="baltan";
    }
}