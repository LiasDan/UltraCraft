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

	public static final DeferredItem<Item> SEVEN_ENERGY = ITEMS.register("seven_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","ultra_seven","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> JACK_ENERGY = ITEMS.register("jack_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","jack","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> ACE_ENERGY = ITEMS.register("ace_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","ace","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> FATHER_ENERGY = ITEMS.register("father_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","father_of_ultra","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> TARO_ENERGY = ITEMS.register("taro_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","taro","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> MOTHER_ENERGY = ITEMS.register("mother_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","mother_of_ultra","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> LEO_MANTLE = ITEMS.register("leo_mantle",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"_mantle","leo","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).ChangeModel("geo/ultracape.geo.json","ultracape.animation.json"));

	public static final DeferredItem<Item> LEO_ENERGY = ITEMS.register("leo_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","leo","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false))
			.addSwitchForm(LEO_MANTLE.get()).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> ASTRA_ENERGY = ITEMS.register("astra_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","astra","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> KING_MANTLE = ITEMS.register("king_mantle",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"_mantle","king","king_buckle",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).ChangeModel("geo/ultracape.geo.json","ultracape.animation.json"));

	public static final DeferredItem<Item> KING_ENERGY = ITEMS.register("king_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","king","king_buckle",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false))
			.addSwitchForm(KING_MANTLE.get()).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> JONEUS_ENERGY = ITEMS.register("joneus_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","joneus","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> ELEK_ENERGY = ITEMS.register("elek_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","elek","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> LOTO_ENERGY = ITEMS.register("loto_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","loto","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> EIGHTY_ENERGY = ITEMS.register("eighty_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","eighty","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> YULLIAN_ENERGY = ITEMS.register("yullian_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","yullian","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> SCOTT_ENERGY = ITEMS.register("scott_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","scott","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> CHUCK_ENERGY = ITEMS.register("chuck_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","chuck","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> BETH_ENERGY = ITEMS.register("beth_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","beth","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> GREAT_ENERGY = ITEMS.register("great_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","great","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> POWERED_ENERGY = ITEMS.register("powered_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","powered","",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.ULTRAMAN));

	public static final DeferredItem<Item> ZEARTH_ENERGY = ITEMS.register("zearth_energy",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","zearth","",
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

	public static final DeferredItem<Item> ULTRA_EYE = ITEMS.register("ultra_eye",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"ultra_seven",SEVEN_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

	public static final DeferredItem<Item> COLOR_TIMER_JACK = ITEMS.register("color_timer_jack",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"jack",JACK_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

	public static final DeferredItem<Item> ULTRA_RINGS = ITEMS.register("ultra_rings",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"ace",ACE_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
	public static final DeferredItem<Item> COLOR_TIMER_FATHER = ITEMS.register("color_timer_father",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"father_of_ultra",FATHER_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

	public static final DeferredItem<Item> ULTRA_BADGE = ITEMS.register("ultra_badge",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"taro",TARO_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
	public static final DeferredItem<Item> COLOR_TIMER_MOTHER = ITEMS.register("color_timer_mother",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"mother_of_ultra",MOTHER_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

	public static final DeferredItem<Item> LEO_RING = ITEMS.register("leo_ring",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"leo",LEO_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
	public static final DeferredItem<Item> COLOR_TIMER_ASTRA = ITEMS.register("color_timer_astra",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"astra",ASTRA_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
	public static final DeferredItem<Item> KING_BUCKLE = ITEMS.register("king_buckle",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"king",KING_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

	public static final DeferredItem<Item> BEAM_FLASHER = ITEMS.register("beam_flasher",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"joneus",JONEUS_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
	public static final DeferredItem<Item> BEAM_FLASHER_ELEK = ITEMS.register("beam_flasher_elek",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"elek",ELEK_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
	public static final DeferredItem<Item> BEAM_FLASHER_LOTO = ITEMS.register("beam_flasher_loto",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"loto",LOTO_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

	public static final DeferredItem<Item> BRIGHT_STICK = ITEMS.register("bright_stick",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"eighty",EIGHTY_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
	public static final DeferredItem<Item> BRIGHT_BRACELET = ITEMS.register("bright_bracelet",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"yullian",YULLIAN_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

	public static final DeferredItem<Item> USA_RISER = ITEMS.register("usa_riser",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"scott",SCOTT_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
	public static final DeferredItem<Item> USA_RISER_CHUCK = ITEMS.register("usa_riser_chuck",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"chuck",CHUCK_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
	public static final DeferredItem<Item> BETH_RISER = ITEMS.register("beth_riser",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"beth",BETH_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

	public static final DeferredItem<Item> DELTA_PLASMA = ITEMS.register("delta_plasma",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"great",GREAT_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
	public static final DeferredItem<Item> FLASH_PRISM = ITEMS.register("flash_prism",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"powered",POWERED_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
	public static final DeferredItem<Item> PIKARI_BRUSH = ITEMS.register("pikari_brush",
			() -> new UltraRiserItem(ArmorMaterials.DIAMOND,"zearth",ZEARTH_ENERGY,ULTRAMAN_HELMET,ULTRAMAN_CHESTPLATE,ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ULTRAMAN).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}