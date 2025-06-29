package com.liasdan.ultracraft.items.others;

import com.google.common.collect.Lists;
import com.liasdan.ultracraft.UltraCraftCore;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
public class UltraRiserItem extends UltraArmorItem {

	public String armorNamePrefix;
	public UltraFormChangeItem Base_Form_Item;
	private ArrayList<UltraFormChangeItem> Extra_Base_Form_Item;
	public String Rider;
	public Item HEAD;
	public Item TORSO;
	public Item LEGS; 
	public int Num_Base_Form_Item = 1;
	public String BELT_TEXT;

	public Boolean Has_basic_belt_info = true;
	public Boolean Show_belt_form_info = true;


	public UltraRiserItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, ArmorItem.Type.BOOTS, properties);

		Rider=rider;
		Base_Form_Item=((UltraFormChangeItem)baseFormItem.get());
		HEAD=head.get();
		TORSO=torso.get(); 
		LEGS=legs.get();

	}

	public boolean isTransformed(LivingEntity player) {
		return player.getItemBySlot(EquipmentSlot.HEAD).getItem()==HEAD.asItem()
				&&player.getItemBySlot(EquipmentSlot.CHEST).getItem()==TORSO.asItem()
				&&player.getItemBySlot(EquipmentSlot.LEGS).getItem()==LEGS.asItem()
				&&player.getItemBySlot(EquipmentSlot.FEET).getItem()==this;
	}

	public static double getRenderType(ItemStack stack) {
		double form_double = 1;
		UltraFormChangeItem form = get_Form_Item(stack, 1);
		if (form.get_Show_Face())form_double=2;
		if (form.get_Show_Under())form_double=3;
		return form_double ;
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {

		if (entity instanceof LivingEntity player) {

			if (stack.has(DataComponents.CUSTOM_DATA)) {
				CompoundTag tag = stack.get(DataComponents.CUSTOM_DATA).getUnsafe();
				if (tag.getBoolean("Update_form")&&slotId==36) OnformChange(stack, player, tag);
				if (!isTransformed(player)||slotId!=36) tag.putBoolean("Update_form", true);

				if (isTransformed(player)) tag.putDouble("render_type", getRenderType(stack));
				if (!isTransformed(player)) tag.putDouble("render_type", 0);
			}
			else {
				set_Update_Form(stack);
			}

			if (isTransformed(player)) {
				for (int n = 0; n < Num_Base_Form_Item; n++) {
					UltraFormChangeItem form = get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), n + 1);

					List<MobEffectInstance> potionEffectList = form.getPotionEffectList();
					for (MobEffectInstance effect : potionEffectList) {
						player.addEffect(new MobEffectInstance(effect.getEffect(), effect.getDuration(), effect.getAmplifier(), true, false));
					}
				}
			}
		}
	}

	public void OnformChange(ItemStack itemstack, LivingEntity player,CompoundTag  tag) {
		if(isTransformed(player)) {
			OnTransformation(itemstack,player);
			Consumer<CompoundTag> data = form -> {
				form.putBoolean("Update_form", false);
			};
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
		}

	}

	public void OnTransformation(ItemStack itemstack, LivingEntity player) {
		if(isTransformed(player) && !player.level().isClientSide()) {
			for (int n = 0; n < Num_Base_Form_Item; n++) {
				UltraFormChangeItem form = get_Form_Item(itemstack, n + 1);
			}
		}
	}

	public UltraRiserItem Add_Extra_Base_Form_Items(DeferredItem<Item> item) {
		Extra_Base_Form_Item= Lists.newArrayList((UltraFormChangeItem)item.get());
		Num_Base_Form_Item=2;
		return this;
	}

	public UltraRiserItem Override_belt_text(String belt) {
		BELT_TEXT = belt;
		return this;
	}

	public UltraRiserItem Add_Extra_Base_Form_Items(DeferredItem<Item> item, DeferredItem<Item> item2) {
		Extra_Base_Form_Item= Lists.newArrayList((UltraFormChangeItem)item.get(),(UltraFormChangeItem)item2.get());
		Num_Base_Form_Item=3;
		return this;
	}

	public UltraRiserItem Add_Extra_Base_Form_Items(DeferredItem<Item> item, DeferredItem<Item> item2, DeferredItem<Item> item3) {
		Extra_Base_Form_Item= Lists.newArrayList((UltraFormChangeItem)item.get(),(UltraFormChangeItem)item2.get(),(UltraFormChangeItem)item3.get());
		Num_Base_Form_Item=4;
		return this;
	}

	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{

		boolean fly = rider instanceof Player player && player.getAbilities().flying;

		if (equipmentSlot == EquipmentSlot.FEET) {
			String belt = ((UltraRiserItem)itemstack.getItem()).BELT_TEXT;
			if (((UltraRiserItem)itemstack.getItem()).BELT_TEXT==null) {
				belt = get_Form_Item(itemstack,1).getBeltTex();
			}
			return "belts/"+belt;
		}
		else return get_Form_Item(itemstack,1).getRangerName(riderName)+get_Form_Item(itemstack,1).getFormName(fly);

	}


	public ResourceLocation getModelResource(ItemStack itemstack, UltraArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		if (get_Form_Item(itemstack, 1).HasWingsIfFlying() && rider instanceof Player player && player.getAbilities().flying){
			return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, get_Form_Item(itemstack, 1).get_FlyingModel());
		}
		return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, get_Form_Item(itemstack, 1).get_Model());
	}
	
	public ResourceLocation getBeltModelResource(ItemStack itemstack, UltraArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, get_Form_Item(itemstack, 1).getBeltModel());
	}

	public ResourceLocation getAnimationResource(ItemStack itemstack, UltraArmorItem animatable, EquipmentSlot slot) {
		return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "animations/ultra.animation.json");
	}

	public static void reset_Form_Item(ItemStack  itemstack)
	{
		if(itemstack.getItem() instanceof UltraRiserItem belt){
			if (belt.Num_Base_Form_Item!=1) {
				for (int n = 0; n < belt.Num_Base_Form_Item-1; n++)
				{
					set_Form_Item( itemstack,belt.Extra_Base_Form_Item.get(n),2+n);
				}
			}
			set_Form_Item(itemstack,belt.Base_Form_Item,1);
		}
	}

	public static void set_Update_Form(ItemStack itemstack)
	{
		if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
			itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
		}
		if (itemstack.getItem() instanceof UltraRiserItem) {
			Consumer<CompoundTag> data = form -> {
				form.putBoolean("Update_form", true);
				form.putDouble("render_type", getRenderType(itemstack));
			};
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
		}
	}

	public static void set_Form_Item(ItemStack itemstack, Item ITEM,int SLOT)
	{
		if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
			itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
		}
		if (itemstack.getItem() instanceof UltraRiserItem driver) {
			CompoundTag  tag = new CompoundTag();
			Consumer<CompoundTag> data = form ->
			{
				if (!form.getString("slot_tex" + SLOT).equals(ITEM.toString())) {
					form.putString("slot_tex" + SLOT, ITEM.toString());
					form.putBoolean("Update_form", true);
					form.putDouble("render_type", getRenderType(itemstack));
				}
			};

			data.accept(tag);
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
			driver.Extra_set_Form_Item(itemstack, ITEM, SLOT,tag);
		}
	}

	public void Extra_set_Form_Item(ItemStack itemstack, Item ITEM, int SLOT, CompoundTag tag)
	{
	}

	public  boolean getPartsForSlot(EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
		case HEAD ->{ 
			if (part =="head") return true;
		}
		case CHEST -> {
			if (part =="body") return true;
			if (part =="rightArm") return true;
			if (part =="leftArm") return true;
		}
		case LEGS -> {

			if (part =="rightLeg") return true;
			if (part =="leftLeg") return true;
		}
		default -> {}
		}
		return false;
	}

	public static UltraFormChangeItem get_Form_Item(ItemStack itemstack, int SLOT) {

		UltraRiserItem belt = (UltraRiserItem) itemstack.getItem();
		UltraFormChangeItem Base_Form_Item = (SLOT>=2 ? belt.Extra_Base_Form_Item.get(SLOT-2) : belt.Base_Form_Item);

		if (itemstack.has(DataComponents.CUSTOM_DATA)) {
			CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
			ResourceLocation Used_Form_Item = ResourceLocation.parse(tag.getString("slot_tex" + SLOT));
			if (BuiltInRegistries.ITEM.get(Used_Form_Item) instanceof UltraFormChangeItem formItem) {
				return formItem;
			}
		}
		return Base_Form_Item;
	}

	public UltraRiserItem CanChangeTexture() {
		UltraCraftCore.CHANGE_CHANGER_TEXTURE.add(this);
		return this;
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

		if (Has_basic_belt_info) {
			if (Show_belt_form_info) {
				{
					Item formItem = this.get_Form_Item(stack, 1);
					tooltipComponents.add(Component.translatable(formItem.toString() + ".form"));
				}
			}
		}
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}
}