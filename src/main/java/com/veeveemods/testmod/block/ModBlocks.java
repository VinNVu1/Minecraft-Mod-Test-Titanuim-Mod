package com.veeveemods.testmod.block;

import com.veeveemods.testmod.TestMod;
import com.veeveemods.testmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MODID);

    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> RUTILE_ORE_BLOCK = registerBlock("rutile_ore_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f)
                    .requiresCorrectToolForDrops(), UniformInt.of(2, 6)
            ));
    public static final RegistryObject<Block> DEEPSLATE_RUTILE_ORE_BLOCK = registerBlock("deepslate_rutile_ore_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(8f)
                    .requiresCorrectToolForDrops(), UniformInt.of(2, 6)
            ));
//
//    public static final RegistryObject<Block> RUTILE_ORE_BLOCK = registerBlock("rutile_ore_block",
//            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
//                    .strength(3.0F, 3.0F)
//                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)
//            ));
//
//    public static final RegistryObject<Block> DEEPSLATE_RUTILE_ORE_BLOCK = registerBlock("deepslate_rutile_ore_block",
//            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
//                    .strength(4.5F, 3.0F)
//                    .sound(SoundType.DEEPSLATE)
//                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)
//            ));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
