package pers.kathelotus.thesage.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import pers.kathelotus.thesage.TheSage;
import pers.kathelotus.thesage.blocks.entity.custom.AltarEntity;
import pers.kathelotus.thesage.items.ModItems;

import java.util.Objects;

@EventBusSubscriber(modid = TheSage.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (!event.getEntity().level().isClientSide()) {
            var entity = event.getEntity();
            if (Objects.requireNonNull(Objects.requireNonNull(event.getSource().getEntity()).getWeaponItem()).is(ModItems.CEREMONIAL_DAGGER)) {
                var be = entity.level().getBlockEntity(entity.getOnPos());
                if (be instanceof AltarEntity altar) {
                    altar.woCao();
                }
            }
        }
    }
}
