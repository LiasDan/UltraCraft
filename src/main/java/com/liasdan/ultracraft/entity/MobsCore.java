package com.liasdan.ultracraft.entity;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.entity.boss.*;
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

	public static final DeferredHolder<EntityType<?>, EntityType<DarrambEntity>> DARRAMB = MOBLIST.register("darramb",
			() -> EntityType.Builder.of(DarrambEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(UltraCraftCore.MODID + ":darramb"));

	public static final DeferredItem<DeferredSpawnEggItem> DARRAMB_SPAWN_EGG = ITEMS.register("darramb_spawn_egg",
			() -> new DeferredSpawnEggItem(DARRAMB,0x897979, 0xd11945, new Item.Properties()));

	public static final DeferredHolder<EntityType<?>, EntityType<HudraEntity>> HUDRA = MOBLIST.register("hudra",
			() -> EntityType.Builder.of(HudraEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(UltraCraftCore.MODID + ":hudra"));

	public static final DeferredItem<DeferredSpawnEggItem> HUDRA_SPAWN_EGG = ITEMS.register("hudra_spawn_egg",
			() -> new DeferredSpawnEggItem(HUDRA,0xd1d1d1, 0x3d32d4, new Item.Properties()));

	public static final DeferredHolder<EntityType<?>, EntityType<DarkTigaEntity>> TIGA_DARK = MOBLIST.register("tiga_dark",
			() -> EntityType.Builder.of(DarkTigaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(UltraCraftCore.MODID + ":tiga_dark"));

	public static final DeferredItem<DeferredSpawnEggItem> TIGA_DARK_SPAWN_EGG = ITEMS.register("tiga_dark_spawn_egg",
			() -> new DeferredSpawnEggItem(TIGA_DARK,0x1f272d, 0xc0ccd6, new Item.Properties()));

	public static final DeferredHolder<EntityType<?>, EntityType<CamearraEntity>> CAMEARRA = MOBLIST.register("camearra",
			() -> EntityType.Builder.of(CamearraEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(UltraCraftCore.MODID + ":camearra"));

	public static final DeferredItem<DeferredSpawnEggItem> CAMEARRA_SPAWN_EGG = ITEMS.register("camearra_spawn_egg",
			() -> new DeferredSpawnEggItem(CAMEARRA, 0x919c9d, 0xd9bb7c, new Item.Properties()));

	public static final DeferredHolder<EntityType<?>, EntityType<IblisEntity>> IBLIS = MOBLIST.register("iblis",
			() -> EntityType.Builder.of(IblisEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(UltraCraftCore.MODID + ":iblis"));

	public static final DeferredItem<DeferredSpawnEggItem> IBLIS_SPAWN_EGG = ITEMS.register("iblis_spawn_egg",
			() -> new DeferredSpawnEggItem(IBLIS, 0xd0021b, 0x4a4a4a, new Item.Properties()));

	public static final DeferredHolder<EntityType<?>, EntityType<ChaosUltramanEntity>> CHAOS_ULTRAMAN = MOBLIST.register("chaos_ultraman",
			() -> EntityType.Builder.of(ChaosUltramanEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(UltraCraftCore.MODID + ":chaos_ultraman"));

	public static final DeferredItem<DeferredSpawnEggItem> CHAOS_ULTRAMAN_SPAWN_EGG = ITEMS.register("chaos_ultraman_spawn_egg",
			() -> new DeferredSpawnEggItem(CHAOS_ULTRAMAN,0x101317, 0xd0021b, new Item.Properties()));

	public static final DeferredHolder<EntityType<?>, EntityType<DarkZagiEntity>> DARK_ZAGI = MOBLIST.register("dark_zagi",
			() -> EntityType.Builder.of(DarkZagiEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(UltraCraftCore.MODID + ":dark_zagi"));

	public static final DeferredItem<DeferredSpawnEggItem> DARK_ZAGI_SPAWN_EGG = ITEMS.register("dark_zagi_spawn_egg",
			() -> new DeferredSpawnEggItem(DARK_ZAGI,0x141414, 0x9e0000, new Item.Properties()));

	public static final DeferredHolder<EntityType<?>, EntityType<InpelaizerEntity>> INPELAIZER = MOBLIST.register("inpelaizer",
			() -> EntityType.Builder.of(InpelaizerEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(UltraCraftCore.MODID + ":inpelaizer"));

	public static final DeferredItem<DeferredSpawnEggItem> INPELAIZER_SPAWN_EGG = ITEMS.register("inpelaizer_spawn_egg",
			() -> new DeferredSpawnEggItem(INPELAIZER,0x5e6266, 0xd02020, new Item.Properties()));

	public static final DeferredHolder<EntityType<?>, EntityType<AlienEmperaEntity>> ALIEN_EMPERA = MOBLIST.register("alien_empera",
			() -> EntityType.Builder.of(AlienEmperaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(UltraCraftCore.MODID + ":alien_empera"));

	public static final DeferredItem<DeferredSpawnEggItem> ALIEN_EMPERA_SPAWN_EGG = ITEMS.register("alien_empera_spawn_egg",
			() -> new DeferredSpawnEggItem(ALIEN_EMPERA,0x0d0d11, 0x5a1827, new Item.Properties()));

	public static final DeferredHolder<EntityType<?>, EntityType<TsurugiEntity>> TSURUGI = MOBLIST.register("tsurugi",
			() -> EntityType.Builder.of(TsurugiEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(UltraCraftCore.MODID + ":tsurugi"));

	public static final DeferredItem<DeferredSpawnEggItem> TSURUGI_SPAWN_EGG = ITEMS.register("tsurugi_spawn_egg",
			() -> new DeferredSpawnEggItem(TSURUGI,0x1c2e60, 0x8c9aa9, new Item.Properties()));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
