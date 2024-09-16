package pers.kathelotus.thesage.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import pers.kathelotus.thesage.blocks.ModBlocks;
import pers.kathelotus.thesage.TheSage;

import java.util.stream.Stream;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheSage.MODID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RANDOMTAB = CREATIVE_MODE_TABS.register("thesage_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativemodetab.thesage")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItems.ENTROPIUM_INGOT.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.acceptAll(Stream.of(
                        ModItems.ENTROPIUM_INGOT,
                        ModItems.CEREMONIAL_DAGGER
                ).map(sup -> sup.get().getDefaultInstance()).toList());
                output.acceptAll(Stream.of(
                        ModBlocks.ENTROPIUM_ORE,
                        ModBlocks.PEDESTAL,
                        ModBlocks.ALTAR)
                        .map(sup ->sup.get().asItem().getDefaultInstance()).toList());
            }).build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
