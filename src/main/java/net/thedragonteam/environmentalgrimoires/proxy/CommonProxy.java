package net.thedragonteam.environmentalgrimoires.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thedragonteam.environmentalgrimoires.achievements.ModAchievements;
import net.thedragonteam.environmentalgrimoires.registry.ModBlocks;
import net.thedragonteam.environmentalgrimoires.registry.ModItems;

/**
 * Created by KewaiiGamer on 15/04/2017.
 */
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        //Items, Blocks, Entities
        ModBlocks.init();
        ModItems.init();
    }

    public void init(FMLInitializationEvent e) {
        registerEvents();
    }

    public void postInit(FMLPostInitializationEvent e) {

    }

    public void registerEvents() {
        ModAchievements.init();
    }
}
