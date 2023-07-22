package com.veeveemods.testmod.item;

import com.veeveemods.testmod.TestMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TestMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab TEST_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTab(CreativeModeTabEvent.Register event) {
        TEST_TAB = event.registerCreativeModeTab(new ResourceLocation(TestMod.MODID, "test_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.TITANIUM.get()))
                        .title(Component.translatable("creativemodetab.test_tab")));
    }
}
