package com.liasdan.ultracraft.items;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.liasdan.ultracraft.effect.EffectCore;
import com.liasdan.ultracraft.items.others.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class OtherItems {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltraCraftCore.MODID);

//	public static final DeferredItem<Item> BASE_SWORD = ITEMS.register("base_sword",
//			() -> new BaseItem(new Item.Properties()).AddToTabList(UltraTabs.MISC));

	public static final DeferredItem<Item> BLANK_FORM = ITEMS.register("blank_form",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","",""));

	public static final DeferredItem<Item> LAND_OF_LIGHT_FRAGMENT = ITEMS.register("land_of_light_fragment",
			() -> new LandOfLightFragment(new Item.Properties()).AddToTabList(UltraTabs.MISC));

	public static final DeferredItem<Item> ULTRAMAN_HELMET = ITEMS.register("ultraman_head",
			() -> new UltraArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(UltraTabs.MISC).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
	public static final DeferredItem<Item> ULTRAMAN_CHESTPLATE = ITEMS.register("ultraman_torso",
			() -> new UltraArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(UltraTabs.MISC).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
	public static final DeferredItem<Item> ULTRAMAN_LEGGINGS = ITEMS.register("ultraman_legs",
			() -> new UltraArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(UltraTabs.MISC).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

	public static final DeferredItem<Item> MANTLE_BROOCH_MOTHER = ITEMS.register("mantle_brooch_mother",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","mother_of_ultra","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false))
			{
				public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
					if (slot == EquipmentSlot.HEAD)
						layerInfo.add(new RenderLayerInfo("father_mantle", "ultracape"));
				}
			});
	public static final DeferredItem<Item> MANTLE_BROOCH_FATHER = ITEMS.register("mantle_brooch_father",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","father_of_ultra","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false))
			{
				public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
					if (slot == EquipmentSlot.HEAD)
						layerInfo.add(new RenderLayerInfo("father_mantle", "ultracape"));
				}
			}.addAlternative(MANTLE_BROOCH_MOTHER.get()));
	public static final DeferredItem<Item> MANTLE_BROOCH_TARO = ITEMS.register("mantle_brooch_taro",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","taro","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false))
			{
				public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
					if (slot == EquipmentSlot.HEAD)
						layerInfo.add(new RenderLayerInfo("brother_mantle", "ultracape"));
				}
			}.addAlternative(MANTLE_BROOCH_FATHER.get()));
	public static final DeferredItem<Item> MANTLE_BROOCH_ACE = ITEMS.register("mantle_brooch_ace",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","ace","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false))
			{
				public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
					if (slot == EquipmentSlot.HEAD)
						layerInfo.add(new RenderLayerInfo("brother_mantle", "ultracape"));
				}
			}.addAlternative(MANTLE_BROOCH_TARO.get()));
	public static final DeferredItem<Item> MANTLE_BROOCH_JACK = ITEMS.register("mantle_brooch_jack",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","jack","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false))
			{
				public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
					if (slot == EquipmentSlot.HEAD)
						layerInfo.add(new RenderLayerInfo("brother_mantle", "ultracape"));
					if (slot == EquipmentSlot.HEAD && rider.getHealth()<5) {
						if (((rider.tickCount / 15) & 1) == 0) layerInfo.add(new RenderLayerInfo("red_color_timer",null));
						else layerInfo.add(new RenderLayerInfo("dark_color_timer",null));
					}
				}
			}.addAlternative(MANTLE_BROOCH_ACE.get()));
	public static final DeferredItem<Item> MANTLE_BROOCH_SEVEN = ITEMS.register("mantle_brooch_seven",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","ultra_seven","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false))
			{
				public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
					if (slot == EquipmentSlot.HEAD)
						layerInfo.add(new RenderLayerInfo("brother_mantle", "ultracape"));
					if (slot == EquipmentSlot.HEAD && rider.getHealth()<5) {
						if (((rider.tickCount / 15) & 1) == 0) layerInfo.add(new RenderLayerInfo("ultra_seven_dark_beam_lamp","seven"));
					}
				}
			}.addAlternative(MANTLE_BROOCH_JACK.get()).ChangeModel("geo/seven.geo.json"));
	public static final DeferredItem<Item> MANTLE_BROOCH_ZOFFY = ITEMS.register("mantle_brooch_zoffy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","zoffy","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false))
			{
				public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
					if (slot == EquipmentSlot.HEAD)
						layerInfo.add(new RenderLayerInfo("brother_mantle", "ultracape"));
					if (slot == EquipmentSlot.HEAD && rider.getHealth()<5) {
						if (((rider.tickCount / 15) & 1) == 0) layerInfo.add(new RenderLayerInfo("red_color_timer",null));
						else layerInfo.add(new RenderLayerInfo("dark_color_timer",null));
					}
				}
			}.addAlternative(MANTLE_BROOCH_SEVEN.get()));
	public static final DeferredItem<Item> MANTLE_BROOCH = ITEMS.register("mantle_brooch",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","ultraman","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false))
			{
				public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
					if (slot == EquipmentSlot.HEAD)
						layerInfo.add(new RenderLayerInfo("brother_mantle", "ultracape"));
					if (slot == EquipmentSlot.HEAD && rider.getHealth()<5) {
						if (((rider.tickCount / 15) & 1) == 0) layerInfo.add(new RenderLayerInfo("red_color_timer",null));
						else layerInfo.add(new RenderLayerInfo("dark_color_timer",null));
					}
				}
			}.addAlternative(MANTLE_BROOCH_ZOFFY.get()).AddToTabList(UltraTabs.MISC));

	public static final DeferredItem<Item> NICE_ENERGY = ITEMS.register("nice_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","nice","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.TDG));

	public static final DeferredItem<Item> NICE_DREAMER = ITEMS.register("nice_dreamer",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"nice",NICE_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.TDG).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}