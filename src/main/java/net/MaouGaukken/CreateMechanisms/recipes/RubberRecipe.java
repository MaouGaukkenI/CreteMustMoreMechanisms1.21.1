package net.MaouGaukken.CreateMechanisms.recipes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

// RubberRecipe Mod class, responsible for creating your recipes
public class RubberRecipe {
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
    public void RubberRecipe(File folder){
        // selects the file to be used
        File file = new File(folder, "RubberRecipe.js");
        generateFile(file);

        // If the file is empty, it performs revenue generation
        if (isFileEmpty(file)) {
            // Adds the recipe to the file
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(
                        "ServerEvents.recipes(event => {\n" +
                                "   event.custom({\n" +
                                "       \"type\": \"create:mixing\",\n" +
                                "       \"ingredients\": [\n" +
                                "           {\n" +
                                "               \"item\": \"minecraft:kelp\"\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"item\": \"minecraft:kelp\"\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"item\": \"minecraft:kelp\"\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"item\": \"minecraft:kelp\"\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"type\": \"fluid_stack\",\n" +
                                "               \"amount\": 250,\n" +
                                "               \"fluid\": \"minecraft:water\"\n" +
                                "           }\n" +
                                "       ],\n" +
                                "       \"results\": [\n" +
                                "           {\n" +
                                "               \"chance\": 1.0,\n" +
                                "               \"item\": {\n" +
                                "                   \"id\": \"createmechanisms:rubber\"\n" +
                                "               },\n" +
                                "               \"amount\": 1\n" +
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

    // Generates the item's recipe
    public void CuredRubberRecipe(File folder){
        // selects the file to be used
        File file = new File(folder, "CuredRubberRecipe.js");
        generateFile(file);

        // If the file is empty, it performs revenue generation
        if (isFileEmpty(file)) {
            // Adds the recipe to the file
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(
                        "ServerEvents.recipes(event => {\n" +
                                "   event.custom(\n" +
                                "       {\n" +
                                "           \"type\": \"minecraft:smelting\",\n" +
                                "           \"category\": \"misc\",\n" +
                                "           \"cookingtime\": 200,\n" +
                                "           \"experience\": 0.25,\n" +
                                "           \"ingredient\": {\n" +
                                "               \"item\": \"createmechanisms:rubber\"\n" +
                                "           },\n" +
                                "           \"result\": {\n" +
                                "               \"count\": 1,\n" +
                                "               \"id\": \"createmechanisms:cured_rubber\"\n" +
                                "           }\n" +
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
