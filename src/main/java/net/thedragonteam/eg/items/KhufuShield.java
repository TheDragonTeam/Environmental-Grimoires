package net.thedragonteam.eg.items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.eg.base.BaseShield;

import java.util.List;
import java.util.Random;

/**
 * Created by sokratis12GR on 4/18/2017.
 */
public class KhufuShield extends BaseShield {

    private Random random = new Random();

    public KhufuShield() {
        super("khufu_shield", 515, Items.IRON_INGOT);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote) {
            if (entityIn instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entityIn;
                if (player.getHeldItem(EnumHand.OFF_HAND).getItem() == stack.getItem()) {
                    if ((player.getMaxHealth() / 3) >= player.getHealth() && !player.isDead) {
                        player.sendStatusMessage(new TextComponentTranslation("status.eg.khufu_shield.tip"), true);
                    }
                }
            }
        }
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn) {
        if (!worldIn.isRemote) {
            ItemStack stack = player.getHeldItem(EnumHand.OFF_HAND);
            if (!player.getCooldownTracker().hasCooldown(stack.getItem())) {
                if (player.getHeldItem(EnumHand.OFF_HAND).getItem() == stack.getItem()) {
                    if ((player.getMaxHealth() / 3) >= player.getHealth() && !player.isDead) {
                        BlockPos teleportPos = new BlockPos(player.posX + (random.nextInt(16 - 8 + 1) + 8), player.posY, player.posZ + (random.nextInt(16 - 8 + 1) + 8));
                        IBlockState block = worldIn.getBlockState(teleportPos);
                        int cooldownTime = 20 * 15;
                        if (block.getBlock() == Blocks.AIR) {
                            player.setPositionAndUpdate(teleportPos.getX(), teleportPos.getY(), teleportPos.getZ());
                            stack.damageItem(50, player);
                            player.getCooldownTracker().setCooldown(stack.getItem(), cooldownTime);
                        } else if (block.getBlock() != Blocks.AIR) {
                            BlockPos alternativePos = teleportPos.add(0, 2, 0);
                            IBlockState blockAlternative = worldIn.getBlockState(alternativePos);
                            if (blockAlternative.getBlock() == Blocks.AIR) {
                                player.setPositionAndUpdate(alternativePos.getX(), alternativePos.getY(), alternativePos.getZ());
                                stack.damageItem(50, player);
                                player.getCooldownTracker().setCooldown(stack.getItem(), cooldownTime);
                            } else if (blockAlternative.getBlock() != Blocks.AIR) {
                                BlockPos alternativePos2 = teleportPos.add(0, 2, 0);
                                IBlockState blockAlternative2 = worldIn.getBlockState(alternativePos2);
                                if (blockAlternative2.getBlock() == Blocks.AIR) {
                                    player.setPositionAndUpdate(alternativePos2.getX(), alternativePos2.getY(), alternativePos2.getZ());
                                    stack.damageItem(50, player);
                                    player.getCooldownTracker().setCooldown(stack.getItem(), cooldownTime);
                                }
                            }
                        }
                    }
                }
            }
        }
        return super.onItemRightClick(worldIn, player, handIn);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(1, "Right-Click on low health to teleport away");
        tooltip.add(2, "Cost: 50 durability");
        super.addInformation(stack, playerIn, tooltip, advanced);
    }
}
