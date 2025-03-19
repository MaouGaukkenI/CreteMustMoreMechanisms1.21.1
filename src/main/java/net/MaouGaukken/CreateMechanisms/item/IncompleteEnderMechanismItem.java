package net.MaouGaukken.CreateMechanisms.item;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import net.minecraft.world.item.Rarity;

// IncompleteEnderMechanismItem Mod class, responsible for creating the item
public class IncompleteEnderMechanismItem extends SequencedAssemblyItem {
    //Defines the item data
    public IncompleteEnderMechanismItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
    }
}
