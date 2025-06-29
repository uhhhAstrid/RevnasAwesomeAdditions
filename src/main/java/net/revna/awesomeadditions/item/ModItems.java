package net.revna.awesomeadditions.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.revna.awesomeadditions.AwesomeAdditions;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AwesomeAdditions.MOD_ID);

    // how to add items - first item - expanded formatting for ease of seeing the different parts
    public static final DeferredItem<Item> FIRST_ADDITION =
            ITEMS.register // takes "item name" and Item<T> as parameters
                    (
                "first_addition",
                      () -> new Item(new Item.Properties()) // "Item" takes "Item Properties" as a parameter. so scuffed
                    );

    // second item - collapsed example
    public static final DeferredItem<Item> SECOND_ADDITION = ITEMS.register("second_addition", () -> new Item(new Item.Properties()));

    // called by mod's constructor on mod startup
    // 1. builds item registry
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
