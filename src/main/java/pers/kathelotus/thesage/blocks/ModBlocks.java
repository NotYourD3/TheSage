package pers.kathelotus.thesage.blocks;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import pers.kathelotus.thesage.blocks.custom.Altar;
import pers.kathelotus.thesage.blocks.custom.Pedestal;
import pers.kathelotus.thesage.items.ModItems;

import java.util.function.Supplier;

import static pers.kathelotus.thesage.TheSage.MODID;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredBlock<Block> ENTROPIUM_ORE = registerBlock("entropium_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,6),
                    BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> PEDESTAL = registerBlock("pedestal", Pedestal::new);
    public static final DeferredBlock<Block> ALTAR = registerBlock("altar", Altar::new);

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }
    private static <T extends Block> DeferredItem<BlockItem> registerBlockItem(String name, DeferredBlock<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
