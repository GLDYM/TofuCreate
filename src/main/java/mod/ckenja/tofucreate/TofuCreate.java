package mod.ckenja.tofucreate;

import baguchan.tofucraft.registry.TofuBlocks;
import com.mojang.logging.LogUtils;
import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.api.behaviour.spouting.BlockSpoutingBehaviour;
import com.simibubi.create.api.event.BlockEntityBehaviourEvent;
import com.simibubi.create.content.kinetics.press.MechanicalPressBlockEntity;
import com.simibubi.create.foundation.data.CreateRegistrate;
import mod.ckenja.tofucreate.config.TCConfigs;
import mod.ckenja.tofucreate.create.BlockPressBehaviour;
import mod.ckenja.tofucreate.create.SpoutTofu;
import mod.ckenja.tofucreate.register.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.Locale;

@Mod(BuildConfig.MODID)
public class TofuCreate {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final CreateRegistrate registrate = CreateRegistrate.create(BuildConfig.MODID);
    public static final String MODID = "tofucreate";

    public TofuCreate(FMLJavaModLoadingContext context) {
        IEventBus modBus = context.getModEventBus();
        modBus.addListener(this::setup);

        ModAllCreativeTabs.CREATIVE_MODE_TABS.register(modBus);
        MinecraftForge.EVENT_BUS.addGenericListener(MechanicalPressBlockEntity.class, (BlockEntityBehaviourEvent<MechanicalPressBlockEntity> event) -> event
                .attach(new BlockPressBehaviour(event.getBlockEntity())));
        registrate.registerEventListeners(modBus);
        registrate.defaultCreativeTab(ModAllCreativeTabs.TOFU_CREATE, "tofu_create");

        ModAllFluids.register();
        ModAllBlocks.register();
        ModAllItems.ITEMS.register(modBus);
        ModAllBlockEntityTypes.register();
        TCConfigs.register(ModLoadingContext.get());
        //AllMovementBehaviours.registerBehaviour(AllBlocks.MECHANICAL_PRESS.get(), new BlockPressMovementBehavior());
        //AllMovementBehaviours.registerBehaviour(AllBlocks.SPOUT.get(), new BlockSpoutMovementBehavior());
        //AllRecipeTypes.register(modEventBus);
        //https://cadiboo.github.io/tutorials/1.15.2/forge/1.4-proxies/
        //プロキシ、いらない
        //DistExecutor.safeRunForDist(()-> ClientProxy::new, () -> ServerProxy::new);
    }

    private void setup(final FMLCommonSetupEvent event) {
        BlockSpoutingBehaviour.BY_BLOCK.register(TofuBlocks.SOYMILK.get(), new SpoutTofu());

    }

    public static ResourceLocation prefix(String name) {
        return ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, name.toLowerCase(Locale.ROOT));
    }
}