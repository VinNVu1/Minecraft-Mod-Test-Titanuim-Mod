package com.veeveemods.testmod.datagen;

import com.veeveemods.testmod.block.ModBlocks;
import com.veeveemods.testmod.item.ModItems;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item()
            .hasEnchantment(new EnchantmentPredicate(Enchantments
                    .SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.TITANIUM_BLOCK.get());

        add(ModBlocks.RUTILE_ORE_BLOCK.get(),
                (block) -> createMultiOreDrop(ModBlocks.RUTILE_ORE_BLOCK.get(), ModItems.RUTILE_ORE.get(), ModItems.RAW_IRON_FRAGMENTS.get()));

        add(ModBlocks.DEEPSLATE_RUTILE_ORE_BLOCK.get(),
                (block) -> createMultiOreDrop(ModBlocks.DEEPSLATE_RUTILE_ORE_BLOCK.get(), ModItems.RUTILE_ORE.get(), ModItems.RAW_IRON_FRAGMENTS.get()));

    }

    protected LootTable.Builder createMultiOreDrop(Block block, Item item1, Item item2) {
        return this.applyExplosionDecay(block,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem
                                        .lootTableItem(block)
                                        .when(HAS_SILK_TOUCH)
                                        .otherwise(LootItem
                                                .lootTableItem(item1)
                                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))))
                        .withPool(LootPool.lootPool()
                                .when(HAS_SILK_TOUCH.invert())
                                .add(LootItem
                                        .lootTableItem(item2)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)))
                                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))
        );
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;   //Providing all our custom blocks in an iterable form so that the class can continue using this
    }
}
