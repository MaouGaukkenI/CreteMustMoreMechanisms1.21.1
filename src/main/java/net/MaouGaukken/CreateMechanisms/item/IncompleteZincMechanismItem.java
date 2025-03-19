package net.MaouGaukken.CreateMechanisms.item;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import net.minecraft.world.item.Rarity;

// IncompleteZincMechanismItem Mod class, responsible for creating the item
public class IncompleteZincMechanismItem extends SequencedAssemblyItem {
    //Defines the item data
    public IncompleteZincMechanismItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
    }
}
