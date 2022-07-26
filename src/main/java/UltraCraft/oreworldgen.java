package UltraCraft;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;


public class oreworldgen implements IWorldGenerator
{
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,IChunkProvider chunkProvider) {

		switch (world.provider.getDimension())
		{
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;

		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;

		case 1:
			generateEnd();
			break;
		}
		
	}
	

	public void generateNether(World world, Random rand, int chunkX, int chunkZ)
	{
		
	}	

	public void generateSurface(World world, Random rand, int chunkX, int chunkZ)
	{
/*		//01 Goranger
		for (int i = 0; i < 4; i++)
		{
			//16x16 area up to y = 64
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(60);
			int randPosZ = chunkZ + rand.nextInt(16);
			// 10 blocks per vein
			BlockPos position = new BlockPos(randPosX, randPosY, randPosZ);
			(new WorldGenMinable(RiderItems.goranger_ore.getDefaultState(), 10)).generate(world, rand,position);
		}*/
	}

	public void generateEnd()
	{
		
	}
}
