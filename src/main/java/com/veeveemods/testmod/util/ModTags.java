package com.veeveemods.testmod.util;

import com.veeveemods.testmod.TestMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_TITANIUM_TOOL = tag("needs_titanium_tool");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(TestMod.MODID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(TestMod.MODID, name));
        }
    }
}
