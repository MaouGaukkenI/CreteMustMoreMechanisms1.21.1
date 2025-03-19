package net.MaouGaukken.CreateMechanisms.item.custom;

import net.MaouGaukken.CreateMechanisms.init.ModToolTiers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.*;

// SawItem class, an extension of AxeItem, used to create saw-like tools with special functionalities
public class SawItem extends AxeItem {

    // Constructor defining the saw item's properties and material tier
    public SawItem(Tier tier, Item.Properties properties) {
        super(tier, properties);
    }

    // Determines the maximum number of blocks that can be broken based on the tool's tier
    private int getMaxBlocks(Tier tier) {
        if (tier == ModToolTiers.COPPER) return 20;
        if (tier == ModToolTiers.MODIFIED_IRON) return 64;
        if (tier == ModToolTiers.MODIFIED_DIAMOND) return 128;
        return 10; // Default value for other tiers
    }

    // Handles the breaking of blocks when mining with the saw
    @Override
    public boolean mineBlock(ItemStack itemInHand, Level level, BlockState state, BlockPos pos, LivingEntity miningEntity) {
        if (level.isClientSide() || !(miningEntity instanceof Player player)) {
            return true; // Prevent execution on the client side
        }

        // Check if the block being mined is a log
        if (isLog(state)) {
            ServerLevel serverLevel = (ServerLevel) level;

            // Retrieve the max block limit based on the saw's material tier
            int maxBlocks = getMaxBlocks(((AxeItem) itemInHand.getItem()).getTier());

            // Scan the tree structure to determine the number of logs and leaves connected
            int[] results = scanTree(serverLevel, pos, maxBlocks);
            int woodFound = results[0];
            int leavesFound = results[1];

            int woodBroken = 0;
            int leavesPassed = 0;

            // If there are enough leaves, process the tree as a connected entity
            if (leavesFound >= 10) {
                results = destroyTree(serverLevel, pos, maxBlocks);
                woodBroken = results[0];
                leavesPassed = results[1];

                // Display a message to the player showing the number of broken logs and detected leaves
                player.displayClientMessage(Component.literal("Wood broken: " + woodBroken + " | Leaves found: " + leavesPassed), true);

                // Reduce durability based on the number of logs broken, except in Creative mode
                if (!player.isCreative()) {
                    itemInHand.hurtAndBreak(woodBroken, player, null);
                }
            } else {
                woodBroken++;
                player.displayClientMessage(Component.literal("Wood broken: " + woodBroken + " | Leaves found: " + leavesPassed), true);
            }
        }
        return true;
    }

    // Scans the tree structure to count logs and leaves within a limit
    private int[] scanTree(ServerLevel level, BlockPos startingPos, int maxBlocks) {
        Set<BlockPos> visited = new HashSet<>();
        Queue<BlockPos> queue = new LinkedList<>();
        queue.add(startingPos);

        int woodCount = 0;
        int leafCount = 0;
        Set<BlockPos> possibleConnections = new HashSet<>();

        // Traverse the tree structure, keeping within the max block limit
        while (!queue.isEmpty() && woodCount < maxBlocks) {
            BlockPos currentPos = queue.poll();
            BlockState currentState = level.getBlockState(currentPos);

            if (isLog(currentState) && visited.add(currentPos)) {
                woodCount++;

                for (BlockPos adjacent : getSurroundingBlocks(currentPos)) {
                    BlockState adjacentState = level.getBlockState(adjacent);
                    if (isLog(adjacentState)) {
                        queue.add(adjacent);
                    } else if (isLeaf(adjacentState) && visited.add(adjacent)) {
                        queue.add(adjacent);
                        leafCount++;
                        possibleConnections.add(adjacent);
                    }
                }
            }
        }
        return new int[]{woodCount, leafCount};
    }

    // Destroys tree blocks starting from the given position, up to the max limit
    private int[] destroyTree(ServerLevel level, BlockPos startingPos, int maxBlocks) {
        Set<BlockPos> visited = new HashSet<>();
        Queue<BlockPos> queue = new LinkedList<>();
        queue.add(startingPos);

        int woodCount = 0;
        int leafCount = 0;

        // Traverse and break logs within the max block limit
        while (!queue.isEmpty() && woodCount < maxBlocks) {
            BlockPos currentPos = queue.poll();
            BlockState currentState = level.getBlockState(currentPos);

            if (isLog(currentState) && visited.add(currentPos)) {
                level.destroyBlock(currentPos, true); // Break the block and drop items
                woodCount++;

                for (BlockPos adjacent : getSurroundingBlocks(currentPos)) {
                    BlockState adjacentState = level.getBlockState(adjacent);
                    if (isLog(adjacentState)) {
                        queue.add(adjacent);
                    } else if (isLeaf(adjacentState) && visited.add(adjacent)) {
                        queue.add(adjacent);
                        leafCount++;
                    }
                }
            }
        }
        return new int[]{woodCount, leafCount};
    }

    // Returns a set of adjacent block positions in all directions
    private Set<BlockPos> getSurroundingBlocks(BlockPos pos) {
        return Set.of(
                pos.above(), pos.below(),
                pos.north(), pos.south(),
                pos.east(), pos.west(),
                pos.north().above(), pos.north().below(),
                pos.south().above(), pos.south().below(),
                pos.east().above(), pos.east().below(),
                pos.west().above(), pos.west().below(),
                pos.north().east(), pos.north().west(),
                pos.south().east(), pos.south().west()
        );
    }

    // Checks if a given block state corresponds to a log
    private boolean isLog(BlockState state) {
        return state.is(BlockTags.LOGS);
    }

    // Checks if a given block state corresponds to a leaf
    private boolean isLeaf(BlockState state) {
        return state.is(BlockTags.LEAVES);
    }
}
