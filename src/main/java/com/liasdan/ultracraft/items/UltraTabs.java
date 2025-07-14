package com.liasdan.ultracraft.items;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.blocks.UltraBlocks;
import com.liasdan.ultracraft.entity.MobsCore;
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
			CreativeModeTab.builder().icon(() -> new ItemStack(UltramanItems.ULTRAMAN_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID,"textures/gui/tab_ultra_items.png"))
					.title(Component.translatable("tab.ultracraft.ultraman")).build());

	public static DeferredHolder<CreativeModeTab, CreativeModeTab> MiscTab = CREATIVE_MODE_TABS.register("umc900", () ->
    		CreativeModeTab.builder().icon(() -> new ItemStack(OtherItems.LAND_OF_LIGHT_FRAGMENT.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID,"textures/gui/tab_ultra_items.png"))
					.title(Component.translatable("tab.ultracraft.misc")).build());
    
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> BlockTab = CREATIVE_MODE_TABS.register("ssc901", () ->
    		CreativeModeTab.builder().icon(() -> new ItemStack(UltraBlocks.METEOR.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID,"textures/gui/tab_ultra_items.png"))
					.title(Component.translatable("tab.ultracraft.block")).build());

    public static List<Item> ULTRAMAN= new ArrayList<Item>();
    
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
