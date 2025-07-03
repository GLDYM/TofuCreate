package mod.ckenja.tofucreate.client;

import mod.ckenja.tofucreate.TofuCreate;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = TofuCreate.MODID, bus = EventBusSubscriber.Bus.MOD)
public class TofuCreateClient {

    @SubscribeEvent
    public static void clientInit(final FMLClientSetupEvent event) {
        ModAllSpriteShifts.init();
        ModAllPartialModels.init();
    }
}
