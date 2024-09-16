package pers.kathelotus.thesage.blocks.entity.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import pers.kathelotus.thesage.blocks.ModBlocks;
import pers.kathelotus.thesage.blocks.entity.ModBlockEntities;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AltarEntity extends BlockEntity {

    private static final int[][] pos1 = {{3,0,0},{2,0,2},{0,0,3},{2,0,-2},{-3,0,0},{-2,0,-2},{0,0,-3},{-2,0,2}};

    public AltarEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.ALTAR_ENTITY.get(), pPos, pBlockState);
    }
    public void woCao(){
    if(checkStructure()){
        ArrayList<ItemStack> items = null;
        for(int[] pos : pos1){
            if(this.getLevel().getBlockEntity(new BlockPos(this.getBlockPos().offset(pos[0],pos[1],pos[2]))) instanceof PedestalEntity entity){
                items.add(entity.getStack());
                }
            }
        calculate(items);
        }

    }
    private static void causeLightning(Level level, BlockPos pos) {
        LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
        bolt.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
        bolt.setVisualOnly(false);
        level.addFreshEntity(bolt);
    }
    private boolean checkStructure(){
        boolean flag = true;
        for(int[] pos : pos1){
            BlockPos pos2 = new BlockPos(this.getBlockPos().offset(pos[0],pos[1],pos[2]));
            if (this.getLevel().getBlockState(pos2) != ModBlocks.PEDESTAL.get().defaultBlockState()){
                flag = false;
            }
        }
        return flag;
    }
    private int calculate(ArrayList<ItemStack> stack){

        return 123;
    }
}
