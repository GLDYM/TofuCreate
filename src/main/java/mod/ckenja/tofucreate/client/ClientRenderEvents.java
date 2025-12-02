package mod.ckenja.tofucreate.client;

import mod.ckenja.tofucreate.TofuCreate;
import mod.ckenja.tofucreate.register.ModAllBlocks;
import mod.ckenja.tofucreate.register.ModAllBlockEntityTypes;
import mod.ckenja.tofucreate.blockentity.YubaBeltBlockEntity;
import mod.ckenja.tofucreate.client.render.YubaBeltRenderer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = TofuCreate.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRenderEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        BlockEntityRenderers.register(ModAllBlockEntityTypes.BELT.get(), YubaBeltRenderer::new);
    }
}
