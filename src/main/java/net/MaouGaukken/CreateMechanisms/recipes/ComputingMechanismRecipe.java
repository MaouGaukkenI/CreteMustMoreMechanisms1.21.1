package net.MaouGaukken.CreateMechanisms.recipes;

import net.minecraft.client.Minecraft;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// ComputingMechanismRecipe Mod class, responsible for creating your recipes
public class ComputingMechanismRecipe {
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
    public void ComputingMechanismRecipeSequencial(File folder){
        // selects the file to be used
        File file = new File(folder, "ComputingMechanismRecipeSequencial.js");
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
                                "           \"item\": \"createmechanisms:zinc_mechanism\"\n" +
                                "       },\n" +
                                "       \"loops\": 3,\n" +
                                "       \"results\": [\n" +
                                "           {\n" +
                                "               \"chance\": 1.0,\n" +
                                "               \"item\": {\n" +
                                "                   \"id\": \"createmechanisms:computing_mechanism\"\n" +
                                "               }\n" +
                                "           }\n" +
                                "       ],\n" +
                                "       \"sequence\": [\n" +
                                "           {\n" +
                                "               \"type\": \"create:deploying\",\n" +
                                "               \"ingredients\": [\n" +
                                "                   { \"item\": \"createmechanisms:computing_mechanism\" },\n" +
                                "                   { \"item\": \"ae2:logic_processor\" }\n" +
                                "               ],\n" +
                                "               \"results\": [\n" +
                                "                   {\n" +
                                "                       \"item\": {\n" +
                                "                           \"id\": \"createmechanisms:computing_mechanism\"\n" +
                                "                       }\n" +
                                "                   }\n" +
                                "               ]\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"type\": \"create:deploying\",\n" +
                                "               \"ingredients\": [\n" +
                                "                   { \"item\": \"createmechanisms:computing_mechanism\" },\n" +
                                "                   { \"item\": \"ae2:calculation_processor\" }\n" +
                                "               ],\n" +
                                "               \"results\": [\n" +
                                "                   {\n" +
                                "                       \"item\": {\n" +
                                "                           \"id\": \"createmechanisms:computing_mechanism\"\n" +
                                "                       }\n" +
                                "                   }\n" +
                                "               ]\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"type\": \"create:deploying\",\n" +
                                "               \"ingredients\": [\n" +
                                "                   { \"item\": \"createmechanisms:computing_mechanism\" },\n" +
                                "                   { \"item\": \"ae2:engineering_processor\" }\n" +
                                "               ],\n" +
                                "               \"results\": [\n" +
                                "                   {\n" +
                                "                       \"item\": {\n" +
                                "                           \"id\": \"createmechanisms:computing_mechanism\"\n" +
                                "                       }\n" +
                                "                   }\n" +
                                "               ]\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"type\": \"create:pressing\",\n" +
                                "               \"ingredients\": [\n" +
                                "                   {\n" +
                                "                       \"item\": \"createmechanisms:computing_mechanism\"\n" +
                                "                   }\n" +
                                "               ],\n" +
                                "               \"results\": [\n" +
                                "                   {\n" +
                                "                       \"item\": {\n" +
                                "                           \"id\": \"createmechanisms:computing_mechanism\"\n" +
                                "                       }\n" +
                                "                   }\n" +
                                "               ]\n" +
                                "           }\n" +
                                "       ],\n" +
                                "       \"transitional_item\": {\n" +
                                "           \"item\": {\n" +
                                "               \"id\": \"createmechanisms:computing_mechanism\"\n" +
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
