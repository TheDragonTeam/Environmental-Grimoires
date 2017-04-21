package net.thedragonteam.eg.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thedragonteam.eg.achievements.ModAchievements;
import net.thedragonteam.eg.events.EntityEvents;
import net.thedragonteam.eg.registry.ModBlocks;
import net.thedragonteam.eg.registry.ModEntities;
import net.thedragonteam.eg.registry.ModItems;
import net.thedragonteam.eg.registry.ModRecipes;
import net.thedragonteam.eg.tileentities.BaseGeneratorTE;

import static net.thedragonteam.eg.utils.Utilities.setLocation;

/**
 * Created by KewaiiGamer on 15/04/2017.
 */
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        //Items, Blocks, Entities
        ModBlocks.initBlocks();
        ModItems.initItems();
        ModEntities.initEntities();
        registerTileEntities();
    }

    public void init(FMLInitializationEvent e) {
        registerEvents();
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    public void registerTileEntities() {
        GameRegistry.registerTileEntity(BaseGeneratorTE.class, setLocation("base_gen_te"));
    }

    public void registerEvents() {
        MinecraftForge.EVENT_BUS.register(EntityEvents.class);
        ModAchievements.initAchievements();
        ModRecipes.initRecipes();
    }
}
