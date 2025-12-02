package mod.ckenja.tofucreate.client;

import mod.ckenja.tofucreate.TofuCreate;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.TickEvent.ClientTickEvent;

@Mod.EventBusSubscriber(modid = TofuCreate.MODID)
public class ClientEvents {
    @SubscribeEvent
    public static void onTickPost(ClientTickEvent event) {
        YubaBeltConnectorHandler.tick();
    }

}
