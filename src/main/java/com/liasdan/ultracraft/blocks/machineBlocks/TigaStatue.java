package com.liasdan.ultracraft.blocks.machineBlocks;

import com.liasdan.ultracraft.entity.MobsCore;
import com.liasdan.ultracraft.entity.boss.DarkTigaEntity;
import com.liasdan.ultracraft.items.OtherItems;
import com.liasdan.ultracraft.items.heisei.TigaItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
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

public class TigaStatue extends MachineBlock {
    public static List<Item> TIGA_STATUE = new ArrayList<>();

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public TigaStatue(Properties properties) {super(properties);
    this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));}

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53681_) {
        p_53681_.add(FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide) {
            if (stack.is(OtherItems.LAND_OF_LIGHT_FRAGMENT.get())) {
                if (player.isCreative()) {
                    stack.shrink(1);
                }
                if (level.random.nextBoolean()) {
                    Direction direction = state.getValue(FACING);

                    DarkTigaEntity tigaDark = MobsCore.TIGA_DARK.get().create(level);
                    if (tigaDark != null) {
                        tigaDark.moveTo(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, 0.0F, 0.0F);
                        level.addFreshEntity(tigaDark);
                    }

                    level.playSound(null, pos, SoundEvents.WARDEN_EMERGE, SoundSource.BLOCKS, 1.0F, 0.8F);
                    level.destroyBlock(pos, false);

                    return ItemInteractionResult.SUCCESS;
                }
                else {
                    process(player, level, pos, hand, TigaItems.TIGA_MULTI_TYPE_ENERGY.get());
                    level.playSound(null, pos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 1.0F, 1.0F);

                    return ItemInteractionResult.SUCCESS;
                }
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public TigaStatue AddToTabList(List<Block> TabList) {
        TabList.add(this);
        return this;
    }

    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public static VoxelShape SHAPE = Block.box(2, 0, 4, 14,32, 12);

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    public static boolean isShapeFullBlock(VoxelShape p_49917_) {
        return false;
    }

    public PushReaction getPistonPushReaction(BlockState p_53683_) {
        return PushReaction.PUSH_ONLY;
    }

    public BlockState rotate(BlockState p_48722_, Rotation p_48723_) {
        return p_48722_.setValue(FACING, p_48723_.rotate(p_48722_.getValue(FACING)));
    }
}
