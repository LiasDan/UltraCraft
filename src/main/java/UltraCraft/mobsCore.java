package UltraCraft;

import UltraCraft.util.Refercence;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class mobsCore 
{
	public static int MobID = 1000;

	public static void Addmob()
	{
		//01 Goranger
		//EntityRegistry.registerModEntity(new  ResourceLocation(Refercence.MODID+":ZoldersMob"),entity_zolders.class, "ZoldersMob", newMobID(), TokuCraft_core.instance, 80, 3, false, 0x121212, 0xa1a1a1);
		//EntityRegistry.addSpawn(entity_zolders.class,  15, 1, 4, EnumCreatureType.MONSTER,Biome.getBiome(1),Biome.getBiome(4),Biome.getBiome(18),Biome.getBiome(21),Biome.getBiome(22),Biome.getBiome(23),Biome.getBiome(27),Biome.getBiome(28),Biome.getBiome(29),Biome.getBiome(129),Biome.getBiome(132),Biome.getBiome(149),Biome.getBiome(151),Biome.getBiome(155),Biome.getBiome(156),Biome.getBiome(157));
		
	}
	
	public static int newMobID()
	{
		MobID=MobID+1; 
		return MobID;
	}
}
