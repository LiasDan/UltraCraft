package com.liasdan.ultracraft.blocks.machineBlocks;

import com.liasdan.ultracraft.blocks.machineBlocks.MachineBlock;
import com.liasdan.ultracraft.items.OtherItems;
import com.liasdan.ultracraft.items.heisei.GaiaItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;


public class SkyAltar extends MachineBlock {

	public static List<Item> SKY_ALTAR = new ArrayList<>();

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	public SkyAltar(Properties properties, VoxelShape shape) {
		super(properties);
	}

	public static VoxelShape SHAPE = Block.box(3.5,0,3.5,12.5,7,12.5);

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ePos) {
		return SHAPE;
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
	        return RenderShape.MODEL;
	    }

    public static boolean isShapeFullBlock(VoxelShape p_49917_) {
		      return false;
		   }


    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53681_) {
        p_53681_.add(FACING);
     }

     public BlockState getStateForPlacement(BlockPlaceContext p_53679_) {
        return this.defaultBlockState().setValue(FACING, p_53679_.getHorizontalDirection().getOpposite());
     }

     public PushReaction getPistonPushReaction(BlockState p_53683_) {
        return PushReaction.PUSH_ONLY;
     }

	@Override
	protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

		if (!level.isClientSide()) {
			if (player.getItemInHand(hand).getItem() == OtherItems.LAND_OF_LIGHT_FRAGMENT.get()) {
				process(player, level, pos, hand,  GaiaItems.GAIA_V1_ENERGY.get());
				return ItemInteractionResult.SUCCESS;
			}

		}
		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}



	public SkyAltar AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

}