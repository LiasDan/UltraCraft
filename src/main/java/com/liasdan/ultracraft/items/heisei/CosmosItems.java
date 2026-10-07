package com.liasdan.ultracraft.items.heisei;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.liasdan.ultracraft.effect.EffectCore;
import com.liasdan.ultracraft.items.OtherItems;
import com.liasdan.ultracraft.items.UltraTabs;
import com.liasdan.ultracraft.items.others.BaseItem;
import com.liasdan.ultracraft.items.others.UltraFormChangeItem;
import com.liasdan.ultracraft.items.others.UltraRiserItem;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class CosmosItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltraCraftCore.MODID);

    public static final DeferredItem<Item> CHAOS_HEADER_PARTICLES = ITEMS.register("chaos_header_particles",
            () -> new BaseItem(new Item.Properties()).AddToTabList(UltraTabs.COSMOS));

    public static final DeferredItem<Item> COSMOS_LUNA_ENERGY = ITEMS.register("cosmos_luna_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_luna","cosmos","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.COSMOS));
    public static final DeferredItem<Item> COSMOS_CORONA_ENERGY = ITEMS.register("cosmos_corona_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_corona","cosmos","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.COSMOS));
    public static final DeferredItem<Item> COSMOS_ECLIPSE_ENERGY = ITEMS.register("cosmos_eclipse_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_eclipse","cosmos","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.COSMOS));
    public static final DeferredItem<Item> COSMOS_MIRACLUNA_ENERGY = ITEMS.register("cosmos_miracluna_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_luna","cosmos","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false))
            {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    RenderType glitter = RenderType.breezeEyes(ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID,"textures/armor/glitter.png"));
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo(glitter, null));
                }
            }.AddToTabList(UltraTabs.COSMOS));
    public static final DeferredItem<Item> COSMOS_SPACE_CORONA_ENERGY = ITEMS.register("cosmos_space_corona_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_space_corona","cosmos","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.COSMOS));
    public static final DeferredItem<Item> COSMOS_FUTURE_ENERGY = ITEMS.register("cosmos_future_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_future","cosmos","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.COSMOS));

    public static final DeferredItem<Item> JUSTICE_ENERGY = ITEMS.register("justice_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"","justice","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.COSMOS));
    public static final DeferredItem<Item> JUSTICE_CRUSHER_ENERGY = ITEMS.register("justice_crusher_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_crusher","justice","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).AddToTabList(UltraTabs.COSMOS));

    public static final DeferredItem<Item> LEGEND_ENERGY = ITEMS.register("legend_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"","legend","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)));

    public static final DeferredItem<Item> CHAOS_ULTRAMAN_ENERGY = ITEMS.register("chaos_ultraman_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"","chaos_ultraman","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).addAlternative(COSMOS_LUNA_ENERGY.get()));
    public static final DeferredItem<Item> CHAOS_ULTRAMAN_CALAMITY_ENERGY = ITEMS.register("chaos_ultraman_calamity_energy",
            () -> new UltraFormChangeItem(new Item.Properties(),0,"_calamity","chaos_ultraman","",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false)).addAlternative(COSMOS_CORONA_ENERGY.get()));

    public static final DeferredItem<Item> COSMO_PLUCK = ITEMS.register("cosmo_pluck",
            () -> new UltraRiserItem(ArmorMaterials.DIAMOND,"cosmos",COSMOS_LUNA_ENERGY, OtherItems.ULTRAMAN_HELMET,OtherItems.ULTRAMAN_CHESTPLATE,OtherItems.ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.COSMOS).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
    public static final DeferredItem<Item> JUST_LANCER = ITEMS.register("just_lancer",
            () -> new UltraRiserItem(ArmorMaterials.DIAMOND,"justice",JUSTICE_ENERGY, OtherItems.ULTRAMAN_HELMET,OtherItems.ULTRAMAN_CHESTPLATE,OtherItems.ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.COSMOS).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));
    public static final DeferredItem<Item> COLOR_TIMER_LEGEND = ITEMS.register("color_timer_legend",
            () -> new UltraRiserItem(ArmorMaterials.DIAMOND,"legend",LEGEND_ENERGY, OtherItems.ULTRAMAN_HELMET,OtherItems.ULTRAMAN_CHESTPLATE,OtherItems.ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.COSMOS).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

    public static final DeferredItem<Item> COLOR_TIMER_CHAOS = ITEMS.register("color_timer_chaos",
            () -> new UltraRiserItem(ArmorMaterials.DIAMOND,"chaos_ultraman",CHAOS_ULTRAMAN_ENERGY, OtherItems.ULTRAMAN_HELMET,OtherItems.ULTRAMAN_CHESTPLATE,OtherItems.ULTRAMAN_LEGGINGS,new Item.Properties()).AddToTabList(UltraTabs.COSMOS).ChangeRepairItem(OtherItems.LAND_OF_LIGHT_FRAGMENT.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
