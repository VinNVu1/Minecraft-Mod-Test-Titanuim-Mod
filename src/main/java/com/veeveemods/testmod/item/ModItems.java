package com.veeveemods.testmod.item;

import com.veeveemods.testmod.TestMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MODID);

    public static final RegistryObject<Item> TITANIUM = ITEMS.register("titanium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUTILE_ORE = ITEMS.register("rutile_ore",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_IRON_FRAGMENTS = ITEMS.register("raw_iron_fragment",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
