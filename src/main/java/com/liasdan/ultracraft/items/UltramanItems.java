package com.liasdan.ultracraft.items;

import com.liasdan.supersentaicraft.SuperSentaiCraftCore;
import com.liasdan.supersentaicraft.effect.EffectCore;
import com.liasdan.supersentaicraft.items.goranger.GorangerBeltItem;
import com.liasdan.supersentaicraft.items.others.*;
import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.items.others.UltraRiserItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UltramanItems {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltraCraftCore.MODID);
    
	public static final DeferredItem<Item> GORANGER_LOGO = ITEMS.register("goranger_logo",
    		() -> new BaseItem(new Item.Properties()).AddToTabList(UltraTabs.GORANGER));

	public static final DeferredItem<Item> AKA_STAR = ITEMS.register("aka_star",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","akaranger","akaranger_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.BOOST, 40, 2,true,false))
            .ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(UltraTabs.GORANGER));

	public static final DeferredItem<Item> AO_STAR = ITEMS.register("ao_star",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","aoranger","aoranger_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.BOOST, 40, 2,true,false)).AddToTabList(UltraTabs.GORANGER));

	public static final DeferredItem<Item> KI_STAR = ITEMS.register("ki_star",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","kiranger","kiranger_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.BOOST, 40, 2,true,false)).AddToTabList(UltraTabs.GORANGER));

	public static final DeferredItem<Item> MOMO_STAR = ITEMS.register("momo_star",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","momoranger","momoranger_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.BOOST, 40, 2,true,false)).AddToTabList(UltraTabs.GORANGER));

	public static final DeferredItem<Item> MIDO_STAR = ITEMS.register("mido_star",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","midoranger","midoranger_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.BOOST, 40, 2,true,false)).AddToTabList(UltraTabs.GORANGER));
    
	public static final DeferredItem<Item> AORANGER_MANGA = ITEMS.register("aoranger_manga",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_manga","aoranger","aoranger_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.BOOST, 40, 2,true,false)));
	
	public static final DeferredItem<Item> KIRANGER_MANGA = ITEMS.register("kiranger_manga",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_manga","kiranger","kiranger_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.BOOST, 40, 2,true,false)));
	
	public static final DeferredItem<Item> MOMORANGER_MANGA = ITEMS.register("momoranger_manga",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_manga","momoranger","momoranger_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.BOOST, 40, 2,true,false)));
	
	public static final DeferredItem<Item> MIDORANGER_MANGA = ITEMS.register("midoranger_manga",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_manga","midoranger","midoranger_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.BOOST, 40, 2,true,false)));
	
	public static final DeferredItem<Item> GORANGER_MANGA = ITEMS.register("goranger_manga",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_manga","akaranger","akaranger_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.BOOST, 40, 2,true,false))
            .ChangeBeltModel("geo/rangerbeltextra.geo.json")
            .addAlternative(AORANGER_MANGA.get()).addAlternative(KIRANGER_MANGA.get()).addAlternative(MOMORANGER_MANGA.get()).addAlternative(MIDORANGER_MANGA.get())
            .AddToTabList(UltraTabs.GORANGER));
	
	public static final DeferredItem<Item> GORANGER_HELMET = ITEMS.register("goranger_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(UltraTabs.GORANGER).ChangeRepairItem(GORANGER_LOGO.get()));
    public static final DeferredItem<Item> GORANGER_CHESTPLATE = ITEMS.register("goranger_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(UltraTabs.GORANGER).ChangeRepairItem(GORANGER_LOGO.get()));
    public static final DeferredItem<Item> GORANGER_LEGGINGS = ITEMS.register("goranger_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(UltraTabs.GORANGER).ChangeRepairItem(GORANGER_LOGO.get()));
    
    public static final DeferredItem<Item> BETA_CAPSULE = ITEMS.register("beta_capsule",
    		() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"ultraman",AKA_STAR,GORANGER_HELMET,GORANGER_CHESTPLATE,GORANGER_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.GORANGER).ChangeRepairItem(GORANGER_LOGO.get()));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}