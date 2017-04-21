package net.thedragonteam.eg.registry;

import net.minecraft.block.Block;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.eg.blocks.AttackGenerator;

import static net.thedragonteam.eg.utils.Utilities.registerBlockRender;

/**
 * Created by KewaiiGamer on 15/04/2017.
 */
public class ModBlocks {

    public static Block attackGen;

    public static void initBlocks() {
        attackGen = new AttackGenerator();
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels() {
        registerBlockRender(attackGen);
    }
}
