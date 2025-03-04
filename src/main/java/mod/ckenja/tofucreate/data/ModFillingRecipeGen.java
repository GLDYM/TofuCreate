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

public class ModFillingRecipeGen extends ProcessingRecipeGen {

    GeneratedRecipe
            SOYMILK_BUCKET = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "fill_soymilk_bucket"), b -> b
            .require(TofuFluids.SOYMILK.get(), 1000).require(Items.BUCKET).output(TofuItems.BUCKET_SOYMILK.get())),
            SOYMILK_HELL_BUCKET = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "fill_soymilk_hell_bucket"), b -> b
                    .require(TofuFluids.SOYMILK_HELL.get(), 1000).require(Items.BUCKET).output(TofuItems.BUCKET_SOYMILK_NETHER.get())),
            SOYMILK_SOUL_BUCKET = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "fill_soymilk_soul_bucket"), b -> b
                    .require(TofuFluids.SOYMILK_SOUL.get(), 1000).require(Items.BUCKET).output(TofuItems.BUCKET_SOYMILK_SOUL.get())),
            SOYMILK = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "fill_soymilk"), b -> b
                    .require(TofuFluids.SOYMILK.get(), 250).require(Items.GLASS_BOTTLE).output(TofuItems.SOYMILK.get())),
            SOYMILK_HELL = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "fill_soymilk_hell"), b -> b
                    .require(TofuFluids.SOYMILK_HELL.get(), 250).require(Items.GLASS_BOTTLE).output(TofuItems.SOYMILK_HELL_BOTTLE.get())),
            SOYMILK_SOUL = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "fill_soymilk_soul"), b -> b
                    .require(TofuFluids.SOYMILK_SOUL.get(), 250).require(Items.GLASS_BOTTLE).output(TofuItems.SOYMILK_SOUL_BOTTLE.get())),
            SOYMILK_APPLE = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "fill_soymilk_apple"), b -> b
                    .require(AllFluids.SOYMILK_APPLE.get(), 250).require(Items.GLASS_BOTTLE).output(TofuItems.SOYMILK_APPLE.get())),
            SOYMILK_COCOA = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "fill_soymilk_cocoa"), b -> b
                    .require(AllFluids.SOYMILK_COCOA.get(), 250).require(Items.GLASS_BOTTLE).output(TofuItems.SOYMILK_COCOA.get())),
            SOYMILK_HONEY = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "fill_soymilk_honey"), b -> b
                    .require(AllFluids.SOYMILK_HONEY.get(), 250).require(Items.GLASS_BOTTLE).output(TofuItems.SOYMILK_HONEY.get())),
            SOYMILK_PUMPKIN = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "fill_soymilk_pumpkin"), b -> b
                    .require(AllFluids.SOYMILK_PUMPKIN.get(), 250).require(Items.GLASS_BOTTLE).output(TofuItems.SOYMILK_PUMPKIN.get())),
            SOYMILK_PUDDING = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "fill_soymilk_pudding"), b -> b
                    .require(AllFluids.SOYMILK_PUDDING.get(), 250).require(Items.GLASS_BOTTLE).output(TofuItems.SOYMILK_PUDDING.get())),
            SOYMILK_KINAKO = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "fill_soymilk_kinako"), b -> b
                    .require(AllFluids.SOYMILK_KINAKO.get(), 250).require(Items.GLASS_BOTTLE).output(TofuItems.SOYMILK_KINAKO.get())),
            SOYMILK_ANNIN = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "fill_soymilk_annin"), b -> b
                    .require(AllFluids.SOYMILK_ANNIN.get(), 250).require(Items.GLASS_BOTTLE).output(TofuItems.SOYMILK_ANNIN.get())),
            SOYMILK_RAMUNE = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "fill_soymilk_ramune"), b -> b
                    .require(AllFluids.SOYMILK_RAMUNE.get(), 250).require(Items.GLASS_BOTTLE).output(TofuItems.SOYMILK_RAMUNE.get())),
            SOYMILK_SAKURA = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "fill_soymilk_sakura"), b -> b
                    .require(AllFluids.SOYMILK_SAKURA.get(), 250).require(Items.GLASS_BOTTLE).output(TofuItems.SOYMILK_SAKURA.get())),
            SOYMILK_TEA = create(ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, "fill_soymilk_tea"), b -> b
                    .require(AllFluids.SOYMILK_TEA.get(), 250).require(Items.GLASS_BOTTLE).output(TofuItems.SOYMILK_TEA.get()));






    public ModFillingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.FILLING;
    }

}