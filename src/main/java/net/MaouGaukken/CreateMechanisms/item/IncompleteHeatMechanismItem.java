package net.MaouGaukken.CreateMechanisms.item;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import net.minecraft.world.item.Rarity;

// IncompleteHeatMechanismItem Mod class, responsible for creating the item
public class IncompleteHeatMechanismItem extends SequencedAssemblyItem {
    //Defines the item data
    public IncompleteHeatMechanismItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
    }
}
