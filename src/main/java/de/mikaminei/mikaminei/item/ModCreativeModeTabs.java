package de.mikaminei.mikaminei.item;

import de.mikaminei.mikaminei.Mikaminei;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Mikaminei.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab MIKAMINEI;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        MIKAMINEI = event.registerCreativeModeTab(new ResourceLocation(Mikaminei.MOD_ID, "mikaminei"),
                builder -> builder.icon(() -> new ItemStack(ModItems.STEEL_INGOT.get()))
                        .title(Component.translatable("creativemodetab.mikaminei")));
    }
}
