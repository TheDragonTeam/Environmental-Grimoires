package net.thedragonteam.environmentalgrimoires.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by KewaiiGamer on 17/04/2017.
 */
public class BaseGenerator extends BaseBlock implements ITileEntityProvider {

    TileEntity tileEntity;

    public BaseGenerator(String name, TileEntity tileEntity) {
        super(name + "generator", Material.ROCK, 3.0F, 10.0F, ToolType.PICKAXE, ToolLevel.ONE);
        this.tileEntity = tileEntity;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return tileEntity;
    }
}
