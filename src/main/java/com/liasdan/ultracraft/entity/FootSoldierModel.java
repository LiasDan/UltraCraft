package com.liasdan.ultracraft.entity;

import com.liasdan.ultracraft.entity.footsoldier.BaseFootsoldierEntity;
import net.minecraft.client.model.AbstractZombieModel;
import net.minecraft.client.model.geom.ModelPart;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FootSoldierModel<T extends BaseFootsoldierEntity> extends AbstractZombieModel<T> {
    public FootSoldierModel(ModelPart root) {
        super(root);
    }

    public boolean isAggressive(T entity) {
        return entity.isAggressive();
    }
}