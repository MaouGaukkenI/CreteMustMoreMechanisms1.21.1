package net.MaouGaukken.CreateMechanisms.item;

import net.MaouGaukken.CreateMechanisms.init.ModFluids;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

// EnderiamItem Mod class, responsible for creating the item
public class EnderiamItem extends BucketItem {
    //Defines the item data
    public EnderiamItem() {
        super(ModFluids.ENDERIAM.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
    }
}

