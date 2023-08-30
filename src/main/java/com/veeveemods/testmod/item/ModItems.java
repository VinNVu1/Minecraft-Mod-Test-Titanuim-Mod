package com.veeveemods.testmod.item;

import com.veeveemods.testmod.TestMod;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword",
            () -> new SwordItem(ModToolTiers.TITANIUM, 4, 2,  new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.TITANIUM, 1, 1,  new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe",
            () -> new AxeItem(ModToolTiers.TITANIUM, 7, 1,  new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel",
            () -> new ShovelItem(ModToolTiers.TITANIUM, 0, 0,  new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe",
            () -> new HoeItem(ModToolTiers.TITANIUM, 0, 0,  new Item.Properties()));

    //TODO: MAKE TITANIUM SHIELD THAT USE 1 TITANIUM AND 6 IRON


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
