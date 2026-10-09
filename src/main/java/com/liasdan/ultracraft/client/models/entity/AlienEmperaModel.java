package com.liasdan.ultracraft.client.models.entity;

import com.liasdan.ultracraft.UltraCraftCore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.animatable.GeoEntity;

public class AlienEmperaModel<T extends LivingEntity & GeoEntity> extends GeoModel<T> {

    @Override
    public ResourceLocation getModelResource(T animatable) {
        return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "geo/ultracape.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "textures/entities/alien_empera.png");
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "animations/ultracape.animation.json");
    }

    @Override
    public void setCustomAnimations(T animatable, long instanceId, AnimationState<T> state) {
        super.setCustomAnimations(animatable, instanceId, state);
    }
}