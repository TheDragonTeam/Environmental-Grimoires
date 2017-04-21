package net.thedragonteam.eg.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import static net.thedragonteam.thedragonlib.util.ItemStackUtils.getItemStack;

/**
 * Created by sokratis12GR on 4/20/2017.
 */
public class EntityKhufuFiredArrow extends EntityArrow {
    private static BlockPos damagedEntityPos;

    public EntityKhufuFiredArrow(World worldIn) {
        super(worldIn);
    }

    public EntityKhufuFiredArrow(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public EntityKhufuFiredArrow(World worldIn, EntityLivingBase shooter) {
        super(worldIn, shooter);
    }

    public static BlockPos getDamagedEntityPos() {
        return damagedEntityPos;
    }

    public static void setDamagedEntityPos(BlockPos damagedEntityPosIn) {
        damagedEntityPos = damagedEntityPosIn;
    }

    @Override
    protected ItemStack getArrowStack() {
        return getItemStack(new ItemArrow());
    }

    @Override
    protected void onHit(RayTraceResult raytraceResultIn) {
        damagedEntityPos = raytraceResultIn.getBlockPos();
        super.onHit(raytraceResultIn);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
    }
}
