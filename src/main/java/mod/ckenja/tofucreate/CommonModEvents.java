package mod.ckenja.tofucreate;

import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.content.kinetics.belt.BeltBlock;
import mod.ckenja.tofucreate.blockentity.YubaBeltBlockEntity;
import mod.ckenja.tofucreate.register.ModAllBlocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CommonModEvents {
    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        YubaBeltBlockEntity.registerCapabilities(event);
    }
}
