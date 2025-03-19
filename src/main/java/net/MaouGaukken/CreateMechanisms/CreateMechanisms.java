package net.MaouGaukken.CreateMechanisms;

import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import net.MaouGaukken.CreateMechanisms.init.*;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

//Sets the mod identifier and initializes the main class
@Mod(CreateMechanisms.MOD_ID)
public class CreateMechanisms {
    public static final String MOD_ID = "createmechanisms"; //Unique Mod ID
    private static final Logger LOGGER = LogUtils.getLogger(); //Logger instance to record information and errors

    /**
     * Mod main class builder.
     * @param modEventBus Mod's Event Bus
     * @param modContainer Mod Container for settings registration
     */
    public CreateMechanisms(IEventBus modEventBus, ModContainer modContainer) {
        //Registers mod settings and recipes
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        //Registers the mod's custom items and blocks
        ModItems.REGISTRY.register(modEventBus);
        ModBlocks.REGISTRY.register(modEventBus);

        //Records the fluids and fluid types of the mod
        ModFluids.REGISTRY.register(modEventBus);
        ModFluidTypes.REGISTRY.register(modEventBus);

        //Registers the custom creative tabs
        ModTabs.REGISTRY.register(modEventBus);
    }
}
