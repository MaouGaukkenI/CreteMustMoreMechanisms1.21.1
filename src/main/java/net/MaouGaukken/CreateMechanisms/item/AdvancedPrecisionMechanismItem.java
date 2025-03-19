package net.MaouGaukken.CreateMechanisms.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

// AdvancedPrecisionMechanismItem Mod class, responsible for creating the item
public class AdvancedPrecisionMechanismItem extends Item {
    //Defines the item data
    public AdvancedPrecisionMechanismItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
