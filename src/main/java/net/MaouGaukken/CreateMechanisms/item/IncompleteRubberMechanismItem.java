package net.MaouGaukken.CreateMechanisms.item;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import net.minecraft.world.item.Rarity;

// IncompleteRubberMechanismItem Mod class, responsible for creating the item
public class IncompleteRubberMechanismItem extends SequencedAssemblyItem {
    //Defines the item data
    public IncompleteRubberMechanismItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
    }
}
