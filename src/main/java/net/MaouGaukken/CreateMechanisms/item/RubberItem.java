package net.MaouGaukken.CreateMechanisms.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

// RubberItem Mod class, responsible for creating the item
public class RubberItem extends Item {
    //Defines the item data
    public RubberItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
