package com.liasdan.ultracraft.items.others;

import com.liasdan.ultracraft.items.OtherItems;
import com.liasdan.ultracraft.items.client.UltraArmorRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class UltraArmorItem extends ArmorItem implements GeoItem {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private Item RepairItem = OtherItems.LAND_OF_LIGHT_FRAGMENT.get();
	
	public UltraArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
		super(material, type, properties.stacksTo(1).durability(type ==Type.BOOTS?600:500));
	
	}

	@Override
	public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
		consumer.accept(new GeoRenderProvider() {
			private UltraArmorRenderer renderer;

			@Override
			public <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(@Nullable T livingEntity, ItemStack itemStack, @Nullable EquipmentSlot equipmentSlot, @Nullable HumanoidModel<T> original) {
				if(this.renderer == null)
					this.renderer = new UltraArmorRenderer(livingEntity, equipmentSlot);
				final Minecraft mc = Minecraft.getInstance();
				this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original, mc.renderBuffers().bufferSource(), mc.getTimer().getGameTimeDeltaPartialTick(true), 0, 0, 0, 0);

				return this.renderer;
			}
		});
	}

	public UltraArmorItem AddToTabList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}

	public static Float GetWheelRotation(ItemStack itemstack)
	{
		if (itemstack.has(DataComponents.CUSTOM_DATA)&itemstack.getItem()instanceof UltraArmorItem) {
			CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
			return tag.getFloat("wheel_rotation");
		}
		return 0f;
	}

	public static void setWheelRotation(ItemStack itemstack,Float num)
	{
		if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
			itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
		}
		if (itemstack.getItem() instanceof UltraRiserItem) {
			Consumer<CompoundTag> data = form -> form.putFloat("wheel_rotation", num);
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
		}
	}

	public static Float GetBallRotation(ItemStack itemstack)
	{
		if (itemstack.has(DataComponents.CUSTOM_DATA)&itemstack.getItem()instanceof UltraArmorItem) {
			CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
			return tag.getFloat("ball_rotation");
		}
		return 0f;
	}

	public static void setBallRotation(ItemStack itemstack,Float num)
	{
		if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
			itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
		}
		if (itemstack.getItem() instanceof UltraRiserItem) {
			Consumer<CompoundTag> data = form -> form.putFloat("ball_rotation", num);
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
		}
	}

	public static Float GetCapeRotation(ItemStack itemstack)
	{
		if (itemstack.has(DataComponents.CUSTOM_DATA)&itemstack.getItem()instanceof UltraArmorItem) {
			CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
			return tag.getFloat("cape_rotation");
		}
		return 0f;
	}

	public static void setCapeRotation(ItemStack itemstack,Float num)
	{
		if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
			itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
		}
		if (itemstack.getItem() instanceof UltraRiserItem) {
			Consumer<CompoundTag> data = form -> form.putFloat("cape_rotation", num);
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
		}
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
		RawAnimation IDLE = RawAnimation.begin().thenLoop("idle");
		RawAnimation WALK = RawAnimation.begin().thenLoop("walk");
		RawAnimation SNEAK = RawAnimation.begin().thenLoop("sneak");

		controllerRegistrar.add(new AnimationController<>(this, "ultraAnim", 20, state -> {
			Entity entity = state.getData(DataTickets.ENTITY);
			boolean IsWalking = false;
			if (entity instanceof LivingEntity player) {

				float X =0;
				float Y =0;
				float Z =0;
				boolean isPlayer =false;
				if (player instanceof Player) {
					X =player.xxa;
					Y=player.yya;
					Z=player.zza;
					isPlayer=true;
				}else if (player instanceof Mob mob) {
					if (player.getDeltaMovement().x != 0 ||player.getDeltaMovement().z != 0){
						X= mob.getViewXRot(state.getPartialTick());
						Vec3 look = player.getLookAngle();
						if (look.x>0&player.getDeltaMovement().x>0)Z= 1;
						else if (look.z>0&player.getDeltaMovement().z>0)Z= 1;
						else  if (look.x<0&player.getDeltaMovement().x<0)Z= 1;
						else if (look.z<0&player.getDeltaMovement().z<0)Z= 1;
						else Z= -1;
					}
				}

				if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof UltraRiserItem&&player.getDeltaMovement().x != 0 ||
						player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof UltraRiserItem&&player.getDeltaMovement().z != 0)
					IsWalking = UltraRiserItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),1).get_Walk();

				if (this instanceof UltraRiserItem belt) {

					if (belt.HasCape(player.getItemBySlot(EquipmentSlot.FEET))) {
						float cape = GetCapeRotation(player.getItemBySlot(EquipmentSlot.FEET));
						float ball = 0;

						if (Z > 0 & cape >-0.7&!player.isSwimming()) cape = cape-0.01f-(player.getSpeed()/10);
						else if (Z < 0&cape <0) cape = cape +0.1f;
						else if  (Z == 0&cape <0&X== 0||cape <-0.7||cape <0&player.isSwimming()) cape = cape +0.02f;
						if (X > 0) {
							ball = 0.2f;
							if (isPlayer&Z == 0& cape >-0.7) cape = cape-0.01f-(player.getSpeed()/10);
						}
						if (X < 0) {
							ball = -0.2f;
							if (isPlayer&Z == 0& cape >-0.7) cape = cape-0.01f-(player.getSpeed()/10);
						}
						if (player.fallDistance>0&!player.isSwimming()& cape>-2.5)cape =cape -0.05f;

						setBallRotation(player.getItemBySlot(EquipmentSlot.FEET), ball);
						setCapeRotation(player.getItemBySlot(EquipmentSlot.FEET), cape);
					}
				}
			}
			state.setAndContinue(IsWalking ? WALK : IDLE);
			return PlayState.CONTINUE;
		}));

	}

	public UltraArmorItem ChangeRepairItem(Item item) {
		RepairItem = item;
		return this;
	}
	
	public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_) {
		return p_40393_.getItem()== RepairItem;
	}
	

	
	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return cache;
	}
}