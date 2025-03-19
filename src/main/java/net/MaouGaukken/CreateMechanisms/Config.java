package net.MaouGaukken.CreateMechanisms;

import net.MaouGaukken.CreateMechanisms.init.CreateDirectories;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

//Mod configuration class, responsible for setting and managing configuration options
@EventBusSubscriber(modid = CreateMechanisms.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder(); //Configuration Specification Builder

    //Setting the Configuration for Initial Revenue Generation
    private static final ModConfigSpec.BooleanValue GENERATE_RECIPES = BUILDER
            .comment("Should initial recipes be generated?")
            .define("generateRecipes", true);  // The default value is true

    //Setting the configuration for generating recipes using the mod
    private static final ModConfigSpec.BooleanValue GENERATE_USES_RECIPES = BUILDER
            .comment("Revenues from uses must be generated?")
            .define("generateUsesRecipes", true);  // The default value is true

    static final ModConfigSpec SPEC = BUILDER.build(); //Creating the Configuration Specification Object

    //Variables to store the values of the settings
    public static boolean generateRecipes;
    public static boolean generateUsesRecipes;

    /**
     * Event triggered when mod settings are loaded.
     * @param event Mod config loading event
     */
    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        generateRecipes = GENERATE_RECIPES.get(); //Gets the value of the "generateRecipes" setting
        generateUsesRecipes = GENERATE_USES_RECIPES.get(); //Gets the value of the "generateUsesRecipes" setting

        //Creates the necessary directories to store the revenues generated
        CreateDirectories GenerateBaseRecipes = new CreateDirectories();
        GenerateBaseRecipes.createDirectories(generateRecipes);
    }
}
