package com.liasdan.ultracraft.items.others;

import com.liasdan.supersentaicraft.SuperSentaiCraftCore;
import com.liasdan.supersentaicraft.items.GorangerItems;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;

import java.util.List;

public class BaseDualSwordItem extends SwordItem {

	private Item RepairItem = GorangerItems.GORANGER_LOGO.get();

	private Boolean Dual = false;
	private Boolean Triple = false;

	public BaseDualSwordItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, prop.attributes(SwordItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));

	}

	public BaseDualSwordItem ChangeRepairItem(Item item) {
		RepairItem = item;
		return this;
	}
	
	public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_) {
		return p_40393_.getItem()== RepairItem;
	}

	public BaseDualSwordItem AddToTabList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}

	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {

		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);

		if (p_41129_.isShiftKeyDown()) {
			if (Triple) {
				if (get_mode(itemstack)==1) {
					set_mode(itemstack,2);
				}
				else if (get_mode(itemstack)==2) {
					set_mode(itemstack,0);
				}
				else {
					set_mode(itemstack,1);
				}
			}
			else if (Dual) {
				if (get_mode(itemstack)==1) {
					set_mode(itemstack,0);
				}
				else {
					set_mode(itemstack,1);
				}
			}
		}
		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}

	public static void set_mode(ItemStack itemstack, int flag)
	{
		if (!itemstack.getComponents().has(DataComponents.CUSTOM_DATA)) {
			itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
		}
		CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
		tag.putInt("item_mode", flag);
	}

	public static int get_mode (ItemStack itemstack)
	{
		if (!itemstack.getComponents().has(DataComponents.CUSTOM_DATA)) return  0;
		else{
			CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
			return tag.getInt("item_mode");
		}
	}

	public BaseDualSwordItem IsDualWeapon() {
		Dual = true;
		SuperSentaiCraftCore.MULTI_WEAPON_ITEM.add(this);
		return this;
	}

	public BaseDualSwordItem IsTripleWeapon() {
		Triple = true;
		SuperSentaiCraftCore.MULTI_WEAPON_ITEM.add(this);
		return this;
	}

}