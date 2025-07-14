package com.liasdan.ultracraft.items.others;

import com.liasdan.ultracraft.effect.EffectCore;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.apache.commons.lang3.ArrayUtils;


public class LandOfLightFragment extends BaseItem {

	public LandOfLightFragment(Item.Properties properties)
	{
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {

		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);

		if (p_41129_.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof UltraRiserItem belt && belt.isTransformed(p_41129_)){
			if (!p_41128_.isClientSide()) {
            	p_41129_.addEffect(new MobEffectInstance(EffectCore.BIG, 3600, 10,true,false));
				p_41129_.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 7,true,false));
				p_41129_.addEffect(new MobEffectInstance(EffectCore.STEP, 3600, 5,true,false));
				p_41129_.addEffect(new MobEffectInstance(EffectCore.LONG_ARM, 3600, 30,true,false));
             	p_41129_.getCooldowns().addCooldown(this, 6000);
				p_41129_.awardStat(Stats.ITEM_USED.get(this));
			}
		}
		
		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}
}