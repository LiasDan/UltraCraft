package com.liasdan.ultracraft.entity.footsoldier;

import com.liasdan.ultracraft.items.OtherItems;
import com.liasdan.ultracraft.items.heisei.CosmosItems;
import com.liasdan.ultracraft.items.heisei.MaxItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BaltanEntity extends BaseFootsoldierEntity {

    public BaltanEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="baltan";
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
                    spawnAtLocation(MaxItems.MAX_ENERGY.get());

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
}