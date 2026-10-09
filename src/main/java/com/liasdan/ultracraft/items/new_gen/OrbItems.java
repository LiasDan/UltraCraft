package com.liasdan.ultracraft.items.new_gen;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.items.OtherItems;
import com.liasdan.ultracraft.items.UltraTabs;
import com.liasdan.ultracraft.items.new_gen.orb.OrbCaliburItem;
import com.liasdan.ultracraft.items.others.BaseSwordItem;
import com.liasdan.ultracraft.items.others.UltraFormChangeItem;
import com.liasdan.ultracraft.items.others.UltraRiserItem;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.print.attribute.standard.MediaSize;

public class OrbItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltraCraftCore.MODID);

    public static final DeferredItem<Item> ORB_ORIGIN_THE_FIRST_ENERGY = ITEMS.register("orb_origin_the_first_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_origin_the_first","orb","").AddToTabList(UltraTabs.MISC));

    public static final DeferredItem<Item> ORB_ORIGIN_CARD = ITEMS.register("orb_origin_card",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_origin","orb","").AddToTabList(UltraTabs.MISC));

    public static final DeferredItem<Item> UNFINISHED_ORB_CALIBUR = ITEMS.register("unfinished_orb_calibur",
            () -> new OrbCaliburItem(ArmorMaterials.DIAMOND,"orb",ORB_ORIGIN_THE_FIRST_ENERGY, OtherItems.ULTRAMAN_HELMET, OtherItems.ULTRAMAN_CHESTPLATE, OtherItems.ULTRAMAN_LEGGINGS, new Item.Properties()).AddToTabList(UltraTabs.MISC).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

    public static final DeferredItem<SwordItem> TRUE_ORB_CALIBUR = ITEMS.register("true_orb_calibur",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(UltraTabs.MISC).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
