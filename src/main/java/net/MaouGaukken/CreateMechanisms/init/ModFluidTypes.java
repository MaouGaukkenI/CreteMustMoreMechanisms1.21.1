package net.MaouGaukken.CreateMechanisms.init;

import net.MaouGaukken.CreateMechanisms.CreateMechanisms;
import net.MaouGaukken.CreateMechanisms.fluid.types.EnderiamFluidType;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

/**
 * This class defines custom Mod Fluid Types for the mod.
 */
public class ModFluidTypes {
    // Registering fluid types using Deferred Register
    public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, CreateMechanisms.MOD_ID);

    // Registering a custom fluid type "enderiam" with the associated fluid class
    public static final DeferredHolder<FluidType, FluidType> ENDERIAM_TYPE = REGISTRY.register("enderiam", () -> new EnderiamFluidType());
}
