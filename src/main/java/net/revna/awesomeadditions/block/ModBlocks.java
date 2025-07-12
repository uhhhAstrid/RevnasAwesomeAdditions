package net.revna.awesomeadditions.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.revna.awesomeadditions.AwesomeAdditions;
import net.revna.awesomeadditions.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AwesomeAdditions.MOD_ID);

    public static final DeferredBlock<Block> THIRD_ADDITION = registerBlock("third_addition",
            () -> new Block(BlockBehaviour.Properties.of()
                                            .strength(4f)
                                            .requiresCorrectToolForDrops()
                                            .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> FOURTH_ADDITION = registerBlock("fourth_addition",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.WOOL)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
    {
        // create and register block
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);

        // register the block's associated item
        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
