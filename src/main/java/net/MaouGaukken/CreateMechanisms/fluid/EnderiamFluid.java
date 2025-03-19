package net.MaouGaukken.CreateMechanisms.fluid;

import net.MaouGaukken.CreateMechanisms.init.ModBlocks;
import net.MaouGaukken.CreateMechanisms.init.ModFluidTypes;
import net.MaouGaukken.CreateMechanisms.init.ModFluids;
import net.MaouGaukken.CreateMechanisms.init.ModItems;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

//Class responsible for creating the fluid Enderiam
public abstract class EnderiamFluid extends BaseFlowingFluid {
    // Properties for the Enderiam fluid, including its type, bucket, and block associated with it
    public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> ModFluidTypes.ENDERIAM_TYPE.get(),
            () -> ModFluids.ENDERIAM.get(), () -> ModFluids.FLOWING_ENDERIAM.get())
            .explosionResistance(100f) // Explosion resistance for the fluid
            .bucket(() -> ModItems.ENDERIAM_BUCKET.get()) // Bucket item associated with the fluid
            .block(() -> (LiquidBlock) ModBlocks.ENDERIAM.get()); // Block associated with the fluid

    // Constructor for EnderiamFluid, using the defined properties
    private EnderiamFluid() {
        super(PROPERTIES);
    }

    // The Source class represents the source block of the fluid (static, full block)
    public static class Source extends EnderiamFluid {
        // Returns the fluid amount for the source block (fully filled, 8)
        public int getAmount(FluidState state) {
            return 8;
        }

        // The source block always returns true as it's the origin of the fluid
        public boolean isSource(FluidState state) {
            return true;
        }
    }

    // The Flowing class represents the flowing state of the fluid (moving, less than 8 blocks)
    public static class Flowing extends EnderiamFluid {
        // Defines the fluid state properties, including the fluid level
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL); // Fluid level property
        }

        // Returns the fluid amount based on the fluid state level
        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        // The flowing state is never the source of the fluid
        public boolean isSource(FluidState state) {
            return false;
        }
    }
}
