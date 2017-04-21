package net.thedragonteam.eg.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.thedragonteam.eg.registry.ModItems;

import static net.thedragonteam.thedragonlib.util.ItemStackUtils.getItemStack;

/**
 * Created by sokratis12GR on 4/20/2017.
 */
public class EntityKhufuFiredArrow extends EntityArrow {
    public EntityKhufuFiredArrow(World worldIn) {
        super(worldIn);
    }

    public EntityKhufuFiredArrow(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public EntityKhufuFiredArrow(World worldIn, EntityLivingBase shooter) {
        super(worldIn, shooter);
    }

    @Override
    protected ItemStack getArrowStack() {
        return getItemStack(ModItems.khufuFiredArrow);
    }

    @Override
    protected void arrowHit(EntityLivingBase living) {
        if (!this.world.isRemote) {
            if (living != shootingEntity) {
                shootingEntity.setPositionAndUpdate(living.getPosition().getX(), living.getPosition().getY(), living.getPosition().getZ());
            }
        }
        super.arrowHit(living);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.world.isRemote && !this.inGround) {
            EntityEnderPearl pearl = new EntityEnderPearl(world);
            world.spawnEntity(pearl);
            pearl.setPositionAndUpdate(this.posX, this.posY, this.posZ);
        }
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return getItemStack(Items.ARROW);
    }
}
