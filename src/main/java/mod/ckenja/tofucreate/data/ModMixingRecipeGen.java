package mod.ckenja.tofucreate.data;

import baguchan.tofucraft.registry.TofuFluids;
import baguchan.tofucraft.registry.TofuItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import mod.ckenja.tofucreate.TofuCreate;
import mod.ckenja.tofucreate.register.AllFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModMixingRecipeGen extends ProcessingRecipeGen {

    GeneratedRecipe

            SOYMILK = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "soymilk"), b -> b
            .require(TofuItems.SEEDS_SOYBEANS.get())
            .output(TofuFluids.SOYMILK.get(), 1000)),
            SOYMILK_HELL = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "soymilk_hell"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS_NETHER.get())
                    .output(TofuFluids.SOYMILK_HELL.get(), 1000)),
            SOYMILK_SOUL = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "soymilk_soul"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS_SOUL.get())
                    .output(TofuFluids.SOYMILK_SOUL.get(), 1000)),
            SOYMILK_APPLE = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "soymilk_apple"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(Items.APPLE)
                    .output(AllFluids.SOYMILK_APPLE.get(), 1000)),
            SOYMILK_COCOA = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "soymilk_cocoa"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(Items.COCOA_BEANS)
                    .output(AllFluids.SOYMILK_COCOA.get(), 1000)),
            SOYMILK_HONEY_WITH_BLOCK = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "soymilk_honey_with_block"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(Items.HONEY_BLOCK)
                    .output(AllFluids.SOYMILK_HONEY.get(), 5000)),
            SOYMILK_HONEY = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "soymilk_honey"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(Items.HONEY_BOTTLE)
                    .output(AllFluids.SOYMILK_HONEY.get(), 1250)),
            SOYMILK_HONEY_FLUID = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "soymilk_honey_fluid"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(com.simibubi.create.AllFluids.HONEY.get(), 250)
                    .output(AllFluids.SOYMILK_HONEY.get(), 1250)),
            SOYMILK_PUMPKIN = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "soymilk_pumpkin"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(Items.PUMPKIN)
                    .output(AllFluids.SOYMILK_PUMPKIN.get(), 1000)),
            SOYMILK_PUDDING = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "soymilk_pudding"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(Items.EGG)
                    .require(Items.SUGAR)
                    .output(AllFluids.SOYMILK_PUDDING.get(), 1000)),
            SOYMILK_KINAKO = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "soymilk_kinako"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(TofuItems.KINAKO.get())
                    .output(AllFluids.SOYMILK_KINAKO.get(), 1000)),
            SOYMILK_ANNIN = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "soymilk_annin"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(TofuItems.KYONINSO.get())
                    .require(TofuItems.KYONINSO.get())
                    .output(AllFluids.SOYMILK_ANNIN.get(), 1000)),
            SOYMILK_RAMUNE = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "soymilk_ramune"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(Items.SUGAR)
                    .require(Items.LIGHT_BLUE_DYE)
                    .output(AllFluids.SOYMILK_RAMUNE.get(), 1000)),
            SOYMILK_SAKURA = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "soymilk_sakura"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(Items.CHERRY_LEAVES)
                    .require(Items.SUGAR)
                    .output(AllFluids.SOYMILK_SAKURA.get(), 1000)),
            SOYMILK_TEA = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "soymilk_tea"), b -> b
                    .require(TofuItems.SEEDS_SOYBEANS.get())
                    .require(com.simibubi.create.AllFluids.TEA.get(), 250)
                    .output(AllFluids.SOYMILK_TEA.get(), 1250));


    GeneratedRecipe
            EXTRA_SOYMILK_APPLE = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "extra_soymilk_apple"), b -> b
            .require(TofuFluids.SOYMILK.get(), 1000)
            .require(Items.APPLE)
            .output(AllFluids.SOYMILK_APPLE.get(), 1000)),
            EXTRA_SOYMILK_COCOA = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "extra_soymilk_cocoa"), b -> b
                    .require(TofuFluids.SOYMILK.get(), 1000)
                    .require(Items.COCOA_BEANS)
                    .output(AllFluids.SOYMILK_COCOA.get(), 1000)),
            EXTRA_SOYMILK_HONEY_FLUID = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "extra_soymilk_honey_fluid"), b -> b
                    .require(TofuFluids.SOYMILK.get(), 1000)
                    .require(com.simibubi.create.AllFluids.HONEY.get(), 250)
                    .output(AllFluids.SOYMILK_HONEY.get(), 1250)),
            EXTRA_SOYMILK_PUMPKIN = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "extra_soymilk_pumpkin"), b -> b
                    .require(TofuFluids.SOYMILK.get(), 1000)
                    .require(Items.PUMPKIN)
                    .output(AllFluids.SOYMILK_PUMPKIN.get(), 1000)),
            EXTRA_SOYMILK_PUDDING = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "extra_soymilk_pudding"), b -> b
                    .require(TofuFluids.SOYMILK.get(), 1000)
                    .require(Items.EGG)
                    .require(Items.SUGAR)
                    .output(AllFluids.SOYMILK_PUDDING.get(), 1000)),
            EXTRA_SOYMILK_KINAKO = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "extra_soymilk_kinako"), b -> b
                    .require(TofuFluids.SOYMILK.get(), 1000)
                    .require(TofuItems.KINAKO.get())
                    .output(AllFluids.SOYMILK_KINAKO.get(), 1000)),
            EXTRA_SOYMILK_ANNIN = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "extra_soymilk_annin"), b -> b
                    .require(TofuFluids.SOYMILK.get(), 1000)
                    .require(TofuItems.KYONINSO.get())
                    .require(TofuItems.KYONINSO.get())
                    .output(AllFluids.SOYMILK_ANNIN.get(), 1000)),
            EXTRA_SOYMILK_RAMUNE = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "extra_soymilk_ramune"), b -> b
                    .require(TofuFluids.SOYMILK.get(), 1000)
                    .require(Items.SUGAR)
                    .require(Items.LIGHT_BLUE_DYE)
                    .output(AllFluids.SOYMILK_RAMUNE.get(), 1000)),
            EXTRA_SOYMILK_SAKURA = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "extra_soymilk_sakura"), b -> b
                    .require(TofuFluids.SOYMILK.get(), 1000)
                    .require(Items.SUGAR)
                    .require(Items.CHERRY_LEAVES)
                    .output(AllFluids.SOYMILK_SAKURA.get(), 1000)),
            EXTRA_SOYMILK_TEA = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "extra_soymilk_tea"), b -> b
                    .require(TofuFluids.SOYMILK.get(), 1000)
                    .require(com.simibubi.create.AllFluids.TEA.get(), 250)
                    .output(AllFluids.SOYMILK_TEA.get(), 1250));




    public ModMixingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.MIXING;
    }

}