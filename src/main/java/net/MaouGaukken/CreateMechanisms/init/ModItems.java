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
    public static final DeferredItem<Item> REDSTONE_MECHANISM = REGISTRY.register("redstone_mechanism", RedstoneMechanismItem::new);
    public static final DeferredItem<Item> BASIC_ENERGY_MECHANISM = REGISTRY.register("basic_energy_mechanism", BasicEnergyMechanismItem::new);
    public static final DeferredItem<Item> IRON_ENERGY_MECHANISM = REGISTRY.register("iron_energy_mechanism", IronEnergyMechanismItem::new);
    public static final DeferredItem<Item> GOLDEN_ENERGY_MECHANISM = REGISTRY.register("golden_energy_mechanism", GoldenEnergyMechanismItem::new);
    public static final DeferredItem<Item> DIAMOND_ENERGY_MECHANISM = REGISTRY.register("diamond_energy_mechanism", DiamondEnergyMechanismItem::new);
    public static final DeferredItem<Item> ENDERIAM_ENERGY_MECHANISM = REGISTRY.register("enderiam_energy_mechanism", EnderiamEnergyMechanismItem::new);

    // Registering incomplete mechanism items
    public static final DeferredItem<Item> INCOMPLETE_WOODEN_MECHANISM = REGISTRY.register("incomplete_wooden_mechanism", IncompleteWoodenMechanismItem::new);
    public static final DeferredItem<Item> INCOMPLETE_RUBBER_MECHANISM = REGISTRY.register("incomplete_rubber_mechanism", IncompleteRubberMechanismItem::new);
    public static final DeferredItem<Item> INCOMPLETE_HEAT_MECHANISM = REGISTRY.register("incomplete_heat_mechanism", IncompleteHeatMechanismItem::new);
    public static final DeferredItem<Item> INCOMPLETE_ZINC_MECHANISM = REGISTRY.register("incomplete_zinc_mechanism", IncompleteZincMechanismItem::new);
    public static final DeferredItem<Item> INCOMPLETE_ADVANCED_PRECISION_MECHANISM = REGISTRY.register("incomplete_advanced_precision_mechanism", IncompleteAdvancedPrecisionMechanismItem::new);
    public static final DeferredItem<Item> INCOMPLETE_COMPUTING_MECHANISM = REGISTRY.register("incomplete_computing_mechanism", IncompleteComputingMechanismItem::new);
    public static final DeferredItem<Item> INCOMPLETE_ENDER_MECHANISM = REGISTRY.register("incomplete_ender_mechanism", IncompleteEnderMechanismItem::new);
    public static final DeferredItem<Item> INCOMPLETE_REDSTONE_MECHANISM = REGISTRY.register("incomplete_redstone_mechanism", IncompleteRedstoneMechanismItem::new);
    public static final DeferredItem<Item> INCOMPLETE_BASIC_ENERGY_MECHANISM = REGISTRY.register("incomplete_basic_energy_mechanism", IncompleteBasicEnergyMechanismItem::new);
    public static final DeferredItem<Item> INCOMPLETE_IRON_ENERGY_MECHANISM = REGISTRY.register("incomplete_iron_energy_mechanism", IncompleteIronEnergyMechanismItem::new);
    public static final DeferredItem<Item> INCOMPLETE_GOLDEN_ENERGY_MECHANISM = REGISTRY.register("incomplete_golden_energy_mechanism", IncompleteGoldenEnergyMechanismItem::new);
    public static final DeferredItem<Item> INCOMPLETE_DIAMOND_ENERGY_MECHANISM = REGISTRY.register("incomplete_diamond_energy_mechanism", IncompleteDiamondEnergyMechanismItem::new);
    public static final DeferredItem<Item> INCOMPLETE_ENDERIAM_ENERGY_MECHANISM = REGISTRY.register("incomplete_enderiam_energy_mechanism", IncompleteEnderiamEnergyMechanismItem::new);

    // Registering other raw materials and items
    public static final DeferredItem<Item> RUBBER = REGISTRY.register("rubber", RubberItem::new);
    public static final DeferredItem<Item> CURED_RUBBER = REGISTRY.register("cured_rubber", CuredRubberItem::new);
    public static final DeferredItem<Item> BRONZE = REGISTRY.register("bronze", BronzeItem::new);
    public static final DeferredItem<Item> ENDERIAM_BUCKET = REGISTRY.register("enderiam_bucket", EnderiamItem::new);
    public static final DeferredItem<Item> ENERGY_CELL = REGISTRY.register("energy_cell", EnergyCellItem::new);
    public static final DeferredItem<Item> ENDERIAM_CELL = REGISTRY.register("enderiam_cell", EnderiamCellItem::new);

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