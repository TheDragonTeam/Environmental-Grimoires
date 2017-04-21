package net.thedragonteam.eg;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thedragonteam.eg.creativetabs.EGTab;
import net.thedragonteam.eg.proxy.CommonProxy;

@Mod(modid = EnvironmentalGrimoires.MODID, name = EnvironmentalGrimoires.MODNAME, version = EnvironmentalGrimoires.VERSION)
public class EnvironmentalGrimoires {

    public static final String MODID = "eg";
    public static final String MODNAME = "EnvironmentalGrimoires";
    public static final String VERSION = "1.11.2-0.0.1";

    public static final String CLIENT_PROXY = "net.thedragonteam.eg.proxy.ClientProxy";
    public static final String SERVER_PROXY = "net.thedragonteam.eg.proxy.ServerProxy";

    @Mod.Instance(MODID)
    public static EnvironmentalGrimoires instance;

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
    public static CommonProxy proxy = new CommonProxy();

    public static CreativeTabs TAB = new EGTab();

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
