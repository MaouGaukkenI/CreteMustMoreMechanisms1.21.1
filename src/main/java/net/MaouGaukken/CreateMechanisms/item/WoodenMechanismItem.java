package net.MaouGaukken.CreateMechanisms.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

// WoodenMechanismItem Mod class, responsible for creating the item
public class WoodenMechanismItem extends Item {
    //Defines the item data
    public WoodenMechanismItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
