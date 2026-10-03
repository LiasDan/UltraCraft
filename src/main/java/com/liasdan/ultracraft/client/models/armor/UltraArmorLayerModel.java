package com.liasdan.ultracraft.client.models.armor;


import com.liasdan.ultracraft.items.others.UltraArmorItem;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoRenderer;

public class UltraArmorLayerModel<T extends UltraArmorItem> extends UltraArmorModel<T> {
    public UltraArmorLayerModel() {
    }

    @Override
    public ResourceLocation getModelResource(T animatable, @Nullable GeoRenderer<T> renderer) {
        return getModelResource(animatable);
    }
}