package com.liasdan.ultracraft.items.others;


import com.google.common.collect.Lists;
import com.liasdan.ultracraft.items.OtherItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public class UltraFormChangeItem extends BaseItem {

	private String FORM_NAME;
	public int Slot =1;
	private List<MobEffectInstance> potionEffectList;
	private int BELT;
	private List<Item> NEEDITEM = new ArrayList<Item>();
	protected String RANGER_NAME;
	protected String OVERRIDE_RANGER_NAME;
	private String BELT_TEX;
	private String UPDATED_MODEL;
	private String UPDATED_BELT;
	private String FLYING_MODEL;
	private Boolean FLYING_TEXT = false;
	public Item SHIFT_ITEM = Items.APPLE;
	public Item SWITCH_ITEM;
	protected Boolean RESET_FORM = false;
	public List<UltraFormChangeItem> alternative = new ArrayList<UltraFormChangeItem>();
	public UltraFormChangeItem alsoChange2ndSlot;
	public String[] compatibilityList= new String[] {""};
	private Boolean HAS_NEED_ITEM_LIST = false;
	public List<Item> needItemList;

	private UltraFormChangeItem NEED_FORM_SLOT_1;
	private UltraFormChangeItem NEED_FORM_SLOT_2;
	private UltraFormChangeItem NEED_FORM_SLOT_3;
	private UltraFormChangeItem NEED_FORM_SLOT_4;

	private Boolean SET_SHOW_FACE = false;
	private Boolean SET_SHOW_UNDER = false;


	public UltraFormChangeItem(Properties properties, int belt, String formName, String rangername, String beltTex, MobEffectInstance... effects) {
		super( properties);

		potionEffectList = Lists.newArrayList(effects);
		FORM_NAME = formName;
		BELT_TEX = beltTex;
		BELT = belt;
		RANGER_NAME = rangername;
	}

	public UltraFormChangeItem(Properties properties, int belt, String formName, String rangername, MobEffectInstance... effects) {
		super( properties);

		potionEffectList = Lists.newArrayList(effects);
		FORM_NAME = formName;
		BELT = belt;
		RANGER_NAME = rangername;
	}

	public List<MobEffectInstance> getPotionEffectList() {
		return potionEffectList;
	}

	public int getBelt() {
		return BELT;
	}

	public String getFormName(Boolean isFlaying) {
		if (isFlaying&FLYING_TEXT) return FORM_NAME+"_wing";
		else return FORM_NAME;
	}


	public String getBeltTex() {
		return BELT_TEX;
	}

	public String get_Model() {
		if (UPDATED_MODEL!=null) return UPDATED_MODEL;
		return "geo/ultra.geo.json";
	}

	public String getBeltModel() {
		if (UPDATED_BELT!=null) return UPDATED_BELT;
		return "geo/ultrabelt.geo.json";
	}

	public Boolean get_Show_Face() {
		return SET_SHOW_FACE;
	}

	public Boolean get_Show_Under() {
		return SET_SHOW_UNDER;
	}

	public String getRangerName(String name) {
		return (OVERRIDE_RANGER_NAME!=null ? OVERRIDE_RANGER_NAME : name);
	}

	public String get_FlyingModel() {
		return FLYING_MODEL;
	}
	public Boolean HasWingsIfFlying() {
		return FLYING_TEXT;
	}
	
	public UltraFormChangeItem alsoChange2ndSlot(Item item) {
		alsoChange2ndSlot=  (UltraFormChangeItem) item;
		return this;
	}

	public UltraFormChangeItem ChangeModel(String model) {
		UPDATED_MODEL=model;
		return this;
	}

	public UltraFormChangeItem ChangeBeltModel(String beltmodel) {
		UPDATED_BELT=beltmodel;
		return this;
	}

	public UltraFormChangeItem SetShowFace() {
		SET_SHOW_FACE = true;
		return this;
	}

	public UltraFormChangeItem SetShowUnder() {
		SET_SHOW_UNDER = true;
		return this;
	}

	public UltraFormChangeItem ChangeRangerName(String name) {
		OVERRIDE_RANGER_NAME=name;
		return this;
	}
	
	public UltraFormChangeItem ChangeSlot(int slot) {
		Slot=slot;
		return this;
	}

	public UltraFormChangeItem ifFlyingModelResource(String model) {
		FLYING_TEXT=true;
		FLYING_MODEL=model;
		return this;
	}

	public UltraFormChangeItem addAlternative(Item item) {
		alternative.add((UltraFormChangeItem) item);
		return this;
	}

	public UltraFormChangeItem BackToBase() {
		RESET_FORM=true;
		return this;
	}

	public UltraFormChangeItem addNeedForm(Item  item, int slot) {
		if (slot==1)NEED_FORM_SLOT_1=((UltraFormChangeItem)item);
		else if (slot==2)NEED_FORM_SLOT_2=((UltraFormChangeItem)item);
		else if (slot==3)NEED_FORM_SLOT_3=((UltraFormChangeItem)item);
		else if (slot==4)NEED_FORM_SLOT_4=((UltraFormChangeItem)item);
		return this;
	}
	
	public UltraFormChangeItem addNeedItem(Item item) {
		NEEDITEM.add(item);
		return this;
	}

	public UltraFormChangeItem addShiftForm(Item item) {
		SHIFT_ITEM=item;
		return this;
	}
	
	public UltraFormChangeItem addSwitchForm(Item item) {
		SWITCH_ITEM=item;
		return this;
	}

	public UltraFormChangeItem AddNeedItemList(List<Item> needChangerItem) {
		needItemList=needChangerItem;
		HAS_NEED_ITEM_LIST=true;
		return this;
	}
	
	public UltraFormChangeItem AddCompatibilityList(String[] List) {
		 compatibilityList=List;
		return this;
	}

	public Boolean iscompatible(String rider) {
		
		for (int i = 0; i < compatibilityList.length; i++)
		{
			if (compatibilityList[i]==rider){
				return true;
			}
		}
		
		return false;
	}
	
	public Boolean CanChange(Player player, UltraRiserItem belt, ItemStack stack) {

		if (this == OtherItems.BLANK_FORM.get()) {
			return true;
		}
		if(belt.Rider!=RANGER_NAME&!iscompatible(belt.Rider)) {
			return false;
		}
		if ( !NEEDITEM.isEmpty()) {
			for (int i = 0; i < NEEDITEM.size(); i++)
			{
				if (player.getInventory().countItem(NEEDITEM.get(i))==0){
					return false;
				}
			}
		}
		if (NEED_FORM_SLOT_1!=null )if (UltraRiserItem.get_Form_Item(stack, 1)!=NEED_FORM_SLOT_1)return false;
		if (NEED_FORM_SLOT_2!=null )if (UltraRiserItem.get_Form_Item(stack, 2)!=NEED_FORM_SLOT_1)return false;
		if (NEED_FORM_SLOT_3!=null )if (UltraRiserItem.get_Form_Item(stack, 3)!=NEED_FORM_SLOT_1)return false;
		if (NEED_FORM_SLOT_4!=null )if (UltraRiserItem.get_Form_Item(stack, 4)!=NEED_FORM_SLOT_1)return false;
		
		if  (HAS_NEED_ITEM_LIST) {
			for (int i = 0; i < needItemList.size(); i++)
			{
				if (player.getInventory().countItem(needItemList.get(i))==0){
					return false;
				}
			}
		}
		return true;
	}
	
	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {

		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);

		ItemStack BELT = p_41129_.getItemBySlot(EquipmentSlot.FEET);
		ItemStack MECHA = p_41129_.getItemBySlot(EquipmentSlot.HEAD);

		if (BELT.getItem() instanceof UltraRiserItem belt) {

			if (SHIFT_ITEM instanceof UltraFormChangeItem & p_41129_.isShiftKeyDown()) {
				((UltraFormChangeItem)SHIFT_ITEM).use(p_41128_, p_41129_, p_41130_);
			}
			else if (CanChange(p_41129_,belt,BELT)) {
				if (RESET_FORM) UltraRiserItem.reset_Form_Item(p_41129_.getItemBySlot(EquipmentSlot.FEET));

				if (alsoChange2ndSlot !=null) UltraRiserItem.set_Form_Item(p_41129_.getItemBySlot(EquipmentSlot.FEET),alsoChange2ndSlot, 2);

				if (SWITCH_ITEM!=null& UltraRiserItem.get_Form_Item(p_41129_.getItemBySlot(EquipmentSlot.FEET), Slot)==this) UltraRiserItem.set_Form_Item(p_41129_.getItemBySlot(EquipmentSlot.FEET),SWITCH_ITEM, Slot);
					else UltraRiserItem.set_Form_Item(p_41129_.getItemBySlot(EquipmentSlot.FEET),this, Slot);

			}else if(!alternative.isEmpty()){

				for (int i = 0; i < alternative.size(); i++)
				{
					UltraFormChangeItem alternativeItem_form_change = alternative.get(i);
					alternativeItem_form_change.use(p_41128_, p_41129_, p_41130_);
				}
			}
		}

		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());

	}
}

/**
	public Item getWing() {
		return WINGS;
	}


	public boolean getNeedItem(Player  playerIn) {
		boolean NEED = true;
		if (NEEDSITEM.isEmpty()){
			NEED=true;
		}
		else {
			for (int i = 0; i < NEEDSITEM.size(); i++)
			{
				if (!playerIn.inventory.hasItemStack(new ItemStack(NEEDSITEM.get(i)))){
						(new ItemStack(NEEDSITEM.get(i)))){
					NEED=false;
				}
			}
		}
		return NEED;
	}


	public RiderFormChangeItem addWing(Item wings) {
		WINGS = wings;
		return this;
	}
	public RiderFormChangeItem ShiftForm(Item ShiftItem) {
		STIFT_ITEM = ShiftItem;
		return this;
	}

	public RiderFormChangeItem addAlternative(RiderFormChangeItem alternativeItem) {
		alternative.add(alternativeItem);
		return this;
	}
	public RiderFormChangeItem addNeedItem(Item needitem) {
		NEEDSITEM.add(needitem);
		return this;
	}



 **/
