package net.MaouGaukken.CreateMechanisms.recipes;

import net.minecraft.client.Minecraft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class EnderiamRecipe {
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

    // Generates the fluid's recipe in Mixing format
    public void EnderiamRecipeMixing(File folder){

        // selects the file to be used
        File file = new File(folder, "EnderiamRecipeMixing.js");
        generateFile(file);

        // If the file is empty, it performs revenue generation
        if (isFileEmpty(file)) {
            // Adds the recipe to the file
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(
                        "ServerEvents.recipes(event => {\n" +
                                "   event.custom({\n" +
                                "       \"type\": \"create:mixing\",\n" +
                                "       \"heat_requirement\": \"heated\",\n" +
                                "       \"ingredients\": [\n" +
                                "           {\n" +
                                "               \"item\": \"minecraft:glowstone_dust\"\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"item\": \"ae2:ender_dust\"\n" +
                                "           },\n" +
                                "           {\n" +
                                "               \"type\": \"fluid_stack\",\n" +
                                "               \"amount\": 1000,\n" +
                                "               \"fluid\": \"minecraft:water\"\n" +
                                "           }\n" +
                                "       ],\n" +
                                "       \"results\": [\n" +
                                "           {\n" +
                                "             \"amount\": 1000,\n" +
                                "             \"id\": \"createmechanisms:enderiam\"\n" +
                                "           }\n" +
                                "       ]\n" +
                                "   })\n" +
                                "})\n"
                );
                writer.flush(); // Ensures that data is written to disk
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
