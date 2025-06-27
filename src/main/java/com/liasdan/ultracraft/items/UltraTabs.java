package com.liasdan.ultracraft.items;

import com.liasdan.supersentaicraft.SuperSentaiCraftCore;
import com.liasdan.supersentaicraft.blocks.RangerBlocks;
import com.liasdan.supersentaicraft.entity.MobsCore;
import com.liasdan.ultracraft.UltraCraftCore;
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
	
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> GorangerTab = CREATIVE_MODE_TABS.register("ssc001", () ->
			CreativeModeTab.builder().icon(() -> new ItemStack(UltramanItems.GORANGER_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(SuperSentaiCraftCore.MODID,"textures/gui/tab_goranger_items.png"))
					.title(Component.translatable("tab.supersentaicraft.goranger")).build());

	public static DeferredHolder<CreativeModeTab, CreativeModeTab> MiscTab = CREATIVE_MODE_TABS.register("ssc900", () ->
    		CreativeModeTab.builder().icon(() -> new ItemStack(OtherItems.SUPER_SENTAI_LOGO.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(SuperSentaiCraftCore.MODID,"textures/gui/tab_misc_items.png"))
					.title(Component.translatable("tab.supersentaicraft.misc")).build());
    
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> BlockTab = CREATIVE_MODE_TABS.register("ssc901", () ->
    		CreativeModeTab.builder().icon(() -> new ItemStack(RangerBlocks.RYUSOULGER_ORE.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(SuperSentaiCraftCore.MODID,"textures/gui/tab_misc_items.png"))
					.title(Component.translatable("tab.supersentaicraft.block")).build());
    
    public static List<Item> GORANGER= new ArrayList<Item>();
    
    public static List<Item> MISC= new ArrayList<Item>();
    public static List<Block> BLOCKS= new ArrayList<Block>();

	public static void register(IEventBus eventBus) {
		CREATIVE_MODE_TABS.register(eventBus);
	}
    
    public static void AddItemsToTabs(BuildCreativeModeTabContentsEvent event){

		if(event.getTab() == UltraTabs.GorangerTab.get()) {
			for (int i = 0; i < UltraTabs.GORANGER.size(); i++)
			{
				event.accept( UltraTabs.GORANGER.get(i));
			}

		}
		else if(event.getTab() == UltraTabs.MiscTab.get()) {

			event.accept(MobsCore.ZOLDERS_SPAWN_EGG);

			event.accept(MobsCore.CRIMERS_SPAWN_EGG);

			event.accept(MobsCore.CUTMEN_SPAWN_EGG);

			event.accept(MobsCore.MACHINEMEN_SPAWN_EGG);

			event.accept(MobsCore.UNGLERS_SPAWN_EGG);

			event.accept(MobsCore.WUMPERS_SPAWN_EGG);
			event.accept(MobsCore.SIGNALMAN_EVIL_SPAWN_EGG);

			event.accept(MobsCore.YARTOTS_SPAWN_EGG);
			event.accept(MobsCore.BLACK_KNIGHT_SPAWN_EGG);

			event.accept(MobsCore.ORGETTES_SPAWN_EGG);
			event.accept(MobsCore.DUKE_ORG_ROUKI_SPAWN_EGG);

			event.accept(MobsCore.NANASHIS_SPAWN_EGG);
			event.accept(MobsCore.GEDOU_SHINKEN_RED_SPAWN_EGG);

			event.accept(MobsCore.PORDERMEN_SPAWN_EGG);

			event.accept(MobsCore.DRUNNS_SPAWN_EGG);
			event.accept(MobsCore.GAISOULG_SPAWN_EGG);
			event.accept(MobsCore.RYUSOUL_MORIA_SPAWN_EGG);

			event.accept(MobsCore.NEJIRETTAS_SPAWN_EGG);
			
			for (int i = 0; i < UltraTabs.MISC.size(); i++)
			{
				event.accept( UltraTabs.MISC.get(i));
			}

			event.accept(OtherItems.SUSUME_GORANGER_MUSIC_DISC);

			event.accept(OtherItems.TAIYOU_SENTAI_SUN_VULCAN_MUSIC_DISC);

			event.accept(OtherItems.GAORANGER_HOERO_MUSIC_DISC);

			event.accept(OtherItems.SAMURAI_SENTAI_SHINKENGER_MUSIC_DISC);
		}
		else if(event.getTab() == UltraTabs.BlockTab.get()) {
			for (int i = 0; i < UltraTabs.BLOCKS.size(); i++)
			{
				event.accept( UltraTabs.BLOCKS.get(i));
			}

		}


    	
    }
    
}
