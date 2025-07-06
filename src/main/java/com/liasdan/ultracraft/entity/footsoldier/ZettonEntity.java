package com.liasdan.ultracraft.entity.footsoldier;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class ZettonEntity extends BaseFootsoldierEntity {

    public ZettonEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="zetton";
    }
}