package net.thedragonteam.environmentalgrimoires.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static net.thedragonteam.thedragonlib.util.ItemStackUtils.getItemStack;

/**
 * Created by KewaiiGamer on 15/04/2017.
 */
public class EGTab extends CreativeTabs {

    public EGTab() {
        super("Environmental Grimoires");
    }

    @Override
    public ItemStack getTabIconItem() {
        return getItemStack(Blocks.DIRT);
    }
}
