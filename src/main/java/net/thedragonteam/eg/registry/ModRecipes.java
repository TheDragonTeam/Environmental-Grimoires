package net.thedragonteam.eg.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

import static net.minecraftforge.fml.common.registry.GameRegistry.addShapedRecipe;
import static net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE;
import static net.thedragonteam.thedragonlib.util.ItemStackUtils.getItemStack;

/**
 * Created by sokratis12GR on 4/20/2017.
 */
public class ModRecipes {

    public static void initRecipes() {
        addShapedRecipe(getItemStack(ModItems.khufuShield), "III", "GLG", " I ", 'I', Items.IRON_INGOT, 'L', Blocks.LAPIS_BLOCK, 'G', Items.GOLD_INGOT);
        addShapedRecipe(getItemStack(ModItems.khufuBow), " G ", "L L", "SSS", 'G', Blocks.GOLD_BLOCK, 'L', getItemStack(Items.DYE, 1, 4), 'S', ModItems.goldenString);
        addShapedRecipe(getItemStack(ModItems.khufuSet[0]), "GLG", "D D", "   ", 'G', Blocks.GOLD_BLOCK, 'D', getItemStack(Items.DYE, 1, 4), 'L', Blocks.LAPIS_BLOCK);
        addShapedRecipe(getItemStack(ModItems.khufuSet[1]), "L L", "WGW", "WWW", 'G', Blocks.GOLD_BLOCK, 'L', Blocks.LAPIS_BLOCK, 'W', getItemStack(Blocks.WOOL, 1, WILDCARD_VALUE));
        addShapedRecipe(getItemStack(ModItems.khufuSet[2]), "WLW", "WGW", "   ", 'G', Blocks.GOLD_BLOCK, 'L', Blocks.LAPIS_BLOCK, 'W', getItemStack(Blocks.WOOL, 1, WILDCARD_VALUE));
        addShapedRecipe(getItemStack(ModItems.khufuSet[2]), "   ", "WLW", "WGW", 'G', Blocks.GOLD_BLOCK, 'L', Blocks.LAPIS_BLOCK, 'W', getItemStack(Blocks.WOOL, 1, WILDCARD_VALUE));
        addShapedRecipe(getItemStack(ModItems.khufuSet[3]), "LGL", "L L", "   ", 'G', Items.GOLD_INGOT, 'L', Items.LEATHER);
        addShapedRecipe(getItemStack(ModItems.goldenString, 3, 0), "GSG", "GSG", "SGS", 'G', Items.GOLD_INGOT, 'S', Items.STRING);
        //  GameRegistry.addShapedRecipe(getItemStack(ModItems.khufuBow, 3), "  L", " BL", "G  ", 'G', Items.GOLD_INGOT, 'B', Blocks.GOLD_BLOCK, 'L', getItemStack(Items.DYE, 1, 4));

        addShapedRecipe(getItemStack(ModBlocks.attackGen, 1, 0), "DID", "IPI", "GIG", 'P', Blocks.PISTON, 'I', Blocks.IRON_BLOCK, 'D', Items.DIAMOND_SWORD, 'G', Items.GOLDEN_SWORD, 'I', Items.IRON_SWORD);
    }

}
