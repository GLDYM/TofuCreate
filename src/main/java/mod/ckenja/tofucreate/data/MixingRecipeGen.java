package mod.ckenja.tofucreate.data;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class MixingRecipeGen extends ProcessingRecipeGen {

   /* GeneratedRecipe

            TEMP_LAVA = create("lava_from_cobble", b -> b.require(Tags.Items.COBBLESTONES)
            .output(Fluids.LAVA, 50)),
*/


    public MixingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.MIXING;
    }

}