package de.mikaminei.mikaminei;

import com.mojang.logging.LogUtils;
import de.mikaminei.mikaminei.block.ModBlocks;
import de.mikaminei.mikaminei.item.ModCreativeModeTabs;
import de.mikaminei.mikaminei.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
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
@Mod(Mikaminei.MOD_ID)
public class Mikaminei {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "mikaminei";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Mikaminei() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == ModCreativeModeTabs.MIKAMINEI) {
            event.accept(ModItems.STEEL_INGOT);
            event.accept(ModItems.RAW_STEEL);
            event.accept(ModItems.STEEL_NUGGET);
            event.accept(ModItems.STEEL_SWORD);

            event.accept(ModBlocks.STEEL_BLOCK);
            event.accept(ModBlocks.STEEL_ORE);
            event.accept(ModBlocks.DEEPSLATE_STEEL_ORE);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
