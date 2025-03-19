package net.MaouGaukken.CreateMechanisms.recipes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

// AdvancedPrecisionMechanismRecipe Mod class, responsible for creating your recipes
public class AdvancedPrecisionMechanismRecipe {
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

    // Generates the item's recipe in Sequencial format
    public void AdvancedPrecisionMechanismRecipeSequencial(File folder){
        // selects the file to be used
        File file = new File(folder, "AdvancedPrecisionMechanismRecipeSequencial.js");
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
                                "           \"item\": \"create:precision_mechanism\"\n" +
                                "       },\n" +
                                "       \"loops\": 4,\n" +
                                "       \"results\": [\n" +
                                "           {\n" +
                                "               \"chance\": 60.0,\n" +
                                "               \"item\": {\n" +
                                "                   \"id\": \"createmechanisms:advanced_precision_mechanism\"\n" +
                                "               }\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"chance\": 8.0,\n" +
                                "               \"item\": {\n" +
                                "                   \"id\": \"create:precision_mechanism\"\n" +
                                "               }\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"chance\": 8.0,\n" +
                                "               \"item\": {\n" +
                                "                   \"id\": \"create:zinc_ingot\"\n" +
                                "               }\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"chance\": 5.0,\n" +
                                "               \"item\": {\n" +
                                "                   \"id\": \"create:brass_ingot\"\n" +
                                "               }\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"chance\": 3.0,\n" +
                                "               \"item\": {\n" +
                                "                   \"id\": \"create:brass_sheet\"\n" +
                                "               }\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"chance\": 2.0,\n" +
                                "               \"item\": {\n" +
                                "                   \"id\": \"create:iron_sheet\"\n" +
                                "               }\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"chance\": 2.0,\n" +
                                "               \"item\": {\n" +
                                "                   \"id\": \"createmechanisms:wooden_mechanism\"\n" +
                                "               }\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"chance\": 6.0,\n" +
                                "               \"item\": {\n" +
                                "                   \"id\": \"createmechanisms:zinc_mechanism\"\n" +
                                "               }\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"chance\": 6.0,\n" +
                                "               \"item\": {\n" +
                                "                   \"id\": \"createmechanisms:rubber_mechanism\"\n" +
                                "               }\n" +
                                "           }\n" +
                                "       ],\n" +
                                "       \"sequence\": [\n" +
                                "           {\n" +
                                "               \"type\": \"create:deploying\",\n" +
                                "               \"ingredients\": [\n" +
                                "                   { \"item\": \"createmechanisms:incomplete_advanced_precision_mechanism\" },\n" +
                                "                   { \"item\": \"createmechanisms:wooden_mechanism\" }\n" +
                                "               ],\n" +
                                "               \"results\": [\n" +
                                "                   {\n" +
                                "                       \"item\": {\n" +
                                "                           \"id\": \"createmechanisms:incomplete_advanced_precision_mechanism\"\n" +
                                "                       }\n" +
                                "                   }\n" +
                                "               ]\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"type\": \"create:deploying\",\n" +
                                "               \"ingredients\": [\n" +
                                "                   { \"item\": \"createmechanisms:incomplete_advanced_precision_mechanism\" },\n" +
                                "                   { \"item\": \"createmechanisms:zinc_mechanism\" }\n" +
                                "               ],\n" +
                                "               \"results\": [\n" +
                                "                   {\n" +
                                "                       \"item\": {\n" +
                                "                           \"id\": \"createmechanisms:incomplete_advanced_precision_mechanism\"\n" +
                                "                       }\n" +
                                "                   }\n" +
                                "               ]\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"type\": \"create:deploying\",\n" +
                                "               \"ingredients\": [\n" +
                                "                   { \"item\": \"createmechanisms:incomplete_advanced_precision_mechanism\" },\n" +
                                "                   { \"item\": \"createmechanisms:rubber_mechanism\" }\n" +
                                "               ],\n" +
                                "               \"results\": [\n" +
                                "                   {\n" +
                                "                       \"item\": {\n" +
                                "                           \"id\": \"createmechanisms:incomplete_advanced_precision_mechanism\"\n" +
                                "                       }\n" +
                                "                   }\n" +
                                "               ]\n" +
                                "           }\n" +
                                "       ],\n" +
                                "       \"transitional_item\": {\n" +
                                "           \"item\": {\n" +
                                "               \"id\": \"createmechanisms:incomplete_advanced_precision_mechanism\"\n" +
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
