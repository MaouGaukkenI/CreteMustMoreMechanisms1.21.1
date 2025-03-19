package net.MaouGaukken.CreateMechanisms.recipes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

// RubberMechanismRecipe Mod class, responsible for creating your recipes
public class RubberMechanismRecipe {
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
    public void RubberMechanismRecipeShaped(File folder){
        // selects the file to be used
        File file = new File(folder, "RubberMechanismShaped.js");
        generateFile(file);

        // If the file is empty, it performs revenue generation
        if (isFileEmpty(file)) {
            // Adds the recipe to the file
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(
                        "ServerEvents.recipes(event => {\n" +
                                "  event.shaped(\n" +
                                "       Item.of('createmechanisms:rubber_mechanism', 1), // arg 1: output\n" +
                                "       [\n" +
                                "           ' a ',\n" +
                                "           'bcb', // arg 2: the shape (array of strings)\n" +
                                "           ' d '\n" +
                                "       ],\n" +
                                "       {\n" +
                                "           a: 'create:copper_nugget',\n" +
                                "           b: 'createmechanisms:cured_rubber',  //arg 3: the mapping object\n" +
                                "           c: 'createmechanisms:wooden_mechanism',\n" +
                                "           d: 'create:copper_sheet'\n" +
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

    public void RubberMechanismRecipeSequencial(File folder){
        // selects the file to be used
        File file = new File(folder, "RubberMechanismRecipeSequencial.js");
        generateFile(file);

        // If the file is empty, it performs revenue generation
        if (isFileEmpty(file)) {
            // Adds the recipe to the file
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(
                        "ServerEvents.recipes(event => {\n" +
                                "  event.custom({\n" +
                                "       \"type\": \"create:sequenced_assembly\",\n" +
                                "       \"ingredient\": {\n" +
                                "           \"item\": \"createmechanisms:wooden_mechanism\"\n" +
                                "       },\n" +
                                "       \"loops\": 1,\n" +
                                "       \"results\": [\n" +
                                "           {\n" +
                                "               \"chance\": 1.0,\n" +
                                "               \"item\": {\n" +
                                "                   \"id\": \"createmechanisms:rubber_mechanism\"\n" +
                                "               }\n" +
                                "           }\n" +
                                "       ],\n" +
                                "       \"sequence\": [\n" +
                                "           {\n" +
                                "               \"type\": \"create:deploying\",\n" +
                                "               \"ingredients\": [\n" +
                                "                   { \"item\": \"createmechanisms:incomplete_rubber_mechanism\" },\n" +
                                "                   { \"item\": \"createmechanisms:cured_rubber\" }\n" +
                                "               ],\n" +
                                "               \"results\": [\n" +
                                "                   {\n" +
                                "                       \"item\": {\n" +
                                "                           \"id\": \"createmechanisms:incomplete_rubber_mechanism\"\n" +
                                "                       }\n" +
                                "                   }\n" +
                                "               ]\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"type\": \"create:pressing\",\n" +
                                "               \"ingredients\": [\n" +
                                "                   {\n" +
                                "                       \"item\": \"createmechanisms:incomplete_rubber_mechanism\"\n" +
                                "                   }\n" +
                                "               ],\n" +
                                "               \"results\": [\n" +
                                "                   {\n" +
                                "                       \"item\": {\n" +
                                "                           \"id\": \"createmechanisms:incomplete_rubber_mechanism\"\n" +
                                "                       }\n" +
                                "                   }\n" +
                                "               ]\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"type\": \"create:deploying\",\n" +
                                "               \"ingredients\": [\n" +
                                "                   { \"item\": \"createmechanisms:incomplete_rubber_mechanism\" },\n" +
                                "                   { \"item\": \"create:copper_nugget\" }\n" +
                                "               ],\n" +
                                "               \"results\": [\n" +
                                "                   {\n" +
                                "                       \"item\": {\n" +
                                "                           \"id\": \"createmechanisms:incomplete_rubber_mechanism\"\n" +
                                "                       }\n" +
                                "                   }\n" +
                                "               ]\n" +
                                "           }\n" +
                                "       ],\n" +
                                "       \"transitional_item\": {\n" +
                                "           \"item\": {\n" +
                                "               \"id\": \"createmechanisms:incomplete_rubber_mechanism\"\n" +
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
