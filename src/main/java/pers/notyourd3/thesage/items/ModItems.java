package pers.notyourd3.thesage.items;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import pers.notyourd3.thesage.items.custom.TestItem;

import static pers.notyourd3.thesage.TheSage.MODID;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredItem<Item> ENTROPIUM_INGOT = ITEMS.registerSimpleItem("entropium_ingot");
    public static final DeferredItem<Item> TEST_ITEM = ITEMS.register("test_item",TestItem::new);
    public static void register(IEventBus eventbus){
        ITEMS.register(eventbus);
    }
}
