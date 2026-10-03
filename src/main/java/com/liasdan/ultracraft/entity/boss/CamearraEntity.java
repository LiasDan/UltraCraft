package com.liasdan.ultracraft.entity.boss;

import com.liasdan.ultracraft.entity.footsoldier.BaseFootsoldierEntity;
import com.liasdan.ultracraft.items.OtherItems;
import com.liasdan.ultracraft.items.heisei.TigaItems;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class CamearraEntity extends BaseFootsoldierEntity {
    private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(Component.translatable(getDisplayName().getString()).withStyle(ChatFormatting.GOLD), BossEvent.BossBarColor.YELLOW, BossEvent.BossBarOverlay.PROGRESS));

    public CamearraEntity(EntityType<? extends BaseFootsoldierEntity> entityType, Level world) {
        super(entityType, world);
        NAME="camearra";
        setItemSlot(EquipmentSlot.HEAD, new ItemStack(OtherItems.ULTRAMAN_HELMET.get()));
        setItemSlot(EquipmentSlot.CHEST, new ItemStack(OtherItems.ULTRAMAN_CHESTPLATE.get()));
        setItemSlot(EquipmentSlot.LEGS, new ItemStack(OtherItems.ULTRAMAN_LEGGINGS.get()));
        setItemSlot(EquipmentSlot.FEET, new ItemStack(TigaItems.CAMEARRA_SPARKLENCE.get()));
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        bossEvent.setProgress(getHealth() / getMaxHealth());
    }


    public void readAdditionalSaveData(CompoundTag p_31474_) {
        super.readAdditionalSaveData(p_31474_);
        if (hasCustomName()) {
            bossEvent.setName(getDisplayName());
        }
    }

    public void setCustomName(@Nullable Component p_31476_) {
        super.setCustomName(p_31476_);
        bossEvent.setName(getDisplayName());
    }

    public void startSeenByPlayer(ServerPlayer p_31483_) {
        super.startSeenByPlayer(p_31483_);
        bossEvent.addPlayer(p_31483_);
    }

    public void stopSeenByPlayer(ServerPlayer p_31488_) {
        super.stopSeenByPlayer(p_31488_);
        bossEvent.removePlayer(p_31488_);
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 35.0D)
                .add(Attributes.MOVEMENT_SPEED,(double)0.2F)
                .add(Attributes.ATTACK_DAMAGE, 15.0D)
                .add(Attributes.ARMOR, 4.0D)
                .add(Attributes.MAX_HEALTH, 100.0D);
    }
}
