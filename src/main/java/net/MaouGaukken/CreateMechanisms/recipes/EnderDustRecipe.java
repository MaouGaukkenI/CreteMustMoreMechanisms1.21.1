package net.MaouGaukken.CreateMechanisms.recipes;

import net.minecraft.client.Minecraft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class EnderDustRecipe {
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

    // Generates the item's recipe in Milling format
    public void EnderDustRecipeMilling(File folder){
        // selects the file to be used
        File file = new File(folder, "EnderDustRecipeMilling.js");
        generateFile(file);

        // If the file is empty, it performs revenue generation
        if (isFileEmpty(file)) {
            // Adds the recipe to the file
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(
                        "ServerEvents.recipes(event => {\n" +
                                "   event.custom({\n" +
                                "       \"type\": \"create:milling\",\n" +
                                "       \"ingredients\": [\n" +
                                "           {\n" +
                                "               \"item\": \"minecraft:ender_pearl\"\n" +
                                "           }\n" +
                                "       ],\n" +
                                "       \"processing_time\": 250,\n" +
                                "       \"results\": [\n" +
                                "           {\n" +
                                "               \"count\": 4,\n" +
                                "               \"item\": {\n" +
                                "                   \"id\": \"ae2:ender_dust\"\n" +
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
