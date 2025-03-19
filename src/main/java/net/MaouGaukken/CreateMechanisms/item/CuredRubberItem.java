package net.MaouGaukken.CreateMechanisms.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

// CuredRubberItem Mod class, responsible for creating the item
public class CuredRubberItem extends Item {
    //Defines the item data
    public CuredRubberItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
