package com.liasdan.ultracraft.items;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.effect.EffectCore;
import com.liasdan.ultracraft.items.others.UltraArmorItem;
import com.liasdan.ultracraft.items.others.UltraFormChangeItem;
import com.liasdan.ultracraft.items.others.UltraRiserItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UltramanItems {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltraCraftCore.MODID);

	public static final DeferredItem<Item> ULTRAMAN_ENERGY = ITEMS.register("ultraman_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"","ultraman","",
            		new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> ZOFFY_ENERGY = ITEMS.register("zoffy_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","zoffy","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> ULTRAMAN_HELMET = ITEMS.register("ultraman_head",
            () -> new UltraArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
    public static final DeferredItem<Item> ULTRAMAN_CHESTPLATE = ITEMS.register("ultraman_torso",
            () -> new UltraArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
    public static final DeferredItem<Item> ULTRAMAN_LEGGINGS = ITEMS.register("ultraman_legs",
            () -> new UltraArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
    
    public static final DeferredItem<Item> BETA_CAPSULE = ITEMS.register("beta_capsule",
    		() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"ultraman",ULTRAMAN_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

	public static final DeferredItem<Item> BETA_CAPSULE_ZOFFY = ITEMS.register("beta_capsule_zoffy",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"zoffy",ZOFFY_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}