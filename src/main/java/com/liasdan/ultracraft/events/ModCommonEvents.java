package com.liasdan.ultracraft.events;

import com.liasdan.ultracraft.effect.EffectCore;
import com.liasdan.ultracraft.entity.MobsCore;
import com.liasdan.ultracraft.entity.boss.*;
import com.liasdan.ultracraft.entity.footsoldier.*;
import com.liasdan.ultracraft.items.OtherItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

import java.util.List;
import java.util.Objects;

public class ModCommonEvents {

	public static class EventHandler {

		@SubscribeEvent
		public void addLivingDamageEvent(LivingDamageEvent.Post event) {

			if (event.getSource().getEntity() instanceof LivingEntity _livEnt) {
				if (event.getSource().is(DamageTypes.PLAYER_ATTACK) || event.getSource().is(DamageTypes.MOB_ATTACK) || event.getSource().is(DamageTypes.MOB_ATTACK_NO_AGGRO)) {

					if (_livEnt.hasEffect(EffectCore.FIREPUNCH)) {
						if (_livEnt.getMainHandItem().isEmpty()) {
							event.getEntity().igniteForSeconds(_livEnt.getEffect(EffectCore.FIREPUNCH).getAmplifier()+1);
						}
					}

					if (_livEnt.hasEffect(EffectCore.THUNDERPUNCH)) {
						if (_livEnt.getMainHandItem().isEmpty()) {
							LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT,_livEnt.level());
							thunder.setPos(   event.getEntity().getX(),   event.getEntity().getY(),   event.getEntity().getZ());
							event.getEntity().level().addFreshEntity(thunder);
						}

					}

					if (_livEnt.hasEffect(EffectCore.EXPLOSIONPUNCH)) {
						if (_livEnt.getMainHandItem().isEmpty()) {
							boolean flag = event.getEntity().level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();
							event.getEntity().level().explode(null, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), _livEnt.getEffect(EffectCore.EXPLOSIONPUNCH).getAmplifier(), flag, Level.ExplosionInteraction.MOB);
						}
					}

					if (event.getEntity().hasEffect(EffectCore.REFLECT)) {
						event.getSource().getEntity().hurt(event.getSource(), (event.getOriginalDamage()) * (1 + event.getEntity().getEffect(EffectCore.REFLECT).getAmplifier() + 1));
					}

					if (_livEnt.hasEffect(EffectCore.FIRESLASH)) {
						if (_livEnt.getMainHandItem().getItem() instanceof SwordItem) {
							event.getEntity().igniteForSeconds(_livEnt.getEffect(EffectCore.FIRESLASH).getAmplifier()+1);
						}
					}

				} else if (event.getSource().is(DamageTypes.ARROW) || event.getSource().is(DamageTypes.MOB_PROJECTILE)) {
					if (_livEnt.hasEffect(EffectCore.FIRESLASH)) {
						event.getEntity().setRemainingFireTicks(25*(Objects.requireNonNull(_livEnt.getEffect(EffectCore.FIRESLASH)).getAmplifier() + 1));
					}

					if (_livEnt.hasEffect(EffectCore.EXPLOSIONSHOT)) {
						boolean flag = event.getEntity().level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();
						event.getEntity().level().explode(null, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), _livEnt.getEffect(EffectCore.EXPLOSIONSHOT).getAmplifier(), flag, Level.ExplosionInteraction.MOB);
					}

					if (_livEnt.hasEffect(EffectCore.THUNDERSHOT)) {

						LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT,_livEnt.level());
						thunder.setPos(   event.getEntity().getX(),   event.getEntity().getY(),   event.getEntity().getZ());
						event.getEntity().level().addFreshEntity(thunder);
					}
				}
			}
		}
	}

	public static class CommonEvents {

		@SubscribeEvent
		public void addCustomTrades(VillagerTradesEvent event) {
		}
	}

	@SubscribeEvent
	public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
		//event.put(MobsCore.ZOLDERS.get(), ZoldersEntity.setAttributes().build());
	}

	@SubscribeEvent
	public static void entitySpawnRestriction(RegisterSpawnPlacementsEvent event) {
		//event.register(MobsCore.ZOLDERS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}
}