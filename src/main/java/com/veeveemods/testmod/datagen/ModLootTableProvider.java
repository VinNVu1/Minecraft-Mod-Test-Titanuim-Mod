package com.veeveemods.testmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class ModLootTableProvider {

    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)));
    }

    // Define a helper method that creates a loot entry for a block and a list of items
//    public LootTable.Builder createMultiOreDrop(Block block, List<Item> items) {
//        LootTable.Builder builder = LootTable.lootTable();
//        for (Item item : items) {
//            LootPoolSingletonContainer.Builder<?> itemBuilder = LootItem.lootTableItem(item);
//            itemBuilder.apply(this.applyExplosionDecay(block, itemBuilder.apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
//            builder.add(itemBuilder);
//        }
//        LootPool.Builder poolBuilder = LootPool.lootPool()
//                .name("...")
//                .setRolls()
//                .add(LootItem.lootTableItem()
//                .apply(function1)
//                .apply(function2)
//                .when(condition1)
//                .when(condition2))
//    );
//        LootTable.Builder tableBuilder = LootTable.lootTable().withPool(poolBuilder);
//        return builder;
//    }





//    protected LootTable.Builder createOreDrop(Block p_250450_, Item p_249745_) {
//        return createSilkTouchDispatchTable(p_250450_, this.applyExplosionDecay(p_250450_, LootItem.lootTableItem(p_249745_).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
//    }
}
