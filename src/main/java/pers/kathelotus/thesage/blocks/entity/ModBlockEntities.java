package pers.kathelotus.thesage.blocks.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import pers.kathelotus.thesage.TheSage;
import pers.kathelotus.thesage.blocks.ModBlocks;

import pers.kathelotus.thesage.blocks.entity.custom.AltarEntity;
import pers.kathelotus.thesage.blocks.entity.custom.PedestalEntity;

import java.util.function.Supplier;


public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, TheSage.MODID);

    public static final Supplier<BlockEntityType<PedestalEntity>> PEDESTAL_ENTITY =
            BLOCK_ENTITIES.register("pedestal_entity", () ->
                    BlockEntityType.Builder.of(PedestalEntity::new,
                            ModBlocks.PEDESTAL.get()).build(null));
    public static final Supplier<BlockEntityType<AltarEntity>> ALTAR_ENTITY =
            BLOCK_ENTITIES.register("altar_entity", () ->
                    BlockEntityType.Builder.of(AltarEntity::new,
                            ModBlocks.ALTAR.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
