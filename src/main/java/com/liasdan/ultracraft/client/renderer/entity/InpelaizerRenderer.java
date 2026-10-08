package com.liasdan.ultracraft.client.renderer.entity;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.client.models.entity.InpelaizerModel;
import com.liasdan.ultracraft.entity.footsoldier.InpelaizerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class InpelaizerRenderer extends MobRenderer<InpelaizerEntity, InpelaizerModel<InpelaizerEntity>> {

    public InpelaizerRenderer(EntityRendererProvider.Context context) {
        super(context, new InpelaizerModel<>(context.bakeLayer(InpelaizerModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(InpelaizerEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "textures/entities/inpelaizer.png");
    }
}