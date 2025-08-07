package net.MaouGaukken.CreateMechanisms.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

// HeatMechanismItem Mod class, responsible for creating the item
public class RedstoneMechanismItem extends Item {
    //Defines the item data
    public RedstoneMechanismItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
