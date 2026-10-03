package com.liasdan.ultracraft.client.renderer.armor;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.client.models.armor.UltraArmorModel;
import com.liasdan.ultracraft.client.renderer.armor.render_layer.UltraRenderLayer;
import com.liasdan.ultracraft.items.others.UltraArmorItem;
import com.liasdan.ultracraft.items.others.UltraRiserItem;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.util.RenderUtil;

import static software.bernie.geckolib.cache.texture.GeoAbstractTexture.appendToPath;


public class UltraArmorRenderer extends GeoArmorRenderer<UltraArmorItem> {
    public UltraArmorRenderer(EquipmentSlot equipmentSlot) {
        super(new UltraArmorModel());
        if (equipmentSlot != EquipmentSlot.FEET) {
            addRenderLayer(new AutoGlowingGeoLayer<>(this) {
                @Nullable
                protected RenderType getRenderType(UltraArmorItem animatable, @Nullable MultiBufferSource bufferSource) {
                    if (getRenderer() instanceof UltraArmorRenderer renderer2) {
                        LivingEntity RIDER = renderer2.GetEntity();
                        if (RIDER != null && RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof UltraRiserItem belt) {
                            if (renderer.getTextureLocation(animatable).getPath().equals((ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "textures/armor/blank.png")).getPath())) {
                                return null;
                            }
                            ResourceLocation path = appendToPath(model.getTextureResource(animatable, renderer2), "_glowmask");
                            return belt.getGlowForSlot(RIDER.getItemBySlot(EquipmentSlot.FEET), renderer2.getCurrentSlot(), RIDER) ? RenderType.breezeEyes(path) : null;
                        }
                    }
                    return null;
                }
            });
        }

        if (equipmentSlot == EquipmentSlot.HEAD || equipmentSlot == EquipmentSlot.FEET) {
            addRenderLayer(new UltraRenderLayer<>(this));
        }

    }

    public GeoArmorRenderer<UltraArmorItem> addRenderLayer(GeoRenderLayer<UltraArmorItem> renderLayer) {
        renderLayers.addLayer(renderLayer);
        return this;
    }

    public LivingEntity GetEntity() {
        if (getCurrentEntity() instanceof LivingEntity entity) {
            return entity;
        } else {
            return null;
        }
    }

    @Override
    public RenderType getRenderType(UltraArmorItem animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }

    @Override
    protected void applyBaseTransformations(HumanoidModel<?> baseModel) {
        super.applyBaseTransformations(baseModel);
        if (body != null) {
            ModelPart bodyPart = baseModel.body;
            RenderUtil.matchModelPartRot(bodyPart, body);
            body.updatePosition(bodyPart.x, -bodyPart.y, bodyPart.z);
        }
    }

    protected void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
        setAllVisible(false);
        if (GetEntity() != null) {
            if (!GetEntity().isInvisible() || GetEntity() instanceof ArmorStand) {
                if (currentSlot == EquipmentSlot.FEET) {
                    setAllVisible(true);
                } else if (GetEntity().getItemBySlot(EquipmentSlot.FEET).getItem() instanceof UltraRiserItem BELT) {
                    setBoneVisible(head, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "head"));
                    setBoneVisible(body, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "body"));
                    setBoneVisible(rightArm, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "rightArm"));
                    setBoneVisible(leftArm, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "leftArm"));
                    setBoneVisible(rightLeg, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "rightLeg"));
                    setBoneVisible(leftLeg, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "leftLeg"));
                }
            }
        }
    }
}