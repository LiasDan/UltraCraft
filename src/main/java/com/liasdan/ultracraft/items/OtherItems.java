package com.liasdan.ultracraft.items;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.effect.EffectCore;
import com.liasdan.ultracraft.items.others.BaseItem;
import com.liasdan.ultracraft.items.others.LandOfLightFragment;
import com.liasdan.ultracraft.items.others.UltraFormChangeItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class OtherItems {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltraCraftCore.MODID);

//	public static final DeferredItem<Item> BASE_SWORD = ITEMS.register("base_sword",
//			() -> new BaseItem(new Item.Properties()).AddToTabList(UltraTabs.MISC));

	public static final DeferredItem<Item> BLANK_FORM = ITEMS.register("blank_form",
			() -> new UltraFormChangeItem(new Item.Properties(),0,"","",""));

	public static final DeferredItem<Item> LAND_OF_LIGHT_FRAGMENT = ITEMS.register("land_of_light_fragment",
			() -> new LandOfLightFragment(new Item.Properties()).AddToTabList(UltraTabs.MISC));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}