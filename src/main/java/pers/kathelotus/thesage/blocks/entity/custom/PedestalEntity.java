package pers.kathelotus.thesage.blocks.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.ItemStackHandler;
import pers.kathelotus.thesage.blocks.entity.ModBlockEntities;
import pers.kathelotus.thesage.TheSage;

@EventBusSubscriber(modid = TheSage.MODID, bus = EventBusSubscriber.Bus.MOD)
public class PedestalEntity extends BlockEntity {
    private final ItemStackHandler itemHandler = new ItemStackHandler(1);
    public PedestalEntity( BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.PEDESTAL_ENTITY.get(), pPos, pBlockState);
    }
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }
    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                ModBlockEntities.PEDESTAL_ENTITY.get(),
                (be, context) -> be.getItemHandler()
        );
    }
    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        CompoundTag inventory = pTag.getCompound("inventory");
        this.itemHandler.deserializeNBT(pRegistries,inventory);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.saveAdditional(pTag, pRegistries);
        pTag.put("inventory",this.itemHandler.serializeNBT(pRegistries));
    }

    public ItemStackHandler getItemHandler(){
        return this.itemHandler;
    }
    public ItemStack getStack() {
        return this.itemHandler.getStackInSlot(0);
    }

}