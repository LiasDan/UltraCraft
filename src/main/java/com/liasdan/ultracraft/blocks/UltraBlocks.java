package com.liasdan.ultracraft.blocks;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.blocks.machineBlocks.*;
import com.liasdan.ultracraft.entity.MobsCore;
import com.liasdan.ultracraft.items.*;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UltraBlocks {
	
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(UltraCraftCore.MODID);

	public static final DeferredBlock<Block> METEOR = registerBlock("meteor",
			() -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6)).AddToTabList(UltraTabs.BLOCKS));

	public static final DeferredBlock<Block> PETRIFIED_TIGA_STATUE = registerBlock("petrified_tiga_statue",
			() -> new TigaStatue(BlockBehaviour.Properties.of().noOcclusion()).AddToTabList(UltraTabs.BLOCKS));

	public static final DeferredBlock<Block> CAMEARRA_BOSS_BLOCK = registerBlock("camearra_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f), MobsCore.CAMEARRA).AddToTabList(UltraTabs.BLOCKS));

	public static final DeferredBlock<Block> COSMIC_REFINER = registerBlock("cosmic_refiner",
			() -> new CosmicRefiner(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.COW_BELL)
					.strength(5.0F,6.0F).sound(SoundType.METAL)).AddToTabList(UltraTabs.BLOCKS));

	public static final DeferredBlock<Block> SKY_ALTAR = registerBlock("sky_altar",
			() -> new SkyAltar(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.COW_BELL)
					.strength(5.0F,6.0F).dynamicShape(),Block.box(3.5,0,3.5, 12.5,7,12.5)).AddToTabList(UltraTabs.BLOCKS));

	public static final DeferredBlock<Block> OCEAN_ALTAR = registerBlock("ocean_altar",
			() -> new OceanAltar(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.COW_BELL)
					.strength(5.0F,6.0F),Block.box(3.5,0,3.5, 12.5,7,12.5)).AddToTabList(UltraTabs.BLOCKS));

	public static final DeferredBlock<Block> CHAOS_ULTRAMAN_BOSS_BLOCK = registerBlock("chaos_ultraman_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f), MobsCore.CHAOS_ULTRAMAN).AddToTabList(UltraTabs.BLOCKS));

	private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
		DeferredBlock<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}

	private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
		OtherItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}

	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}