package net.MaouGaukken.CreateMechanisms.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

// ComputingMechanismItem Mod class, responsible for creating the item
public class ComputingMechanismItem extends Item {
    //Defines the item data
    public ComputingMechanismItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
