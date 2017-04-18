package net.thedragonteam.environmentalgrimoires.registry;

import net.minecraft.block.Block;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.environmentalgrimoires.blocks.AttackGenerator;
import net.thedragonteam.environmentalgrimoires.blocks.LavarinoGenerator;

import static net.thedragonteam.environmentalgrimoires.utils.Utilities.registerBlockRender;

/**
 * Created by KewaiiGamer on 15/04/2017.
 */
public class ModBlocks {

    public static Block attackGen;
    public static Block lavarinoGen;

    public static void init() {
        attackGen = new AttackGenerator();
        lavarinoGen = new LavarinoGenerator();
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels() {
        registerBlockRender(attackGen);
        registerBlockRender(lavarinoGen);
    }
}
