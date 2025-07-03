package mod.ckenja.tofucreate;

import baguchan.tofucraft.registry.TofuBlocks;
import com.mojang.logging.LogUtils;
import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.api.behaviour.spouting.BlockSpoutingBehaviour;
import com.simibubi.create.api.event.BlockEntityBehaviourEvent;
import com.simibubi.create.foundation.data.CreateRegistrate;
import mod.ckenja.tofucreate.config.TCConfigs;
import mod.ckenja.tofucreate.create.BlockPressBehaviour;
import mod.ckenja.tofucreate.create.SpoutTofu;
import mod.ckenja.tofucreate.register.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

import java.util.Locale;


@Mod(BuildConfig.MODID)
public class TofuCreate {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final CreateRegistrate registrate = CreateRegistrate.create(BuildConfig.MODID);
    public static final String MODID = "tofucreate";

    public TofuCreate(ModContainer modContainer, IEventBus modBus) {
        modBus.addListener(this::setup);

        ModAllCreativeTabs.CREATIVE_MODE_TABS.register(modBus);
        NeoForge.EVENT_BUS.addListener(this::setupBehavior);
        registrate.registerEventListeners(modBus);
        registrate.defaultCreativeTab(ModAllCreativeTabs.TOFU_CREATE, "tofu_create");

        ModAllFluids.register();
        ModAllBlocks.register();
        ModAllItems.ITEMS.register(modBus);
        ModAllBlockEntityTypes.register();
        TCConfigs.register(modContainer);
        //AllMovementBehaviours.registerBehaviour(AllBlocks.MECHANICAL_PRESS.get(), new BlockPressMovementBehavior());
        //AllMovementBehaviours.registerBehaviour(AllBlocks.SPOUT.get(), new BlockSpoutMovementBehavior());
        //AllRecipeTypes.register(modEventBus);
        //https://cadiboo.github.io/tutorials/1.15.2/forge/1.4-proxies/
        //プロキシ、いらない
        //DistExecutor.safeRunForDist(()-> ClientProxy::new, () -> ServerProxy::new);
    }

    private void setup(FMLCommonSetupEvent event) {
        BlockSpoutingBehaviour.BY_BLOCK.register(TofuBlocks.SOYMILK.get(), new SpoutTofu());
    }

    private void setupBehavior(final BlockEntityBehaviourEvent event) {
        event.forType(AllBlockEntityTypes.MECHANICAL_PRESS.get(), smartBlockEntity -> {
            event.attach(new BlockPressBehaviour(smartBlockEntity));
        });
    }


    public static ResourceLocation prefix(String name) {
        return ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, name.toLowerCase(Locale.ROOT));
    }
}