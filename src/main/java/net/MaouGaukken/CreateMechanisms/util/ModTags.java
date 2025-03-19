package net.MaouGaukken.CreateMechanisms.util;

import net.MaouGaukken.CreateMechanisms.CreateMechanisms;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

//Initializes the generation of the mod's Tags
public class ModTags {
    //Generate Item Tags
    public static class Items{
        //Create the "sawing_tools" tag
        public static final  TagKey<Item> SAWING_TOOLS = createTag("sawing_tools");

        /**
         * Helper method to create an Item Tag.
         * @param name Tag Name
         * @return Returns the corresponding TagKey<Item>
         */
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(CreateMechanisms.MOD_ID, name));
        }
    }
}
