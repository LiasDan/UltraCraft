package com.liasdan.ultracraft.blocks.machineBlocks;


import com.liasdan.ultracraft.items.heisei.DynaItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CosmicRefiner extends MachineBlock {

    public static List<Item> COSMIC_REFINER = new ArrayList<>();

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public CosmicRefiner(Properties properties) {
        super(properties);
    }



    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53681_) {
        p_53681_.add(FACING);
    }

    public BlockState getStateforPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
    }

    private Item getKeyDrop() {
        Random generator = new Random();
        int rand = generator.nextInt(COSMIC_REFINER.size());
        return COSMIC_REFINER.get(rand);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (!level.isClientSide) {
            if (player.getItemInHand(hand).getItem() == DynaItems.NEO_FRONTIER_SPACE_DUST.get()) {
                process(player, level, pos, hand, getKeyDrop());
                return ItemInteractionResult.SUCCESS;
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public CosmicRefiner AddToTabList(List<Block> TabList) {
        TabList.add(this);
        return this;
    }
}
