package net.MaouGaukken.CreateMechanisms.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

// ZincMechanismItem Mod class, responsible for creating the item
public class ZincMechanismItem extends Item {
    //Defines the item data
    public ZincMechanismItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
