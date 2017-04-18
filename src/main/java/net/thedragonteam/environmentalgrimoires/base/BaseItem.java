package net.thedragonteam.environmentalgrimoires.base;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thedragonteam.environmentalgrimoires.EnvironmentalGrimoires;

import static net.thedragonteam.environmentalgrimoires.utils.Utilities.setName;

/**
 * Created by KewaiiGamer on 16/04/2017.
 */
public class BaseItem extends Item {
    public BaseItem(String name) {
        super();
        this.setUnlocalizedName(setName(name));
        this.setRegistryName(name);
        this.setCreativeTab(EnvironmentalGrimoires.TAB);
        GameRegistry.register(this);
    }
}
