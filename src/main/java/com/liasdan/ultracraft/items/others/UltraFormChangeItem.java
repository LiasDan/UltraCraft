package com.liasdan.ultracraft.items.others;


import com.google.common.collect.Lists;
import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.effect.EffectCore;
import com.liasdan.ultracraft.items.OtherItems;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.GeckoLibCache;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UltraFormChangeItem extends BaseItem {

	private String FORM_NAME;
	public int Slot =1;
	private int OffhandSlot =2;
	private Boolean Offhand = false;

	private List<MobEffectInstance> potionEffectList;
	private int BELT;
	private List<Item> NEEDITEM = new ArrayList<Item>();
	protected String RANGER_NAME;
	protected String OVERRIDE_RANGER_NAME;

	private String BELT_TEX;
	private Boolean IS_GLOWING = false;
	private Boolean IS_BELT_GLOWING = false;
	private Boolean HAS_STATIC_WINGS = false;
	private String UPDATED_MODEL;
	private String UPDATED_BELT_MODEL;
	private String UPDATED_MODEL_ANIMATION;
	private String FLYING_MODEL;
	private Boolean SET_PLAYER_MODEL_INVISIBLE = false;
	private Boolean SET_SHOW_FACE = false;
	private Boolean SET_SHOW_UNDER = false;

	private Boolean USE_WALK = false;
	private Boolean HAS_CAPE = false;

	private Boolean FLYING_TEXT = false;
	private Item SHIFT_ITEM = Items.APPLE;
	private Item SWITCH_ITEM;
	private Boolean RESET_FORM = false;
	private Boolean RESET_FORM_MAIN = false;

	private Boolean SET_TO_ARMOR_FORM = false;

	private List<UltraFormChangeItem> alternative = new ArrayList<UltraFormChangeItem>();
	private UltraFormChangeItem alsoChange1stSlot;
	private UltraFormChangeItem alsoChange2ndSlot;

	private Boolean hasIncompatibleForms = false;
	private List<UltraFormChangeItem> incompatibleForms= new ArrayList<UltraFormChangeItem>();

	public String[] compatibilityList= new String[] {""};
	public List<Item> needItemList = new ArrayList<Item>();

	private Boolean NEED_BASE_FORM = false;
	private UltraFormChangeItem NEED_FORM_SLOT_1;
	private UltraFormChangeItem NEED_FORM_SLOT_2;
	private UltraFormChangeItem NEED_FORM_SLOT_3;
	private UltraFormChangeItem NEED_FORM_SLOT_4;

	private int timeoutDuration=0;
	private int lockDuration=0;
	private UltraFormChangeItem REVERT_FORM;

	private Boolean IGNORE_BELT_TEXT = false;

	private int Store_num =1;


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

	public int getSlot() {
		return Slot;
	}

	public int getBelt() {
		return BELT;
	}

	public String getFormName(Boolean isFlying) {
		return (isFlying&FLYING_TEXT ? FORM_NAME+"_wing" : FORM_NAME);
	}

	public String getRangerName(String name) {
		return (OVERRIDE_RANGER_NAME!=null ? OVERRIDE_RANGER_NAME : name);
	}

	public Boolean getRESET_FORM(){return RESET_FORM;}

	public Item getSHIFT_ITEM(){return SHIFT_ITEM;}

	public UltraFormChangeItem getAlsoChange2ndSlot(){return alsoChange2ndSlot;}

	public String getBeltTex() {
		return BELT_TEX;
	}

	public List<UltraFormChangeItem> getAlternative () {
		return alternative;
	}


	public Boolean getIgnoreOverrideBeltText() {
		return IGNORE_BELT_TEXT;
	}

	public String get_Belt_Model() {
		return (UPDATED_BELT_MODEL!=null ? UPDATED_BELT_MODEL : "geo/ultrabelt.geo.json");
	}

	public String get_Model(String rangerName) {
		if (UPDATED_MODEL!=null) return UPDATED_MODEL;
		ResourceLocation FORM_MODEL = ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "geo/"+getRangerName(rangerName)+FORM_NAME+".geo.json");
		return (GeckoLibCache.getBakedModels().get(FORM_MODEL)!=null ? getRangerName(rangerName)+FORM_NAME+".geo.json" : (get_Has_Static_Wings() ? "geo/ultrawing.geo.json" : "geo/ultra.geo.json"));
	}

	public Boolean get_Show_Face() {
		return SET_SHOW_FACE;
	}

	public Boolean get_Show_under() {
		return SET_SHOW_UNDER;
	}

	public Boolean get_Is_Glowing() {
		return IS_GLOWING;
	}

	public Boolean get_has_cape() {
		return HAS_CAPE;
	}
	public Boolean get_Walk() {
		return USE_WALK;
	}

	public Boolean get_Is_Belt_Glowing() {
		return IS_BELT_GLOWING;
	}

	public Boolean get_Has_Static_Wings() {
		return HAS_STATIC_WINGS;
	}

	public int get_Stored_num() {
		return Store_num;
	}

	public String get_FlyingModel(String rangerName) {
		if (FLYING_MODEL!=null) return FLYING_MODEL;
		ResourceLocation FORM_MODEL = ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "geo/"+getRangerName(rangerName)+FORM_NAME+"_wing.geo.json");
		return (GeckoLibCache.getBakedModels().get(FORM_MODEL)!=null ? getRangerName(rangerName)+FORM_NAME+"_wing.geo.json" : "ultrawingbelt.geo.json");
	}
	public Boolean HasWingsIfFlying() {
		return FLYING_TEXT;
	}

	public UltraFormChangeItem AddIncompatibleForm(Item item) {
		incompatibleForms.add((UltraFormChangeItem) item);
		hasIncompatibleForms=true;
		return this;
	}

	public UltraFormChangeItem alsoChange1stSlot(Item item) {
		alsoChange1stSlot=  (UltraFormChangeItem) item;
		return this;
	}

	public UltraFormChangeItem alsoChange2ndSlot(Item item) {
		alsoChange2ndSlot=  (UltraFormChangeItem) item;
		return this;
	}

	public UltraFormChangeItem ChangeRangerName(String name) {
		OVERRIDE_RANGER_NAME=name;
		return this;
	}

	public UltraFormChangeItem ChangeModel(String model) {
		UPDATED_MODEL=model;
		return this;
	}

	public UltraFormChangeItem SetPalyerModelInvisible() {
		SET_PLAYER_MODEL_INVISIBLE = true;
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

	public UltraFormChangeItem ChangeBeltModel(String model) {
		UPDATED_BELT_MODEL=model;
		return this;
	}

	public UltraFormChangeItem ChangeSlot(int slot) {
		Slot=slot;
		return this;
	}

	public int getTimeoutDuration() {
		return this.timeoutDuration;
	}

	public int getLockDuration() {
		return this.lockDuration;
	}

	public UltraFormChangeItem getRevertForm() {
		return this.REVERT_FORM;
	}

	public UltraFormChangeItem hasTimeout(int timeout, int lock, UltraFormChangeItem revertsTo) {
		timeoutDuration = timeout;
		lockDuration = lock;
		REVERT_FORM = revertsTo;
		return this;
	}

	public UltraFormChangeItem AddNum(int num) {
		Store_num=num;
		return this;
	}
	public UltraFormChangeItem SetOffhandSlot(int slot) {
		OffhandSlot=slot;
		Offhand=true;
		return this;
	}

	public UltraFormChangeItem hasFlyingWings(@Nullable String model) {
		FLYING_TEXT=true;
		if (model!=null) FLYING_MODEL=model;
		return this;
	}

	public UltraFormChangeItem addAlternative(Item item) {
		alternative.add((UltraFormChangeItem) item);
		return this;
	}

	public UltraFormChangeItem ResetFormToBase() {
		RESET_FORM=true;
		return this;
	}
	public UltraFormChangeItem ResetFormToBaseIfMain() {
		RESET_FORM_MAIN=true;
		return this;
	}
	public UltraFormChangeItem SetFormToArmor() {
		SET_TO_ARMOR_FORM=true;
		return this;
	}

	public UltraFormChangeItem IsGlowing() {
		IS_GLOWING=true;
		return this;
	}

	public UltraFormChangeItem HasCape() {
		HAS_CAPE=true;
		return this;
	}

	public UltraFormChangeItem IsWalk() {
		USE_WALK=true;
		return this;
	}

	public UltraFormChangeItem IsBeltGlowing() {
		IS_BELT_GLOWING=true;
		return this;
	}

	public UltraFormChangeItem hasStaticWings() {
		HAS_STATIC_WINGS=true;
		return this;
	}

	public UltraFormChangeItem needBaseForm() {
		NEED_BASE_FORM=true;
		return this;
	}

	public UltraFormChangeItem ignoreOverrideBeltText() {
		IGNORE_BELT_TEXT =true;
		return this;
	}

	public UltraFormChangeItem addNeedForm(Item  item) {
		NEED_FORM_SLOT_1=((UltraFormChangeItem)item);
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

	public UltraFormChangeItem AddNeedItemList(List<Item> NEED_ITEM) {
		needItemList=NEED_ITEM;
		return this;
	}

	public UltraFormChangeItem AddCompatibilityList(String[] List) {
		compatibilityList=List;
		return this;
	}


	public Boolean iscompatible(UltraRiserItem belt) {
		if (belt.Rider.equals(RANGER_NAME)) return true;
		for (String str : compatibilityList) {
			if (str==belt.Rider) return true;
		}
		ItemStack itemstack=new ItemStack(belt);
		return itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "form_change_item/works_with/" +RANGER_NAME+FORM_NAME)));
	}

	public boolean inventoryOrHolderContains(Player player, Item item) {
		NonNullList<ItemStack> inv = NonNullList.create();
		inv.addAll(player.getInventory().items);
		inv.addAll(player.getInventory().armor);
		inv.add(player.getInventory().offhand.getFirst());

		if (player.getInventory().countItem(item)!=0) return true;
		else for (int i = 0; i < inv.size(); i++) {
			if (inv.get(i).has(DataComponents.CONTAINER)) {
				for (ItemStack stack : inv.get(i).getComponents().get(DataComponents.CONTAINER).nonEmptyItems()) if (stack.getItem() == item) return true;
			} else if (inv.get(i).has(DataComponents.BUNDLE_CONTENTS))
				for (ItemStack stack : inv.get(i).getComponents().get(DataComponents.BUNDLE_CONTENTS).items()) if (stack.getItem() == item) return true;
		}
		return false;
	}

	public Boolean canChange(Player player, UltraRiserItem belt, ItemStack stack) {

		if (this == OtherItems.BLANK_FORM.get()) {
			//return true;
		}
		if (hasIncompatibleForms) {
			for (UltraFormChangeItem incompatibleForm : incompatibleForms) {
				int num_forms = belt.Num_Base_Form_Item;
				for (int n = 0; n < num_forms; n++) {
					if (incompatibleForm == UltraRiserItem.get_Form_Item(stack, n + 1)) {
						return false;
					}
				}
			}
		}
		if (!iscompatible(belt)) {
			return false;
		}
		if (!NEEDITEM.isEmpty()) {
			for (Item item : NEEDITEM) {
				if (!inventoryOrHolderContains(player, item)) return false;
			}
		}
		if (NEED_BASE_FORM) if (UltraRiserItem.get_Form_Item(stack, 1) != belt.Base_Form_Item) return false;
		if (NEED_FORM_SLOT_1 != null) if (UltraRiserItem.get_Form_Item(stack, 1) != NEED_FORM_SLOT_1) return false;
		if (NEED_FORM_SLOT_2 != null) if (UltraRiserItem.get_Form_Item(stack, 2) != NEED_FORM_SLOT_2) return false;

		if (!needItemList.isEmpty()) {
			for (Item item : needItemList) {
				if (!inventoryOrHolderContains(player, item)) return false;
			}
		}
		return true;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

		ItemStack itemStack = player.getItemInHand(usedHand);

		ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

		if (!player.hasEffect(EffectCore.FORM_LOCK)) {
			if (BELT.getItem() instanceof UltraRiserItem belt) {
				if (SHIFT_ITEM instanceof UltraFormChangeItem form && player.isShiftKeyDown())
					SHIFT_ITEM.use(level, player, usedHand);
				else if (canChange(player, belt, BELT)) {
					if (!player.isCreative()) {
						player.getCooldowns().addCooldown(this, 60);
						player.addEffect(new MobEffectInstance(EffectCore.FORM_LOCK, 20, 0, true, false));
					}
					if (RESET_FORM) UltraRiserItem.reset_Form_Item(player.getItemBySlot(EquipmentSlot.FEET));
					if (RESET_FORM_MAIN & Objects.equals(belt.Rider, RANGER_NAME))
						UltraRiserItem.reset_Form_Item(player.getItemBySlot(EquipmentSlot.FEET));
					if (alsoChange1stSlot != null)
						UltraRiserItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), alsoChange1stSlot, 1);
					if (alsoChange2ndSlot != null)
						UltraRiserItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), alsoChange2ndSlot, 2);

					int SLOT = Slot;
					if (usedHand == InteractionHand.OFF_HAND & Offhand) SLOT = OffhandSlot;

					if (SWITCH_ITEM != null & UltraRiserItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), SLOT) == this)
						UltraRiserItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), SWITCH_ITEM, SLOT);
					else UltraRiserItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), this, SLOT);
					if (!alternative.isEmpty()) {

						for (UltraFormChangeItem alternativeItem_form_change : alternative) {
							alternativeItem_form_change.use(level, player, usedHand);
						}
					}
				}
			}
		}
			return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());

		}


		public void OnTransformation (ItemStack itemstack, LivingEntity entity){
			if (timeoutDuration != 0) {
				if (entity instanceof Player player && !player.isCreative())
					player.getCooldowns().addCooldown(this, this.lockDuration);
			}
			if (entity.level() instanceof ServerLevel sl) {
				sl.sendParticles(ParticleTypes.GUST,
						entity.getX(), entity.getY() + 1.0,
						entity.getZ(), 1, 0, 0, 0, 1);
			}
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
