package com.liasdan.ultracraft.entity;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.entity.footsoldier.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MobsCore {
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltraCraftCore.MODID);
	public static final DeferredRegister<EntityType<?>> MOBLIST = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, UltraCraftCore.MODID);

	public static final DeferredHolder<EntityType<?>, EntityType<ZettonEntity>> ZETTON = MOBLIST.register("zetton",
			() -> EntityType.Builder.of(ZettonEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(UltraCraftCore.MODID + ":zetton"));

	public static final DeferredItem<DeferredSpawnEggItem> ZETTON_SPAWN_EGG = ITEMS.register("zetton_spawn_egg",
			() -> new DeferredSpawnEggItem(ZETTON,0x191919, 0xcccccc, new Item.Properties()));

	public static final DeferredHolder<EntityType<?>, EntityType<YapoolEntity>> YAPOOL = MOBLIST.register("yapool",
			() -> EntityType.Builder.of(YapoolEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(UltraCraftCore.MODID + ":yapool"));

	public static final DeferredItem<DeferredSpawnEggItem> YAPOOL_SPAWN_EGG = ITEMS.register("yapool_spawn_egg",
			() -> new DeferredSpawnEggItem(YAPOOL,0xfa1800, 0x9c5e21, new Item.Properties()));

	public static final DeferredHolder<EntityType<?>, EntityType<BaltanEntity>> BALTAN = MOBLIST.register("baltan",
			() -> EntityType.Builder.of(BaltanEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(UltraCraftCore.MODID + ":baltan"));

	public static final DeferredItem<DeferredSpawnEggItem> BALTAN_SPAWN_EGG = ITEMS.register("baltan_spawn_egg",
			() -> new DeferredSpawnEggItem(BALTAN,0x306878, 0x275461, new Item.Properties()));

	public static final DeferredHolder<EntityType<?>, EntityType<AlienMagmaEntity>> ALIEN_MAGMA = MOBLIST.register("alien_magma",
            () -> EntityType.Builder.of(AlienMagmaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(UltraCraftCore.MODID + ":alien_magma"));

    public static final DeferredItem<DeferredSpawnEggItem> ALIEN_MAGMA_SPAWN_EGG = ITEMS.register("alien_magma_spawn_egg",
            () -> new DeferredSpawnEggItem(ALIEN_MAGMA,0x0c0c0c, 0x9e9e9e, new Item.Properties()));

	public static final DeferredHolder<EntityType<?>, EntityType<ShadowEntity>> SHADOW = MOBLIST.register("shadow",
			() -> EntityType.Builder.of(ShadowEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(UltraCraftCore.MODID + ":shadow"));

	public static final DeferredItem<DeferredSpawnEggItem> SHADOW_SPAWN_EGG = ITEMS.register("shadow_spawn_egg",
			() -> new DeferredSpawnEggItem(SHADOW,0x002368, 0xffdd00, new Item.Properties()));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
