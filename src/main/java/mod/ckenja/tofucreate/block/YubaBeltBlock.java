package mod.ckenja.tofucreate.block;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.api.contraption.transformable.TransformableBlock;
import com.simibubi.create.api.schematic.requirement.SpecialBlockItemRequirement;
import com.simibubi.create.content.contraptions.StructureTransform;
import com.simibubi.create.content.equipment.armor.DivingBootsItem;
import com.simibubi.create.content.kinetics.base.HorizontalKineticBlock;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.belt.*;
import com.simibubi.create.content.kinetics.belt.behaviour.TransportedItemStackHandlerBehaviour;
import com.simibubi.create.content.kinetics.belt.transport.BeltMovementHandler;
import com.simibubi.create.content.kinetics.belt.transport.BeltTunnelInteractionHandler;
import com.simibubi.create.content.logistics.box.PackageEntity;
import com.simibubi.create.content.logistics.box.PackageItem;
import com.simibubi.create.content.logistics.funnel.FunnelBlock;
import com.simibubi.create.content.logistics.tunnel.BeltTunnelBlock;
import com.simibubi.create.content.schematics.requirement.ItemRequirement;
import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.foundation.block.ProperWaterloggedBlock;
import com.simibubi.create.foundation.block.render.MultiPosDestructionHandler;
import com.simibubi.create.foundation.block.render.ReducedDestroyEffects;
import com.simibubi.create.foundation.item.ItemHelper;
import mod.ckenja.tofucreate.register.ModAllBlockEntityTypes;
import mod.ckenja.tofucreate.register.ModAllBlocks;
import mod.ckenja.tofucreate.register.ModAllItems;
import net.createmod.catnip.data.Iterate;
import net.createmod.catnip.math.VecHelper;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.levelgen.DebugLevelSource;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;

import org.apache.commons.lang3.mutable.MutableBoolean;

import java.util.*;

public class YubaBeltBlock extends BeltBlock {

    public YubaBeltBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(SLOPE, BeltSlope.HORIZONTAL)
                .setValue(PART, BeltPart.START)
                .setValue(CASING, false)
                .setValue(WATERLOGGED, false));
    }


    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos,
                                       Player player) {
        return ModAllItems.YUBA_CONNECTOR.asStack();
    }

    @SuppressWarnings("deprecation")
    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        List<ItemStack> drops = super.getDrops(state, builder);
        BlockEntity blockEntity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (blockEntity instanceof BeltBlockEntity && ((BeltBlockEntity) blockEntity).hasPulley())
            drops.addAll(ModAllBlocks.TOFU_METAL_SHAFT.getDefaultState()
                    .getDrops(builder));
        return drops;
    }


    @Override
    public void spawnAfterBreak(BlockState state, ServerLevel worldIn, BlockPos pos, ItemStack p_220062_4_, boolean b) {
        BeltBlockEntity controllerBE = BeltHelper.getControllerBE(worldIn, pos);
        if (controllerBE != null)
            controllerBE.getInventory()
                    .ejectAll();
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return false;
    }

    @Override
    public void updateEntityAfterFallOn(BlockGetter worldIn, Entity entityIn) {
        super.updateEntityAfterFallOn(worldIn, entityIn);
        BlockPos entityPosition = entityIn.blockPosition();
        BlockPos beltPos = null;

        if (ModAllBlocks.YUBA.has(worldIn.getBlockState(entityPosition)))
            beltPos = entityPosition;
        else if (ModAllBlocks.YUBA.has(worldIn.getBlockState(entityPosition.below())))
            beltPos = entityPosition.below();
        if (beltPos == null)
            return;
        if (!(worldIn instanceof Level))
            return;

        entityInside(worldIn.getBlockState(beltPos), (Level) worldIn, beltPos, entityIn);
    }

    @Override
    public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
        if (!canTransportObjects(state))
            return;
        if (entityIn instanceof Player player) {
            if (player.isShiftKeyDown() && !AllItems.CARDBOARD_BOOTS.isIn(player.getItemBySlot(EquipmentSlot.FEET)))
                return;
            if (player.getAbilities().flying)
                return;
        }

        if (DivingBootsItem.isWornBy(entityIn))
            return;

        BeltBlockEntity belt = BeltHelper.getSegmentBE(worldIn, pos);
        if (belt == null)
            return;
        ItemStack asItem = ItemHelper.fromItemEntity(entityIn);
        if (!asItem.isEmpty()) {
            if (worldIn.isClientSide)
                return;
            if (entityIn.getDeltaMovement().y > 0)
                return;
            Vec3 targetLocation = VecHelper.getCenterOf(pos)
                    .add(0, 5 / 16f, 0);
            if (!PackageEntity.centerPackage(entityIn, targetLocation))
                return;
            if (BeltTunnelInteractionHandler.getTunnelOnPosition(worldIn, pos) != null)
                return;
            withBlockEntityDo(worldIn, pos, be -> {
                IItemHandler handler = be.getCapability(ForgeCapabilities.ITEM_HANDLER).orElse(null);
                if (handler == null)
                    return;
                ItemStack remainder = handler.insertItem(0, asItem, false);
                if (remainder.isEmpty())
                    entityIn.discard();
                else if (entityIn instanceof ItemEntity itemEntity && remainder.getCount() != itemEntity.getItem().getCount())
                    itemEntity.setItem(remainder);
            });
            return;
        }

        BeltBlockEntity controller = BeltHelper.getControllerBE(worldIn, pos);
        if (controller == null || controller.passengers == null)
            return;
        if (controller.passengers.containsKey(entityIn)) {
            BeltMovementHandler.TransportedEntityInfo info = controller.passengers.get(entityIn);
            if (info.getTicksSinceLastCollision() != 0 || pos.equals(entityIn.blockPosition()))
                info.refresh(pos, state);
        } else {
            controller.passengers.put(entityIn, new BeltMovementHandler.TransportedEntityInfo(pos, state));
            entityIn.setOnGround(true);
        }
    }

    public static boolean canTransportObjects(BlockState state) {
        if (!ModAllBlocks.YUBA.has(state))
            return false;
        BeltSlope slope = state.getValue(SLOPE);
        return slope != BeltSlope.VERTICAL && slope != BeltSlope.SIDEWAYS;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
		if (player.isShiftKeyDown() || !player.mayBuild())
			return InteractionResult.PASS;
		ItemStack heldItem = player.getItemInHand(handIn);

        boolean isWrench = AllItems.WRENCH.isIn(heldItem);
        boolean isConnector = ModAllItems.YUBA_CONNECTOR.isIn(heldItem);
        boolean isShaft = ModAllBlocks.TOFU_METAL_SHAFT.isIn(heldItem);

        boolean isHand = heldItem.isEmpty() && handIn == InteractionHand.MAIN_HAND;
        if (isConnector)
            return BeltSlicer.useConnector(state, level, pos, player, handIn, hit, new BeltSlicer.Feedback());
        if (isWrench)
            return BeltSlicer.useWrench(state, level, pos, player, handIn, hit, new BeltSlicer.Feedback()); 
        BeltBlockEntity belt = BeltHelper.getSegmentBE(level, pos);
        if (belt == null)
            return InteractionResult.PASS;

        if (PackageItem.isPackage(heldItem)) {
            ItemStack toInsert = heldItem.copy();
            IItemHandler handler = belt.getCapability(ForgeCapabilities.ITEM_HANDLER).orElse(null);
            if (handler == null)
                return InteractionResult.PASS;
            ItemStack remainder = handler.insertItem(0, toInsert, false);
            if (remainder.isEmpty()) {
                heldItem.shrink(1);
                return InteractionResult.SUCCESS;
            }
        }

        if (isHand) {
            BeltBlockEntity controllerBelt = belt.getControllerBE();
            if (controllerBelt == null)
                return InteractionResult.PASS;
            if (level.isClientSide)
                return InteractionResult.SUCCESS;
            MutableBoolean success = new MutableBoolean(false);
            controllerBelt.getInventory()
                    .applyToEachWithin(belt.index + .5f, .55f, (transportedItemStack) -> {
                        player.getInventory()
                                .placeItemBackInInventory(transportedItemStack.stack);
                        success.setTrue();
                        return TransportedItemStackHandlerBehaviour.TransportedResult.removeItem();
                    });
            if (success.isTrue())
                level.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, .2f,
                        1f + level.random.nextFloat());
        }

        if (isShaft) {
            if (state.getValue(PART) != BeltPart.MIDDLE)
                return InteractionResult.PASS;
            if (level.isClientSide)
                return InteractionResult.SUCCESS;
            if (!player.isCreative())
                heldItem.shrink(1);
            KineticBlockEntity.switchToBlockState(level, pos, state.setValue(PART, BeltPart.PULLEY));
            return InteractionResult.SUCCESS;
        }


        /*if (AllBlocks.ANDESITE_CASING.isIn(stack)) {
            withBlockEntityDo(level, pos, be -> be.setCasingType(BeltBlockEntity.CasingType.ANDESITE));
            updateCoverProperty(level, pos, level.getBlockState(pos));

            SoundType soundType = AllBlocks.ANDESITE_CASING.getDefaultState()
                    .getSoundType(level, pos, player);
            level.playSound(null, pos, soundType.getPlaceSound(), SoundSource.BLOCKS,
                    (soundType.getVolume() + 1.0F) / 2.0F, soundType.getPitch() * 0.8F);

            return ItemInteractionResult.SUCCESS;
        }*/

        return InteractionResult.PASS;
    }

    @Override
    public InteractionResult onWrenched(BlockState state, UseOnContext context) {
        Level world = context.getLevel();
        Player player = context.getPlayer();
        BlockPos pos = context.getClickedPos();

        if (state.getValue(CASING)) {
            if (world.isClientSide)
                return InteractionResult.SUCCESS;
            withBlockEntityDo(world, pos, be -> be.setCasingType(BeltBlockEntity.CasingType.NONE));
            return InteractionResult.SUCCESS;
        }

        if (state.getValue(PART) == BeltPart.PULLEY) {
            if (world.isClientSide)
                return InteractionResult.SUCCESS;
            KineticBlockEntity.switchToBlockState(world, pos, state.setValue(PART, BeltPart.MIDDLE));
            if (player != null && !player.isCreative())
                player.getInventory()
                        .placeItemBackInInventory(ModAllBlocks.TOFU_METAL_SHAFT.asStack());
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    public static void initBelt(Level world, BlockPos pos) {
        if (world.isClientSide)
            return;
        if (world instanceof ServerLevel && ((ServerLevel) world).getChunkSource()
                .getGenerator() instanceof DebugLevelSource)
            return;

        BlockState state = world.getBlockState(pos);
        if (!ModAllBlocks.YUBA.has(state))
            return;
        // Find controller
        int limit = 1000;
        BlockPos currentPos = pos;
        while (limit-- > 0) {
            BlockState currentState = world.getBlockState(currentPos);
            if (!ModAllBlocks.YUBA.has(currentState)) {
                world.destroyBlock(pos, true);
                return;
            }
            BlockPos nextSegmentPosition = nextSegmentPosition(currentState, currentPos, false);
            if (nextSegmentPosition == null)
                break;
            if (!world.isLoaded(nextSegmentPosition))
                return;
            currentPos = nextSegmentPosition;
        }

        // Init belts
        int index = 0;
        List<BlockPos> beltChain = getBeltChain(world, currentPos);
        if (beltChain.size() < 2) {
            world.destroyBlock(currentPos, true);
            return;
        }

        for (BlockPos beltPos : beltChain) {
            BlockEntity blockEntity = world.getBlockEntity(beltPos);
            BlockState currentState = world.getBlockState(beltPos);

            if (blockEntity instanceof BeltBlockEntity be && ModAllBlocks.YUBA.has(currentState)) {
                be.setController(currentPos);
                be.beltLength = beltChain.size();
                be.index = index;
                be.attachKinetics();
                be.setChanged();
                be.sendData();

                if (be.isController() && !canTransportObjects(currentState))
                    be.getInventory()
                            .ejectAll();
            } else {
                world.destroyBlock(currentPos, true);
                return;
            }
            index++;
        }

    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        super.onRemove(state, world, pos, newState, isMoving);

        if (world.isClientSide)
            return;
        if (state.getBlock() == newState.getBlock())
            return;
        if (isMoving)
            return;

        // Destroy chain
        for (boolean forward : Iterate.trueAndFalse) {
            BlockPos currentPos = nextSegmentPosition(state, pos, forward);
            if (currentPos == null)
                continue;
            BlockState currentState = world.getBlockState(currentPos);
            if (!ModAllBlocks.YUBA.has(currentState))
                continue;

            boolean hasPulley = false;
            BlockEntity blockEntity = world.getBlockEntity(currentPos);
            if (blockEntity instanceof BeltBlockEntity belt) {
                if (belt.isController())
                    belt.getInventory()
                            .ejectAll();

                hasPulley = belt.hasPulley();
            }

            world.removeBlockEntity(currentPos);
            BlockState shaftState = ModAllBlocks.TOFU_METAL_SHAFT.getDefaultState()
                    .setValue(BlockStateProperties.AXIS, getRotationAxis(currentState));
            world.setBlock(currentPos, ProperWaterloggedBlock.withWater(world,
                    hasPulley ? shaftState : Blocks.AIR.defaultBlockState(), currentPos), 3);
            world.levelEvent(2001, currentPos, Block.getId(currentState));
        }
    }

    public static List<BlockPos> getBeltChain(LevelAccessor world, BlockPos controllerPos) {
        List<BlockPos> positions = new LinkedList<>();

        BlockState blockState = world.getBlockState(controllerPos);
        if (!ModAllBlocks.YUBA.has(blockState))
            return positions;

        int limit = 1000;
        BlockPos current = controllerPos;
        while (limit-- > 0 && current != null) {
            BlockState state = world.getBlockState(current);
            if (!ModAllBlocks.YUBA.has(state))
                break;
            positions.add(current);
            current = nextSegmentPosition(state, current, true);
        }

        return positions;
    }

    public static BlockPos nextSegmentPosition(BlockState state, BlockPos pos, boolean forward) {
        Direction direction = state.getValue(HORIZONTAL_FACING);
        BeltSlope slope = state.getValue(SLOPE);
        BeltPart part = state.getValue(PART);

        int offset = forward ? 1 : -1;

        if (part == BeltPart.END && forward || part == BeltPart.START && !forward)
            return null;
        if (slope == BeltSlope.VERTICAL)
            return pos.above(direction.getAxisDirection() == Direction.AxisDirection.POSITIVE ? offset : -offset);
        pos = pos.relative(direction, offset);
        if (slope != BeltSlope.HORIZONTAL && slope != BeltSlope.SIDEWAYS)
            return pos.above(slope == BeltSlope.UPWARD ? offset : -offset);
        return pos;
    }

    @Override
    public Class<BeltBlockEntity> getBlockEntityClass() {
        return BeltBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends BeltBlockEntity> getBlockEntityType() {
        return ModAllBlockEntityTypes.BELT.get();
    }

    @Override
    public ItemRequirement getRequiredItems(BlockState state, BlockEntity be) {
        List<ItemStack> required = new ArrayList<>();
        if (state.getValue(PART) != BeltPart.MIDDLE)
            required.add(ModAllBlocks.TOFU_METAL_SHAFT.asStack());
        if (state.getValue(PART) == BeltPart.START)
            required.add(ModAllItems.YUBA_CONNECTOR.asStack());
        if (required.isEmpty())
            return ItemRequirement.NONE;
        return new ItemRequirement(ItemRequirement.ItemUseType.CONSUME, required);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        BlockState rotate = super.rotate(state, rot);

        if (state.getValue(SLOPE) != BeltSlope.VERTICAL)
            return rotate;
        if (state.getValue(HORIZONTAL_FACING)
                .getAxisDirection() != rotate.getValue(HORIZONTAL_FACING)
                .getAxisDirection()) {
            if (state.getValue(PART) == BeltPart.START)
                return rotate.setValue(PART, BeltPart.END);
            if (state.getValue(PART) == BeltPart.END)
                return rotate.setValue(PART, BeltPart.START);
        }

        return rotate;
    }

    public BlockState transform(BlockState state, StructureTransform transform) {
        if (transform.mirror != null) {
            state = mirror(state, transform.mirror);
        }

        if (transform.rotationAxis == Direction.Axis.Y) {
            return rotate(state, transform.rotation);
        }
        return transformInner(state, transform);
    }

    protected BlockState transformInner(BlockState state, StructureTransform transform) {
        boolean halfTurn = transform.rotation == Rotation.CLOCKWISE_180;

        Direction initialDirection = state.getValue(HORIZONTAL_FACING);
        boolean diagonal =
                state.getValue(SLOPE) == BeltSlope.DOWNWARD || state.getValue(SLOPE) == BeltSlope.UPWARD;

        if (!diagonal) {
            for (int i = 0; i < transform.rotation.ordinal(); i++) {
                Direction direction = state.getValue(HORIZONTAL_FACING);
                BeltSlope slope = state.getValue(SLOPE);
                boolean vertical = slope == BeltSlope.VERTICAL;
                boolean horizontal = slope == BeltSlope.HORIZONTAL;
                boolean sideways = slope == BeltSlope.SIDEWAYS;

                Direction newDirection = direction.getOpposite();
                BeltSlope newSlope = BeltSlope.VERTICAL;

                if (vertical) {
                    if (direction.getAxis() == transform.rotationAxis) {
                        newDirection = direction.getCounterClockWise();
                        newSlope = BeltSlope.SIDEWAYS;
                    } else {
                        newSlope = BeltSlope.HORIZONTAL;
                        newDirection = direction;
                        if (direction.getAxis() == Direction.Axis.Z)
                            newDirection = direction.getOpposite();
                    }
                }

                if (sideways) {
                    newDirection = direction;
                    if (direction.getAxis() == transform.rotationAxis)
                        newSlope = BeltSlope.HORIZONTAL;
                    else
                        newDirection = direction.getCounterClockWise();
                }

                if (horizontal) {
                    newDirection = direction;
                    if (direction.getAxis() == transform.rotationAxis)
                        newSlope = BeltSlope.SIDEWAYS;
                    else if (direction.getAxis() != Direction.Axis.Z)
                        newDirection = direction.getOpposite();
                }

                state = state.setValue(HORIZONTAL_FACING, newDirection);
                state = state.setValue(SLOPE, newSlope);
            }

        } else if (initialDirection.getAxis() != transform.rotationAxis) {
            for (int i = 0; i < transform.rotation.ordinal(); i++) {
                Direction direction = state.getValue(HORIZONTAL_FACING);
                Direction newDirection = direction.getOpposite();
                BeltSlope slope = state.getValue(SLOPE);
                boolean upward = slope == BeltSlope.UPWARD;
                boolean downward = slope == BeltSlope.DOWNWARD;

                // Rotate diagonal
                if (direction.getAxisDirection() == Direction.AxisDirection.POSITIVE ^ downward ^ direction.getAxis() == Direction.Axis.Z) {
                    state = state.setValue(SLOPE, upward ? BeltSlope.DOWNWARD : BeltSlope.UPWARD);
                } else {
                    state = state.setValue(HORIZONTAL_FACING, newDirection);
                }
            }

        } else if (halfTurn) {
            Direction direction = state.getValue(HORIZONTAL_FACING);
            Direction newDirection = direction.getOpposite();
            BeltSlope slope = state.getValue(SLOPE);
            boolean vertical = slope == BeltSlope.VERTICAL;

            if (diagonal) {
                state = state.setValue(SLOPE, slope == BeltSlope.UPWARD ? BeltSlope.DOWNWARD
                        : slope == BeltSlope.DOWNWARD ? BeltSlope.UPWARD : slope);
            } else if (vertical) {
                state = state.setValue(HORIZONTAL_FACING, newDirection);
            }
        }

        return state;
    }
}
