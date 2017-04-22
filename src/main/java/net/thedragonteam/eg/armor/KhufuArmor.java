package net.thedragonteam.eg.armor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.eg.EnvironmentalGrimoires;

import java.util.List;

import static net.minecraft.init.SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
import static net.thedragonteam.eg.utils.EnumUtils.addArmorMaterial;
import static net.thedragonteam.eg.utils.Utilities.getTranslatedText;
import static net.thedragonteam.eg.utils.Utilities.setName;

/**
 * Created by sokratis12GR on 18/4/2017.
 */
public class KhufuArmor extends ItemArmor {

    public static final ArmorMaterial KHUFU = addArmorMaterial("khufu", 120, new int[]{2, 5, 7, 2}, 16, ITEM_ARMOR_EQUIP_DIAMOND, 1.0F);

    public KhufuArmor(EntityEquipmentSlot slot) {
        super(KHUFU, 0, slot);
        String name = "khufu";
        switch (slot) {
            case HEAD:
                this.setUnlocalizedName(setName(name + "_helmet"));
                this.setRegistryName(name + "_helmet");
                break;
            case CHEST:
                this.setUnlocalizedName(setName(name + "_chestplate"));
                this.setRegistryName(name + "_chestplate");
                break;
            case LEGS:
                this.setUnlocalizedName(setName(name + "_skirt"));
                this.setRegistryName(name + "_skirt");
                break;
            case FEET:
                this.setUnlocalizedName(setName(name + "_sandals"));
                this.setRegistryName(name + "_sandals");
                break;
        }
        this.setCreativeTab(EnvironmentalGrimoires.TAB);
        GameRegistry.register(this);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (player.isInWater()) {
            itemStack.damageItem(1, player);
        }
        super.onArmorTick(world, player, itemStack);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(1, getTranslatedText("tooltip.khufu_armor.line.one.text"));
        super.addInformation(stack, playerIn, tooltip, advanced);
    }
}
