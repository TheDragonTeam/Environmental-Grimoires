package net.thedragonteam.environmentalgrimoires.achievements;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;
import net.thedragonteam.environmentalgrimoires.EnvironmentalGrimoires;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KewaiiGamer on 14/04/2017.
 */
public class ModAchievements {

    public static Achievement welcomeToEnvironmentalGrimoires;
    public static Achievement environmentalGrimoires;

    public static ArrayList<AchievementEG> normalCraftingAchievements = new ArrayList<>();

    public static void init() {
        welcomeToEnvironmentalGrimoires = new AchievementEG("join_world", 0, 0, Blocks.CRAFTING_TABLE, AchievementList.OPEN_INVENTORY).setNormalCrafting(new ItemStack(Blocks.CRAFTING_TABLE)).setSpecial();
        AchievementPage egAchievementPage = new AchievementPage(EnvironmentalGrimoires.MODNAME, AchievementEG.achievements.toArray(new Achievement[AchievementEG.achievements.size()]));
        AchievementPage.registerAchievementPage(egAchievementPage);
    }

    public static class AchievementEG extends Achievement {

        public static List<Achievement> achievements = new ArrayList<>();
        ItemStack[] triggerItems;

        public AchievementEG(String name, int x, int y, Item icon, Achievement parent) {
            this(name, x, y, new ItemStack(icon), parent);
        }

        public AchievementEG(String name, int x, int y, Block icon, Achievement parent) {
            this(name, x, y, new ItemStack(icon), parent);
        }

        public AchievementEG(String name, int x, int y, ItemStack icon, Achievement parent) {
            super("achievement.eg." + name, "eg." + name, x, y, icon, parent);
            achievements.add(this);
            registerStat();
        }

        public AchievementEG setNormalCrafting(ItemStack... triggerItems) {
            this.triggerItems = triggerItems;
            normalCraftingAchievements.add(this);
            return this;
        }
    }
}
