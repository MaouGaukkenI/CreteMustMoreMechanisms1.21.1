package net.MaouGaukken.CreateMechanisms.recipes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

// BronzeRecipe Mod class, responsible for creating your recipes
public class BronzeRecipe {
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
    public void BronzeRecipe(File folder){
        // selects the file to be used
        File file = new File(folder, "BronzeRecipe.js");
        generateFile(file);

        // If the file is empty, it performs revenue generation
        if (isFileEmpty(file)) {
            // Adds the recipe to the file
            try (FileWriter writer = new FileWriter(file, true)) { // O segundo parâmetro "true" permite modo de append
                writer.write(
                        "ServerEvents.recipes(event => {\n" +
                                "// Bronze\n" +
                                "   event.custom({\n" +
                                "       \"type\": \"create:mixing\",\n" +
                                "       \"heat_requirement\": \"heated\",\n" +
                                "       \"ingredients\": [\n" +
                                "           {\n" +
                                "               \"item\": \"minecraft:copper_ingot\"\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"item\": \"minecraft:copper_ingot\"\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"item\": \"minecraft:copper_ingot\"\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"item\": \"minecraft:iron_ingot\"\n" +
                                "           }\n" +
                                "       ],\n" +
                                "       \"results\": [\n" +
                                "           {\n" +
                                "               \"count\": 4,\n" +
                                "               \"item\": {\n" +
                                "                   \"id\": \"createmechanisms:bronze\"\n" +
                                "               }\n" +
                                "           }\n" +
                                "       ]\n" +
                                "   })\n" +
                                "})"
                );
                writer.flush(); // Ensures that data is written to disk
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
