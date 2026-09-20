package com.liasdan.ultracraft.items.heisei.gaia;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.items.others.UltraArmorItem;
import com.liasdan.ultracraft.items.others.UltraRiserItem;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class AgulaterItem extends UltraRiserItem {
    public AgulaterItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
    {
        super(material, rider, baseFormItem, head, torso, legs, properties);
    }

    @Override
    public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String rangerName)
    {
        String belt = ((UltraRiserItem)itemstack.getItem()).BELT_TEXT;

        boolean fly = !rider.onGround();

        if (equipmentSlot == EquipmentSlot.FEET) {
            if (!isTransformed(rider)) {
                return "belts/agulater";
            }
            else {
                if (((UltraRiserItem)itemstack.getItem()).BELT_TEXT==null) {
                    belt = get_Form_Item(itemstack,1).getBeltTex();
                }
                return "belts/"+belt;
            }
        }

        else return get_Form_Item(itemstack,1).getRangerName(rangerName)+get_Form_Item(itemstack,1).getFormName(fly);
    }

    @Override
    public ResourceLocation getBeltModelResource(ItemStack itemstack, UltraArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        if (!isTransformed(rider)) return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "geo/right_brace.geo.json");
        return ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, get_Form_Item(itemstack, 1).get_Belt_Model());
    }

    @Override
    public boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

        switch (currentSlot) {
            case HEAD, LEGS ->{
                return true;
            }
            case CHEST -> {
            }
            default -> {}
        }
        return false;
    }
}
