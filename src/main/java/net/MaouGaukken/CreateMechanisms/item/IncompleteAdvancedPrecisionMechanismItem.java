package net.MaouGaukken.CreateMechanisms.item;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
// IncompleteAdvancedPrecisionMechanismItem Mod class, responsible for creating the item
public class IncompleteAdvancedPrecisionMechanismItem extends SequencedAssemblyItem {
    //Defines the item data
    public IncompleteAdvancedPrecisionMechanismItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
    }
}
