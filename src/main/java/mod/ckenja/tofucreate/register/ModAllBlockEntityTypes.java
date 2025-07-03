package mod.ckenja.tofucreate.register;

import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntityRenderer;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import mod.ckenja.tofucreate.TofuCreate;
import mod.ckenja.tofucreate.client.visual.TofuBracketedKineticBlockEntityVisual;

public class ModAllBlockEntityTypes {


    public static final BlockEntityEntry<BracketedKineticBlockEntity> BRACKETED_KINETIC = TofuCreate.registrate
            .blockEntity("simple_kinetic", BracketedKineticBlockEntity::new)
            .visual(() -> TofuBracketedKineticBlockEntityVisual::create, false)
            .validBlocks(ModAllBlocks.TOFU_METAL_SHAFT, ModAllBlocks.TOFU_COGWHEEL, ModAllBlocks.TOFU_LARGE_COGWHEEL)
            .renderer(() -> BracketedKineticBlockEntityRenderer::new)
            .register();

    public static void register() {
    }

}
