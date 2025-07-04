package mod.ckenja.tofucreate.client;

import mod.ckenja.tofucreate.TofuCreate;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@EventBusSubscriber(modid = TofuCreate.MODID)
public class ClientEvents {

    @SubscribeEvent
    public static void onTickPost(ClientTickEvent.Post event) {
        YubaBeltConnectorHandler.tick();
    }

}
