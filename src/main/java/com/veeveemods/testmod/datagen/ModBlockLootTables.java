package com.veeveemods.testmod.datagen;

import com.veeveemods.testmod.block.ModBlocks;
import com.veeveemods.testmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
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

        add(ModBlocks.DEEPSLATE_RUTILE_ORE_BLOCK.get(),
                (block) -> createMultiOreDrop(ModBlocks.DEEPSLATE_RUTILE_ORE_BLOCK.get(), ModItems.RUTILE_ORE.get(), ModItems.RAW_IRON_FRAGMENTS.get()));

    }

    /*
    * TODO: Figure out this block of code.
    *  We know we need 4 of those parameters but how can we utilize the builder?
    *  I have a builder method we can use on line 66 but it is not modified yet.
    *  Line 66 - 93 I'm using as references. It should give us something if we figure out how to combine them together.
    * */
    protected LootTable.Builder createMultiOreDrop(Block oreBlock, Item ore1, Item ore2, LootItemCondition.Builder builder) {
        return createSilkTouchDispatchTable(oreBlock,
                this.applyExplosionDecay(oreBlock,
                        LootTable.lootTable()
                                .withPool(LootPool.lootPool()
                                        .add(LootItem
                                                .lootTableItem(ore1).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))
                                .withPool(LootPool.lootPool()
                                        .add(LootItem
                                                .lootTableItem(ore2).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)))
                                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))))
        );

    }

    LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.RUTILE_ORE_BLOCK.get()).setProperties(StatePropertiesPredicate.Builder.properties());
    protected LootTable.Builder createOreDrop(Block oreBlock, Item ore1) {
        return createSilkTouchDispatchTable(oreBlock, this.applyExplosionDecay(oreBlock,
                LootItem.lootTableItem(ore1)
                        .apply(ApplyBonusCount
                                .addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
    protected LootTable.Builder createCropDrops(Block cropBlock, Item wheat, Item seed, LootItemCondition.Builder builder) {
        return this.applyExplosionDecay(cropBlock,
                LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem
                                .lootTableItem(wheat)
                                .when(builder)
                                .otherwise(LootItem.lootTableItem(seed))))
                .withPool(LootPool
                        .lootPool()
                        .when(builder)
                        .add(LootItem.lootTableItem(seed)
                                .apply(ApplyBonusCount
                                        .addBonusBinomialDistributionCount(Enchantments
                                                .BLOCK_FORTUNE, 0.5714286F, 3)))));
    }
    protected LootTable.Builder createLapisOreDrops(Block lapisOre) {
        return createSilkTouchDispatchTable(lapisOre, this.applyExplosionDecay(lapisOre, LootItem.lootTableItem(Items.LAPIS_LAZULI)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 9.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;   //Providing all our custom blocks in an iterable form so that the class can continue using this
    }
}
