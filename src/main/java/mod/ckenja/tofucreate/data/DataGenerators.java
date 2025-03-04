package mod.ckenja.tofucreate.data;

import mod.ckenja.tofucreate.TofuCreate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = TofuCreate.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        event.getGenerator().addProvider(event.includeClient(), new ItemModelGenerator(packOutput, event.getExistingFileHelper()));
        event.getGenerator().addProvider(event.includeServer(), new ModEmptyingRecipeGen(packOutput, lookupProvider));
        event.getGenerator().addProvider(event.includeServer(), new ModFillingRecipeGen(packOutput, lookupProvider));
        event.getGenerator().addProvider(event.includeServer(), new ModMixingRecipeGen(packOutput, lookupProvider));
        event.getGenerator().addProvider(event.includeServer(), new ModPressingRecipeGen(packOutput, lookupProvider));
        event.getGenerator().addProvider(event.includeServer(), new ModSequencedAssemblyRecipeGen(packOutput, lookupProvider));
    }
}