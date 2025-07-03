package mod.ckenja.tofucreate.client;

import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;
import mod.ckenja.tofucreate.TofuCreate;
import net.createmod.catnip.render.SpriteShiftEntry;
import net.createmod.catnip.render.SpriteShifter;

public class ModAllSpriteShifts {
    public static final CTSpriteShiftEntry TOFU_METAL_CASING = omni("tofu_metal_casing");

    public static final CTSpriteShiftEntry
            TOFU_ENCASED_COGWHEEL_SIDE = vertical("tofu_encased_cogwheel_side"),
            TOFU_ENCASED_COGWHEEL_OTHERSIDE = horizontal("tofu_encased_cogwheel_side");


    private static CTSpriteShiftEntry omni(String name) {
        return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
    }

    private static CTSpriteShiftEntry horizontal(String name) {
        return getCT(AllCTTypes.HORIZONTAL, name);
    }

    private static CTSpriteShiftEntry vertical(String name) {
        return getCT(AllCTTypes.VERTICAL, name);
    }

    //

    private static SpriteShiftEntry get(String originalLocation, String targetLocation) {
        return SpriteShifter.get(TofuCreate.prefix(originalLocation), TofuCreate.prefix(targetLocation));
    }

    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
        return CTSpriteShifter.getCT(type, TofuCreate.prefix("block/" + blockTextureName),
                TofuCreate.prefix("block/" + connectedTextureName + "_connected"));
    }

    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
        return getCT(type, blockTextureName, blockTextureName);
    }

    public static void init() {
    }
}
