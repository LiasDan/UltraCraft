package com.liasdan.ultracraft.items;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.effect.EffectCore;
import com.liasdan.ultracraft.items.others.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class OtherItems {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltraCraftCore.MODID);

//	public static final DeferredItem<Item> BASE_SWORD = ITEMS.register("base_sword",
//			() -> new BaseItem(new Item.Properties()).AddToTabList(UltraTabs.MISC));

	public static final DeferredItem<Item> BLANK_FORM = ITEMS.register("blank_form",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","",""));

	public static final DeferredItem<Item> LAND_OF_LIGHT_FRAGMENT = ITEMS.register("land_of_light_fragment",
			() -> new LandOfLightFragment(new Item.Properties()).AddToTabList(UltraTabs.MISC));

	public static final DeferredItem<Item> NICE_ENERGY = ITEMS.register("nice_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","nice","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.MISC));

	public static final DeferredItem<Item> ULTRAMAN_HELMET = ITEMS.register("ultraman_head",
			() -> new UltraArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(UltraTabs.MISC).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
	public static final DeferredItem<Item> ULTRAMAN_CHESTPLATE = ITEMS.register("ultraman_torso",
			() -> new UltraArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(UltraTabs.MISC).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
	public static final DeferredItem<Item> ULTRAMAN_LEGGINGS = ITEMS.register("ultraman_legs",
			() -> new UltraArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(UltraTabs.MISC).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

	public static final DeferredItem<Item> NICE_DREAMER = ITEMS.register("nice_dreamer",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"nice",NICE_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.MISC).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}