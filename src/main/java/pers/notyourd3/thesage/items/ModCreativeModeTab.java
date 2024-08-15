package pers.notyourd3.thesage.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import pers.notyourd3.thesage.TheSage;

import java.util.stream.Stream;

import static pers.notyourd3.thesage.blocks.ModBlocks.ENTROPIUM_ORE;
import static pers.notyourd3.thesage.blocks.ModBlocks.PEDESTAL;
import static pers.notyourd3.thesage.items.ModItems.*;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheSage.MODID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RANDOMTAB = CREATIVE_MODE_TABS.register("thesage_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativemodetab.thesage")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ENTROPIUM_INGOT.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.acceptAll(Stream.of(
                        ENTROPIUM_INGOT,
                        TEST_ITEM
                ).map(sup -> sup.get().getDefaultInstance()).toList());
                output.accept(ENTROPIUM_ORE);
                output.accept(PEDESTAL);
            }).build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
