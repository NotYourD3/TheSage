package pers.kathelotus.thesage.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import pers.kathelotus.thesage.blocks.entity.custom.PedestalEntity;

public class Pedestal extends BaseEntityBlock {
    private static final VoxelShape SHAPE = makeShape();
    public Pedestal() {
        super(Properties.ofFullCopy(Blocks.STONE));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new PedestalEntity(blockPos,blockState);
    }
    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
        return SHAPE;
    }
    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
            var tile = level.getBlockEntity(pos);
            if (tile instanceof PedestalEntity pedestal) {
                var inventory = pedestal.getItemHandler();
                var input = inventory.getStackInSlot(0);
                if (input.isEmpty() && !stack.isEmpty()) {
                    inventory.setStackInSlot(0, stack.copyWithCount(1));
                    player.setItemInHand(hand, stack.consumeAndReturn(stack.getCount() - 1, null));
                    level.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
                } else if (stack.isEmpty()) {
                    inventory.setStackInSlot(0, ItemStack.EMPTY);
                    var item = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), input);
                    item.setNoPickUpDelay();
                    level.addFreshEntity(item);
                }
                pedestal.setChanged();
            }
        return ItemInteractionResult.SUCCESS;
    }

    public static VoxelShape makeShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0, 0, 0, 1, 0.125, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.6875, 0, 1, 0.8125, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 0.125, 0.125, 0.875, 0.6875, 0.875), BooleanOp.OR);

        return shape;
    }


}
