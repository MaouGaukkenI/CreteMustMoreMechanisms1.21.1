package net.MaouGaukken.CreateMechanisms.item;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import net.minecraft.world.item.Rarity;

// IncompleteWoodenMechanismItem Mod class, responsible for creating the item
public class IncompleteWoodenMechanismItem extends SequencedAssemblyItem {
    //Defines the item data
    public IncompleteWoodenMechanismItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
    }
}
