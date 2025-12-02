package mod.ckenja.tofucreate.register;

import com.simibubi.create.AllItems;
import com.simibubi.create.content.kinetics.belt.item.BeltConnectorItem;
import com.simibubi.create.foundation.data.AssetLookup;
import com.tterrag.registrate.util.entry.ItemEntry;
import mod.ckenja.tofucreate.TofuCreate;
import mod.ckenja.tofucreate.item.TofuVerticalGearboxItem;
import mod.ckenja.tofucreate.item.YubaConnectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModAllItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TofuCreate.MODID);

    public static final RegistryObject<Item> TOFU_METAL_PLATE = ITEMS.register("tofumetal_plate", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> TF_COMPACT_CIRCUIT = ITEMS.register("tf_compact_circuit", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> INCOMPLETE_TF_COMPACT_CIRCUIT = ITEMS.register("incomplete_tf_compact_circuit", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> TOFU_PRECISION_MECHANISM = ITEMS.register("tofu_precision_mechanism", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> INCOMPLETE_TOFU_PRECISION_MECHANISM = ITEMS.register("incomplete_tofu_precision_mechanism", () -> new Item((new Item.Properties())));
    public static final ItemEntry<TofuVerticalGearboxItem> TOFU_VERTICAL_GEARBOX =
            TofuCreate.registrate.item("tofu_vertical_gearbox", TofuVerticalGearboxItem::new)
                    .model(AssetLookup.customBlockItemModel("tofu_gearbox", "item_vertical"))
                    .register();
    public static final ItemEntry<YubaConnectorItem> YUBA_CONNECTOR =
            TofuCreate.registrate.item("yuba_connector", YubaConnectorItem::new)
                    .register();
}

