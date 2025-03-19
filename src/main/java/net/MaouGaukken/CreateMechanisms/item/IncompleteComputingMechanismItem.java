package net.MaouGaukken.CreateMechanisms.item;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import net.minecraft.world.item.Rarity;

// IncompleteComputingMechanismItem Mod class, responsible for creating the item
public class IncompleteComputingMechanismItem extends SequencedAssemblyItem {
    //Defines the item data
    public IncompleteComputingMechanismItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
    }
}
