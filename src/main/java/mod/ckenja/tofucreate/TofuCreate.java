package mod.ckenja.tofucreate;

import baguchan.tofucraft.registry.TofuBlocks;
import com.mojang.logging.LogUtils;
import com.simibubi.create.api.behaviour.spouting.BlockSpoutingBehaviour;
import com.simibubi.create.api.event.BlockEntityBehaviourEvent;
import com.simibubi.create.content.kinetics.press.MechanicalPressBlockEntity;
import com.simibubi.create.foundation.data.CreateRegistrate;
import mod.ckenja.tofucreate.create.BlockPressBehaviour;
import mod.ckenja.tofucreate.create.SpoutTofu;
import mod.ckenja.tofucreate.register.ModAllBlocks;
import mod.ckenja.tofucreate.register.ModAllCreativeTabs;
import mod.ckenja.tofucreate.register.ModAllFluids;
import mod.ckenja.tofucreate.register.ModAllItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.Locale;

@Mod(BuildConfig.MODID)
public class TofuCreate {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    public static final IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
    public static final CreateRegistrate registrate = CreateRegistrate.create(BuildConfig.MODID);
    public static final String MODID = "tofucreate";

    public TofuCreate(){
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::enqueueIMC);
        modEventBus.addListener(this::processIMC);
        forgeEventBus.addGenericListener(MechanicalPressBlockEntity.class, (BlockEntityBehaviourEvent<MechanicalPressBlockEntity> event) -> event
                .attach(new BlockPressBehaviour(event.getBlockEntity())));
        registrate.registerEventListeners(modEventBus);
        ModAllFluids.register();
        ModAllBlocks.register(modEventBus);
        ModAllItems.ITEMS.register(modEventBus);
        ModAllCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
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

    private void enqueueIMC(final InterModEnqueueEvent event) {
        //使い道、なさそう
    }

    private void processIMC(final InterModProcessEvent event) {
        //そもそも名前なんでこんなわかりにくやつなの
    }

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(TofuCreate.MODID, name.toLowerCase(Locale.ROOT));
    }
}