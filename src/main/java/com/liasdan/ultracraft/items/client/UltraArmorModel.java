package com.liasdan.ultracraft.items.client;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.items.others.UltraArmorItem;
import com.liasdan.ultracraft.items.others.UltraRiserItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class UltraArmorModel extends GeoModel<UltraArmorItem> {

	public UltraArmorModel() {
	}

	@Override
	public ResourceLocation getModelResource(UltraArmorItem animatable, @Nullable GeoRenderer<UltraArmorItem> renderer) {
		if (renderer instanceof UltraArmorRenderer rangerRenderer) {
			LivingEntity RANGER = rangerRenderer.GetEntity();
			EquipmentSlot slot= rangerRenderer.getCurrentSlot();
			if (RANGER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof UltraRiserItem BELT) {
				if (slot == EquipmentSlot.FEET)
					return BELT.getBeltModelResource(RANGER.getItemBySlot(EquipmentSlot.FEET), animatable, slot, RANGER);
				else return BELT.getModelResource(RANGER.getItemBySlot(EquipmentSlot.FEET), animatable, slot, RANGER);
			}
		}
		return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "geo/ultra.geo.json");
	}

	@Override
	public ResourceLocation getModelResource(UltraArmorItem animatable) {
		return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "geo/ultra.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(UltraArmorItem animatable, @Nullable GeoRenderer<UltraArmorItem> renderer) {
		if (renderer instanceof UltraArmorRenderer riderRenderer) {
			LivingEntity RIDER = riderRenderer.GetEntity();
			EquipmentSlot slot = riderRenderer.getCurrentSlot();
			ItemStack BELT = RIDER.getItemBySlot(EquipmentSlot.FEET);
			if (BELT.getItem() instanceof UltraRiserItem DRIVER && (slot == EquipmentSlot.FEET || DRIVER.isTransformed(RIDER))) {
				return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "textures/armor/" + DRIVER.GET_TEXT(BELT, slot, RIDER, DRIVER.Rider) + ".png");
			}
		}
		return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "textures/armor/blank.png");
	}

	@Override
	public ResourceLocation getTextureResource(UltraArmorItem animatable) {
		return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "textures/armor/blank.png");
	}



	@Override
	public ResourceLocation getAnimationResource(UltraArmorItem animatable) {
		return  ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "animations/ultra.animation.json");
	}

	@Override
	public void setCustomAnimations(UltraArmorItem an, long instanceId, AnimationState<UltraArmorItem> state) {

		Entity entity = state.getData(DataTickets.ENTITY);
		if (entity instanceof LivingEntity RIDER) {
			GeoBone front_fork = this.getAnimationProcessor().getBone("front_fork");
			GeoBone front_fork2 = this.getAnimationProcessor().getBone("front_fork2");
			GeoBone b_wheel = this.getAnimationProcessor().getBone("b_wheel");
			GeoBone f_wheel = this.getAnimationProcessor().getBone("f_wheel");
			GeoBone f_wheel2 = this.getAnimationProcessor().getBone("f_wheel2");
			GeoBone ball = this.getAnimationProcessor().getBone("ball");

			GeoBone cape = this.getAnimationProcessor().getBone("cape");
			if (cape != null & UltraArmorItem.GetCapeRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)) < 0)
				cape.setRotX(UltraArmorItem.GetCapeRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
			if (cape != null & UltraArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)) != 0)
				cape.setRotY(UltraArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));

			if (front_fork != null) front_fork.setRotY(UltraArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
			if (front_fork2 != null)
				front_fork2.setRotY(UltraArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));

			if (f_wheel != null) f_wheel.setRotX(UltraArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
			if (f_wheel2 != null) f_wheel2.setRotX(UltraArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
			if (b_wheel != null) b_wheel.setRotX(UltraArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
			if (ball != null) {
				ball.setRotX(UltraArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
				ball.setRotZ(UltraArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
			}
		}
	}
}