package pers.kathelotus.thesage.items;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import pers.kathelotus.thesage.items.custom.CeremonialDagger;

import static pers.kathelotus.thesage.TheSage.MODID;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredItem<Item> ENTROPIUM_INGOT = ITEMS.registerSimpleItem("entropium_ingot");
    public static final DeferredItem<Item> CEREMONIAL_DAGGER = ITEMS.register("ceremonial_dagger", CeremonialDagger::new);
    public static void register(IEventBus eventbus){
        ITEMS.register(eventbus);
    }
}
