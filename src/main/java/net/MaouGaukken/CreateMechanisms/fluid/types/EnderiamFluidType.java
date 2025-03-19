package net.MaouGaukken.CreateMechanisms.fluid.types;

import net.MaouGaukken.CreateMechanisms.init.ModFluidTypes;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;

// This annotation makes the class subscribe to the MOD event bus
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
// Class responsible for creating the fluid type Enderiam
public class EnderiamFluidType extends FluidType {

    // Constructor for EnderiamFluidType, defining properties like path type, sound, and motion scale
    public EnderiamFluidType() {
        super(FluidType.Properties.create()
                .canSwim(false)  // Disables swimming in the fluid
                .canDrown(false) // Disables drowning in the fluid
                .pathType(PathType.LAVA) // Defines path type for AI navigation
                .adjacentPathType(null) // No adjacent path type
                .motionScale(0.007D) // Sets motion scale for the fluid
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL) // Sound when the fluid is filled into a bucket
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY) // Sound when the fluid is emptied from a bucket
                .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH) // Sound when the fluid vaporizes
        );
    }

    // Event handler method to register fluid type extensions (textures for still and flowing fluids)
    @SubscribeEvent
    public static void registerFluidTypeExtensions(RegisterClientExtensionsEvent event) {
        // Register the custom textures for the Enderiam fluid type
        event.registerFluidType(new IClientFluidTypeExtensions() {
            private static final ResourceLocation STILL_TEXTURE = ResourceLocation.parse("createmechanisms:block/enderiam_still");
            private static final ResourceLocation FLOWING_TEXTURE = ResourceLocation.parse("createmechanisms:block/enderiam_flow");

            // Returns the texture for the still state of the fluid
            @Override
            public ResourceLocation getStillTexture() {
                return STILL_TEXTURE;
            }

            // Returns the texture for the flowing state of the fluid
            @Override
            public ResourceLocation getFlowingTexture() {
                return FLOWING_TEXTURE;
            }
        }, ModFluidTypes.ENDERIAM_TYPE.get()); // Registers the textures for the specific fluid type
    }
}
