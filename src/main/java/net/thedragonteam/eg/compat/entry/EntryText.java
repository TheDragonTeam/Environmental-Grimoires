package net.thedragonteam.eg.compat.entry;

import amerifrance.guideapi.api.IPage;
import amerifrance.guideapi.entry.EntryResourceLocation;
import net.minecraft.util.ResourceLocation;

import java.util.List;

/**
 * Created by KewaiiGamer on 15/04/2017.
 */
public class EntryText extends EntryResourceLocation {
    public EntryText(List<IPage> pageList, String name, boolean unicode) {
        super(pageList, name, new ResourceLocation("eg", "textures/gui/khufus_grimoire.png"), unicode);
    }
}
