package net.MaouGaukken.CreateMechanisms.recipes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

// SawRecipe Mod class, responsible for creating your recipes
public class SawRecipe {
    // Checks if the file is empty
    private boolean isFileEmpty(File file) {
        try {
            return Files.size(file.toPath()) == 0;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Creates the file if it doesn't exist
    private void generateFile(File file) {
        if (!file.exists()) {
            try {
                file.createNewFile(); // If the file does not exist, it is created
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Generates the item's recipe
    public void CopperSawRecipe(File folder){
        // selects the file to be used
        File file = new File(folder, "CopperSawRecipe.js");
        generateFile(file);

        // If the file is empty, it performs revenue generation
        if (isFileEmpty(file)) {
            // Adds the recipe to the file
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(
                        "ServerEvents.recipes(event => {\n" +
                                "   event.shaped(\n" +
                                "       Item.of('createmechanisms:copper_saw', 1), // arg 1: output\n" +
                                "       [\n" +
                                "           '  c',\n" +
                                "           ' cb', // arg 2: the shape (array of strings)\n" +
                                "           'ab '\n" +
                                "       ],\n" +
                                "       {\n" +
                                "           a: '#minecraft:planks',\n" +
                                "           b: '#c:ingots/copper',\n" +
                                "           c: 'minecraft:stick'" +
                                "       }\n" +
                                "   )\n" +
                                "})"
                );
                writer.flush(); // Ensures that data is written to disk
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Generates the item's recipe
    public void IronSawRecipe(File folder){
        // Adds the recipe to the file
        File file = new File(folder, "IronSawRecipe.js");
        generateFile(file);

        // If the file is empty, it performs revenue generation
        if (isFileEmpty(file)) {
            // Adds the recipe to the file
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(
                        "ServerEvents.recipes(event => {\n" +
                                "   event.shaped(\n" +
                                "       Item.of('createmechanisms:iron_saw', 1), // arg 1: output\n" +
                                "       [\n" +
                                "           '  c',\n" +
                                "           ' cb', // arg 2: the shape (array of strings)\n" +
                                "           'ab '\n" +
                                "       ],\n" +
                                "       {\n" +
                                "           a: '#minecraft:planks',\n" +
                                "           b: '#c:ingots/iron',\n" +
                                "           c: 'minecraft:stick'" +
                                "       }\n" +
                                "   )\n" +
                                "})"
                );
                writer.flush(); // Ensures that data is written to disk
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Generates the item's recipe
    public void DiamondSawRecipe(File folder){
        // Adds the recipe to the file
        File file = new File(folder, "DiamondSawRecipe.js");
        generateFile(file);

        // If the file is empty, it performs revenue generation
        if (isFileEmpty(file)) {
            // Adds the recipe to the file
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(
                        "ServerEvents.recipes(event => {\n" +
                                "   event.shaped(\n" +
                                "       Item.of('createmechanisms:diamond_saw', 1), // arg 1: output\n" +
                                "       [\n" +
                                "           '  c',\n" +
                                "           ' cb', // arg 2: the shape (array of strings)\n" +
                                "           'ab '\n" +
                                "       ],\n" +
                                "       {\n" +
                                "           a: '#minecraft:planks',\n" +
                                "           b: '#c:gems/diamond',\n" +
                                "           c: 'minecraft:stick'" +
                                "       }\n" +
                                "   )\n" +
                                "})"
                );
                writer.flush(); // Ensures that data is written to disk
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
