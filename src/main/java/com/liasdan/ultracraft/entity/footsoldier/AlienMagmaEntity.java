package com.liasdan.ultracraft.entity.footsoldier;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class AlienMagmaEntity extends BaseFootsoldierEntity {

    public AlienMagmaEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="alien_magma";
    }
}