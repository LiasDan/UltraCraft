package com.liasdan.ultracraft.items.new_gen;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.liasdan.ultracraft.effect.EffectCore;
import com.liasdan.ultracraft.items.OtherItems;
import com.liasdan.ultracraft.items.UltraTabs;
import com.liasdan.ultracraft.items.others.BaseSwordItem;
import com.liasdan.ultracraft.items.others.UltraFormChangeItem;
import com.liasdan.ultracraft.items.others.UltraRiserItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import software.bernie.geckolib.util.Color;

import java.util.List;

public class ZeroItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltraCraftCore.MODID);

    public static final DeferredItem<Item> ZERO_ENERGY = ITEMS.register("zero_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"","zero","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (rider.getItemBySlot(EquipmentSlot.OFFHAND).getItem() != ZERO_SLUGGER.asItem() && rider.getItemBySlot(EquipmentSlot.MAINHAND).getItem() != ZeroItems.ZERO_SLUGGER.asItem()) {
                            layerInfo.add(new RenderLayerInfo("zero_slugger", "seven"));
                        }
                    }
            }.ChangeModel("geo/seven.geo.json").AddToTabList(UltraTabs.ZERO));
    public static final DeferredItem<Item> ZERO_STRONG_CORONA_ENERGY = ITEMS.register("zero_strong_corona_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_strong_corona","zero","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false)){
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (rider.getItemBySlot(EquipmentSlot.OFFHAND).getItem() != ZERO_SLUGGER.asItem() && rider.getItemBySlot(EquipmentSlot.MAINHAND).getItem() != ZeroItems.ZERO_SLUGGER.asItem()) {
                        layerInfo.add(new RenderLayerInfo("zero_slugger_strong_corona", "seven"));
                    }
                }
            }.ChangeModel("geo/seven.geo.json").AddToTabList(UltraTabs.ZERO));
    public static final DeferredItem<Item> ZERO_LUNA_MIRACLE_ENERGY = ITEMS.register("zero_luna_miracle_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_luna_miracle","zero","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED,40, 2, true, false)){
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (rider.getItemBySlot(EquipmentSlot.OFFHAND).getItem() != ZERO_SLUGGER.asItem() && rider.getItemBySlot(EquipmentSlot.MAINHAND).getItem() != ZeroItems.ZERO_SLUGGER.asItem()) {
                        layerInfo.add(new RenderLayerInfo("zero_slugger_luna_miracle", "seven"));
                    }
                }
            }.ChangeModel("geo/seven.geo.json").AddToTabList(UltraTabs.ZERO));
    public static final DeferredItem<Item> ZERO_WILD_BURST_ENERGY = ITEMS.register("zero_wild_burst_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_wild_burst","zero","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (rider.getItemBySlot(EquipmentSlot.OFFHAND).getItem() != ZERO_SLUGGER.asItem() && rider.getItemBySlot(EquipmentSlot.MAINHAND).getItem() != ZeroItems.ZERO_SLUGGER.asItem()) {
                        layerInfo.add(new RenderLayerInfo("zero_slugger", "seven"));
                    }
                }
            }.ChangeModel("geo/seven.geo.json").AddToTabList(UltraTabs.ZERO));

    public static final DeferredItem<Item> ULTRA_ZERO_EYE = ITEMS.register("ultra_zero_eye",
            () -> new UltraRiserItem(ArmorMaterials.DIAMOND,"zero",ZERO_ENERGY, OtherItems.ULTRAMAN_HELMET,OtherItems.ULTRAMAN_CHESTPLATE,OtherItems.ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.ZERO).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

    public static final DeferredItem<SwordItem> ZERO_SLUGGER = ITEMS.register("zero_slugger",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(UltraTabs.ZERO).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
