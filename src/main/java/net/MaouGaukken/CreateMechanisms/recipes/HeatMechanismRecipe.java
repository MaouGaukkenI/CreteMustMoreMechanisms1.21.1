package net.MaouGaukken.CreateMechanisms.recipes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

// HeatMechanismRecipe Mod class, responsible for creating your recipes
public class HeatMechanismRecipe {
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

    // Generates the item's recipe in Shaped format
    public void HeatMechanismRecipeShaped(File folder){
        // selects the file to be used
        File file = new File(folder, "HeatMechanismRecipeShaped.js");
        generateFile(file);

        // If the file is empty, it performs revenue generation
        if (isFileEmpty(file)) {
            // Adds the recipe to the file
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(
                        "ServerEvents.recipes(event => {\n" +
                                "   event.shaped(\n" +
                                "       Item.of('createmechanisms:heat_mechanism', 1), // arg 1: output\n" +
                                "       [\n" +
                                "           ' d ',\n" +
                                "           'aba', // arg 2: the shape (array of strings)\n" +
                                "           ' c '\n" +
                                "       ],\n" +
                                "       {\n" +
                                "           a: 'minecraft:lava_bucket',\n" +
                                "           b: 'createmechanisms:rubber_mechanism',  //arg 3: the mapping object\n" +
                                "           c: 'createmechanisms:bronze',\n" +
                                "           d: 'minecraft:magma_block'\n" +
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

    // Generates the item's recipe in Sequencial format
    public void HeatMechanismRecipeSequencial(File folder){
        // selects the file to be used
        File file = new File(folder, "HeatMechanismRecipeSequencial.js");
        generateFile(file);

        // If the file is empty, it performs revenue generation
        if (isFileEmpty(file)) {
            // Adds the recipe to the file
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(
                        "ServerEvents.recipes(event => {\n" +
                                "   event.custom({\n" +
                                "       \"type\": \"create:sequenced_assembly\",\n" +
                                "       \"ingredient\": {\n" +
                                "           \"item\": \"createmechanisms:bronze\"\n" +
                                "       },\n" +
                                "       \"loops\": 5,\n" +
                                "       \"results\": [\n" +
                                "           {\n" +
                                "               \"chance\": 1.0,\n" +
                                "               \"item\": {\n" +
                                "                   \"id\": \"createmechanisms:heat_mechanism\"\n" +
                                "               }\n" +
                                "           }\n" +
                                "       ],\n" +
                                "       \"sequence\": [\n" +
                                "           {\n" +
                                "               \"type\": \"create:pressing\",\n" +
                                "               \"ingredients\": [\n" +
                                "                   {\n" +
                                "                       \"item\": \"createmechanisms:incomplete_heat_mechanism\"\n" +
                                "                   }\n" +
                                "               ],\n" +
                                "               \"results\": [\n" +
                                "                   {\n" +
                                "                       \"item\": {\n" +
                                "                           \"id\": \"createmechanisms:incomplete_heat_mechanism\"\n" +
                                "                       }\n" +
                                "                   }\n" +
                                "               ]\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"type\": \"create:deploying\",\n" +
                                "               \"ingredients\": [\n" +
                                "                   { \"item\": \"createmechanisms:incomplete_heat_mechanism\" },\n" +
                                "                   { \"item\": \"minecraft:magma_block\" }\n" +
                                "               ],\n" +
                                "               \"results\": [\n" +
                                "                   {\n" +
                                "                       \"item\": {\n" +
                                "                           \"id\": \"createmechanisms:incomplete_heat_mechanism\"\n" +
                                "                       }\n" +
                                "                   }\n" +
                                "               ]\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"type\": \"create:filling\",\n" +
                                "               \"ingredients\": [\n" +
                                "                   {\n" +
                                "                       \"item\": \"createmechanisms:incomplete_heat_mechanism\"\n" +
                                "                   },\n" +
                                "                   {\n" +
                                "                       \"type\": \"fluid_stack\",\n" +
                                "                       \"amount\": 200,\n" +
                                "                       \"fluid\": \"minecraft:lava\"\n" +
                                "                   }\n" +
                                "               ],\n" +
                                "               \"results\": [\n" +
                                "                   {\n" +
                                "                       \"item\": {\n" +
                                "                           \"id\": \"createmechanisms:incomplete_heat_mechanism\"\n" +
                                "                       }\n" +
                                "                   }\n" +
                                "               ]\n" +
                                "           }\n" +
                                "       ],\n" +
                                "       \"transitional_item\": {\n" +
                                "           \"item\": {\n" +
                                "               \"id\": \"createmechanisms:incomplete_heat_mechanism\"\n" +
                                "           },\n" +
                                "           \"amount\": 1\n" +
                                "       }\n" +
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
