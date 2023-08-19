package com.veeveemods.testmod.datagen;

import com.veeveemods.testmod.block.ModBlocks;
import com.veeveemods.testmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.TITANIUM_BLOCK.get());

        add(ModBlocks.RUTILE_ORE_BLOCK.get(),
                (block) -> createOreDrop(ModBlocks.RUTILE_ORE_BLOCK.get(), ModItems.RUTILE_ORE.get()));


//        add(ModBlocks.DEEPSLATE_RUTILE_ORE_BLOCK.get(),
//                (block) -> createMultiOreDrop(ModBlocks.DEEPSLATE_RUTILE_ORE_BLOCK.get(), List.of(ModItems.RUTILE_ORE.get(), ModItems.RAW_IRON_FRAGMENT.get())));

        add(ModBlocks.DEEPSLATE_RUTILE_ORE_BLOCK.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_RUTILE_ORE_BLOCK.get(), ModItems.RUTILE_ORE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;   //Providing all our custom blocks in an iterable form so that the class can continue using this
    }
}
