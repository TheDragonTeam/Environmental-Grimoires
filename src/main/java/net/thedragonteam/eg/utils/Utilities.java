package net.thedragonteam.eg.utils;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static net.thedragonteam.eg.EnvironmentalGrimoires.MODID;
import static net.thedragonteam.eg.utils.UtilityType.NAMING;
import static net.thedragonteam.eg.utils.UtilityType.REGISTRY;
import static net.thedragonteam.thedragonlib.util.ItemStackUtils.getItem;

/**
 * Created by KewaiiGamer on 15/04/2017.
 */
public class Utilities {

    @Utility(REGISTRY)
    public static String setName(String name) {
        return c(MODID, ".", name);
    }

    @Utility(REGISTRY)
    public static String setLocation(String name) {
        return c(MODID, ":", name);
    }

    @Utility(REGISTRY)
    public static ResourceLocation setResourceLocation(String path) {
        return new ResourceLocation(MODID, path);
    }

    @Utility(NAMING)
    public static TextComponentTranslation setTextTranslation(String translationKey, Object... args) {
        return new TextComponentTranslation(translationKey, args);
    }

    @Utility(NAMING)
    public static String getTranslatedText(String translationKey, Object... args) {
        return setTextTranslation(translationKey, args).getFormattedText();
    }

    @Utility(NAMING)
    public static TextComponentString setText(String text) {
        return new TextComponentString(text);
    }

    @Utility(NAMING)
    public static String getText(String text) {
        return setText(text).getFormattedText();
    }

    @SideOnly(Side.CLIENT)
    public static void registerBlockRender(Block block) {
        if (block.getRegistryName() != null) {
            ModelLoader.setCustomModelResourceLocation(getItem(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
        }
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemRender(Item item) {
        if (item.getRegistryName() != null) {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }

    public static String c(String f, String s, String t) {
        return f + s + t;
    }

    public static TextComponentString addText(String text) {
        return new TextComponentString(text);
    }
}