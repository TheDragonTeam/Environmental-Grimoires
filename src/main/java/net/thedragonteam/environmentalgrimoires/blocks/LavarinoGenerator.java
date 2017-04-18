package net.thedragonteam.environmentalgrimoires.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by KewaiiGamer on 15/04/2017.
 */
public class LavarinoGenerator extends BaseGenerator implements ITileEntityProvider {

    public int energyProduced;

    public LavarinoGenerator() {
        super("lavarino", null);
    }

    @Override
    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor) {
        if (world.getBlockState(neighbor).equals(Blocks.LAVA.getBlockState())) {
            energyProduced = 10;
        }
        if (world.getBlockState(neighbor).equals(Blocks.FLOWING_LAVA)) {
            energyProduced = 5;
        }
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        final ITextComponent signText = new TextComponentString(TextFormatting.GREEN + String.valueOf(energyProduced + "RF"));
        playerIn.sendStatusMessage(signText, false);
        return true;
    }
}
