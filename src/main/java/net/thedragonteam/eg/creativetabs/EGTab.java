package net.thedragonteam.eg.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static net.thedragonteam.thedragonlib.util.ItemStackUtils.getItemStack;

/**
 * Created by KewaiiGamer on 15/04/2017.
 */
public class EGTab extends CreativeTabs {

    public EGTab() {
        super("eg");
    }

    @Override
    public ItemStack getTabIconItem() {
        return getItemStack(Item.getByNameOrId("guideapi:eg-khufu_grimoire"));
    }
}
