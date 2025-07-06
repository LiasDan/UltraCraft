package com.liasdan.ultracraft;

import com.liasdan.ultracraft.blocks.UltraBlocks;
import com.liasdan.ultracraft.client.renderer.BasicEntityRenderer;
import com.liasdan.ultracraft.effect.EffectCore;
import com.liasdan.ultracraft.entity.MobsCore;
import com.liasdan.ultracraft.events.ModClientEvents;
import com.liasdan.ultracraft.events.ModCommonEvents;
import com.liasdan.ultracraft.items.*;
import com.liasdan.ultracraft.items.others.*;
import com.mojang.logging.LogUtils;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.neoforged.neoforge.client.event.RenderPlayerEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Mod(UltraCraftCore.MODID)
public class UltraCraftCore {

	public static final String MODID="ultracraft";
	private static final Logger LOGGER = LogUtils.getLogger();

	private static final ResourceLocation BLOCKING_PROPERTY_RESLOC = ResourceLocation.parse("blocking");

	public static List<Item> SWORD_GUN_ITEM= new ArrayList<Item>();

	public static List<Item> SHIELD_ITEM= new ArrayList<Item>();

	public static List<Item> MULTI_WEAPON_ITEM= new ArrayList<Item>();

	public static List<Item> CHARGED_WEAPON= new ArrayList<Item>();

	public static List<Item> FORM_WEAPON_ITEM= new ArrayList<Item>();

	public static List<Item> CHANGE_CHANGER_TEXTURE= new ArrayList<Item>();

	public UltraCraftCore(IEventBus modEventBus, ModContainer modContainer) {
		// Register the commonSetup method for modloading
		modEventBus.addListener(this::commonSetup);
		NeoForge.EVENT_BUS.register(new ModClientEvents.ClientEvents());
		NeoForge.EVENT_BUS.register(new ModCommonEvents.CommonEvents());
		NeoForge.EVENT_BUS.register(new ModCommonEvents.EventHandler());

		// Register ourselves for server and other game events we are interested in.
		// Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
		// Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
		NeoForge.EVENT_BUS.register(this);
		EffectCore.register(modEventBus);

		OtherItems.register(modEventBus);

		UltramanItems.register(modEventBus);

		UltraBlocks.register(modEventBus);

		MobsCore.register(modEventBus);
		MobsCore.MOBLIST.register(modEventBus);
		UltraTabs.register(modEventBus);

		// Register the item to a creative tab
		modEventBus.addListener(this::addCreative);
		modEventBus.addListener(ModCommonEvents::entityAttributeEvent);
		modEventBus.addListener(ModCommonEvents::entitySpawnRestriction);

		// Register our mod's ModConfigSpec so that FML can create and load the config file for us
		modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
	}

	private void commonSetup(final FMLCommonSetupEvent event)
	{
	}

	// Add the example block item to the building blocks tab
	private void addCreative(BuildCreativeModeTabContentsEvent event)
	{
		UltraTabs.AddItemsToTabs(event);
	}

	// You can use SubscribeEvent and let the Event Bus discover methods to call
	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event)
	{
	}

	@SubscribeEvent
	public void addRenderLivingEvent(RenderLivingEvent.Pre event) {

		if (event.getRenderer().getModel() instanceof PlayerModel model) {
			if (event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() instanceof ArmorItem belt) {
				if (belt instanceof UltraRiserItem driver && driver.isTransformed(event.getEntity())) {
					double tag = driver.getRenderType(event.getEntity().getItemBySlot(EquipmentSlot.FEET));
					if (tag != 0) {
						if (tag != 2) {
							model.head.visible = false;
						}
						else {
							model.head.visible = true;
						}

						if (tag != 3) {
							model.leftLeg.visible = false;
							model.rightLeg.visible = false;
							model.leftArm.visible = false;
							model.rightArm.visible = false;
							model.body.visible = false;
						}
						else {
							model.head.visible = true;
							model.leftLeg.visible = true;
							model.rightLeg.visible = true;
							model.leftArm.visible = true;
							model.rightArm.visible = true;
							model.body.visible = true;
						}

						model.hat.visible = false;
						model.leftSleeve.visible = false;
						model.rightSleeve.visible = false;
						model.leftPants.visible = false;
						model.rightPants.visible = false;
						model.jacket.visible = false;
					}
					else {
						model.head.visible = true;
						model.hat.visible = true;
						model.leftLeg.visible = true;
						model.rightLeg.visible = true;
						model.leftArm.visible = true;
						model.rightArm.visible = true;
						model.body.visible = true;
						model.leftSleeve.visible = true;
						model.rightSleeve.visible = true;
						model.leftPants.visible = true;
						model.rightPants.visible = true;
						model.jacket.visible = true;
					}
				}
				else if (event.getEntity().getItemBySlot(EquipmentSlot.FEET).has(DataComponents.CUSTOM_DATA)) {
					CompoundTag tag = event.getEntity().getItemBySlot(EquipmentSlot.FEET).get(DataComponents.CUSTOM_DATA).getUnsafe();
					if (tag.getDouble("render_type") != 0) {
						if (tag.getDouble("render_type") != 2) {
							model.head.visible = false;
						}
						else {
							model.head.visible = true;
						}

						if (tag.getDouble("render_type") != 3) {
							model.leftLeg.visible = false;
							model.rightLeg.visible = false;
							model.leftArm.visible = false;
							model.rightArm.visible = false;
							model.body.visible = false;
						}
						else {
							model.head.visible = true;
							model.leftLeg.visible = true;
							model.rightLeg.visible = true;
							model.leftArm.visible = true;
							model.rightArm.visible = true;
							model.body.visible = true;
						}

						model.leftSleeve.visible = false;
						model.rightSleeve.visible = false;
						model.leftPants.visible = false;
						model.rightPants.visible = false;
						model.jacket.visible = false;
					}
					else {
						model.head.visible = true;
						model.hat.visible = true;
						model.leftLeg.visible = true;
						model.rightLeg.visible = true;
						model.leftArm.visible = true;
						model.rightArm.visible = true;
						model.body.visible = true;
						model.leftSleeve.visible = true;
						model.rightSleeve.visible = true;
						model.leftPants.visible = true;
						model.rightPants.visible = true;
						model.jacket.visible = true;
					}
				}
				else {
					model.head.visible = true;
					model.hat.visible = true;
					model.leftLeg.visible = true;
					model.rightLeg.visible = true;
					model.leftArm.visible = true;
					model.rightArm.visible = true;
					model.body.visible = true;
					model.leftSleeve.visible = true;
					model.rightSleeve.visible = true;
					model.leftPants.visible = true;
					model.rightPants.visible = true;
					model.jacket.visible = true;
				}
			}
			else {
				model.head.visible = true;
				model.hat.visible = true;
				model.leftLeg.visible = true;
				model.rightLeg.visible = true;
				model.leftArm.visible = true;
				model.rightArm.visible = true;
				model.body.visible = true;
				model.leftSleeve.visible = true;
				model.rightSleeve.visible = true;
				model.leftPants.visible = true;
				model.rightPants.visible = true;
				model.jacket.visible = true;
			}
		}

		float size = 1;
		boolean Tall = event.getEntity().hasEffect(EffectCore.STRETCH);

		if (event.getEntity().hasEffect(EffectCore.STRETCH)) {
			size = size + ((event.getEntity().getEffect(EffectCore.STRETCH).getAmplifier()) +1f);
		}

		float size2 = event.getEntity().hasEffect(EffectCore.STRETCH) ? 1 : size;

		if (event.getEntity().hasEffect(EffectCore.FLAT)) {
			size2 = 0.04f;
		}
		float size3 = event.getEntity().hasEffect(EffectCore.STRETCH) ? 1 : size;
		if (event.getEntity().hasEffect(EffectCore.WIDE)) {
			size2 = (float) (size2 * 3);
			size3 = (float) (size3 * 3);
		}
		event.getPoseStack().scale(size3, size, size2);
	}

	@SubscribeEvent
	public void addRenderPlayerEvent(RenderPlayerEvent.Pre event) {

	}

	// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
	@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientModEvents {
		@SubscribeEvent
		public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
			event.registerEntityRenderer(MobsCore.ZETTON.get(), BasicEntityRenderer::new);
			event.registerEntityRenderer(MobsCore.YAPOOL.get(), BasicEntityRenderer::new);
			event.registerEntityRenderer(MobsCore.BALTAN.get(), BasicEntityRenderer::new);
			event.registerEntityRenderer(MobsCore.ALIEN_MAGMA.get(), BasicEntityRenderer::new);
			event.registerEntityRenderer(MobsCore.SHADOW.get(), BasicEntityRenderer::new);
		}
	}
}