package net.MaouGaukken.CreateMechanisms.block;

import net.MaouGaukken.CreateMechanisms.init.ModFluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;

public class EnderiamBlock extends LiquidBlock {

    // Constructor to initialize the Enderiam block with specific properties
    public EnderiamBlock() {
        // Super constructor for LiquidBlock with customized properties
        super(ModFluids.ENDERIAM.get(),
                BlockBehaviour.Properties.of()  // Create block properties
                        .mapColor(MapColor.LAPIS)      // Set the block color to lapis
                        .strength(100f)               // Set block strength to 100
                        .hasPostProcess((bs, br, bp) -> true)  // Always return true for post-processing
                        .emissiveRendering((bs, br, bp) -> true)  // Make the block emit light
                        .noCollission()               // Disable collision with the block
                        .noLootTable()                // Disable loot table for the block
                        .liquid()                     // Set the block as a liquid block
                        .pushReaction(PushReaction.DESTROY)  // Set push reaction to DESTROY
                        .sound(SoundType.EMPTY)       // Set block sound to empty (no sound)
                        .replaceable());             // Block can be replaced by other blocks
    }
}
