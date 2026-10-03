package com.liasdan.ultracraft.items.showa.seven;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.items.others.UltraArmorItem;
import com.liasdan.ultracraft.items.others.UltraRiserItem;
import com.liasdan.ultracraft.items.showa.ShowaUltramanItems;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class UltraEyeItem extends UltraRiserItem {
    public UltraEyeItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
    {
        super(material, rider, baseFormItem, head, torso, legs, properties);
        Unlimited_Textures = 1;
    }

    @Override
    public ResourceLocation getModelResource(ItemStack itemstack, UltraArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID,"geo/seven.geo.json");
    }

    @Override
    public String getUnlimitedTextures(ItemStack itemstack, LivingEntity livingEntity, String riderName, int num) {
        if (num == 1 && !livingEntity.isHolding(ShowaUltramanItems.EYE_SLUGGER.get())) return "eye_slugger";
        return "blank";
    }
}

