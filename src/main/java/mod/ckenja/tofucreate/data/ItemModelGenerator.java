package mod.ckenja.tofucreate.data;

import com.tterrag.registrate.util.entry.ItemEntry;
import mod.ckenja.tofucreate.TofuCreate;
import mod.ckenja.tofucreate.register.ModAllItems;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.loaders.ItemLayerModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

import static mod.ckenja.tofucreate.TofuCreate.prefix;

public class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, TofuCreate.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        singleTex(ModAllItems.TOFU_METAL_PLATE);
        singleTex(ModAllItems.INCOMPLETE_TF_COMPACT_CIRCUIT);
        singleTex(ModAllItems.TF_COMPACT_CIRCUIT);
        singleTex(ModAllItems.TOFU_PRECISION_MECHANISM);
        singleTex(ModAllItems.INCOMPLETE_TOFU_PRECISION_MECHANISM);
        singleTex(ModAllItems.YUBA_CONNECTOR);
    }

    private ItemModelBuilder generated(String name, ResourceLocation... layers) {
        return buildItem(name, "item/generated", 0, layers);
    }

    private ItemModelBuilder buildItem(String name, String parent, int emissivity, ResourceLocation... layers) {
        ItemModelBuilder builder = withExistingParent(name, parent);
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        if (emissivity > 0)
            builder = builder.customLoader(ItemLayerModelBuilder::begin).emissive(emissivity, emissivity, 0).renderType("minecraft:translucent", 0).end();
        return builder;
    }

    private ItemModelBuilder singleTex(DeferredItem<?> item) {
        return generated(item.getId().getPath(), prefix("item/" + item.getId().getPath()));
    }

    private ItemModelBuilder singleTex(ItemEntry<?> item) {
        return generated(item.getId().getPath(), prefix("item/" + item.getId().getPath()));
    }
}
