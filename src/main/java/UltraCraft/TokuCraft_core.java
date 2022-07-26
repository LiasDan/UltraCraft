package UltraCraft;

import UltraCraft.potion.PotionCore;
import UltraCraft.potion.PotionFirePunch;
import UltraCraft.potion.PotionFly;
import UltraCraft.potion.PotionPunchBoost;
import UltraCraft.util.Refercence;
import UltraCraft.world.gen.WorldGenCustomStructures;
import UltraCraft.world.gen.modDimensionWorldGen;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;


@Mod(modid = Refercence.MODID, name = Refercence.NAME, version = Refercence.VERSION)
public class TokuCraft_core {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	public static final List<Block> BLOCKS = new ArrayList<Block>();


	@Instance
	public static TokuCraft_core instance;

	@SidedProxy(clientSide = Refercence.CLIENT_PROXY_CLASS, serverSide = Refercence.COMMON_PROXY_CLASS)
	public static CommonProxyUltra proxy;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		UltraItems.init();
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		proxy.preInit();
		PotionCore.init(event);
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderThings();
		GameRegistry.registerWorldGenerator(new oreworldgen(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
		mobsCore.Addmob();
	}

}


