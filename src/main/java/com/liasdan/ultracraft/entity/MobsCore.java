package com.liasdan.ultracraft.entity;

import com.liasdan.ultracraft.UltraCraftCore;
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

//	public static final DeferredHolder<EntityType<?>, EntityType<ZoldersEntity>> ZOLDERS = MOBLIST.register("zolder",
//            () -> EntityType.Builder.of(ZoldersEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(SuperSentaiCraftCore.MODID + ":zolder"));
//
//    public static final DeferredItem<DeferredSpawnEggItem> ZOLDERS_SPAWN_EGG = ITEMS.register("zolder_spawn_egg",
//            () -> new DeferredSpawnEggItem(ZOLDERS,0xffffff, 0x151515, new Item.Properties()));


	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
