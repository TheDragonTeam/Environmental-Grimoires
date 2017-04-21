package net.thedragonteam.eg.base;

import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thedragonteam.eg.EnvironmentalGrimoires;

import static net.thedragonteam.eg.utils.Utilities.setName;

/**
 * Created by sokratis12GR on 4/20/2017.
 */
public class BaseSword extends ItemSword {

    public BaseSword(ToolMaterial material, String name) {
        super(material);
        this.setUnlocalizedName(setName(name));
        this.setRegistryName(name);
        this.setCreativeTab(EnvironmentalGrimoires.TAB);
        GameRegistry.register(this);
    }
}
