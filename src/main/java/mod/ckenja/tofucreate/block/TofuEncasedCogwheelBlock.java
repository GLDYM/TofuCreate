package mod.ckenja.tofucreate.block;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.SimpleKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogwheelBlock;
import com.simibubi.create.content.schematics.requirement.ItemRequirement;
import mod.ckenja.tofucreate.register.ModAllBlockEntityTypes;
import mod.ckenja.tofucreate.register.ModAllBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.function.Supplier;

public class TofuEncasedCogwheelBlock extends EncasedCogwheelBlock {
    public TofuEncasedCogwheelBlock(Properties properties, boolean large, Supplier<Block> casing) {
        super(properties, large, casing);
    }

    @Override
    public BlockEntityType<? extends SimpleKineticBlockEntity> getBlockEntityType() {
        return isLarge ? ModAllBlockEntityTypes.ENCASED_LARGE_COGWHEEL.get() : ModAllBlockEntityTypes.ENCASED_COGWHEEL.get();
    }

    @Override
    public ItemRequirement getRequiredItems(BlockState state, BlockEntity be) {
        return ItemRequirement
                .of(isLarge ? ModAllBlocks.TOFU_LARGE_COGWHEEL.getDefaultState() : ModAllBlocks.TOFU_COGWHEEL.getDefaultState(), be);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
        if (target instanceof BlockHitResult)
            return ((BlockHitResult) target).getDirection()
                    .getAxis() != getRotationAxis(state)
                    ? isLarge ? ModAllBlocks.TOFU_LARGE_COGWHEEL.asStack() : ModAllBlocks.TOFU_COGWHEEL.asStack()
                    : getCasing().asItem().getDefaultInstance();
        return super.getCloneItemStack(state, target, world, pos, player);
    }

    @Override
    public InteractionResult onSneakWrenched(BlockState state, UseOnContext context) {
        if (context.getLevel().isClientSide)
            return InteractionResult.SUCCESS;
        context.getLevel()
                .levelEvent(2001, context.getClickedPos(), Block.getId(state));
        KineticBlockEntity.switchToBlockState(context.getLevel(), context.getClickedPos(),
                (isLarge ? ModAllBlocks.TOFU_LARGE_COGWHEEL : ModAllBlocks.TOFU_COGWHEEL).getDefaultState()
                        .setValue(AXIS, state.getValue(AXIS)));
        return InteractionResult.SUCCESS;
    }
}
