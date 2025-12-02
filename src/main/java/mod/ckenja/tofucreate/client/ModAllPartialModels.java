package mod.ckenja.tofucreate.client;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import mod.ckenja.tofucreate.TofuCreate;

public class ModAllPartialModels {
    public static final PartialModel SHAFTLESS_COGWHEEL = block("tofu_cogwheel_shaftless"), SHAFTLESS_LARGE_COGWHEEL = block("tofu_large_cogwheel_shaftless"),
            COGWHEEL_SHAFT = block("tofu_cogwheel_shaft"), SHAFT_HALF = block("tofu_metal_shaft_half"),
            SHAFT = block("tofu_metal_shaft"),
            COGWHEEL = block("tofu_cogwheel"),
            WATER_WHEEL = block("water_wheel/wheel"), LARGE_WATER_WHEEL = block("large_water_wheel/block"),
            LARGE_WATER_WHEEL_EXTENSION = block("large_water_wheel/block_extension"),
            BELT_PULLEY = block("yuba_pulley"), BELT_START = block("yuba/start"), BELT_MIDDLE = block("yuba/middle"),
            BELT_END = block("yuba/end"), BELT_START_BOTTOM = block("yuba/start_bottom"),
            BELT_MIDDLE_BOTTOM = block("yuba/middle_bottom"), BELT_END_BOTTOM = block("yuba/end_bottom"),
            BELT_DIAGONAL_START = block("yuba/diagonal_start"), BELT_DIAGONAL_MIDDLE = block("yuba/diagonal_middle"),
            BELT_DIAGONAL_END = block("yuba/diagonal_end");


    private static PartialModel block(String path) {
        return PartialModel.of(TofuCreate.prefix("block/" + path));
    }

    public static void init() {
    }
}
