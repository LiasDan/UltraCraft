package com.liasdan.ultracraft.entity.footsoldier;

import com.liasdan.ultracraft.entity.MobsCore;
import com.liasdan.ultracraft.level.ModGameRules;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class InpelaizerEntity extends BaseFootsoldierEntity {

    public InpelaizerEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="imperializer";
    }

    protected SoundEvent getAmbientSound() { return SoundEvents.ZOMBIE_AMBIENT; }

    protected SoundEvent getHurtSound(DamageSource p_34327_) { return SoundEvents.ZOMBIE_HURT; }

    protected SoundEvent getDeathSound() { return SoundEvents.ZOMBIE_DEATH; }

    public void remove(RemovalReason p_149847_) {
        if ( this.isDeadOrDying()) {
            if (this.random.nextDouble() * 100.0 <= this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE)) {
                int bossChoice = this.random.nextInt(5);
                switch (bossChoice) {
                    case 1:
                        BaseFootsoldierEntity boss = MobsCore.ALIEN_EMPERA.get().create(this.level());
                        if (boss != null) {
                            boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                            this.level().addFreshEntity(boss);

                            if (this.getLastAttacker() instanceof Player) {
                                Player playerIn = (Player) this.getLastAttacker();
                            }
                        }
                        break;
                    case 2:
                        boss = MobsCore.TSURUGI.get().create(this.level());
                        if (boss != null) {
                            boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                            this.level().addFreshEntity(boss);

                            if (this.getLastAttacker() instanceof Player) {
                                Player playerIn = (Player) this.getLastAttacker();
                            }
                        }
                        break;
                }
            }
        }
        super.remove(p_149847_);
    }
}