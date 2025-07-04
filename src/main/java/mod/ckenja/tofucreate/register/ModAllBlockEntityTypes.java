package mod.ckenja.tofucreate.register;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.base.ShaftRenderer;
import com.simibubi.create.content.kinetics.belt.BeltBlockEntity;
import com.simibubi.create.content.kinetics.belt.BeltRenderer;
import com.simibubi.create.content.kinetics.belt.BeltVisual;
import com.simibubi.create.content.kinetics.gearbox.GearboxBlockEntity;
import com.simibubi.create.content.kinetics.gearbox.GearboxRenderer;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntityRenderer;
import com.simibubi.create.content.kinetics.simpleRelays.SimpleKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogRenderer;
import com.simibubi.create.content.kinetics.waterwheel.WaterWheelBlockEntity;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import mod.ckenja.tofucreate.TofuCreate;
import mod.ckenja.tofucreate.blockentity.YubaBeltBlockEntity;
import mod.ckenja.tofucreate.client.render.TofuWaterWheelRenderer;
import mod.ckenja.tofucreate.client.render.YubaBeltRenderer;
import mod.ckenja.tofucreate.client.visual.*;

import static com.simibubi.create.Create.REGISTRATE;

public class ModAllBlockEntityTypes {


    public static final BlockEntityEntry<BracketedKineticBlockEntity> BRACKETED_KINETIC = TofuCreate.registrate
            .blockEntity("simple_kinetic", BracketedKineticBlockEntity::new)
            .visual(() -> TofuBracketedKineticBlockEntityVisual::create, false)
            .validBlocks(ModAllBlocks.TOFU_METAL_SHAFT, ModAllBlocks.TOFU_COGWHEEL, ModAllBlocks.TOFU_LARGE_COGWHEEL)
            .renderer(() -> BracketedKineticBlockEntityRenderer::new)
            .register();
    public static final BlockEntityEntry<GearboxBlockEntity> GEARBOX = TofuCreate.registrate
            .blockEntity("gearbox", GearboxBlockEntity::new)
            .visual(() -> TofuGearboxVisual::new, false)
            .validBlocks(ModAllBlocks.TOFU_GEARBOX)
            .renderer(() -> GearboxRenderer::new)
            .register();
    public static final BlockEntityEntry<KineticBlockEntity> ENCASED_SHAFT = TofuCreate.registrate
            .blockEntity("encased_shaft", KineticBlockEntity::new)
            .visual(() -> TofuSingleAxisRotatingVisual::shaft, false)
            .validBlocks(ModAllBlocks.TOFU_ENCASED_SHAFT)
            .renderer(() -> ShaftRenderer::new)
            .register();
    public static final BlockEntityEntry<SimpleKineticBlockEntity> ENCASED_COGWHEEL = TofuCreate.registrate
            .blockEntity("encased_cogwheel", SimpleKineticBlockEntity::new)
            .visual(() -> TofuEncasedCogVisual::small, false)
            .validBlocks(ModAllBlocks.TOFU_ENCASED_COGWHEEL)
            .renderer(() -> EncasedCogRenderer::small)
            .register();

    public static final BlockEntityEntry<SimpleKineticBlockEntity> ENCASED_LARGE_COGWHEEL = TofuCreate.registrate
            .blockEntity("encased_large_cogwheel", SimpleKineticBlockEntity::new)
            .visual(() -> TofuEncasedCogVisual::large, false)
            .validBlocks(ModAllBlocks.TOFU_ENCASED_LARGE_COGWHEEL)
            .renderer(() -> EncasedCogRenderer::large)
            .register();

    public static final BlockEntityEntry<WaterWheelBlockEntity> WATER_WHEEL = TofuCreate.registrate
            .blockEntity("water_wheel", WaterWheelBlockEntity::new)
            .visual(() -> TofuWaterWheelVisual::standard, false)
            .validBlocks(ModAllBlocks.TOFU_WATER_WHEEL)
            .renderer(() -> TofuWaterWheelRenderer::standard)
            .register();
    public static final BlockEntityEntry<YubaBeltBlockEntity> BELT = TofuCreate.registrate
            .blockEntity("belt", YubaBeltBlockEntity::new)
            .visual(() -> YubaBeltVisual::new, YubaBeltBlockEntity::shouldRenderNormally)
            .validBlocks(ModAllBlocks.YUBA)
            .renderer(() -> YubaBeltRenderer::new)
            .register();


    public static void register() {
    }

}
