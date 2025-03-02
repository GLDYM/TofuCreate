package mod.ckenja.tofucreate.register;

import mod.ckenja.tofucreate.TofuCreate;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AllItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TofuCreate.MODID);

    public static final DeferredItem<Item> TOFU_METAL_PLATE = ITEMS.registerItem("tofumetal_plate", (properties) -> new Item((properties)));
    public static final DeferredItem<Item> TF_COMPACT_CIRCUIT = ITEMS.registerItem("tf_compact_circuit", (properties) -> new Item((properties)));
    public static final DeferredItem<Item> INCOMPLETE_TF_COMPACT_CIRCUIT = ITEMS.registerItem("incomplete_tf_compact_circuit", (properties) -> new Item((properties)));
    public static final DeferredItem<Item> TOFU_PRECISION_MECHANISM = ITEMS.registerItem("tofu_precision_mechanism", (properties) -> new Item((properties)));
    public static final DeferredItem<Item> INCOMPLETE_TOFU_PRECISION_MECHANISM = ITEMS.registerItem("incomplete_tofu_precision_mechanism", (properties) -> new Item((properties)));
}

