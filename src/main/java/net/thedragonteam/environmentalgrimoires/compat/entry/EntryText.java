package net.thedragonteam.environmentalgrimoires.compat.entry;

import amerifrance.guideapi.api.IPage;
import amerifrance.guideapi.entry.EntryResourceLocation;
import net.minecraft.util.ResourceLocation;

import java.util.List;

/**
 * Created by KewaiiGamer on 15/04/2017.
 */
public class EntryText extends EntryResourceLocation {
    public EntryText(List<IPage> pageList, String name, boolean unicode) {
        super(pageList, name, new ResourceLocation("khufus_grimoire", "textures/gui/khufus_grimoire"), unicode);
    }

    public EntryText(List<IPage> pageList, String name) {
        this(pageList, name, false);
    }
}
