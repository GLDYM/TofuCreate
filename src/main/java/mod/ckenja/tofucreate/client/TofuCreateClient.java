package mod.ckenja.tofucreate.client;

import mod.ckenja.tofucreate.TofuCreate;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.event.TickEvent.ClientTickEvent;

@Mod.EventBusSubscriber(modid = TofuCreate.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TofuCreateClient {

    @SubscribeEvent
    public static void clientInit(final FMLClientSetupEvent event) {
        ModAllSpriteShifts.init();
        ModAllPartialModels.init();
    }

}
