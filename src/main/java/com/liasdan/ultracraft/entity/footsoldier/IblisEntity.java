package com.liasdan.ultracraft.entity.footsoldier;

import com.liasdan.ultracraft.items.OtherItems;
import com.liasdan.ultracraft.items.heisei.CosmosItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

public class IblisEntity extends BaseFootsoldierEntity
{
    
	public IblisEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level)
	{
        super(type, level);
        NAME = "iblis";
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (itemstack.is(OtherItems.LAND_OF_LIGHT_FRAGMENT)) {
            if (!level().isClientSide() && level() instanceof ServerLevel serverLevel) {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                if (random.nextInt(3) == 0) {
                    if (random.nextInt(2) == 0) {
                        spawnAtLocation(CosmosItems.COSMOS_LUNA_ENERGY.get());
                    }
                    else {
                        spawnAtLocation(CosmosItems.COSMOS_CORONA_ENERGY.get());
                    }

                    int particleDropCount = 1 + random.nextInt(4);
                    spawnAtLocation(CosmosItems.CHAOS_HEADER_PARTICLES.get(), particleDropCount);

                    serverLevel.sendParticles(ParticleTypes.HEART, getX(), getY() + 0.5D, getZ(), 7, 0.5D, 0.5D, 0.5D, 0.02D);
                    discard();
                }
                else {
                    serverLevel.sendParticles(ParticleTypes.SMOKE, getX(), getY() + 0.5D, getZ(), 5, 0.5D, 0.5D, 0.5D, 0.02D);
                }
            }
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
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
