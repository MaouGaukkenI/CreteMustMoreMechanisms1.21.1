package net.MaouGaukken.CreateMechanisms.init;

import net.MaouGaukken.CreateMechanisms.CreateMechanisms;

import net.MaouGaukken.CreateMechanisms.fluid.EnderiamFluid;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

/**
 * This class defines custom Mod Fluid for the mod.
 */
public class ModFluids {
    // Registering fluids using Deferred Register
    public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, CreateMechanisms.MOD_ID);

    // Registering the Enderiam fluid (both static and flowing variants)
    public static final DeferredHolder<Fluid, FlowingFluid> ENDERIAM = REGISTRY.register("enderiam", () -> new EnderiamFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_ENDERIAM = REGISTRY.register("flowing_enderiam", () -> new EnderiamFluid.Flowing());

    // Handling client-side fluid rendering
    @EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class FluidsClientSideHandler {
        // Setting the render layer for the Enderiam fluid and its flowing counterpart
        @SubscribeEvent
        public static void clientSetup(FMLClientSetupEvent event) {
            // Making the fluid translucent for proper rendering
            ItemBlockRenderTypes.setRenderLayer(ENDERIAM.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FLOWING_ENDERIAM.get(), RenderType.translucent());
        }
    }
}
