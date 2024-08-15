package pers.notyourd3.thesage.blocks.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import pers.notyourd3.thesage.blocks.entity.custom.PedestalEntity;

public class PedestalRenderer implements BlockEntityRenderer<PedestalEntity> {
    public PedestalRenderer(BlockEntityRendererProvider.Context pContext){

    }

    @Override
    public void render(PedestalEntity pBlockEntity, float v, PoseStack  pPoseStack ,MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        ItemStack stack = pBlockEntity.getStack();
        Level level = pBlockEntity.getLevel();
        long gametime = level != null ? level.getGameTime() : 0;
        float rotation = gametime % 360;
        if(!stack.isEmpty()){
        pPoseStack.pushPose();
        pPoseStack.translate(0.5,1.2,0.5);
        pPoseStack.mulPose(Axis.YP.rotationDegrees(rotation));
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        BakedModel bakedModel = itemRenderer.getModel(stack,level,null,0);
        itemRenderer.render(stack, ItemDisplayContext.FIXED,true,pPoseStack,pBuffer,pPackedLight,pPackedOverlay,bakedModel);
        pPoseStack.popPose();
        }
    }
}
