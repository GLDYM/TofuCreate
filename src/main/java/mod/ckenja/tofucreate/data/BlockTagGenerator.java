package mod.ckenja.tofucreate.data;

import mod.ckenja.tofucreate.TofuCreate;
import mod.ckenja.tofucreate.register.ModAllBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends BlockTagsProvider {
    public BlockTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper exFileHelper) {
        super(packOutput, lookupProvider, TofuCreate.MODID, exFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModAllBlocks.TOFU_METAL_SHAFT.get()).add(ModAllBlocks.TOFU_METAL_CASING.get()).add(ModAllBlocks.TOFU_GEARBOX.get()).add(ModAllBlocks.TOFU_COGWHEEL.get()).add(ModAllBlocks.TOFU_LARGE_COGWHEEL.get())
                .add(ModAllBlocks.TOFU_ENCASED_SHAFT.get())
                .add(ModAllBlocks.TOFU_ENCASED_COGWHEEL.get())
                .add(ModAllBlocks.TOFU_ENCASED_LARGE_COGWHEEL.get())
        ;
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModAllBlocks.TOFU_METAL_CASING.get()).add(ModAllBlocks.TOFU_GEARBOX.get()).add(ModAllBlocks.TOFU_COGWHEEL.get()).add(ModAllBlocks.TOFU_LARGE_COGWHEEL.get())
                .add(ModAllBlocks.TOFU_ENCASED_SHAFT.get())
                .add(ModAllBlocks.TOFU_ENCASED_COGWHEEL.get())
                .add(ModAllBlocks.TOFU_ENCASED_LARGE_COGWHEEL.get());

    }
}
