package com.liasdan.ultracraft.items.client;

import com.liasdan.ultracraft.items.others.UltraArmorItem;
import com.liasdan.ultracraft.items.others.UltraRiserItem;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.texture.AutoGlowingTexture;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class UltraArmorRenderer extends GeoArmorRenderer<UltraArmorItem> {

	private static LivingEntity RIDER;

	public UltraArmorRenderer(LivingEntity entity, EquipmentSlot equipmentSlot) {

		super(new UltraArmorModel());
		addRenderLayer(new AutoGlowingGeoLayer<>(this){
			@Nullable
			protected RenderType getRenderType(UltraArmorItem animatable, @Nullable MultiBufferSource bufferSource) {
				if (this.getRenderer() instanceof UltraArmorRenderer renderer2) {
					LivingEntity RIDER = renderer2.GetEntity();
					if (RIDER!=null&&RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof UltraRiserItem belt) {
						return belt.getGlowForSlot(RIDER.getItemBySlot(EquipmentSlot.FEET), equipmentSlot,RIDER)? AutoGlowingTexture.getRenderType(getTextureResource(animatable)): null;
					}}
				return null;
			}});

		if (entity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof UltraRiserItem belt) {
			if (belt.Unlimited_Textures != 0 & equipmentSlot == EquipmentSlot.HEAD
					||belt.Unlimited_Belt_Textures != 0 & equipmentSlot == EquipmentSlot.FEET) {
				addRenderLayer(new UltraRenderLayer<>(this));
			}
		}
	}

	public GeoArmorRenderer<UltraArmorItem> addRenderLayer(GeoRenderLayer<UltraArmorItem> renderLayer) {
		this.renderLayers.addLayer(renderLayer);

		return this;
	}

	public LivingEntity GetEntity(){
		if (getCurrentEntity() instanceof LivingEntity entity) return entity;
		else return null;
	}

	protected void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
		setAllVisible(false);

		if (GetEntity() != null) {
			if (!GetEntity().hasEffect(MobEffects.INVISIBILITY) || !GetEntity().isInvisible()) {
				if (currentSlot == EquipmentSlot.FEET) {
					setBoneVisible(this.body, true);
					setBoneVisible(this.leftArm, true);
					setBoneVisible(this.rightArm, true);
				} else if (GetEntity().getItemBySlot(EquipmentSlot.FEET).getItem() instanceof UltraRiserItem BELT && BELT.isTransformed(GetEntity())) {
					setBoneVisible(this.head, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "head"));
					setBoneVisible(this.body, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "body"));
					setBoneVisible(this.rightArm, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "rightArm"));
					setBoneVisible(this.leftArm, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "leftArm"));
					setBoneVisible(this.rightLeg, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "rightLeg"));
					setBoneVisible(this.leftLeg, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "leftLeg"));
				}
			}
		}
	}

}