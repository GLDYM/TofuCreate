package mod.ckenja.tofucreate.data;

import com.simibubi.create.api.registry.CreateRegistries;
import mod.ckenja.tofucreate.TofuCreate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModGeneratedEntriesProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(CreateRegistries.POTATO_PROJECTILE_TYPE, ModAllPotatoProjectileTypes::bootstrap);

    public ModGeneratedEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(TofuCreate.MODID));
    }

    @Override
    public String getName() {
        return "Tofu Create's Generated Registry Entries";
    }
}
