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

public class GaiaItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltraCraftCore.MODID);

    public static final DeferredItem<Item> GAIA_V1_ENERGY = ITEMS.register("gaia_v1_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_v1","gaia","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.TDG));

    public static final DeferredItem<Item> GAIA_V2_ENERGY = ITEMS.register("gaia_v2_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_v2","gaia","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.TDG));

    public static final DeferredItem<Item> GAIA_SUPREME_ENERGY = ITEMS.register("gaia_supreme_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_supreme","gaia","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.TDG));

    public static final DeferredItem<Item> GAIA_SUPER_SUPREME_ENERGY = ITEMS.register("gaia_super_supreme_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_super_supreme","gaia","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.TDG));

    public static final DeferredItem<Item> AGUL_V1_ENERGY = ITEMS.register("agul_v1_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_v1","agul","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.TDG));

    public static final DeferredItem<Item> AGUL_V2_ENERGY = ITEMS.register("agul_v2_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_v2","agul","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.TDG));

    public static final DeferredItem<Item> AGUL_SUPREME_ENERGY = ITEMS.register("agul_supreme_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_supreme","agul","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.TDG));

    public static final DeferredItem<Item> PHOTOELECTRON_TUBE = ITEMS.register("photoelectron_tube",
            () -> new UltraRiserItem(ArmorMaterials.DIAMOND,"gaia",GAIA_V1_ENERGY, OtherItems.ULTRAMAN_HELMET,OtherItems.ULTRAMAN_CHESTPLATE,OtherItems.ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.TDG).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
    public static final DeferredItem<Item> ESPLENDER = ITEMS.register("esplender",
            () -> new UltraRiserItem(ArmorMaterials.DIAMOND,"gaia",GAIA_V1_ENERGY, OtherItems.ULTRAMAN_HELMET,OtherItems.ULTRAMAN_CHESTPLATE,OtherItems.ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.TDG).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

    public static final DeferredItem<Item> AGULATER = ITEMS.register("agulater",
            () -> new UltraRiserItem(ArmorMaterials.DIAMOND,"agul",AGUL_V1_ENERGY, OtherItems.ULTRAMAN_HELMET,OtherItems.ULTRAMAN_CHESTPLATE,OtherItems.ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.TDG).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
