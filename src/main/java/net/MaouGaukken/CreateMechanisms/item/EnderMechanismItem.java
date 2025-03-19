package net.MaouGaukken.CreateMechanisms.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

// EnderMechanismItem Mod class, responsible for creating the item
public class EnderMechanismItem extends Item {
    //Defines the item data
    public EnderMechanismItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
