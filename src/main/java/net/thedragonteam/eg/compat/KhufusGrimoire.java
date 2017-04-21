package net.thedragonteam.eg.compat;

import amerifrance.guideapi.api.GuideAPI;
import amerifrance.guideapi.api.GuideBook;
import amerifrance.guideapi.api.IGuideBook;
import amerifrance.guideapi.api.impl.Book;
import amerifrance.guideapi.category.CategoryItemStack;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.eg.compat.category.CategoryCombat;
import net.thedragonteam.eg.compat.category.CategoryIntroduction;
import net.thedragonteam.eg.compat.category.CategoryMachinery;
import net.thedragonteam.eg.registry.ModBlocks;
import net.thedragonteam.eg.registry.ModItems;

import javax.annotation.Nullable;
import java.awt.*;

import static net.thedragonteam.eg.utils.Utilities.setResourceLocation;
import static net.thedragonteam.thedragonlib.util.ItemStackUtils.getItemStack;

/**
 * Created by KewaiiGamer on 15/04/2017.
 */
@GuideBook
public class KhufusGrimoire implements IGuideBook {

    public static Book khufus_grimoire;

    @Nullable
    @Override
    public Book buildBook() {
        khufus_grimoire = new Book();
        khufus_grimoire.setTitle("Khufu's Grimoire");
        khufus_grimoire.setDisplayName("Khufu's Grimoire");
        khufus_grimoire.setAuthor("Environmental Grimoires");
        khufus_grimoire.setColor(Color.ORANGE);
        khufus_grimoire.setRegistryName(setResourceLocation("khufu_grimoire"));
        return khufus_grimoire;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void handleModel(ItemStack itemStack) {
        GuideAPI.setModel(khufus_grimoire, setResourceLocation("khufu_grimoire"), "khufu_grimoire");
    }

    @Override
    public void handlePost(ItemStack itemStack) {
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            khufus_grimoire.addCategory(new CategoryItemStack(CategoryIntroduction.buildCategory(), "guide.eg.category.introduction", getItemStack(Item.getByNameOrId("guideapi:eg-khufu_grimoire"))));
            khufus_grimoire.addCategory(new CategoryItemStack(CategoryCombat.buildCategory(), "guide.eg.category.combat", getItemStack(ModItems.khufuSword)));
            khufus_grimoire.addCategory(new CategoryItemStack(CategoryMachinery.buildCategory(), "guide.eg.category.machinery", getItemStack(ModBlocks.attackGen)));
        }
        GameRegistry.addShapelessRecipe(itemStack, Items.BOOK, Items.PAPER);
    }
}
