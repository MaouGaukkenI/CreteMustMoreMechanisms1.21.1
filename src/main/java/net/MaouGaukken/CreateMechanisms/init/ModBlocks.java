package net.MaouGaukken.CreateMechanisms.init;

import net.MaouGaukken.CreateMechanisms.CreateMechanisms;
import net.MaouGaukken.CreateMechanisms.block.EnderiamBlock;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

/**
 * This class defines custom Mod Blocks for the mod.
 */
public class ModBlocks {

    // Creating a Deferred Register for blocks with the mod ID
    public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(CreateMechanisms.MOD_ID);

    // Registering specific blocks using the registerBlock method
    public static final DeferredBlock<Block> ENDERIAM = REGISTRY.register("enderiam", EnderiamBlock::new);

    // Helper method to register a block and its corresponding BlockItem
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> blockSupplier) {
        // Registering the block
        DeferredBlock<T> toReturn = REGISTRY.register(name, blockSupplier);
        // Registering the BlockItem for the block
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Helper method to register a BlockItem for a given block
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        // Registering the BlockItem for the block using the same name
        ModItems.REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Method to register all blocks with the event bus
    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
