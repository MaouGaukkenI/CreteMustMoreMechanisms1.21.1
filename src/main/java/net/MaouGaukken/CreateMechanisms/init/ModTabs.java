package net.MaouGaukken.CreateMechanisms.init;

import net.MaouGaukken.CreateMechanisms.CreateMechanisms;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * This class defines custom Creative Mode Tabs for the mod.
 */
public class ModTabs {
    // Registers a new DeferredRegister for Creative Mode Tabs under the mod's namespace
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateMechanisms.MOD_ID);

    /**
     * Mechanisms Tab: Contains various mechanical components used in the mod.
     * - Title: "item_group.createmechanisms.mechanisms" (translatable)
     * - Icon: Wooden Mechanism
     * - Items: Various mechanical parts (wooden, rubber, advanced, heat, zinc, computing, and ender mechanisms)
     */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MECHANISMS = REGISTRY.register("mechanisms",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("item_group.createmechanisms.mechanisms"))
                    .icon(() -> new ItemStack(ModItems.WOODEN_MECHANISM.get()))
                    .displayItems((parameters, tabData) -> {
                        tabData.accept(ModItems.WOODEN_MECHANISM.get());
                        tabData.accept(ModItems.RUBBER_MECHANISM.get());
                        tabData.accept(ModItems.ADVANCED_PRECISION_MECHANISM.get());
                        tabData.accept(ModItems.HEAT_MECHANISM.get());
                        tabData.accept(ModItems.ZINC_MECHANISM.get());
                        tabData.accept(ModItems.COMPUTING_MECHANISM.get());
                        tabData.accept(ModItems.ENDER_MECHANISM.get());
                    }).build());

    /**
     * Extra Items Tab: Contains additional materials and tools.
     * - Title: "item_group.createmechanisms.extra_items" (translatable)
     * - Icon: Cured Rubber
     * - Items: Various materials (rubber, bronze, enderiam bucket) and tools (copper, iron, and diamond saws)
     * - Appears after the Mechanisms tab
     */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXTRA_ITEMS = REGISTRY.register("extra_items",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("item_group.createmechanisms.extra_items"))
                    .icon(() -> new ItemStack(ModItems.CURED_RUBBER.get()))
                    .displayItems((parameters, tabData) -> {
                        tabData.accept(ModItems.CURED_RUBBER.get());
                        tabData.accept(ModItems.RUBBER.get());
                        tabData.accept(ModItems.BRONZE.get());
                        tabData.accept(ModItems.ENDERIAM_BUCKET.get());
                        tabData.accept(ModItems.COPPER_SAW.get());
                        tabData.accept(ModItems.IRON_SAW.get());
                        tabData.accept(ModItems.DIAMOND_SAW.get());
                    })
                    .withTabsBefore(MECHANISMS.getId()) // Ensures this tab appears after the Mechanisms tab
                    .build());
}
