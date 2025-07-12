package net.revna.awesomeadditions.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.revna.awesomeadditions.AwesomeAdditions;
import net.revna.awesomeadditions.block.ModBlocks;

import java.util.function.Supplier;


public class ModCreativeModeTabs
{
    // whenever you make a registry in a class, you have to register it
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AwesomeAdditions.MOD_ID);

    // design the actual tab for items here
    public static final Supplier<CreativeModeTab> REVNAS_ITEMS_TAB = CREATIVE_MODE_TAB.register(
            "revnas_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.FIRST_ADDITION.get()))
                    .title(Component.translatable("creativetab.revnas_awesomeadditions.revnas_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.FIRST_ADDITION);
                        output.accept(ModItems.SECOND_ADDITION);
                    })
                    .build());

    // design the tab for blocks here
    public static final Supplier<CreativeModeTab> REVNAS_BLOCK_TAB = CREATIVE_MODE_TAB.register(
            "revnas_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.THIRD_ADDITION))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(AwesomeAdditions.MOD_ID, "revnas_items"))
                    .title(Component.translatable("creativetab.revnas_awesomeadditions.revnas_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.THIRD_ADDITION);
                        output.accept(ModBlocks.FOURTH_ADDITION);
                    })
                    .build());

    // register the registries
    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
