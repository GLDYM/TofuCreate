package mod.ckenja.tofucreate.data;

import baguchan.tofucraft.registry.TofuItems;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe;
import com.simibubi.create.content.kinetics.press.PressingRecipe;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyRecipeBuilder;
import com.simibubi.create.api.data.recipe.SequencedAssemblyRecipeGen;
import mod.ckenja.tofucreate.TofuCreate;
import mod.ckenja.tofucreate.register.ModAllItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

import java.util.function.UnaryOperator;

public class ModSequencedAssemblyRecipeGen extends SequencedAssemblyRecipeGen {

    GeneratedRecipe

            PRECISION_MECHANISM = create("tofu_precision_mechanism", b -> b.require(ModAllItems.TOFU_METAL_PLATE.get())
            .transitionTo(ModAllItems.INCOMPLETE_TOFU_PRECISION_MECHANISM.get())
            .addOutput(ModAllItems.TOFU_PRECISION_MECHANISM.get(), 120)
            .addOutput(ModAllItems.TOFU_METAL_PLATE.get(), 8)
            .addOutput(Items.REDSTONE, 2)
            .loops(2)
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(TofuItems.TOFUGEM.get()))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(Items.REDSTONE))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(ModAllItems.TF_COMPACT_CIRCUIT.get())));

    GeneratedRecipe

            TF_COMPACT_CIRCUIT = create("tf_compact_circuit", b -> b.require(TofuItems.TOFUISHI.get())
            .transitionTo(ModAllItems.INCOMPLETE_TF_COMPACT_CIRCUIT.get())
            .addOutput(ModAllItems.TF_COMPACT_CIRCUIT.get(), 120)
            .addOutput(TofuItems.TOFUISHI.get(), 5)
            .addOutput(Items.REDSTONE, 5)
            .loops(1)
            .addStep(PressingRecipe::new, rb -> rb)
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(Items.REDSTONE))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.ELECTRON_TUBE)));


    public ModSequencedAssemblyRecipeGen(PackOutput output) {
        super(output, TofuCreate.MODID);
    }

    protected GeneratedRecipe create(String name, UnaryOperator<SequencedAssemblyRecipeBuilder> transform) {
        GeneratedRecipe generatedRecipe =
                c -> transform.apply(new SequencedAssemblyRecipeBuilder(TofuCreate.prefix(name)))
                        .build(c);
        all.add(generatedRecipe);
        return generatedRecipe;
    }

}