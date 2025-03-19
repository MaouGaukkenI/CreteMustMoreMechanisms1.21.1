package net.MaouGaukken.CreateMechanisms.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

// RubberMechanismItem Mod class, responsible for creating the item
public class RubberMechanismItem extends Item {
    //Defines the item data
    public RubberMechanismItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
