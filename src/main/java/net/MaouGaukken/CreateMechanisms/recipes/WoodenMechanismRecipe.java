package net.MaouGaukken.CreateMechanisms.recipes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

// WoodenMechanismRecipe Mod class, responsible for creating your recipes
public class WoodenMechanismRecipe {
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

    // Generates the item's recipe in Shapeless format
    public void WoodenMechanismRecipeShapeless(File folder){
        // selects the file to be used
        File file = new File(folder, "WoodenMechanismRecipeShapeless.js");
        generateFile(file);

        // If the file is empty, it performs revenue generation
        if (isFileEmpty(file)) {
            // Adds the recipe to the file
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(
                        "ServerEvents.recipes(event => {\n" +
                                "   event.shapeless(\n" +
                                "       Item.of('createmechanisms:wooden_mechanism', 1), // arg 1: output\n" +
                                "       [\n" +
                                "           '2x create:andesite_alloy',\n" +
                                "           'minecraft:stripped_oak_wood', \t       // arg 2: the array of inputs\n" +
                                "           '2x create:shaft',\n" +
                                "           'minecraft:oak_planks',\n" +
                                "           '#createmechanisms:sawing_tools'\n" +
                                "       ]\n" +
                                "   ).damageIngredient('#createmechanisms:sawing_tools');\n" +
                                "})"
                );
                writer.flush(); // Ensures that data is written to disk
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Generates the item's recipe in Sequencial format
    public void WoodenMechanismRecipeSequencial(File folder){
        // selects the file to be used
        File file = new File(folder, "WoodenMechanismRecipeSequencial.js");
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
                                "           \"tag\": \"c:stripped_woods\"\n" +
                                "       },\n" +
                                "       \"loops\": 1,\n" +
                                "       \"results\": [\n" +
                                "           {\n" +
                                "               \"chance\": 1.0,\n" +
                                "               \"item\": {\n" +
                                "                   \"id\": \"createmechanisms:wooden_mechanism\"\n" +
                                "               }\n" +
                                "           }\n" +
                                "       ],\n" +
                                "       \"sequence\": [\n" +
                                "           {\n" +
                                "               \"type\": \"create:pressing\",\n" +
                                "               \"ingredients\": [\n" +
                                "                   {\n" +
                                "                       \"item\": \"createmechanisms:incomplete_wooden_mechanism\"\n" +
                                "                   }\n" +
                                "               ],\n" +
                                "               \"results\": [\n" +
                                "                   {\n" +
                                "                       \"item\": {\n" +
                                "                           \"id\": \"createmechanisms:incomplete_wooden_mechanism\"\n" +
                                "                       }\n" +
                                "                   }\n" +
                                "               ]\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"type\": \"create:deploying\",\n" +
                                "               \"ingredients\": [\n" +
                                "                   { \"item\": \"createmechanisms:incomplete_wooden_mechanism\" },\n" +
                                "                   { \"item\": \"create:andesite_alloy\" }\n" +
                                "               ],\n" +
                                "               \"results\": [\n" +
                                "                   {\n" +
                                "                       \"item\": {\n" +
                                "                           \"id\": \"createmechanisms:incomplete_wooden_mechanism\"\n" +
                                "                       }\n" +
                                "                   }\n" +
                                "               ]\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"type\": \"create:deploying\",\n" +
                                "               \"ingredients\": [\n" +
                                "                   { \"item\": \"createmechanisms:incomplete_wooden_mechanism\" },\n" +
                                "                   { \"item\": \"create:cogwheel\" }\n" +
                                "               ],\n" +
                                "               \"results\": [\n" +
                                "                   {\n" +
                                "                       \"item\": {\n" +
                                "                           \"id\": \"createmechanisms:incomplete_wooden_mechanism\"\n" +
                                "                       }\n" +
                                "                   }\n" +
                                "               ]\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"type\": \"create:deploying\",\n" +
                                "               \"ingredients\": [\n" +
                                "                   { \"item\": \"createmechanisms:incomplete_wooden_mechanism\" },\n" +
                                "                   { \"item\": \"create:large_cogwheel\" }\n" +
                                "               ],\n" +
                                "               \"results\": [\n" +
                                "                   {\n" +
                                "                       \"item\": {\n" +
                                "                           \"id\": \"createmechanisms:incomplete_wooden_mechanism\"\n" +
                                "                       }\n" +
                                "                   }\n" +
                                "               ]\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"type\": \"create:deploying\",\n" +
                                "               \"ingredients\": [\n" +
                                "                   { \"item\": \"createmechanisms:incomplete_wooden_mechanism\" },\n" +
                                "                   { \"item\": \"create:cogwheel\" }\n" +
                                "               ],\n" +
                                "               \"results\": [\n" +
                                "                   {\n" +
                                "                       \"item\": {\n" +
                                "                           \"id\": \"createmechanisms:incomplete_wooden_mechanism\"\n" +
                                "                       }\n" +
                                "                   }\n" +
                                "               ]\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"type\": \"create:deploying\",\n" +
                                "               \"ingredients\": [\n" +
                                "                   { \"item\": \"createmechanisms:incomplete_wooden_mechanism\" },\n" +
                                "                   { \"item\": \"create:large_cogwheel\" }\n" +
                                "               ],\n" +
                                "               \"results\": [\n" +
                                "                   {\n" +
                                "                       \"item\": {\n" +
                                "                           \"id\": \"createmechanisms:incomplete_wooden_mechanism\"\n" +
                                "                       }\n" +
                                "                   }\n" +
                                "               ]\n" +
                                "           }\n" +
                                "       ],\n" +
                                "       \"transitional_item\": {\n" +
                                "           \"item\": {\n" +
                                "               \"id\": \"createmechanisms:incomplete_wooden_mechanism\"\n" +
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
