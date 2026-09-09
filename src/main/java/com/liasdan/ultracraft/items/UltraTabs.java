package com.liasdan.ultracraft.items;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.blocks.UltraBlocks;
import com.liasdan.ultracraft.entity.MobsCore;
import com.liasdan.ultracraft.items.heisei.*;
import com.liasdan.ultracraft.items.showa.ShowaUltramanItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class UltraTabs {
	
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
			UltraCraftCore.MODID) ;
	
    /*public static DeferredItem<CreativeModeTab> RiderblockTab = CREATIVE_MODE_TABS.register("krc_999_blocks_tab", () ->
			CreativeModeTab.builder().icon(() -> new ItemStack(Rider_Blocks.PURE_GAIA_MEMORY_BLOCK.get())).withBackgroundLocation(new ResourceLocation(KamenRiderCraftCore.MODID+"textures/gui/tab_iichigo_items.png"))
			.title(Component.literal("Rider Blocks")).build());*/
	
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> UltramanTab = CREATIVE_MODE_TABS.register("umc001", () ->
			CreativeModeTab.builder().icon(() -> new ItemStack(ShowaUltramanItems.BETA_CAPSULE.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID,"textures/gui/tab_ultra_items.png"))
					.title(Component.translatable("tab.ultracraft.ultraman")).build());

	public static DeferredHolder<CreativeModeTab, CreativeModeTab> TDGTab = CREATIVE_MODE_TABS.register("umc002", () ->
			CreativeModeTab.builder().icon(() -> new ItemStack(TigaItems.TIGA_SPARKLENCE.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID,"textures/gui/tab_tdg_items.png"))
					.title(Component.translatable("tab.ultracraft.tdg")).build());

	public static DeferredHolder<CreativeModeTab, CreativeModeTab> NeosTab = CREATIVE_MODE_TABS.register("umc003", () ->
			CreativeModeTab.builder().icon(() -> new ItemStack(NeosItems.ESTRELLAR.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID,"textures/gui/tab_neos_items.png"))
					.title(Component.translatable("tab.ultracraft.neos")).build());

	public static DeferredHolder<CreativeModeTab, CreativeModeTab> CosmosTab = CREATIVE_MODE_TABS.register("umc004", () ->
			CreativeModeTab.builder().icon(() -> new ItemStack(CosmosItems.COSMO_PLUCK.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID,"textures/gui/tab_cosmos_items.png"))
					.title(Component.translatable("tab.ultracraft.cosmos")).build());

	public static DeferredHolder<CreativeModeTab, CreativeModeTab> NexusTab = CREATIVE_MODE_TABS.register("umc005", () ->
			CreativeModeTab.builder().icon(() -> new ItemStack(NexusItems.EVOLTRUSTER.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID,"textures/gui/tab_nexus_items.png"))
					.title(Component.translatable("tab.ultracraft.nexus")).build());

	public static DeferredHolder<CreativeModeTab, CreativeModeTab> MaxTab = CREATIVE_MODE_TABS.register("umc006", () ->
			CreativeModeTab.builder().icon(() -> new ItemStack(MaxItems.MAX_SPARK.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID,"textures/gui/tab_max_items.png"))
					.title(Component.translatable("tab.ultracraft.max")).build());

	public static DeferredHolder<CreativeModeTab, CreativeModeTab> MebiusTab = CREATIVE_MODE_TABS.register("umc007", () ->
			CreativeModeTab.builder().icon(() -> new ItemStack(MebiusItems.MEBIUS_BRACE.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID,"textures/gui/tab_mebius_items.png"))
					.title(Component.translatable("tab.ultracraft.mebius")).build());

	public static DeferredHolder<CreativeModeTab, CreativeModeTab> MiscTab = CREATIVE_MODE_TABS.register("umc900", () ->
    		CreativeModeTab.builder().icon(() -> new ItemStack(OtherItems.LAND_OF_LIGHT_FRAGMENT.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID,"textures/gui/tab_ultra_items.png"))
					.title(Component.translatable("tab.ultracraft.misc")).build());
    
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> BlockTab = CREATIVE_MODE_TABS.register("ssc901", () ->
    		CreativeModeTab.builder().icon(() -> new ItemStack(UltraBlocks.METEOR.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID,"textures/gui/tab_ultra_items.png"))
					.title(Component.translatable("tab.ultracraft.block")).build());

    public static List<Item> ULTRAMAN= new ArrayList<Item>();
	public static List<Item> TDG= new ArrayList<Item>();
	public static List<Item> NEOS= new ArrayList<Item>();
	public static List<Item> COSMOS= new ArrayList<Item>();
	public static List<Item> NEXUS= new ArrayList<Item>();
	public static List<Item> MAX= new ArrayList<Item>();
	public static List<Item> MEBIUS= new ArrayList<Item>();
    
    public static List<Item> MISC= new ArrayList<Item>();
    public static List<Block> BLOCKS= new ArrayList<Block>();

	public static void register(IEventBus eventBus) {
		CREATIVE_MODE_TABS.register(eventBus);
	}
    
    public static void AddItemsToTabs(BuildCreativeModeTabContentsEvent event){

		if(event.getTab() == UltraTabs.UltramanTab.get()) {
			for (int i = 0; i < UltraTabs.ULTRAMAN.size(); i++)
			{
				event.accept( UltraTabs.ULTRAMAN.get(i));
			}

		}
		else if(event.getTab() == UltraTabs.TDGTab.get()) {
			for (int i = 0; i < UltraTabs.TDG.size(); i++)
			{
				event.accept( UltraTabs.TDG.get(i));
			}
		}
		else if(event.getTab() == UltraTabs.NeosTab.get()) {
			for (int i = 0; i < UltraTabs.NEOS.size(); i++)
			{
				event.accept( UltraTabs.NEOS.get(i));
			}
		}
		else if(event.getTab() == UltraTabs.CosmosTab.get()) {
			for (int i = 0; i < UltraTabs.COSMOS.size(); i++)
			{
				event.accept( UltraTabs.COSMOS.get(i));
			}
		}
		else if(event.getTab() == UltraTabs.NexusTab.get()) {
			for (int i = 0; i < UltraTabs.NEXUS.size(); i++)
			{
				event.accept( UltraTabs.NEXUS.get(i));
			}
		}
		else if(event.getTab() == UltraTabs.MaxTab.get()) {
			for (int i = 0; i < UltraTabs.MAX.size(); i++)
			{
				event.accept( UltraTabs.MAX.get(i));
			}
		}
		else if(event.getTab() == UltraTabs.MebiusTab.get()) {
			for (int i = 0; i < UltraTabs.MEBIUS.size(); i++)
			{
				event.accept( UltraTabs.MEBIUS.get(i));
			}
		}
		else if(event.getTab() == UltraTabs.MiscTab.get()) {

			event.accept(MobsCore.ZETTON_SPAWN_EGG);
			event.accept(MobsCore.YAPOOL_SPAWN_EGG);
			event.accept(MobsCore.BALTAN_SPAWN_EGG);
			event.accept(MobsCore.ALIEN_MAGMA_SPAWN_EGG);
			event.accept(MobsCore.SHADOW_SPAWN_EGG);
			
			for (int i = 0; i < UltraTabs.MISC.size(); i++)
			{
				event.accept( UltraTabs.MISC.get(i));
			}
		}
		else if(event.getTab() == UltraTabs.BlockTab.get()) {
			for (int i = 0; i < UltraTabs.BLOCKS.size(); i++)
			{
				event.accept( UltraTabs.BLOCKS.get(i));
			}

		}


    	
    }
    
}
