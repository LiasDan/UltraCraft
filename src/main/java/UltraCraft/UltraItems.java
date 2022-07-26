package UltraCraft;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import UltraCraft.blocks.custom.BlockType;
import UltraCraft.blocks.custom.CustomBlock;
import UltraCraft.blocks.custom.Property;
import UltraCraft.blocks.decor_block;
import UltraCraft.blocks.ore_block;
import UltraCraft.item.*;
import UltraCraft.item.ultraman.item_form_change;
import UltraCraft.item.ultraman.item_ultra_armor;
import UltraCraft.item.ultraman.item_ultra_riser;
import UltraCraft.potion.PotionCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static UltraCraft.blocks.custom.Property.TRANSPARENT;
import static UltraCraft.blocks.custom.Property.WALKTHROUGH;
import static java.util.Objects.*;

public class UltraItems 
{
	public static Item blanknoitem = new Item_ore("blanknoitem");
	public static Item blanknoform = new item_form_change("blanknoform",item_ultra_riser.class,blanknoitem,"","");
	
	public static Item land_of_light_fragment = new Item_ore("land_of_light_fragment").setCreativeTab(Tabs.tabUltraman);

	public static Item ultraman_head = new item_ultra_armor("ultraman_head", item_ultra_riser.class, ArmorMaterial.DIAMOND, 4, EntityEquipmentSlot.HEAD, land_of_light_fragment).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	public static Item ultraman_torso = new item_ultra_armor("ultraman_torso", item_ultra_riser.class, ArmorMaterial.DIAMOND, 4, EntityEquipmentSlot.CHEST, land_of_light_fragment).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	public static Item ultraman_legs = new item_ultra_armor("ultraman_legs", item_ultra_riser.class, ArmorMaterial.DIAMOND, 4, EntityEquipmentSlot.LEGS, land_of_light_fragment).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	
	public static Item ultraman_energy = new item_form_change("ultraman_energy", item_ultra_riser.class, blanknoitem, "", "ultraman",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).setCreativeTab(Tabs.tabUltraman);

	public static Item zoffy_energy = new item_form_change("zoffy_energy", item_ultra_riser.class, blanknoitem, "", "zoffy",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).setCreativeTab(Tabs.tabUltraman);

	public static Item seven_energy = new item_form_change("seven_energy", item_ultra_riser.class, blanknoitem, "", "ultra_seven",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).setCreativeTab(Tabs.tabUltraman);

	public static Item jack_energy = new item_form_change("jack_energy", item_ultra_riser.class, blanknoitem, "", "jack",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).setCreativeTab(Tabs.tabUltraman);
	
	public static Item ace_energy = new item_form_change("ace_energy", item_ultra_riser.class, blanknoitem, "", "father_of_ultra",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).setCreativeTab(Tabs.tabUltraman);
	
	public static Item father_energy = new item_form_change("father_energy", item_ultra_riser.class, blanknoitem, "", "ace",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).setCreativeTab(Tabs.tabUltraman);
	
	public static Item taro_energy = new item_form_change("taro_energy", item_ultra_riser.class, blanknoitem, "", "taro",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).setCreativeTab(Tabs.tabUltraman);

	public static Item mother_energy = new item_form_change("mother_energy", item_ultra_riser.class, blanknoitem, "", "mother_of_ultra",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).setCreativeTab(Tabs.tabUltraman);

	public static Item leo_mantle = new item_form_change("leo_mantle", item_ultra_riser.class, blanknoitem, "", "leo",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).Rend2ndLyer("leo_mantle");
	
	public static Item leo_energy = new item_mantle(leo_mantle, "leo_energy", item_ultra_riser.class, blanknoitem, "", "leo",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).setCreativeTab(Tabs.tabUltraman);

	public static Item astra_energy = new item_form_change("astra_energy", item_ultra_riser.class, blanknoitem, "", "astra",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).setCreativeTab(Tabs.tabUltraman);

	public static Item king_mantle = new item_form_change("king_mantle", item_ultra_riser.class, blanknoitem, "", "leo",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).Rend2ndLyer("king_armor");
	
	public static Item king_energy = new item_mantle(king_mantle, "king_energy", item_ultra_riser.class, blanknoitem, "", "king",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).Rend2ndLyer("king_mantle").setCreativeTab(Tabs.tabUltraman);

	public static Item joneus_energy = new item_form_change("joneus_energy", item_ultra_riser.class, blanknoitem, "", "joneus",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).setCreativeTab(Tabs.tabUltraman);

	public static Item elek_energy = new item_form_change("elek_energy", item_ultra_riser.class, blanknoitem, "", "elek",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).Rend2ndLyer("elek_armor").setCreativeTab(Tabs.tabUltraman);

	public static Item loto_energy = new item_form_change("loto_energy", item_ultra_riser.class, blanknoitem, "", "loto",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).setCreativeTab(Tabs.tabUltraman);

	public static Item eighty_energy = new item_form_change("eighty_energy", item_ultra_riser.class, blanknoitem, "", "eighty",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).setCreativeTab(Tabs.tabUltraman);
	
	public static Item yullian_energy = new item_form_change("yullian_energy", item_ultra_riser.class, blanknoitem, "", "yullian",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).setCreativeTab(Tabs.tabUltraman);

	public static Item scott_energy = new item_form_change("scott_energy", item_ultra_riser.class, blanknoitem, "", "scott",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).setCreativeTab(Tabs.tabUltraman);

	public static Item chuck_energy = new item_form_change("chuck_energy", item_ultra_riser.class, blanknoitem, "", "chuck",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).Rend2ndLyer("chuck_armor").setCreativeTab(Tabs.tabUltraman);

	public static Item beth_energy = new item_form_change("beth_energy", item_ultra_riser.class, blanknoitem, "", "beth",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).setCreativeTab(Tabs.tabUltraman);

	public static Item great_energy = new item_form_change("great_energy", item_ultra_riser.class, blanknoitem, "", "great",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).setCreativeTab(Tabs.tabUltraman);

	public static Item powered_energy = new item_form_change("powered_energy", item_ultra_riser.class, blanknoitem, "", "powered",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).setCreativeTab(Tabs.tabUltraman);

	public static Item zearth_energy = new item_form_change("zearth_energy", item_ultra_riser.class, blanknoitem, "", "zearth",
			new PotionEffect(PotionCore.FLY_POTION, 20, 0,true,false),
			new PotionEffect(MobEffects.STRENGTH, 20, 4,true,false),
			new PotionEffect(MobEffects.JUMP_BOOST, 20, 1,true,false),
			new PotionEffect(MobEffects.NIGHT_VISION, 250, 1,true,false),
			new PotionEffect(MobEffects.RESISTANCE, 20, 4,true,false)).setCreativeTab(Tabs.tabUltraman);

	public static Item beta_capsule = new item_ultra_riser("beta_capsule",ArmorMaterial.DIAMOND, 4,"ultraman",(item_form_change) ultraman_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	public static Item beta_capsule_zoffy = new item_ultra_riser("beta_capsule_zoffy",ArmorMaterial.DIAMOND, 4,"zoffy",(item_form_change) zoffy_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	
	public static Item ultra_eye = new item_ultra_riser("ultra_eye",ArmorMaterial.DIAMOND, 4,"ultra_seven",(item_form_change) seven_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	
	public static Item color_timer_jack = new item_ultra_riser("color_timer_jack",ArmorMaterial.DIAMOND, 4,"jack",(item_form_change) jack_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	
	public static Item ultra_rings = new item_ultra_riser("ultra_rings",ArmorMaterial.DIAMOND, 4,"ace",(item_form_change) ace_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	public static Item color_timer_father = new item_ultra_riser("color_timer_father",ArmorMaterial.DIAMOND, 4,"father_of_ultra",(item_form_change) father_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);

	public static Item ultra_badge = new item_ultra_riser("ultra_badge",ArmorMaterial.DIAMOND, 4,"taro",(item_form_change) taro_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	public static Item color_timer_mother = new item_ultra_riser("color_timer_mother",ArmorMaterial.DIAMOND, 4,"mother_of_ultra",(item_form_change) mother_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	
	public static Item leo_ring = new item_ultra_riser("leo_ring",ArmorMaterial.DIAMOND, 4,"leo",(item_form_change) leo_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	public static Item color_timer_astra = new item_ultra_riser("color_timer_astra",ArmorMaterial.DIAMOND, 4,"astra",(item_form_change) astra_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	public static Item king_buckle = new item_ultra_riser("king_buckle",ArmorMaterial.DIAMOND, 4,"king",(item_form_change) king_energy, ultraman_head, ultraman_torso, ultraman_legs).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	
	public static Item beam_flasher = new item_ultra_riser("beam_flasher",ArmorMaterial.DIAMOND, 4,"joneus",(item_form_change) joneus_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	public static Item beam_flasher_elek = new item_ultra_riser("beam_flasher_elek",ArmorMaterial.DIAMOND, 4,"elek",(item_form_change) elek_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	public static Item beam_flasher_loto = new item_ultra_riser("beam_flasher_loto",ArmorMaterial.DIAMOND, 4,"loto",(item_form_change) loto_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	
	public static Item bright_stick = new item_ultra_riser("bright_stick",ArmorMaterial.DIAMOND, 4,"eighty",(item_form_change) eighty_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	public static Item bright_bracelet = new item_ultra_riser("bright_bracelet",ArmorMaterial.DIAMOND, 4,"yullian",(item_form_change) yullian_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	
	public static Item usa_riser = new item_ultra_riser("usa_riser",ArmorMaterial.DIAMOND, 4,"scott",(item_form_change) scott_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	public static Item usa_riser_chuck = new item_ultra_riser("usa_riser_chuck",ArmorMaterial.DIAMOND, 4,"chuck",(item_form_change) chuck_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	public static Item beth_riser = new item_ultra_riser("beth_riser",ArmorMaterial.DIAMOND, 4,"beth",(item_form_change) beth_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	
	public static Item delta_plasma = new item_ultra_riser("delta_plasma",ArmorMaterial.DIAMOND, 4,"great",(item_form_change) great_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	public static Item flash_prism = new item_ultra_riser("flash_prism",ArmorMaterial.DIAMOND, 4,"powered",(item_form_change) powered_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	public static Item pikari_brush = new item_ultra_riser("pikari_brush",ArmorMaterial.DIAMOND, 4,"zearth",(item_form_change) zearth_energy, ultraman_head, ultraman_torso, ultraman_legs).belt(true).setMaxStackSize(1).setCreativeTab(Tabs.tabUltraman);
	
	public static void init() 
	{
		
	}
	
	//public static void init(){}
}