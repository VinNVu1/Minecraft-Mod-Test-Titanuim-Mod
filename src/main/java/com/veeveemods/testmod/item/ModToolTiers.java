package com.veeveemods.testmod.item;

import com.veeveemods.testmod.TestMod;
import com.veeveemods.testmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier TITANIUM = TierSortingRegistry.registerTier(
            new ForgeTier(2, 1300, 3, -2.4F, 14,
                    ModTags.Blocks.NEEDS_TITANIUM_TOOL, () -> Ingredient.of(ModItems.TITANIUM.get())),
            new ResourceLocation(TestMod.MODID, "titanium"),
            List.of(Tiers.IRON),
            List.of(Tiers.DIAMOND));
}
