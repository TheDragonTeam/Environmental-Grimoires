package net.thedragonteam.eg.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import static net.thedragonteam.thedragonlib.util.ItemStackUtils.getItemStack;

/**
 * Created by sokratis12GR on 4/20/2017.
 */
public class ModRecipes {

    public static void initRecipes() {
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.khufuShield), "III", "GLG", " I ", 'I', Items.IRON_INGOT, 'L', Blocks.LAPIS_BLOCK, 'G', Items.GOLD_INGOT);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.khufuBow), " G ", "L L", "SSS", 'G', Blocks.GOLD_BLOCK, 'L', getItemStack(Items.DYE, 1, 4), 'S', ModItems.goldenString);

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.khufuSet[0]), "GLG", "D D", "   ", 'G', Blocks.GOLD_BLOCK, 'D', getItemStack(Items.DYE, 1, 4), 'L', Blocks.LAPIS_BLOCK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.khufuSet[1]), "L L", "WGW", "WWW", 'G', Blocks.GOLD_BLOCK, 'L', Blocks.LAPIS_BLOCK, 'W', getItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.khufuSet[2]), "WLW", "WGW", "   ", 'G', Blocks.GOLD_BLOCK, 'L', Blocks.LAPIS_BLOCK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.khufuSet[2]), "   ", "WLW", "WGW", 'G', Blocks.GOLD_BLOCK, 'L', Blocks.LAPIS_BLOCK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.khufuSet[3]), "LGL", "L L", "   ", 'G', Items.GOLD_INGOT, 'L', Items.LEATHER);

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.goldenString, 3), "GSG", "GSG", "SGS", 'G', Items.GOLD_INGOT, 'S', Items.STRING);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.khufuBow, 3), "  L", " BL", "G  ", 'G', Items.GOLD_INGOT, 'B', Blocks.GOLD_BLOCK, 'L', getItemStack(Items.DYE, 1, 4));

        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.attackGen, 1), "DID", "IPI","GIG", 'P', getItemStack(Blocks.PISTON), 'I', getItemStack(Blocks.IRON_BLOCK), 'D', Items.DIAMOND_SWORD, 'G', Items.GOLDEN_SWORD, 'I', Items.IRON_SWORD);
    }

}
