package mod.ckenja.tofucreate.client;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import mod.ckenja.tofucreate.TofuCreate;

public class ModAllPartialModels {
    public static final PartialModel SHAFTLESS_COGWHEEL = block("tofu_cogwheel_shaftless"), SHAFTLESS_LARGE_COGWHEEL = block("tofu_large_cogwheel_shaftless"),
            COGWHEEL_SHAFT = block("tofu_cogwheel_shaft"), SHAFT_HALF = block("tofu_metal_shaft_half"),
            SHAFT = block("tofu_metal_shaft"),
            COGWHEEL = block("tofu_cogwheel");

    private static PartialModel block(String path) {
        return PartialModel.of(TofuCreate.prefix("block/" + path));
    }

    public static void init() {
    }
}
