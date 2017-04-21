package net.thedragonteam.eg.base;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.eg.utils.Utility;

import javax.annotation.Nullable;
import java.util.List;

import static net.minecraft.block.BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY;
import static net.minecraft.item.ItemArmor.DISPENSER_BEHAVIOR;
import static net.thedragonteam.eg.utils.UtilityType.ITEM;
import static net.thedragonteam.thedragonlib.util.ItemStackUtils.getItem;

/**
 * Created by sokratis12GR on 18/04/2017.
 */
@Utility(ITEM)
public class BaseShield extends BaseItem {

    private String itemName;
    private Object repairMaterial;

    public BaseShield(String name, int maxDamage, Object repair) {
        super(name);
        this.setMaxStackSize(1);
        this.setMaxDamage(maxDamage);
        addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
        DISPENSE_BEHAVIOR_REGISTRY.putObject(this, DISPENSER_BEHAVIOR);
        itemName = name;
        repairMaterial = repair;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return new TextComponentTranslation("item.eg." + itemName + ".name").getFormattedText();
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        stack.damageItem(1, entityLiving);
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        ItemBanner.appendHoverTextFromTileEntityTag(stack, tooltip);
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BLOCK;
    }

    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 72000;
    }

    /**
     * Called when the equipped item is right clicked.
     */
    @Override
    @SuppressWarnings("unchecked")
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        return new ActionResult(EnumActionResult.SUCCESS, itemstack);
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        if (repairMaterial == null || ((ItemStack) repairMaterial).isEmpty()) return false;
        if (repairMaterial instanceof Item) {
            if (repair.getItem() == repairMaterial) {
                return true;
            }
        } else if (repairMaterial instanceof Block) {
            if (repair.getItem() == getItem((Block) repairMaterial)) {
                return true;
            }
        } else if (repairMaterial instanceof ItemStack) {
            if (repair == repairMaterial || repair.getItem() == ((ItemStack) repairMaterial).getItem()) {
                return true;
            }
        }
        return false;
    }
}
