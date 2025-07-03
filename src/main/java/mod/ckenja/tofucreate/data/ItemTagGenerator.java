package mod.ckenja.tofucreate.data;

import com.simibubi.create.AllTags;
import mod.ckenja.tofucreate.TofuCreate;
import mod.ckenja.tofucreate.register.ModAllItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends ItemTagsProvider {
    public ItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> tagLookupCompletableFuture, ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, tagLookupCompletableFuture, TofuCreate.MODID, existingFileHelper);

    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(AllTags.AllItemTags.PLATES.tag).add(ModAllItems.TOFU_METAL_PLATE.asItem());
    }
}
