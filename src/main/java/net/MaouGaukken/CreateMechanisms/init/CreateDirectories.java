package net.MaouGaukken.CreateMechanisms.init;

import net.MaouGaukken.CreateMechanisms.Config;
import net.MaouGaukken.CreateMechanisms.recipes.*;
import net.minecraft.client.Minecraft;

import java.io.File;

public class CreateDirectories {

    /**
     * Creates directories and generates recipes if required.
     *
     * @param generateRecipes Determines whether recipes should be generated.
     */
    public void createDirectories(boolean generateRecipes) {

        // Defines the custom folders
        File baseFolder = new File(Minecraft.getInstance().gameDirectory, "kubejs/server_scripts/CreateMechanisms/Base");
        File Ae2DependenciesFolder = new File(Minecraft.getInstance().gameDirectory, "kubejs/server_scripts/CreateMechanisms/Ae2Dependencies");

        // Creates the folders if they do not exist
        if (!Ae2DependenciesFolder.exists()) {
            Ae2DependenciesFolder.mkdirs();
        }
        if (!baseFolder.exists()) {
            baseFolder.mkdirs();
        }

        // Checks if the initial recipes should be generated
        if (!generateRecipes) {
            // If recipe generation is not required, delete the recipe folders
            deleteFolder(Ae2DependenciesFolder);
            deleteFolder(baseFolder);
            return; // Stops execution to avoid generating recipes
        }

        // Recipe creation
        WoodenMechanismRecipe WOODEN_MECHANISM = new WoodenMechanismRecipe();
        RubberMechanismRecipe RUBBER_MECHANISM = new RubberMechanismRecipe();
        ZincMechanismRecipe ZINC_MECHANISM = new ZincMechanismRecipe();
        HeatMechanismRecipe HEAT_MECHANISM = new HeatMechanismRecipe();
        ComputingMechanismRecipe COMPUTING_MECHANISM = new ComputingMechanismRecipe();
        AdvancedPrecisionMechanismRecipe ADVANCED_PRECISION_MECHANISM = new AdvancedPrecisionMechanismRecipe();
        EnderMechanismRecipe ENDER_MECHANISM = new EnderMechanismRecipe();
        RubberRecipe RUBBER = new RubberRecipe();
        BronzeRecipe BRONZE = new BronzeRecipe();
        EnderDustRecipe ENDER_DUST = new EnderDustRecipe();
        EnderiamRecipe ENDERIAM = new EnderiamRecipe();
        SawRecipe SAW = new SawRecipe();

        // If Applied Energistics 2 (AE2) is installed, generate AE2-dependent recipes
        if (isAE2Installed()) {
            ENDER_MECHANISM.EnderMechanismRecipeSequencial(Ae2DependenciesFolder);
            COMPUTING_MECHANISM.ComputingMechanismRecipeSequencial(Ae2DependenciesFolder);
            ENDER_DUST.EnderDustRecipeMilling(Ae2DependenciesFolder);
            ENDERIAM.EnderiamRecipeMixing(Ae2DependenciesFolder);
        } else {
            deleteFolder(Ae2DependenciesFolder);
        }

        // Mechanisms
        WOODEN_MECHANISM.WoodenMechanismRecipeShapeless(baseFolder);
        WOODEN_MECHANISM.WoodenMechanismRecipeSequencial(baseFolder);
        RUBBER_MECHANISM.RubberMechanismRecipeShaped(baseFolder);
        RUBBER_MECHANISM.RubberMechanismRecipeSequencial(baseFolder);
        ZINC_MECHANISM.ZincMechanismRecipeSequencial(baseFolder);
        ZINC_MECHANISM.ZincMechanismRecipeShaped(baseFolder);
        HEAT_MECHANISM.HeatMechanismRecipeSequencial(baseFolder);
        HEAT_MECHANISM.HeatMechanismRecipeShaped(baseFolder);
        ADVANCED_PRECISION_MECHANISM.AdvancedPrecisionMechanismRecipeSequencial(baseFolder);

        // Tools
        SAW.IronSawRecipe(baseFolder);
        SAW.CopperSawRecipe(baseFolder);
        SAW.DiamondSawRecipe(baseFolder);

        // Items
        RUBBER.CuredRubberRecipe(baseFolder);
        RUBBER.RubberRecipe(baseFolder);
        BRONZE.BronzeRecipe(baseFolder);
    }

    /**
     * Checks if Applied Energistics 2 (AE2) is installed.
     *
     * @return true if AE2 is installed, false otherwise.
     */
    public static boolean isAE2Installed() {
        // Gets the "mods" folder inside the game directory
        File modsFolder = new File(Minecraft.getInstance().gameDirectory, "mods");
        String nameAE2 = "appliedenergistics";

        // Checks if the folder exists and is a directory
        if (modsFolder.exists() && modsFolder.isDirectory()) {
            // Lists all files inside the mods folder
            File[] files = modsFolder.listFiles();

            if (files != null) {
                for (File file : files) {
                    // If the file name contains "appliedenergistics", return true
                    if (file.getName().toLowerCase().contains(nameAE2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Deletes a folder and all its contents recursively.
     *
     * @param folder The folder to be deleted.
     */
    private void deleteFolder(File folder) {
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteFolder(file); // Recursively delete subdirectories
                    } else {
                        file.delete();
                    }
                }
            }
            folder.delete(); // Deletes the folder itself
        }
    }
}
