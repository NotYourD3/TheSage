package pers.kathelotus.thesage.villagers;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import pers.kathelotus.thesage.TheSage;
import pers.kathelotus.thesage.blocks.ModBlocks;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class ModVillagers {

    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, TheSage.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(Registries.VILLAGER_PROFESSION, TheSage.MODID);


    public static final Supplier<PoiType> PEDESTAL_POI = POI_TYPES.register("pedestal_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.PEDESTAL.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final Predicate<Holder<PoiType>> IS_PEDESTAL_POI = poiTypeHolder -> poiTypeHolder.value() == PEDESTAL_POI.get();
    public static final Supplier<VillagerProfession> THE_SAGE = VILLAGER_PROFESSIONS.register("the_sage",
            () -> new VillagerProfession("the_sage",IS_PEDESTAL_POI,
                    IS_PEDESTAL_POI, ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.EVOKER_CAST_SPELL));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }

}