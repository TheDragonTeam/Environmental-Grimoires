package net.thedragonteam.environmentalgrimoires.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thedragonteam.environmentalgrimoires.registry.ModBlocks;
import net.thedragonteam.environmentalgrimoires.registry.ModItems;

/**
 * Created by KewaiiGamer on 15/04/2017.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ModBlocks.registerModels();
        ModItems.registerModels();
    }



    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}
