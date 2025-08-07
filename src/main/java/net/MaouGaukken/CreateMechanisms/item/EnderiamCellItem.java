package net.MaouGaukken.CreateMechanisms.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

// BronzeItem Mod class, responsible for creating the item
public class EnderiamCellItem extends Item{
    //Defines the item data
    public EnderiamCellItem() {
        super(new Properties().stacksTo(16).rarity(Rarity.COMMON));
    }
}
