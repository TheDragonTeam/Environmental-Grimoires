package net.thedragonteam.eg.base;

import net.thedragonteam.eg.utils.Utility;

import static net.thedragonteam.eg.utils.UtilityType.ITEM;

/**
 * Created by KewaiiGamer on 16/04/2017.
 */
@Utility(ITEM)
public class BaseTool extends BaseItem {
    public BaseTool(String name) {
        super(name + "_pickaxe");
    }
}
