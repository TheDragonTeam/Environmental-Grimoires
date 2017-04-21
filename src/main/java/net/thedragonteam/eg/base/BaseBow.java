package net.thedragonteam.eg.base;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.eg.EnvironmentalGrimoires;
import net.thedragonteam.thedragonlib.util.NBTHelper;

import javax.annotation.Nonnull;
import java.util.stream.IntStream;

import static net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel;
import static net.thedragonteam.eg.utils.Utilities.setName;

/**
 * Created by sokratis12GR on 4/20/2017.
 */
public class BaseBow extends ItemBow {

    public BaseBow(String name) {
        this.setUnlocalizedName(setName(name));
        this.setRegistryName(name);
        this.setCreativeTab(EnvironmentalGrimoires.TAB);
        GameRegistry.register(this);
        this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, World worldIn, EntityLivingBase entityIn) {
                if (entityIn == null) return 0.0F;
                ItemStack itemstack = entityIn.getActiveItemStack();
                return itemstack.getCount() > 0 && itemstack.getItem() == stack.getItem() ? (float) (stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F : 0.0F;
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, World worldIn, EntityLivingBase entityIn) {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
    }

    @Nonnull
    public ItemStack findAmmo(EntityPlayer player) {
        return this.isArrow(player.getHeldItem(EnumHand.OFF_HAND)) ? player.getHeldItem(EnumHand.OFF_HAND) : this.isArrow(player.getHeldItem(EnumHand.MAIN_HAND)) ? player.getHeldItem(EnumHand.MAIN_HAND) : IntStream.range(0, player.inventory.getSizeInventory()).mapToObj(i -> player.inventory.getStackInSlot(i)).filter(this::isArrow).findFirst().orElse(ItemStack.EMPTY);
    }

    public float getVelocityOfArrow(ItemStack stack) {
        NBTHelper.INSTANCE.checkNBT(stack);
        NBTTagCompound tag = stack.getTagCompound();
        return (tag != null && tag.hasKey("velocity")) ? tag.getFloat("velocity") : 3;
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
                        ItemArrow itemarrow = ((ItemArrow) (itemstack.getItem() instanceof ItemArrow ? itemstack.getItem() : Items.ARROW));
                        EntityArrow entityArrow = itemarrow.createArrow(world, itemstack, player);

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
}
