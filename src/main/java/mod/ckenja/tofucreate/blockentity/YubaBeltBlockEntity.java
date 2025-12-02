package mod.ckenja.tofucreate.blockentity;

import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.belt.BeltBlock;
import com.simibubi.create.content.kinetics.belt.BeltBlockEntity;
import com.simibubi.create.content.kinetics.belt.BeltSlope;
import com.simibubi.create.content.kinetics.belt.transport.BeltInventory;
import com.simibubi.create.content.kinetics.belt.transport.BeltMovementHandler;
import com.simibubi.create.content.kinetics.belt.transport.ItemHandlerBeltSegment;
import mod.ckenja.tofucreate.block.YubaBeltBlock;
import mod.ckenja.tofucreate.register.ModAllBlockEntityTypes;
import mod.ckenja.tofucreate.register.ModAllBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.simibubi.create.content.kinetics.belt.BeltBlock.SLOPE;
import static com.simibubi.create.content.kinetics.belt.BeltPart.MIDDLE;
import static com.simibubi.create.content.kinetics.belt.BeltSlope.HORIZONTAL;

public class YubaBeltBlockEntity extends BeltBlockEntity {
    public YubaBeltBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public static boolean canTransportObjects(BlockState state) {
        if (!ModAllBlocks.YUBA.has(state))
            return false;
        BeltSlope slope = state.getValue(SLOPE);
        return slope != BeltSlope.VERTICAL && slope != BeltSlope.SIDEWAYS;
    }

    @Override
    public void tick() {
        // Init belt
        if (beltLength == 0)
            YubaBeltBlock.initBelt(level, worldPosition);

        super.tick();

        if (!ModAllBlocks.YUBA.has(level.getBlockState(worldPosition)))
            return;

        initializeItemHandler();

        // Move Items
        if (!isController())
            return;

        invalidateRenderBoundingBox();

        getInventory().tick();

        if (getSpeed() == 0)
            return;

        // Move Entities
        if (passengers == null)
            passengers = new HashMap<>();

        List<Entity> toRemove = new ArrayList<>();
        passengers.forEach((entity, info) -> {
            boolean canBeTransported = BeltMovementHandler.canBeTransported(entity);
            boolean leftTheBelt =
                    info.getTicksSinceLastCollision() > ((getBlockState().getValue(SLOPE) != HORIZONTAL) ? 3 : 1);
            if (!canBeTransported || leftTheBelt) {
                toRemove.add(entity);
                return;
            }

            info.tick();
            BeltMovementHandler.transportEntity(this, entity, info);
        });
        toRemove.forEach(passengers::remove);
    }

    public boolean hasPulley() {
        if (!ModAllBlocks.YUBA.has(getBlockState()))
            return false;
        return getBlockState().getValue(BeltBlock.PART) != MIDDLE;
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return itemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        itemHandler.invalidate();
    }
}
