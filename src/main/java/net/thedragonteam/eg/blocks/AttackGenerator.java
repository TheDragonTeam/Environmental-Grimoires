package net.thedragonteam.eg.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.thedragonteam.eg.tileentities.BaseGeneratorTE;

import static net.thedragonteam.eg.utils.Utilities.addText;

/**
 * Created by KewaiiGamer on 15/04/2017.
 */
public class AttackGenerator extends BaseGenerator implements ITileEntityProvider {
    public static int FEProduceInt;
    public float FEProduce;

    public AttackGenerator() {
        super("attack", new BaseGeneratorTE());
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        final ItemStack held = playerIn.getHeldItemMainhand();
        if (worldIn.isRemote) return;
        if (!held.isEmpty()) {
            if (held.getItem() instanceof ItemSword) {
                FEProduce = (((ItemSword) held.getItem()).getDamageVsEntity() + 3.0F) * 2;
                FEProduceInt = (int) Math.floor(FEProduce);
                getTE(worldIn, pos).maxReceive = FEProduceInt;
                getTE(worldIn, pos).isReceiving = true;
                if (held.getItem().isDamageable()) held.damageItem(1, playerIn);
                final ITextComponent signText = addText(TextFormatting.LIGHT_PURPLE + String.valueOf(getTE(worldIn, pos).flow + "FE/t"));
                playerIn.sendStatusMessage(signText, false);
            }
        }
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote) return true;
        final ITextComponent signText = new TextComponentString(TextFormatting.GREEN + String.valueOf(getTE(worldIn, pos).energy) + "/" + String.valueOf(getTE(worldIn, pos).capacity) + "FE");
        playerIn.sendStatusMessage(signText, false);
        return true;
    }

    public BaseGeneratorTE getTE(World world, BlockPos pos) {
        TileEntity tile = world.getTileEntity(pos);
        return tile instanceof BaseGeneratorTE ? (BaseGeneratorTE) tile : null;
    }


}
