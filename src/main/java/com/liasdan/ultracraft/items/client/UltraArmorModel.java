package com.liasdan.ultracraft.items.client;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.items.others.UltraArmorItem;
import com.liasdan.ultracraft.items.others.UltraRiserItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.GeoModel;

public class UltraArmorModel extends GeoModel<UltraArmorItem> {

	private static LivingEntity RIDER;
	private EquipmentSlot slot;

	public UltraArmorModel(LivingEntity livingEntity, EquipmentSlot equipmentSlot) {

		RIDER =  livingEntity;
		slot =  equipmentSlot;
	}

	@Override
	public ResourceLocation getModelResource(UltraArmorItem animatable) {
		if (slot== EquipmentSlot.FEET) {
			if (RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof UltraRiserItem) {
				UltraRiserItem BELT = ((UltraRiserItem)RIDER.getItemBySlot(EquipmentSlot.FEET).getItem()); 
				
				return BELT.getBeltModelResource(RIDER.getItemBySlot(EquipmentSlot.FEET),animatable,slot,RIDER);
				
			}else return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "geo/ultrabelt.geo.json");
		}else {
			
			if (RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof UltraRiserItem) {
				UltraRiserItem BELT = ((UltraRiserItem)RIDER.getItemBySlot(EquipmentSlot.FEET).getItem()); 
				
				return BELT.getModelResource(RIDER.getItemBySlot(EquipmentSlot.FEET),animatable,slot,RIDER);
				
			}else return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "geo/ultra.geo.json");
		}
	}

	@Override
	public ResourceLocation getTextureResource(UltraArmorItem animatable) {


		String FORM="blank";
		ItemStack BELT = RIDER.getItemBySlot(EquipmentSlot.FEET); 
		if (BELT.getItem() instanceof UltraRiserItem) {
			FORM=((UltraRiserItem) BELT.getItem()).GET_TEXT(BELT,slot,RIDER,((UltraRiserItem) BELT.getItem()).Rider );
			if (slot == EquipmentSlot.FEET) {

				FORM=((UltraRiserItem) BELT.getItem()).GET_TEXT(BELT,slot ,RIDER,((UltraRiserItem) BELT.getItem()).Rider);
			}else if ( ((UltraRiserItem) BELT.getItem()).HEAD.asItem()!=RIDER.getItemBySlot(EquipmentSlot.HEAD).getItem()||
					 ((UltraRiserItem) BELT.getItem()).TORSO.asItem()!=RIDER.getItemBySlot(EquipmentSlot.CHEST).getItem()||
					 ((UltraRiserItem) BELT.getItem()).LEGS.asItem()!=RIDER.getItemBySlot(EquipmentSlot.LEGS).getItem()) {
				 FORM="blank";
			}
	

		}
		return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "textures/armor/"+FORM+".png");
	}



@Override
public ResourceLocation getAnimationResource(UltraArmorItem animatable) {
	if (slot== EquipmentSlot.FEET) {
		return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "animations/ultrabelt.animation.json");
	}else {
		
		if (RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof UltraRiserItem) {
			UltraRiserItem BELT = ((UltraRiserItem)RIDER.getItemBySlot(EquipmentSlot.FEET).getItem()); 
			
			return BELT.getAnimationResource(RIDER.getItemBySlot(EquipmentSlot.FEET),animatable,slot);
			
		}else return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "animations/ultra.animation.json");
	}

}
}