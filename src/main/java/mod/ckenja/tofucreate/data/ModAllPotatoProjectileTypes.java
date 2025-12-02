package mod.ckenja.tofucreate.data;

import baguchan.tofucraft.registry.TofuBlocks;
import baguchan.tofucraft.registry.TofuItems;
import com.simibubi.create.Create;
import com.simibubi.create.api.equipment.potatoCannon.PotatoCannonProjectileType;
import com.simibubi.create.api.registry.CreateRegistries;
import com.simibubi.create.content.equipment.potatoCannon.AllPotatoProjectileBlockHitActions;
import com.simibubi.create.content.equipment.potatoCannon.AllPotatoProjectileEntityHitActions;
import mod.ckenja.tofucreate.TofuCreate;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class ModAllPotatoProjectileTypes {
    public static final ResourceKey<PotatoCannonProjectileType> FALLBACK = ResourceKey.create(CreateRegistries.POTATO_PROJECTILE_TYPE, Create.asResource("fallback"));

    public static void bootstrap(BootstapContext<PotatoCannonProjectileType> ctx) {

        register(ctx, "soybeans", new PotatoCannonProjectileType.Builder()
                .damage(1)
                .reloadTicks(3)
                .velocity(1.5f)
                .knockback(0.25f)
                .soundPitch(1.2f)
                .renderTumbling()
                .onBlockHit(new AllPotatoProjectileBlockHitActions.PlantCrop(TofuBlocks.SOYBEAN.get()))
                .addItems(TofuItems.SEEDS_SOYBEANS.get())
                .build());
        register(ctx, "soybeans_parched", new PotatoCannonProjectileType.Builder()
                .damage(2)
                .reloadTicks(8)
                .velocity(1.5f)
                .knockback(0.25f)
                .soundPitch(1.2f)
                .splitInto(3)
                .renderTumbling()
                .addItems(TofuItems.SOYBEAN_PARCHED.get())
                .build());
        register(ctx, "soybeans_nether", new PotatoCannonProjectileType.Builder()
                .damage(1)
                .reloadTicks(3)
                .velocity(1.5f)
                .knockback(0.25f)
                .soundPitch(1.2f)
                .renderTumbling()
                .preEntityHit(new AllPotatoProjectileEntityHitActions.SetOnFire(40))
                .onBlockHit(new AllPotatoProjectileBlockHitActions.PlantCrop(TofuBlocks.SOYBEAN_NETHER.get()))
                .addItems(TofuItems.SEEDS_SOYBEANS_NETHER.get())
                .build());
        register(ctx, "soybeans_soul", new PotatoCannonProjectileType.Builder()
                .damage(3)
                .splitInto(3)
                .reloadTicks(10)
                .velocity(1.5f)
                .knockback(0.25f)
                .soundPitch(1.2f)
                .renderTumbling()
                .addItems(TofuItems.SEEDS_SOYBEANS_SOUL.get())
                .build());
    }

    private static void register(BootstapContext<PotatoCannonProjectileType> ctx, String name, PotatoCannonProjectileType type) {
        ctx.register(ResourceKey.create(CreateRegistries.POTATO_PROJECTILE_TYPE, ResourceLocation.fromNamespaceAndPath(TofuCreate.MODID, name)), type);
    }
}
