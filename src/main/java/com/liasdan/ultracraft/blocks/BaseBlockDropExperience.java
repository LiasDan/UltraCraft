package com.liasdan.ultracraft.blocks;


import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;

import java.util.List;

public class BaseBlockDropExperience extends DropExperienceBlock {

	public BaseBlockDropExperience(Properties properties, IntProvider xpRange) {
		super(xpRange, properties);
	}

	public BaseBlockDropExperience AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

}