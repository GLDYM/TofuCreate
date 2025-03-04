package mod.ckenja.tofucreate.data;

import baguchan.tofucraft.registry.TofuItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import mod.ckenja.tofucreate.TofuCreate;
import mod.ckenja.tofucreate.register.ModAllItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

import java.util.concurrent.CompletableFuture;

public class ModPressingRecipeGen extends ProcessingRecipeGen {

    GeneratedRecipe TOFU_METAL = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "tofu_metal"), b -> b.require(TofuItems.TOFUMETAL.get())
            .output(ModAllItems.TOFU_METAL_PLATE.get()));

    public ModPressingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.PRESSING;
    }

}