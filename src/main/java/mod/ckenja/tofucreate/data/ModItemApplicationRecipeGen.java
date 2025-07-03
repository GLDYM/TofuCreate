package mod.ckenja.tofucreate.data;

import baguchan.tofucraft.registry.TofuItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import mod.ckenja.tofucreate.TofuCreate;
import mod.ckenja.tofucreate.register.ModAllBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ModItemApplicationRecipeGen extends ProcessingRecipeGen {


    GeneratedRecipe TOFU_METAL = woodCasing("tofu_metal", () -> TofuItems.TOFUMETAL.get(), () -> ModAllBlocks.TOFU_METAL_CASING.asItem());

    protected GeneratedRecipe woodCasing(String type, Supplier<ItemLike> ingredient, Supplier<ItemLike> output) {
        return woodCasingIngredient(type, () -> Ingredient.of(ingredient.get()), output);
    }

    protected GeneratedRecipe woodCasingTag(String type, Supplier<TagKey<Item>> ingredient, Supplier<ItemLike> output) {
        return woodCasingIngredient(type, () -> Ingredient.of(ingredient.get()), output);
    }

    protected GeneratedRecipe woodCasingIngredient(String type, Supplier<Ingredient> ingredient,
                                                   Supplier<ItemLike> output) {
        create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, type + "_casing_from_log"), b -> b.require(Tags.Items.STRIPPED_LOGS)
                .require(ingredient.get())
                .output(output.get()));
        return create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, type + "_casing_from_wood"), b -> b.require(Tags.Items.STRIPPED_WOODS)
                .require(ingredient.get())
                .output(output.get()));
    }

    public ModItemApplicationRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.ITEM_APPLICATION;
    }

}
