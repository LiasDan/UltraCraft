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

public class MebiusItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltraCraftCore.MODID);

    public static final DeferredItem<Item> MEBIUS_ENERGY = ITEMS.register("mebius_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"","mebius","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.MEBIUS));
    public static final DeferredItem<Item> HIKARI_ENERGY = ITEMS.register("hikari_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"","hikari","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.MEBIUS));
    public static final DeferredItem<Item> TSURUGI_ENERGY = ITEMS.register("tsurugi_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"","tsurugi","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.MEBIUS));

    public static final DeferredItem<Item> MEBIUS_BRAVE_ENERGY = ITEMS.register("mebius_brave_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"","mebius_brave","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)));
    public static final DeferredItem<Item> GUTS_ENERGY = ITEMS.register("guts_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_burning_brave","mebius","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.MEBIUS));
    public static final DeferredItem<Item> MEBIUS_PHOENIX_BRAVE_ENERGY = ITEMS.register("mebius_phoenix_brave_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_phoenix_brave","mebius","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.MEBIUS));
    public static final DeferredItem<Item> MEBIUS_INFINITY_ENERGY = ITEMS.register("mebius_infinity_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_infinity","mebius","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.MEBIUS));

    public static final DeferredItem<Item> MEBIUS_BRACE = ITEMS.register("mebius_brace",
            () -> new UltraRiserItem(ArmorMaterials.DIAMOND,"mebius",MEBIUS_ENERGY, OtherItems.ULTRAMAN_HELMET,OtherItems.ULTRAMAN_CHESTPLATE,OtherItems.ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.MEBIUS).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
    public static final DeferredItem<Item> KNIGHT_BRACE = ITEMS.register("knight_brace",
            () -> new UltraRiserItem(ArmorMaterials.DIAMOND,"hikari",HIKARI_ENERGY, OtherItems.ULTRAMAN_HELMET,OtherItems.ULTRAMAN_CHESTPLATE,OtherItems.ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.MEBIUS).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
    public static final DeferredItem<Item> KNIGHT_BRACE_TSURUGI = ITEMS.register("knight_brace_tsurugi",
            () -> new UltraRiserItem(ArmorMaterials.DIAMOND,"tsurugi",TSURUGI_ENERGY, OtherItems.ULTRAMAN_HELMET,OtherItems.ULTRAMAN_CHESTPLATE,OtherItems.ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.MEBIUS).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
    public static final DeferredItem<Item> KNIGHT_MEBIUS_BRACE = ITEMS.register("knight_mebius_brace",
            () -> new UltraRiserItem(ArmorMaterials.DIAMOND,"mebius_brave",MEBIUS_BRAVE_ENERGY, OtherItems.ULTRAMAN_HELMET,OtherItems.ULTRAMAN_CHESTPLATE,OtherItems.ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.MEBIUS).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
