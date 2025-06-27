package com.liasdan.ultracraft.items.others;

import com.google.common.collect.ImmutableMultimap;
import com.liasdan.supersentaicraft.SuperSentaiCraftCore;
import com.liasdan.supersentaicraft.effect.EffectCore;
import com.liasdan.supersentaicraft.items.GorangerItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Unit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;

import javax.annotation.Nullable;
import java.util.List;

public class BaseBlasterItem extends BowItem {
	private Item RepairItem = GorangerItems.GORANGER_LOGO.get();
	private Item Changer = null;
	private Boolean Charged = false;
	private static int LFBB = 1;
	private Item craftingRemainingItem = null;

	public enum BlasterProjectile {
		ARROW,
		SMALL_FIREBALL {
			public void fire(LivingEntity user, Vec3 movement) {
				SmallFireball smallfireball = new SmallFireball(user.level(), user, movement.normalize());
				smallfireball.setPos(smallfireball.getX(), user.getY(0.5) + 0.5, smallfireball.getZ());
				user.level().addFreshEntity(smallfireball);
			}
		},
		LARGE_FIREBALL {
			public void fire(LivingEntity user, Vec3 movement) {
				LargeFireball largefireball = new LargeFireball(user.level(), user, movement.normalize(), LFBB);
				largefireball.setPos(largefireball.getX(), user.getY(0.5) + 0.5, largefireball.getZ());
				user.level().addFreshEntity(largefireball);
			}
		},
		ENDER_PEARL {
			public void fire(LivingEntity user, Vec3 movement) {
				ThrownEnderpearl fireball = new ThrownEnderpearl(user.level(),user);
				fireball.setPos(fireball.getX(), user.getY(0.5D) + 0.5D, fireball.getZ());
				fireball.addDeltaMovement(movement.scale(3));
				user.level().addFreshEntity(fireball);
			}
		},
		WITHER_SKULL {
			public void fire(LivingEntity user, Vec3 movement) {
				WitherSkull fireball = new WitherSkull(user.level(), user,movement.normalize());
				fireball.setPos(fireball.getX(), user.getY(0.5D) + 0.5D, fireball.getZ());
				user.level().addFreshEntity(fireball);
			}
		},
		EGG {
			public void fire(LivingEntity user, Vec3 movement) {
				ThrownEgg fireball = new ThrownEgg(user.level(),user);
				fireball.setPos(fireball.getX(), user.getY(0.5D) + 0.5D, fireball.getZ());
				fireball.addDeltaMovement(movement.scale(3));
				user.level().addFreshEntity(fireball);
			}
		},
		DRAGON_FIREBALL {
			public void fire(LivingEntity user, Vec3 movement) {
				DragonFireball dragonfireball = new DragonFireball(user.level(), user, movement.normalize());
				dragonfireball.setPos(dragonfireball.getX(), user.getY(0.5D) + 0.5D, dragonfireball.getZ());
				user.level().addFreshEntity(dragonfireball);
			}
		};

		public void fire(LivingEntity player, Vec3 vec3) {}
	}
	private BlasterProjectile projectile = BlasterProjectile.ARROW;

	public BaseBlasterItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(prop.durability(toolTier.getUses()).attributes(SwordItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));
		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
	}
	public BaseBlasterItem AddToTabList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}

	public BaseBlasterItem KeepDifItem(Item Dif) {
		craftingRemainingItem=Dif;
		return this;
	}

	public BaseBlasterItem KeepItem() {
		craftingRemainingItem=this;
		return this;
	}

	public ItemStack getCraftingRemainingItem(ItemStack stack)
	{
		if (stack.getItem() instanceof BaseBlasterItem) {
			if (!hasCraftingRemainingItem(stack))
			{
				return ItemStack.EMPTY;
			}
			return new ItemStack(craftingRemainingItem);
		} else  return new ItemStack(this.getCraftingRemainingItem());
	}


	public boolean hasCraftingRemainingItem(ItemStack stack)
	{
		return ((BaseBlasterItem)stack.getItem()).craftingRemainingItem!=null;
	}


	@Override
	public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
		return !player.isCreative();
	}

	public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof Player player && level instanceof ServerLevel serverlevel) {
			if (Changer != null && player.getItemBySlot(EquipmentSlot.FEET)==ItemStack.EMPTY) {
				player.setItemSlot(EquipmentSlot.FEET, new ItemStack(Changer));
				if (player.getItemBySlot(EquipmentSlot.OFFHAND).getItem() instanceof UltraFormChangeItem formItem) formItem.use(level, player, InteractionHand.OFF_HAND);
			}
			if (projectile != BlasterProjectile.ARROW) {
				projectile.fire(player, player.getLookAngle());
				stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
			} else {
				if (Charged) {
					if (get_mode(stack) < 30) set_mode(stack, get_mode(stack) + 1);
					else if (get_mode(stack) == 30) {
						player.addEffect(new MobEffectInstance(EffectCore.EXPLOSIONSHOT, 40, 2, true, false));
					}
				}
				ItemStack arrow = new ItemStack(Items.ARROW, 1);
				arrow.set(DataComponents.INTANGIBLE_PROJECTILE, Unit.INSTANCE);
				this.shoot(serverlevel, player, player.getUsedItemHand(), stack, List.of(arrow), 3, 1.0F, true, (LivingEntity)null);
			}
			level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + 1 * 0.5F);
			player.awardStat(Stats.ITEM_USED.get(this));
		}

	}

	@Override
	protected void shootProjectile(LivingEntity shooter, Projectile projectile, int index, float velocity, float inaccuracy, float angle, @Nullable LivingEntity target) {
		projectile.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot() + angle, 0.0F, velocity, inaccuracy);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		boolean flag = !player.getProjectile(itemstack).isEmpty();
		InteractionResultHolder<ItemStack> ret = EventHooks.onArrowNock(itemstack, level, player, hand, flag);

		if (ret != null) return ret;
		else {
			player.startUsingItem(hand);
			return InteractionResultHolder.consume(itemstack);
		}
	}


	public int getDefaultProjectileRange() {
		return 30;
	}



	public BaseBlasterItem ChangeRepairItem(Item item) {
		RepairItem = item;
		return this;
	}

	public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_) {
		return p_40393_.getItem()== RepairItem;
	}

	public BaseBlasterItem isChanger(Item item) {
		Changer =item;
		return this;
	}

	public BaseBlasterItem IsChargeWeapon() {
		SuperSentaiCraftCore.CHARGED_WEAPON.add(this);
		Charged = true;
		return this;
	}

	public BaseBlasterItem IsSwordGun() {
		SuperSentaiCraftCore.SWORD_GUN_ITEM.add(this);
		return this;
	}

	public BaseBlasterItem setProjectile(BlasterProjectile type) {
		projectile = type;
		return this;
	}

	public BaseBlasterItem setExplosionPower(int blast) {
		LFBB=blast;
		return this;
	}

	public BlasterProjectile getProjectile() {
		return this.projectile;
	}

	public int getExplosionPower() {
		return LFBB;
	}

	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		return true;
	}

	@Override
	public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
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

	public static ItemAttributeModifiers createAttributes(Tier tier, int attackDamage, float attackSpeed) {
		return createAttributes(tier, (float)attackDamage, attackSpeed);
	}
	public static ItemAttributeModifiers createAttributes(Tier p_330371_, float p_331976_, float p_332104_) {
		return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (double)(p_331976_ + p_330371_.getAttackDamageBonus()), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, (double)p_332104_, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
	}
}