package mod.ckenja.tofucreate.register;

import mod.ckenja.tofucreate.TofuCreate;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.stream.Stream;

public class ModAllCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TofuCreate.MODID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TOFU_CREATE = CREATIVE_MODE_TABS.register("tofu_create", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup." + TofuCreate.MODID))
            .icon(() -> ModAllItems.TOFU_METAL_PLATE.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.acceptAll(Stream.of(
                        ModAllItems.TOFU_METAL_PLATE,
                        ModAllItems.INCOMPLETE_TF_COMPACT_CIRCUIT,
                        ModAllItems.TF_COMPACT_CIRCUIT,
                        ModAllItems.INCOMPLETE_TOFU_PRECISION_MECHANISM,
                        ModAllItems.TOFU_PRECISION_MECHANISM
                ).map(sup -> {
                    return sup.get().getDefaultInstance();
                }).toList());

            }).build());
}
