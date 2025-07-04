package mod.ckenja.tofucreate.block;

import com.simibubi.create.content.kinetics.waterwheel.WaterWheelBlock;
import com.simibubi.create.content.kinetics.waterwheel.WaterWheelBlockEntity;
import mod.ckenja.tofucreate.register.ModAllBlockEntityTypes;
import mod.ckenja.tofucreate.register.ModAllBlocks;
import net.createmod.catnip.data.Iterate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class TofuWaterWheelBlock extends WaterWheelBlock {
    public TofuWaterWheelBlock(Properties properties) {
        super(properties);
    }


    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        for (Direction direction : Iterate.directions) {
            BlockPos neighbourPos = pos.relative(direction);
            BlockState neighbourState = worldIn.getBlockState(neighbourPos);
            if (!ModAllBlocks.TOFU_WATER_WHEEL.has(neighbourState))
                continue;
            Direction.Axis axis = state.getValue(FACING)
                    .getAxis();
            if (neighbourState.getValue(FACING)
                    .getAxis() != axis || axis != direction.getAxis())
                return false;
        }
        return true;
    }


    @Override
    public BlockEntityType<? extends WaterWheelBlockEntity> getBlockEntityType() {
        return ModAllBlockEntityTypes.WATER_WHEEL.get();
    }
}
