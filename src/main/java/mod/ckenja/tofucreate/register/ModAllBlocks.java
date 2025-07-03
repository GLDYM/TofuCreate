package mod.ckenja.tofucreate.register;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.content.decoration.encasing.EncasedCTBehaviour;
import com.simibubi.create.content.decoration.encasing.EncasingRegistry;
import com.simibubi.create.content.kinetics.base.RotatedPillarKineticBlock;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockModel;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogCTBehaviour;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedShaftBlock;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.data.*;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import mod.ckenja.tofucreate.TofuCreate;
import mod.ckenja.tofucreate.block.*;
import mod.ckenja.tofucreate.client.ModAllSpriteShifts;
import mod.ckenja.tofucreate.config.TCStress;
import net.createmod.catnip.data.Couple;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

import static com.simibubi.create.foundation.data.BlockStateGen.axisBlock;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public class ModAllBlocks {
    public static final BlockEntry<TofuShaftBlock> TOFU_METAL_SHAFT = TofuCreate.registrate.block("tofu_metal_shaft", TofuShaftBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.mapColor(MapColor.METAL).forceSolidOff())
            .transform(pickaxeOnly())
            .transform(TCStress.setNoImpact())
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
            .transform(TCStress.setImpact(0.1F))
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
                    .transform(TCStress.setImpact(0.1F))
                    .blockstate(BlockStateGen.axisBlockProvider(false))
                    .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                    .item(TofuCogwheelBlockItem::new)
                    .build()
                    .register();
    public static final BlockEntry<CasingBlock> TOFU_METAL_CASING = TofuCreate.registrate.block("tofu_metal_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_WHITE))
            .transform(BuilderTransformers.casing(() -> ModAllSpriteShifts.TOFU_METAL_CASING))
            .register();

    public static final BlockEntry<TofuGearboxBlock> TOFU_GEARBOX = TofuCreate.registrate.block("tofu_gearbox", TofuGearboxBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.noOcclusion()
                    .mapColor(MapColor.PODZOL))
            .transform(axeOrPickaxe())
            .transform(TCStress.setImpact(0.1F))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(ModAllSpriteShifts.TOFU_METAL_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, ModAllSpriteShifts.TOFU_METAL_CASING,
                    (s, f) -> f.getAxis() == s.getValue(TofuGearboxBlock.AXIS))))
            .blockstate((c, p) -> axisBlock(c, p, $ -> AssetLookup.partialBaseModel(c, p), true))
            .item()
            .transform(customItemModel())
            .register();

    public static final BlockEntry<TofuEncasedShaftBlock> TOFU_ENCASED_SHAFT =
            TofuCreate.registrate.block("tofu_encased_shaft", p -> new TofuEncasedShaftBlock(p, ModAllBlocks.TOFU_METAL_CASING::get))
                    .properties(p -> p.mapColor(MapColor.PODZOL))
                    .transform(encasedShaft("tofu", () -> ModAllSpriteShifts.TOFU_METAL_CASING))
                    .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
                    .transform(axeOrPickaxe())
                    .register();

    public static final BlockEntry<TofuEncasedCogwheelBlock> TOFU_ENCASED_COGWHEEL = TofuCreate.registrate
            .block("tofu_encased_cogwheel", p -> new TofuEncasedCogwheelBlock(p, false, ModAllBlocks.TOFU_METAL_CASING::get))
            .properties(p -> p.mapColor(MapColor.PODZOL))
            .transform(encasedCogwheel("tofu", () -> ModAllSpriteShifts.TOFU_METAL_CASING))
            .transform(EncasingRegistry.addVariantTo(ModAllBlocks.TOFU_COGWHEEL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(ModAllSpriteShifts.TOFU_METAL_CASING,
                    Couple.create(ModAllSpriteShifts.TOFU_ENCASED_COGWHEEL_SIDE,
                            ModAllSpriteShifts.TOFU_ENCASED_COGWHEEL_OTHERSIDE))))
            .transform(axeOrPickaxe())
            .register();
    public static final BlockEntry<TofuEncasedCogwheelBlock> TOFU_ENCASED_LARGE_COGWHEEL = TofuCreate.registrate
            .block("tofu_encased_large_cogwheel",
                    p -> new TofuEncasedCogwheelBlock(p, true, ModAllBlocks.TOFU_METAL_CASING::get))
            .properties(p -> p.mapColor(MapColor.PODZOL))
            .transform(encasedLargeCogwheel("tofu", () -> ModAllSpriteShifts.TOFU_METAL_CASING))
            .transform(EncasingRegistry.addVariantTo(ModAllBlocks.TOFU_LARGE_COGWHEEL))
            .transform(axeOrPickaxe())
            .register();

    public static <B extends EncasedShaftBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> encasedShaft(String casing,
                                                                                                         Supplier<CTSpriteShiftEntry> casingShift) {
        return builder -> encasedBase(builder, () -> ModAllBlocks.TOFU_METAL_SHAFT.get())
                .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(casingShift.get())))
                .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, casingShift.get(),
                        (s, f) -> f.getAxis() != s.getValue(EncasedShaftBlock.AXIS))))
                .blockstate((c, p) -> axisBlock(c, p, blockState -> p.models()
                        .getExistingFile(p.modLoc("block/encased_shaft/block_" + casing)), true))
                .transform(TCStress.setNoImpact());
    }

    public static <B extends TofuEncasedCogwheelBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> encasedCogwheel(
            String casing, Supplier<CTSpriteShiftEntry> casingShift) {
        return b -> encasedCogwheelBase(b, casing, casingShift, () -> ModAllBlocks.TOFU_COGWHEEL.get(), false);
    }

    public static <B extends TofuEncasedCogwheelBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> encasedLargeCogwheel(
            String casing, Supplier<CTSpriteShiftEntry> casingShift) {
        return b -> encasedCogwheelBase(b, casing, casingShift, () -> ModAllBlocks.TOFU_LARGE_COGWHEEL.get(), true)
                .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(casingShift.get())));
    }

    private static <B extends TofuEncasedCogwheelBlock, P> BlockBuilder<B, P> encasedCogwheelBase(BlockBuilder<B, P> b,
                                                                                                  String casing, Supplier<CTSpriteShiftEntry> casingShift, Supplier<ItemLike> drop, boolean large) {
        return encasedBase(b, drop)
                .transform(TCStress.setImpact(0.1F));
    }

    private static <B extends RotatedPillarKineticBlock, P> BlockBuilder<B, P> encasedBase(BlockBuilder<B, P> b,
                                                                                           Supplier<ItemLike> drop) {
        return b.initialProperties(SharedProperties::stone)
                .properties(BlockBehaviour.Properties::noOcclusion)
                .loot((p, lb) -> p.dropOther(lb, drop.get()));
    }


    public static void register() {
    }

}