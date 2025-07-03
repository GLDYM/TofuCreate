package mod.ckenja.tofucreate.register;

import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockModel;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import mod.ckenja.tofucreate.TofuCreate;
import mod.ckenja.tofucreate.block.TofuCogWheelBlock;
import mod.ckenja.tofucreate.block.TofuCogwheelBlockItem;
import mod.ckenja.tofucreate.block.TofuShaftBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public class ModAllBlocks {
    public static final BlockEntry<TofuShaftBlock> TOFU_METAL_SHAFT = TofuCreate.registrate.block("tofu_metal_shaft", TofuShaftBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.mapColor(MapColor.METAL).forceSolidOff())
            .transform(pickaxeOnly())
            .blockstate(BlockStateGen.axisBlockProvider(false))
            .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
            .item()
            .build()
            .register();

    public static final BlockEntry<TofuCogWheelBlock> TOFU_COGWHEEL = TofuCreate.registrate.block("tofu_cogwheel", TofuCogWheelBlock::small)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.sound(SoundType.WOOD)
                    .mapColor(MapColor.DIRT))
            .transform(axeOrPickaxe())
            .blockstate(BlockStateGen.axisBlockProvider(false))
            .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
            .item(TofuCogwheelBlockItem::new)
            .build()
            .register();

    public static final BlockEntry<TofuCogWheelBlock> TOFU_LARGE_COGWHEEL =
            TofuCreate.registrate.block("tofu_large_cogwheel", TofuCogWheelBlock::large)
                    .initialProperties(SharedProperties::stone)
                    .properties(p -> p.sound(SoundType.WOOD)
                            .mapColor(MapColor.DIRT))
                    .transform(axeOrPickaxe())
                    .blockstate(BlockStateGen.axisBlockProvider(false))
                    .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                    .item(TofuCogwheelBlockItem::new)
                    .build()
                    .register();

    public static void register() {
    }

}