package UltraCraft.blocks;

import java.util.Random;

import UltraCraft.UltraItems;
import UltraCraft.TokuCraft_core;
import UltraCraft.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ore_block extends Block implements IHasModel
{
	public Item CRYSTAL;
	
	public ore_block(String string, Material par3Material,Item ore,int lv)
	{
		super(par3Material);
		// TODO Auto-generated constructor stub
		this.setHarvestLevel("pickaxe", lv);
		setHardness(9.9F);
		setLightLevel(0.1f);
		setTranslationKey(string);
		setRegistryName(string);
		CRYSTAL = ore;

        TokuCraft_core.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        TokuCraft_core.BLOCKS.add(this);
	}
	
	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune)
	{
		Random generator = new Random();
		
		return CRYSTAL;
	}

	public int getExpDrop(IBlockAccess world, int metadata, int fortune)
	{
		return 5;
	}

	@Override
	public void registerModels() 
	{
		TokuCraft_core.proxy.registerItemRender(Item.getItemFromBlock(this),0,"inventory");
	}
}