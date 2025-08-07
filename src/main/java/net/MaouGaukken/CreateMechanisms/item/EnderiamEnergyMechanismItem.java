package net.MaouGaukken.CreateMechanisms.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

// AdvancedPrecisionMechanismItem Mod class, responsible for creating the item
public class EnderiamEnergyMechanismItem extends Item {
    //Defines the item data
    public EnderiamEnergyMechanismItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
