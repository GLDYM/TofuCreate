package mod.ckenja.tofucreate.data;

import baguchan.tofucraft.registry.TofuFluids;
import baguchan.tofucraft.registry.TofuItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import mod.ckenja.tofucreate.TofuCreate;
import mod.ckenja.tofucreate.register.ModAllFluids;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

public class ModMixingRecipeGen extends ProcessingRecipeGen {

    GeneratedRecipe

            SOYMILK = create(new ResourceLocation(TofuCreate.MODID, "soymilk"), b -> b
            .require(TofuItems.SEEDS_SOYBEANS.get())
            .output(TofuFluids.SOYMILK.get(), 1000)),
            SOYMILK_HELL = create(new ResourceLocation(TofuCreate.MODID, "soymilk_hell"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS_NETHER.get())
                    .output(TofuFluids.SOYMILK_HELL.get(), 1000)),
            SOYMILK_SOUL = create(new ResourceLocation(TofuCreate.MODID, "soymilk_soul"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS_SOUL.get())
                    .output(TofuFluids.SOYMILK_SOUL.get(), 1000)),
            SOYMILK_APPLE = create(new ResourceLocation(TofuCreate.MODID, "soymilk_apple"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(Items.APPLE)
                    .output(ModAllFluids.SOYMILK_APPLE.get(), 1000)),
            SOYMILK_COCOA = create(new ResourceLocation(TofuCreate.MODID, "soymilk_cocoa"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(Items.COCOA_BEANS)
                    .output(ModAllFluids.SOYMILK_COCOA.get(), 1000)),
            SOYMILK_HONEY = create(new ResourceLocation(TofuCreate.MODID, "soymilk_honey"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(Items.HONEY_BOTTLE)
                    .output(ModAllFluids.SOYMILK_HONEY.get(), 1250)),
            SOYMILK_HONEY_FLUID = create(new ResourceLocation(TofuCreate.MODID, "soymilk_honey_fluid"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(com.simibubi.create.AllFluids.HONEY.get(), 250)
                    .output(ModAllFluids.SOYMILK_HONEY.get(), 1250)),
            SOYMILK_PUMPKIN = create(new ResourceLocation(TofuCreate.MODID, "soymilk_pumpkin"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(Items.PUMPKIN)
                    .output(ModAllFluids.SOYMILK_PUMPKIN.get(), 1000)),
            SOYMILK_PUDDING = create(new ResourceLocation(TofuCreate.MODID, "soymilk_pudding"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(Items.EGG)
                    .require(Items.SUGAR)
                    .output(ModAllFluids.SOYMILK_PUDDING.get(), 1000)),
            SOYMILK_KINAKO = create(new ResourceLocation(TofuCreate.MODID, "soymilk_kinako"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(TofuItems.KINAKO.get())
                    .output(ModAllFluids.SOYMILK_KINAKO.get(), 1000)),
            SOYMILK_ANNIN = create(new ResourceLocation(TofuCreate.MODID, "soymilk_annin"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(TofuItems.KYONINSO.get())
                    .require(TofuItems.KYONINSO.get())
                    .output(ModAllFluids.SOYMILK_ANNIN.get(), 1000)),
            SOYMILK_RAMUNE = create(new ResourceLocation(TofuCreate.MODID, "soymilk_ramune"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(Items.SUGAR)
                    .require(Items.LIGHT_BLUE_DYE)
                    .output(ModAllFluids.SOYMILK_RAMUNE.get(), 1000)),
            SOYMILK_SAKURA = create(new ResourceLocation(TofuCreate.MODID, "soymilk_sakura"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(Items.CHERRY_LEAVES)
                    .require(Items.SUGAR)
                    .output(ModAllFluids.SOYMILK_SAKURA.get(), 1000)),
            SOYMILK_TEA = create(new ResourceLocation(TofuCreate.MODID, "soymilk_tea"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(com.simibubi.create.AllFluids.TEA.get(), 250)
                    .output(ModAllFluids.SOYMILK_TEA.get(), 1250));


    GeneratedRecipe
            EXTRA_SOYMILK_APPLE = create(new ResourceLocation(TofuCreate.MODID, "extra_soymilk_apple"), b -> b
            .require(TofuFluids.SOYMILK.get(), 1000)
            .require(Items.APPLE)
            .output(ModAllFluids.SOYMILK_APPLE.get(), 1000)),
            EXTRA_SOYMILK_COCOA = create(new ResourceLocation(TofuCreate.MODID, "extra_soymilk_cocoa"), b -> b
                    .require(TofuFluids.SOYMILK.get(), 1000)
                    .require(Items.COCOA_BEANS)
                    .output(ModAllFluids.SOYMILK_COCOA.get(), 1000)),
            EXTRA_SOYMILK_HONEY_FLUID = create(new ResourceLocation(TofuCreate.MODID, "extra_soymilk_honey_fluid"), b -> b
                    .require(TofuFluids.SOYMILK.get(), 1000)
                    .require(com.simibubi.create.AllFluids.HONEY.get(), 250)
                    .output(ModAllFluids.SOYMILK_HONEY.get(), 1250)),
            EXTRA_SOYMILK_PUMPKIN = create(new ResourceLocation(TofuCreate.MODID, "extra_soymilk_pumpkin"), b -> b
                    .require(TofuFluids.SOYMILK.get(), 1000)
                    .require(Items.PUMPKIN)
                    .output(ModAllFluids.SOYMILK_PUMPKIN.get(), 1000)),
            EXTRA_SOYMILK_PUDDING = create(new ResourceLocation(TofuCreate.MODID, "extra_soymilk_pudding"), b -> b
                    .require(TofuFluids.SOYMILK.get(), 1000)
                    .require(Items.EGG)
                    .require(Items.SUGAR)
                    .output(ModAllFluids.SOYMILK_PUDDING.get(), 1000)),
            EXTRA_SOYMILK_KINAKO = create(new ResourceLocation(TofuCreate.MODID, "extra_soymilk_kinako"), b -> b
                    .require(TofuFluids.SOYMILK.get(), 1000)
                    .require(TofuItems.KINAKO.get())
                    .output(ModAllFluids.SOYMILK_KINAKO.get(), 1000)),
            EXTRA_SOYMILK_ANNIN = create(new ResourceLocation(TofuCreate.MODID, "extra_soymilk_annin"), b -> b
                    .require(TofuFluids.SOYMILK.get(), 1000)
                    .require(TofuItems.KYONINSO.get())
                    .require(TofuItems.KYONINSO.get())
                    .output(ModAllFluids.SOYMILK_ANNIN.get(), 1000)),
            EXTRA_SOYMILK_RAMUNE = create(new ResourceLocation(TofuCreate.MODID, "extra_soymilk_ramune"), b -> b
                    .require(TofuFluids.SOYMILK.get(), 1000)
                    .require(Items.SUGAR)
                    .require(Items.LIGHT_BLUE_DYE)
                    .output(ModAllFluids.SOYMILK_RAMUNE.get(), 1000)),
            EXTRA_SOYMILK_SAKURA = create(new ResourceLocation(TofuCreate.MODID, "extra_soymilk_sakura"), b -> (com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder<com.simibubi.create.content.processing.recipe.ProcessingRecipe<?>>) b
                    .require(TofuFluids.SOYMILK.get(), 1000)
                    .require(Items.SUGAR)
                    .require(Items.CHERRY_LEAVES)
                    .output(ModAllFluids.SOYMILK_SAKURA.get(), 1000)),
            EXTRA_SOYMILK_TEA = create(new ResourceLocation(TofuCreate.MODID, "extra_soymilk_tea"), b -> b
                    .require(TofuFluids.SOYMILK.get(), 1000)
                    .require(com.simibubi.create.AllFluids.TEA.get(), 250)
                    .output(ModAllFluids.SOYMILK_TEA.get(), 1250));


    public ModMixingRecipeGen(PackOutput output) {
        super(output);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.MIXING;
    }

}