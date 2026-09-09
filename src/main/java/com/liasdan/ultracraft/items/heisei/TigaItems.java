package com.liasdan.ultracraft.items.heisei;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.effect.EffectCore;
import com.liasdan.ultracraft.items.OtherItems;
import com.liasdan.ultracraft.items.UltraTabs;
import com.liasdan.ultracraft.items.others.BaseItem;
import com.liasdan.ultracraft.items.others.UltraFormChangeItem;
import com.liasdan.ultracraft.items.others.UltraRiserItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TigaItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltraCraftCore.MODID);

    public static final DeferredItem<Item> TIGA_MULTI_TYPE_ENERGY = ITEMS.register("tiga_multi_type_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_multi_type","tiga","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.TDG));

    public static final DeferredItem<Item> TIGA_POWER_TYPE_ENERGY = ITEMS.register("tiga_power_type_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_power_type","tiga","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.TDG));

    public static final DeferredItem<Item> TIGA_SKY_TYPE_ENERGY = ITEMS.register("tiga_sky_type_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_sky_type","tiga","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.TDG));

    public static final DeferredItem<Item> TIGA_DARK_ENERGY = ITEMS.register("tiga_dark_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"","tiga_dark","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.TDG));

    public static final DeferredItem<Item> TIGA_DARK_TORNADO_ENERGY = ITEMS.register("tiga_dark_tornado_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_tornado","tiga_dark","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.TDG));

    public static final DeferredItem<Item> TIGA_DARK_BLAST_ENERGY = ITEMS.register("tiga_dark_blast_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_blast","tiga_dark","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.TDG));

    public static final DeferredItem<Item> CAMEARRA_ENERGY = ITEMS.register("camearra_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"","camearra",""));

    public static final DeferredItem<Item> TIGA_SPARKLENCE = ITEMS.register("tiga_sparklence",
            () -> new UltraRiserItem(ArmorMaterials.DIAMOND,"tiga",TIGA_MULTI_TYPE_ENERGY,OtherItems.ULTRAMAN_HELMET,OtherItems.ULTRAMAN_CHESTPLATE,OtherItems.ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.TDG).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

    public static final DeferredItem<Item> BLACK_SPARKLENCE = ITEMS.register("black_sparklence",
            () -> new UltraRiserItem(ArmorMaterials.DIAMOND,"tiga_dark",TIGA_DARK_ENERGY,OtherItems.ULTRAMAN_HELMET,OtherItems.ULTRAMAN_CHESTPLATE,OtherItems.ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.TDG).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

    public static final DeferredItem<Item> CAMEARRA_SPARKLENCE = ITEMS.register("camearra_sparklence",
            () -> new UltraRiserItem(ArmorMaterials.DIAMOND,"camearra",CAMEARRA_ENERGY,OtherItems.ULTRAMAN_HELMET,OtherItems.ULTRAMAN_CHESTPLATE,OtherItems.ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.TDG).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
