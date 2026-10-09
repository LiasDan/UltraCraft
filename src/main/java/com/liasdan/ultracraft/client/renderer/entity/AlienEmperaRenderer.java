package com.liasdan.ultracraft.client.renderer.entity;

import com.liasdan.ultracraft.client.models.entity.AlienEmperaModel;
import com.liasdan.ultracraft.entity.boss.AlienEmperaEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AlienEmperaRenderer extends GeoEntityRenderer<AlienEmperaEntity> {

    public AlienEmperaRenderer(EntityRendererProvider.Context context) {
        // Enforce the explicit type generic casting on the new Model instance
        super(context, new AlienEmperaModel<AlienEmperaEntity>());
        this.shadowRadius = 0.7F;
    }
}