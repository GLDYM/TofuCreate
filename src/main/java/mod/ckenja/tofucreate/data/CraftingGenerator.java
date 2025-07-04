package mod.ckenja.tofucreate.data;

import baguchan.tofucraft.registry.TofuBlocks;
import baguchan.tofucraft.registry.TofuItems;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe;
import com.simibubi.create.content.kinetics.press.PressingRecipe;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyRecipeBuilder;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import mod.ckenja.tofucreate.TofuCreate;
import mod.ckenja.tofucreate.register.ModAllBlocks;
import mod.ckenja.tofucreate.register.ModAllItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class CraftingGenerator extends CreateRecipeProvider {

    CreateRecipeProvider.GeneratedRecipe

            PRECISION_MECHANISM = create("tofu_precision_mechanism", b -> b.require(ModAllItems.TOFU_METAL_PLATE.get())
            .transitionTo(ModAllItems.INCOMPLETE_TOFU_PRECISION_MECHANISM.get())
            .addOutput(ModAllItems.TOFU_PRECISION_MECHANISM.get(), 120)
            .addOutput(ModAllItems.TOFU_METAL_PLATE.get(), 8)
            .addOutput(Items.REDSTONE, 2)
            .loops(2)
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(TofuItems.TOFUGEM.get()))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(Items.REDSTONE))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(ModAllItems.TF_COMPACT_CIRCUIT.get())));

    CreateRecipeProvider.GeneratedRecipe

            TF_COMPACT_CIRCUIT = create("tf_compact_circuit", b -> b.require(TofuItems.TOFUISHI.get())
            .transitionTo(ModAllItems.INCOMPLETE_TF_COMPACT_CIRCUIT.get())
            .addOutput(ModAllItems.TF_COMPACT_CIRCUIT.get(), 120)
            .addOutput(TofuItems.TOFUISHI.get(), 5)
            .addOutput(Items.REDSTONE, 5)
            .loops(1)
            .addStep(PressingRecipe::new, rb -> rb)
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(Items.REDSTONE))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.ELECTRON_TUBE)));


    public CraftingGenerator(PackOutput p_248933_, CompletableFuture<HolderLookup.Provider> p_323846_) {
        super(p_248933_, p_323846_);
    }


    @Override
    protected void buildRecipes(RecipeOutput consumer) {
        super.buildRecipes(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModAllBlocks.TOFU_METAL_SHAFT.get(), 4)
                .pattern("M")
                .pattern("M")
                .define('M', TofuItems.TOFUMETAL.get())
                .unlockedBy("has_item", has(TofuItems.TOFUMETAL.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TRANSPORTATION, ModAllBlocks.TOFU_COGWHEEL.get(), 1)
                .requires(ModAllBlocks.TOFU_METAL_SHAFT.get())
                .requires(ItemTags.PLANKS)
                .unlockedBy("has_item", has(ModAllBlocks.TOFU_METAL_SHAFT.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TRANSPORTATION, ModAllBlocks.TOFU_LARGE_COGWHEEL.get(), 1)
                .requires(ModAllBlocks.TOFU_COGWHEEL.get())
                .requires(ItemTags.PLANKS)
                .unlockedBy("has_item", has(ModAllBlocks.TOFU_COGWHEEL.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModAllBlocks.TOFU_WATER_WHEEL, 1)
                .pattern("SSS")
                .pattern("SMS")
                .pattern("SSS")
                .define('M', ModAllBlocks.TOFU_LARGE_COGWHEEL.get())
                .define('S', ItemTags.PLANKS)
                .unlockedBy("has_item", has(ModAllBlocks.TOFU_LARGE_COGWHEEL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModAllBlocks.TOFU_GEARBOX, 1)
                .pattern(" C ")
                .pattern("CMC")
                .pattern(" C ")
                .define('M', ModAllBlocks.TOFU_METAL_CASING.get())
                .define('C', ModAllBlocks.TOFU_COGWHEEL)
                .unlockedBy("has_item", has(ModAllBlocks.TOFU_METAL_CASING.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TRANSPORTATION, ModAllItems.TOFU_VERTICAL_GEARBOX.get(), 1)
                .requires(ModAllBlocks.TOFU_GEARBOX)
                .unlockedBy("has_item", has(ModAllBlocks.TOFU_GEARBOX.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TRANSPORTATION, ModAllBlocks.TOFU_GEARBOX.get(), 1)
                .requires(ModAllItems.TOFU_VERTICAL_GEARBOX)
                .unlockedBy("has_item", has(ModAllBlocks.TOFU_GEARBOX.get()))
                .save(consumer, TofuCreate.prefix("revert_tofu_gearbox"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.MILLSTONE, 1)
                .pattern("C")
                .pattern("T")
                .pattern("S")
                .define('S', TofuBlocks.TOFUSLATE)
                .define('C', ModAllBlocks.TOFU_COGWHEEL)
                .define('T', ModAllBlocks.TOFU_METAL_CASING.get())
                .unlockedBy("has_item", has(ModAllBlocks.TOFU_METAL_CASING.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.HAND_CRANK, 1)
                .pattern("PPP")
                .pattern("T  ")
                .define('T', TofuItems.TOFUMETAL.get())
                .define('P', ItemTags.PLANKS)
                .unlockedBy("has_item", has(ModAllBlocks.TOFU_METAL_CASING.get()))
                .save(consumer);
    }

    protected GeneratedRecipe create(String name, UnaryOperator<SequencedAssemblyRecipeBuilder> transform) {
        GeneratedRecipe generatedRecipe =
                c -> transform.apply(new SequencedAssemblyRecipeBuilder(TofuCreate.prefix(name)))
                        .build(c);
        all.add(generatedRecipe);
        return generatedRecipe;
    }

}