package com.veeveemods.testmod;

import com.mojang.logging.LogUtils;
import com.veeveemods.testmod.block.ModBlocks;
import com.veeveemods.testmod.item.ModCreativeModeTabs;
import com.veeveemods.testmod.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TestMod.MODID)
public class TestMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "testmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "testmod" namespace

    public TestMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if(event.getTab() == ModCreativeModeTabs.TEST_TAB) {
            event.accept(ModItems.TITANIUM);
            event.accept(ModItems.RUTILE_ORE);
            event.accept(ModItems.RAW_IRON_FRAGMENTS);
            event.accept(ModBlocks.TITANIUM_BLOCK);
            event.accept(ModBlocks.RUTILE_ORE_BLOCK);
            event.accept(ModBlocks.DEEPSLATE_RUTILE_ORE_BLOCK);
        }

        if(event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.TITANIUM);
            event.accept(ModItems.RUTILE_ORE);
            event.accept(ModItems.RAW_IRON_FRAGMENTS);
        }

        if(event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.RUTILE_ORE_BLOCK);
            event.accept(ModBlocks.DEEPSLATE_RUTILE_ORE_BLOCK);
        }

            if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.TITANIUM_BLOCK);
        }

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
