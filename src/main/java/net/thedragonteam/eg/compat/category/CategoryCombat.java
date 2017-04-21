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
public class CategoryCombat {
    public static Map<ResourceLocation, EntryAbstract> buildCategory() {
        Map<ResourceLocation, EntryAbstract> entries = new LinkedHashMap<>();
        String keyBase = "guide." + EnvironmentalGrimoires.MODID + ".entry.combat.";

        List<IPage> armorPages = new ArrayList<>();
        armorPages.addAll(PageHelper.pagesForLongText(TextHelper.localize(keyBase + "armor" + ".info").replace("<br>", "\n"), 370));
        entries.put(new ResourceLocation(keyBase + "armor"), new EntryText(armorPages, TextHelper.localize(keyBase + "armor"), true));

        List<IPage> swordPages = new ArrayList<>();
        swordPages.addAll(PageHelper.pagesForLongText(TextHelper.localize(keyBase + "sword" + ".info").replace("<br>", "\n"), 370));
        entries.put(new ResourceLocation(keyBase + "sword"), new EntryText(swordPages, TextHelper.localize(keyBase + "sword"), true));

        List<IPage> bowPages = new ArrayList<>();
        bowPages.addAll(PageHelper.pagesForLongText(TextHelper.localize(keyBase + "bow" + ".info").replace("<br>", "\n"), 370));
        entries.put(new ResourceLocation(keyBase + "bow"), new EntryText(bowPages, TextHelper.localize(keyBase + "bow"), true));

        List<IPage> shieldPages = new ArrayList<>();
        shieldPages.addAll(PageHelper.pagesForLongText(TextHelper.localize(keyBase + "shield" + ".info").replace("<br>", "\n"), 370));
        entries.put(new ResourceLocation(keyBase + "shield"), new EntryText(shieldPages, TextHelper.localize(keyBase + "shield"), true));

        return entries;
    }
}
