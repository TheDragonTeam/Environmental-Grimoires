package net.thedragonteam.eg.base;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thedragonteam.eg.EnvironmentalGrimoires;
import net.thedragonteam.eg.utils.Utility;

import static net.thedragonteam.eg.utils.Utilities.setName;
import static net.thedragonteam.eg.utils.UtilityType.ITEM;

/**
 * Created by KewaiiGamer on 16/04/2017.
 */
@Utility(ITEM)
public class BaseItem extends Item {

    public BaseItem(String name) {
        this.setUnlocalizedName(setName(name));
        this.setRegistryName(name);
        this.setCreativeTab(EnvironmentalGrimoires.TAB);
        GameRegistry.register(this);
    }
}
