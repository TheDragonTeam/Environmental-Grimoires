package net.thedragonteam.environmentalgrimoires.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thedragonteam.environmentalgrimoires.tileentities.BaseGeneratorTE;

import static net.thedragonteam.environmentalgrimoires.utils.Utilities.setLocation;

/**
 * Created by KewaiiGamer on 17/04/2017.
 */
public class MiningGenerator extends BaseGenerator implements ITileEntityProvider {

    public MiningGenerator() {
        super("mining", null);
        GameRegistry.registerTileEntity(BaseGeneratorTE.class, setLocation("attackgen_te"));
    }
}
