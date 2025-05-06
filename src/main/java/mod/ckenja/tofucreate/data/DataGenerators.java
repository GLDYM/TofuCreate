package mod.ckenja.tofucreate.data;

import baguchan.tofucraft.data.RegistryDataGenerator;
import mod.ckenja.tofucreate.TofuCreate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DataPackRegistriesHooks;

import java.util.HashSet;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = TofuCreate.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        CompletableFuture<HolderLookup.Provider> tofuRegistries = lookupProvider.thenApply(r -> constructRegistries(r, RegistryDataGenerator.BUILDER));

        ModGeneratedEntriesProvider generatedEntriesProvider = new ModGeneratedEntriesProvider(packOutput, tofuRegistries);
        lookupProvider = generatedEntriesProvider.getRegistryProvider();
        generator.addProvider(event.includeServer(), generatedEntriesProvider);

        event.getGenerator().addProvider(event.includeClient(), new ItemModelGenerator(packOutput, existingFileHelper));
        event.getGenerator().addProvider(event.includeServer(), new ModEmptyingRecipeGen(packOutput));
        event.getGenerator().addProvider(event.includeServer(), new ModFillingRecipeGen(packOutput));
        event.getGenerator().addProvider(event.includeServer(), new ModMixingRecipeGen(packOutput));
        event.getGenerator().addProvider(event.includeServer(), new ModPressingRecipeGen(packOutput));
        event.getGenerator().addProvider(event.includeServer(), new ModSequencedAssemblyRecipeGen(packOutput));
    }

    private static HolderLookup.Provider constructRegistries(HolderLookup.Provider original, RegistrySetBuilder datapackEntriesBuilder) {
        var builderKeys = new HashSet<>(datapackEntriesBuilder.getEntryKeys());
        DataPackRegistriesHooks.getDataPackRegistriesWithDimensions().filter(data -> !builderKeys.contains(data.key())).forEach(data -> datapackEntriesBuilder.add(data.key(), context -> {
        }));
        return datapackEntriesBuilder.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY), original);
    }
}