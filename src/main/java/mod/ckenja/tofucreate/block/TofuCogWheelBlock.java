package mod.ckenja.tofucreate.block;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.CogWheelBlock;
import mod.ckenja.tofucreate.register.ModAllBlockEntityTypes;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class TofuCogWheelBlock extends CogWheelBlock {
    protected TofuCogWheelBlock(boolean large, Properties properties) {
        super(large, properties);
    }

    @Override
    public BlockEntityType<? extends KineticBlockEntity> getBlockEntityType() {
        return ModAllBlockEntityTypes.BRACKETED_KINETIC.get();
    }

    public static TofuCogWheelBlock small(Properties properties) {
        return new TofuCogWheelBlock(false, properties);
    }

    public static TofuCogWheelBlock large(Properties properties) {
        return new TofuCogWheelBlock(true, properties);
    }

}
