package com.liasdan.ultracraft.client.renderer.entity;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.client.models.entity.IblisModel;
import com.liasdan.ultracraft.entity.footsoldier.IblisEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class IblisRenderer extends MobRenderer<IblisEntity, IblisModel<IblisEntity>> {

    public IblisRenderer(EntityRendererProvider.Context context) {
        // We pass the context along with your specific model layer location to bake the custom mesh
        super(context, new IblisModel<>(context.bakeLayer(IblisModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(IblisEntity entity) {
        // Points to the custom PNG texture map you exported from Blockbench
        return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "textures/entities/chaos_header_iblis.png");
    }
}