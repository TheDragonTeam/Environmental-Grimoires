package net.thedragonteam.eg.compat.category;

import amerifrance.guideapi.api.IPage;
import amerifrance.guideapi.api.impl.abstraction.EntryAbstract;
import amerifrance.guideapi.api.util.PageHelper;
import amerifrance.guideapi.api.util.TextHelper;
import net.minecraft.util.ResourceLocation;
import net.thedragonteam.eg.EnvironmentalGrimoires;
import net.thedragonteam.eg.compat.entry.EntryText;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by KewaiiGamer on 20/04/2017.
 */
public class CategoryMachinery {
    public static Map<ResourceLocation, EntryAbstract> buildCategory() {
        Map<ResourceLocation, EntryAbstract> entries = new LinkedHashMap<>();
        String keyBase = "guide." + EnvironmentalGrimoires.MODID + ".entry.machinery.";

        List<IPage> attackGeneratorPage = new ArrayList<>();
        attackGeneratorPage.addAll(PageHelper.pagesForLongText(TextHelper.localize(keyBase + "attackgenerator" + ".info").replace("<br>", "\n"), 370));
        entries.put(new ResourceLocation(keyBase + "attackgenerator"), new EntryText(attackGeneratorPage, TextHelper.localize(keyBase + "attackgenerator"), true));

        return entries;
    }
}
