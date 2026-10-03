package com.liasdan.ultracraft.entity.boss;

import com.liasdan.ultracraft.entity.footsoldier.BaseFootsoldierEntity;
import com.liasdan.ultracraft.items.OtherItems;
import com.liasdan.ultracraft.items.heisei.TigaItems;
import com.liasdan.ultracraft.items.others.UltraRiserItem;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.Random;

import static com.liasdan.ultracraft.attachments.AttachmentTypes.MOB_STATE;

public class DarkTigaEntity  extends BaseFootsoldierEntity {
    private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(Component.translatable(getDisplayName().getString()).withStyle(ChatFormatting.GRAY), BossEvent.BossBarColor.YELLOW, BossEvent.BossBarOverlay.PROGRESS));

    public DarkTigaEntity(EntityType<? extends BaseFootsoldierEntity> entityType, Level world) {
        super(entityType, world);
        NAME="tiga_dark";
        setItemSlot(EquipmentSlot.HEAD, new ItemStack(OtherItems.ULTRAMAN_HELMET.get()));
        setItemSlot(EquipmentSlot.CHEST, new ItemStack(OtherItems.ULTRAMAN_CHESTPLATE.get()));
        setItemSlot(EquipmentSlot.LEGS, new ItemStack(OtherItems.ULTRAMAN_LEGGINGS.get()));
        setItemSlot(EquipmentSlot.FEET, new ItemStack(TigaItems.BLACK_SPARKLENCE.get()));
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

    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if (getData(MOB_STATE).isEmpty() && !level().isClientSide() && getHealth()<51 && source.getEntity() instanceof Player){
            setItemSlot(EquipmentSlot.FEET, new ItemStack(TigaItems.BLACK_SPARKLENCE.get()));
            ItemStack riser = getItemBySlot(EquipmentSlot.FEET);
            int rand = random.nextInt(3);
            switch (rand) {
                case 1:
                    UltraRiserItem.set_Form_Item(riser, TigaItems.TIGA_DARK_TORNADO_ENERGY.get(), 1);
                    break;
                case 2:
                    UltraRiserItem.set_Form_Item(riser, TigaItems.TIGA_DARK_BLAST_ENERGY.get(), 1);
                    break;
            }
            setData(MOB_STATE,"phase_two");
            setHealth(50);
        }
    }

    public void remove(RemovalReason reason) {
        if (isDeadOrDying()) {
            ItemStack riser = getItemBySlot(EquipmentSlot.FEET);
            if (!level().isClientSide() && UltraRiserItem.get_Form_Item(riser, 1) ==  TigaItems.TIGA_DARK_TORNADO_ENERGY.get()) {
                Random rand = new Random();
                int randomInt = rand.nextInt(2);

                if (randomInt == 0) {
                    ItemEntity energy = new ItemEntity(level(), getX(), getY(), getZ(), new ItemStack(TigaItems.TIGA_POWER_TYPE_ENERGY.get(),1), 0, 0, 0);
                    energy.setPickUpDelay(0);
                    level().addFreshEntity(energy);
                }
                else if (randomInt == 1) {
                    ItemEntity energy = new ItemEntity(level(), getX(), getY(), getZ(), new ItemStack(TigaItems.TIGA_DARK_TORNADO_ENERGY.get(),1), 0, 0, 0);
                    energy.setPickUpDelay(0);
                    level().addFreshEntity(energy);
                }
            }
            else if (!level().isClientSide() && UltraRiserItem.get_Form_Item(riser, 1) ==  TigaItems.TIGA_DARK_BLAST_ENERGY.get()) {
                Random rand = new Random();
                int randomInt = rand.nextInt(2);

                if (randomInt == 0) {
                    ItemEntity energy = new ItemEntity(level(), getX(), getY(), getZ(), new ItemStack(TigaItems.TIGA_SKY_TYPE_ENERGY.get(),1), 0, 0, 0);
                    energy.setPickUpDelay(0);
                    level().addFreshEntity(energy);
                }
                else if (randomInt == 1) {
                    ItemEntity energy = new ItemEntity(level(), getX(), getY(), getZ(), new ItemStack(TigaItems.TIGA_DARK_BLAST_ENERGY.get(),1), 0, 0, 0);
                    energy.setPickUpDelay(0);
                    level().addFreshEntity(energy);
                }
            }
        }
        super.remove(reason);
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
