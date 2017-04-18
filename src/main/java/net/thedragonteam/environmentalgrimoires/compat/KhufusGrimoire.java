package net.thedragonteam.environmentalgrimoires.compat;

import amerifrance.guideapi.api.GuideAPI;
import amerifrance.guideapi.api.GuideBook;
import amerifrance.guideapi.api.IGuideBook;
import amerifrance.guideapi.api.impl.Book;
import amerifrance.guideapi.category.CategoryItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.environmentalgrimoires.compat.category.CategoryIntroduction;

import javax.annotation.Nullable;
import java.awt.*;

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
        khufus_grimoire.setRegistryName(new ResourceLocation("eg", "khufusgrimoire"));
        return khufus_grimoire;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void handleModel(ItemStack itemStack) {
        GuideAPI.setModel(khufus_grimoire, new ResourceLocation("eg", "khufusgrimoire"), "khufus_grimoire");
    }

    @Override
    public void handlePost(ItemStack itemStack) {
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            khufus_grimoire.addCategory(new CategoryItemStack(CategoryIntroduction.buildCategory(), "guide.eg.category.introduction", new ItemStack(Blocks.DIRT)));
        }
        GameRegistry.addShapelessRecipe(itemStack, Items.BOOK, Items.PAPER);
    }


}
