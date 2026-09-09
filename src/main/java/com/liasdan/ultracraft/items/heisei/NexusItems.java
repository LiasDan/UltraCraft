package com.liasdan.ultracraft.items.heisei;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.effect.EffectCore;
import com.liasdan.ultracraft.items.OtherItems;
import com.liasdan.ultracraft.items.UltraTabs;
import com.liasdan.ultracraft.items.others.UltraFormChangeItem;
import com.liasdan.ultracraft.items.others.UltraRiserItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NexusItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltraCraftCore.MODID);

    public static final DeferredItem<Item> NEXUS_ANPHANS_ENERGY = ITEMS.register("nexus_anphans_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_anphans","nexus","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.NEXUS));
    public static final DeferredItem<Item> NEXUS_JUNIS_ENERGY = ITEMS.register("nexus_junis_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_junis","nexus","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.NEXUS));
    public static final DeferredItem<Item> NEXUS_JUNIS_BLUE_ENERGY = ITEMS.register("nexus_junis_blue_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_junis_blue","nexus","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.NEXUS));

    public static final DeferredItem<Item> NOA_ENERGY = ITEMS.register("noa_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"","noa","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.NEXUS));

    public static final DeferredItem<Item> THE_NEXT_ANPHANS_ENERGY = ITEMS.register("the_next_anphans_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_anphans","the_next","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.NEXUS));
    public static final DeferredItem<Item> THE_NEXT_JUNIS_ENERGY = ITEMS.register("the_next_junis_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_junis","the_next","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.NEXUS));

    public static final DeferredItem<Item> EVOLTRUSTER = ITEMS.register("evoltruster",
            () -> new UltraRiserItem(ArmorMaterials.DIAMOND,"nexus",NEXUS_ANPHANS_ENERGY, OtherItems.ULTRAMAN_HELMET,OtherItems.ULTRAMAN_CHESTPLATE,OtherItems.ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.NEXUS).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
    public static final DeferredItem<Item> EVOLTRUSTER_NOA = ITEMS.register("evoltruster_noa",
            () -> new UltraRiserItem(ArmorMaterials.DIAMOND,"noa",NOA_ENERGY, OtherItems.ULTRAMAN_HELMET,OtherItems.ULTRAMAN_CHESTPLATE,OtherItems.ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.NEXUS).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
    public static final DeferredItem<Item> ENERGY_CORE = ITEMS.register("energy_core",
            () -> new UltraRiserItem(ArmorMaterials.DIAMOND,"the_next",THE_NEXT_ANPHANS_ENERGY, OtherItems.ULTRAMAN_HELMET,OtherItems.ULTRAMAN_CHESTPLATE,OtherItems.ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.NEXUS).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
