package com.liasdan.ultracraft.blocks;


import net.minecraft.world.level.block.Block;

import java.util.List;
public class BaseBlock extends Block {



	public BaseBlock(Properties prop) {
		super(prop);
		
	}

	public BaseBlock AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

}