package net.MaouGaukken.CreateMechanisms.init;

import net.MaouGaukken.CreateMechanisms.CreateMechanisms;
import net.MaouGaukken.CreateMechanisms.item.*;

import net.MaouGaukken.CreateMechanisms.item.custom.SawItem;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

/**
 * This class defines custom Mod Items for the mod.
 */
public class ModItems {
    // Registering items using Deferred Register
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(CreateMechanisms.MOD_ID);

    // Registering different types of mechanism items with unique identifiers
    public static final DeferredItem<Item> WOODEN_MECHANISM = REGISTRY.register("wooden_mechanism", WoodenMechanismItem::new);
    public static final DeferredItem<Item> RUBBER_MECHANISM = REGISTRY.register("rubber_mechanism", RubberMechanismItem::new);
    public static final DeferredItem<Item> ADVANCED_PRECISION_MECHANISM = REGISTRY.register("advanced_precision_mechanism", AdvancedPrecisionMechanismItem::new);
    public static final DeferredItem<Item> HEAT_MECHANISM = REGISTRY.register("heat_mechanism", HeatMechanismItem::new);
    public static final DeferredItem<Item> ZINC_MECHANISM = REGISTRY.register("zinc_mechanism", ZincMechanismItem::new);
    public static final DeferredItem<Item> COMPUTING_MECHANISM = REGISTRY.register("computing_mechanism", ComputingMechanismItem::new);
    public static final DeferredItem<Item> ENDER_MECHANISM = REGISTRY.register("ender_mechanism", EnderMechanismItem::new);

    // Registering incomplete mechanism items
    public static final DeferredItem<Item> INCOMPLETE_WOODEN_MECHANISM = REGISTRY.register("incomplete_wooden_mechanism", IncompleteWoodenMechanismItem::new);
    public static final DeferredItem<Item> INCOMPLETE_RUBBER_MECHANISM = REGISTRY.register("incomplete_rubber_mechanism", IncompleteRubberMechanismItem::new);
    public static final DeferredItem<Item> INCOMPLETE_HEAT_MECHANISM = REGISTRY.register("incomplete_heat_mechanism", IncompleteHeatMechanismItem::new);
    public static final DeferredItem<Item> INCOMPLETE_ZINC_MECHANISM = REGISTRY.register("incomplete_zinc_mechanism", IncompleteZincMechanismItem::new);
    public static final DeferredItem<Item> INCOMPLETE_ADVANCED_PRECISION_MECHANISM = REGISTRY.register("incomplete_advanced_precision_mechanism", IncompleteAdvancedPrecisionMechanismItem::new);
    public static final DeferredItem<Item> INCOMPLETE_COMPUTING_MECHANISM = REGISTRY.register("incomplete_computing_mechanism", IncompleteComputingMechanismItem::new);
    public static final DeferredItem<Item> INCOMPLETE_ENDER_MECHANISM = REGISTRY.register("incomplete_ender_mechanism", IncompleteEnderMechanismItem::new);

    // Registering other raw materials and items
    public static final DeferredItem<Item> RUBBER = REGISTRY.register("rubber", RubberItem::new);
    public static final DeferredItem<Item> CURED_RUBBER = REGISTRY.register("cured_rubber", CuredRubberItem::new);
    public static final DeferredItem<Item> BRONZE = REGISTRY.register("bronze", BronzeItem::new);
    public static final DeferredItem<Item> ENDERIAM_BUCKET = REGISTRY.register("enderiam_bucket", EnderiamItem::new);

    // Registering saw items with different materials and tool attributes
    public static final DeferredItem<SawItem> IRON_SAW = REGISTRY.register("iron_saw",
            () -> new SawItem(ModToolTiers.MODIFIED_IRON, new Item.Properties().attributes(
                    SawItem.createAttributes(ModToolTiers.MODIFIED_IRON, 6.0F, -3.1F))));

    public static final DeferredItem<SawItem> COPPER_SAW = REGISTRY.register("copper_saw",
            () -> new SawItem(ModToolTiers.COPPER, new Item.Properties().attributes(
                    SawItem.createAttributes(ModToolTiers.COPPER, 6.0F, -3.1F))));

    public static final DeferredItem<SawItem> DIAMOND_SAW = REGISTRY.register("diamond_saw",
            () -> new SawItem(ModToolTiers.MODIFIED_DIAMOND, new Item.Properties().attributes(
                    SawItem.createAttributes(ModToolTiers.MODIFIED_DIAMOND, 6.0F, -3.1F))));
}