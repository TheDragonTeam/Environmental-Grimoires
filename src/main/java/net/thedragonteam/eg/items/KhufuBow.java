package net.thedragonteam.eg.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.eg.base.BaseBow;
import net.thedragonteam.eg.entities.EntityKhufuFiredArrow;
import net.thedragonteam.eg.registry.ModItems;

import java.util.List;

import static net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel;

/**
 * Created by sokratis12GR on 4/20/2017.
 */
public class KhufuBow extends BaseBow {

    public KhufuBow() {
        super("khufu_bow");
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase entityLiving, int timeLeft) {
        if (entityLiving instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entityLiving;
            boolean requiredConditions = player.capabilities.isCreativeMode || getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
            ItemStack itemstack = this.findAmmo(player);

            int useDuration = this.getMaxItemUseDuration(stack) - timeLeft;
            useDuration = ForgeEventFactory.onArrowLoose(stack, world, (EntityPlayer) entityLiving, useDuration, !itemstack.isEmpty() || requiredConditions);
            if (useDuration < 0) return;

            if (!itemstack.isEmpty() || requiredConditions) {
                if (itemstack.isEmpty()) itemstack = new ItemStack(Items.ARROW);

                float arrowVelocity = getArrowVelocity(useDuration);

                if ((double) arrowVelocity >= 0.1D) {
                    boolean secondaryConditions = requiredConditions && itemstack.getItem() == Items.ARROW;

                    if (!world.isRemote) {
                        ItemKhufuFiredArrow firedArrow = (ItemKhufuFiredArrow) (itemstack.getItem() instanceof ItemKhufuFiredArrow ? itemstack.getItem() : ModItems.khufuFiredArrow);
                        EntityKhufuFiredArrow entityArrow = (EntityKhufuFiredArrow) firedArrow.createArrow(world, itemstack, player);

                        float newArrowVelocity = arrowVelocity * getVelocityOfArrow(stack);
                        entityArrow.setAim(player, player.rotationPitch, player.rotationYaw, 0.0F, newArrowVelocity, 1.0F);

                        if (newArrowVelocity == 0) {
                            world.playSound(null, player.getPosition(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.NEUTRAL, 0.4F, 1.0F);
                            return;
                        }
                        int powerLevel = getEnchantmentLevel(Enchantments.POWER, stack);

                        entityArrow.setDamage(entityArrow.getDamage() + (powerLevel > 0 ? powerLevel * 0.5 + 0.5 : 0));

                        int punchLevel = getEnchantmentLevel(Enchantments.PUNCH, stack);

                        if (punchLevel > 0) entityArrow.setKnockbackStrength(punchLevel);

                        if (getEnchantmentLevel(Enchantments.FLAME, stack) > 0) entityArrow.setFire(100);

                        stack.damageItem(1, player);
                        if (secondaryConditions) entityArrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;

                        world.spawnEntity(entityArrow);
                    }

                    world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.NEUTRAL, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + arrowVelocity * 0.5F);

                    if (!secondaryConditions) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) player.inventory.deleteStack(itemstack);
                    }
                }
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(1, "Arrows on impact teleport you to the entity");
        tooltip.add(2, "While doing damage to the entity too");
        super.addInformation(stack, playerIn, tooltip, advanced);
    }
}
