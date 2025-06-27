package com.liasdan.ultracraft.blocks;

import com.google.common.collect.Lists;
import com.liasdan.supersentaicraft.entity.footsoldier.BaseFootsoldierEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
public class BossBlock extends BaseBlock {

	private Component TEXT;
	private Supplier<? extends EntityType<? extends BaseFootsoldierEntity>> BOSS;
	private List<Block> BLOCK;
	private int NUM;



	public BossBlock(Properties prop,Supplier<? extends EntityType<? extends BaseFootsoldierEntity>> boss,Component text) {
		super(prop);
		TEXT=text;
		BOSS =boss;

	}

	public BossBlock(Properties prop,Supplier<? extends EntityType<? extends BaseFootsoldierEntity>> boss,Component text,int nun,Block... block) {
		super(prop);
		TEXT=text;
		BOSS =boss;
		BLOCK = Lists.newArrayList(block);

	}



	@Override
	public void playerDestroy(Level wolrd, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity p_49831_, ItemStack stack) {
		player.awardStat(Stats.BLOCK_MINED.get(this));
		player.causeFoodExhaustion(0.005F);
		dropResources(state, wolrd, pos, p_49831_, player, stack);
		if (BLOCK!=null) {
			if(NUM==1) {
				for (int n = 0; n < 40; n++)
				{
					Random generator = new Random();
					int posX = (pos.getX()-10)+generator.nextInt(20);
					int posY = pos.getY()+generator.nextInt(6);
					int posZ = (pos.getZ()-10)+generator.nextInt(20);
					BlockPos pos1 = new BlockPos(posX,posY,posZ);
					if (wolrd.isEmptyBlock(pos1))wolrd.setBlockAndUpdate(pos1, BLOCK.get(generator.nextInt(BLOCK.size())).defaultBlockState());
				}
			}else {
				for (int n = 0; n < 40; n++)
				{
					Random generator = new Random();
					int posX = (pos.getX()-10)+generator.nextInt(20);
					int posY = pos.getY();
					int posZ = (pos.getZ()-10)+generator.nextInt(20);
					BlockPos pos1 = new BlockPos(posX,posY,posZ);
					if (wolrd.isEmptyBlock(pos1))wolrd.setBlockAndUpdate(pos1, BLOCK.get(generator.nextInt(BLOCK.size())).defaultBlockState());
				}
			}
		}
		BaseFootsoldierEntity boss = BOSS.get().create(wolrd);
		if (boss != null) {
			boss.moveTo(pos.getX(), pos.getY(), pos.getZ(), 0, 0.0F);
			wolrd.addFreshEntity(boss);
			player.sendSystemMessage(TEXT);

		}

	}

}