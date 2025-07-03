package mod.ckenja.tofucreate.block;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.ShaftBlock;
import mod.ckenja.tofucreate.register.ModAllBlockEntityTypes;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class TofuShaftBlock extends ShaftBlock {
    public TofuShaftBlock(Properties properties) {
        super(properties);
    }

    public static TofuCogWheelBlock small(Properties properties) {
        return new TofuCogWheelBlock(false, properties);
    }

    public static TofuCogWheelBlock large(Properties properties) {
        return new TofuCogWheelBlock(true, properties);
    }


    @Override
    public BlockEntityType<? extends KineticBlockEntity> getBlockEntityType() {
        return ModAllBlockEntityTypes.BRACKETED_KINETIC.get();
    }
}
