package net.MaouGaukken.CreateMechanisms.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.SimpleTier;

/**
 * Class responsible for defining custom tool tiers for the mod.
 */
public class ModToolTiers {
    /**
     * Modified Iron tier with custom durability, efficiency, attack damage, and enchantability.
     * - Durability: 350
     * - Efficiency: 6.0F
     * - Attack Damage: 2.0F
     * - Enchantability: 14
     * - Repair Material: Iron Ingot
     */
    public static final Tier MODIFIED_IRON = new SimpleTier(
            BlockTags.NEEDS_IRON_TOOL,
            350, 6.0F, 2.0F, 14,
            () -> Ingredient.of(new ItemLike[]{Items.IRON_INGOT})
    );

    /**
     * Copper tier with custom durability, efficiency, attack damage, and enchantability.
     * - Durability: 280
     * - Efficiency: 6.0F
     * - Attack Damage: 2.0F
     * - Enchantability: 14
     * - Repair Material: Copper Ingot
     */
    public static final Tier COPPER = new SimpleTier(
            BlockTags.NEEDS_IRON_TOOL,
            280, 6.0F, 2.0F, 14,
            () -> Ingredient.of(new ItemLike[]{Items.COPPER_INGOT})
    );

    /**
     * Modified Diamond tier with enhanced durability and efficiency.
     * - Durability: 3500
     * - Efficiency: 8.0F
     * - Attack Damage: 3.0F
     * - Enchantability: 10
     * - Repair Material: Diamond
     */
    public static final Tier MODIFIED_DIAMOND = new SimpleTier(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            3500, 8.0F, 3.0F, 10,
            () -> Ingredient.of(new ItemLike[]{Items.DIAMOND})
    );
}
