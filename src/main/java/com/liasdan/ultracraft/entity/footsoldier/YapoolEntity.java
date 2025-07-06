package com.liasdan.ultracraft.entity.footsoldier;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class YapoolEntity extends BaseFootsoldierEntity {

    public YapoolEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="yapool";
    }
}