package mod.ckenja.tofucreate.data;

import baguchan.tofucraft.registry.TofuFluids;
import baguchan.tofucraft.registry.TofuItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import mod.ckenja.tofucreate.TofuCreate;
import mod.ckenja.tofucreate.register.ModAllFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModEmptyingRecipeGen extends ProcessingRecipeGen {

    GeneratedRecipe
            SOYMILK_BUCKET = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_soymilk_bucket"), b -> b
            .output(TofuFluids.SOYMILK.get(), 1000).output(Items.BUCKET).require(TofuItems.BUCKET_SOYMILK.get())),
            SOYMILK_HELL_BUCKET = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_soymilk_hell_bucket"), b -> b
                    .output(TofuFluids.SOYMILK_HELL.get(), 1000).output(Items.BUCKET).require(TofuItems.BUCKET_SOYMILK_NETHER.get())),
            SOYMILK_SOUL_BUCKET = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_soymilk_soul_bucket"), b -> b
                    .output(TofuFluids.SOYMILK_SOUL.get(), 1000).output(Items.BUCKET).require(TofuItems.BUCKET_SOYMILK_SOUL.get())),
            SOYMILK = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_soymilk"), b -> b
                    .output(TofuFluids.SOYMILK.get(), 250).output(Items.GLASS_BOTTLE).require(TofuItems.SOYMILK.get())),
            SOYMILK_HELL = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_soymilk_hell"), b -> b
                    .output(TofuFluids.SOYMILK_HELL.get(), 250).output(Items.GLASS_BOTTLE).require(TofuItems.SOYMILK_HELL_BOTTLE.get())),
            SOYMILK_SOUL = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_soymilk_soul"), b -> b
                    .output(TofuFluids.SOYMILK_SOUL.get(), 250).output(Items.GLASS_BOTTLE).require(TofuItems.SOYMILK_SOUL_BOTTLE.get())),
            SOYMILK_APPLE = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_soymilk_apple"), b -> b
                    .output(ModAllFluids.SOYMILK_APPLE.get(), 250).output(Items.GLASS_BOTTLE).require(TofuItems.SOYMILK_APPLE.get())),
            SOYMILK_COCOA = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_soymilk_cocoa"), b -> b
                    .output(ModAllFluids.SOYMILK_COCOA.get(), 250).output(Items.GLASS_BOTTLE).require(TofuItems.SOYMILK_COCOA.get())),
            SOYMILK_HONEY = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_soymilk_honey"), b -> b
                    .output(ModAllFluids.SOYMILK_HONEY.get(), 250).output(Items.GLASS_BOTTLE).require(TofuItems.SOYMILK_HONEY.get())),
            SOYMILK_PUMPKIN = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_soymilk_pumpkin"), b -> b
                    .output(ModAllFluids.SOYMILK_PUMPKIN.get(), 250).output(Items.GLASS_BOTTLE).require(TofuItems.SOYMILK_PUMPKIN.get())),
            SOYMILK_PUDDING = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_soymilk_pudding"), b -> b
                    .output(ModAllFluids.SOYMILK_PUDDING.get(), 250).output(Items.GLASS_BOTTLE).require(TofuItems.SOYMILK_PUDDING.get())),
            SOYMILK_KINAKO = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_soymilk_kinako"), b -> b
                    .output(ModAllFluids.SOYMILK_KINAKO.get(), 250).output(Items.GLASS_BOTTLE).require(TofuItems.SOYMILK_KINAKO.get())),
            SOYMILK_ANNIN = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_soymilk_annin"), b -> b
                    .output(ModAllFluids.SOYMILK_ANNIN.get(), 250).output(Items.GLASS_BOTTLE).require(TofuItems.SOYMILK_ANNIN.get())),
            SOYMILK_RAMUNE = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_soymilk_ramune"), b -> b
                    .output(ModAllFluids.SOYMILK_RAMUNE.get(), 250).output(Items.GLASS_BOTTLE).require(TofuItems.SOYMILK_RAMUNE.get())),
            SOYMILK_SAKURA = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_soymilk_sakura"), b -> b
                    .output(ModAllFluids.SOYMILK_SAKURA.get(), 250).output(Items.GLASS_BOTTLE).require(TofuItems.SOYMILK_SAKURA.get())),
            SOYMILK_TEA = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_soymilk_tea"), b -> b
                    .output(ModAllFluids.SOYMILK_TEA.get(), 250).output(Items.GLASS_BOTTLE).require(TofuItems.SOYMILK_TEA.get())),
            SOYMILK_STRAWBERRY = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_soymilk_strawberry"), b -> b
                    .output(ModAllFluids.SOYMILK_STRAWBERRY.get(), 250).output(Items.GLASS_BOTTLE).require(TofuItems.SOYMILK_STRAWBERRY.get())),
            SOYOIL = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_soyoil"), b -> b
                    .output(ModAllFluids.SOYOIL.get(), 250).output(Items.GLASS_BOTTLE).require(TofuItems.BOTTLE_SOYOIL.get())),
            CRIMSON_FLUID = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_crimson"), b -> b
                    .output(TofuFluids.CRIMSON.get(), 250).output(Items.GLASS_BOTTLE).require(TofuItems.CRIMSON_BOTTLE.get())),
            WARPED_FLUID = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "emptying_warped"), b -> b
                    .output(TofuFluids.WARPED.get(), 250).output(Items.GLASS_BOTTLE).require(TofuItems.WARPED_BOTTLE.get()));






    public ModEmptyingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.EMPTYING;
    }

}