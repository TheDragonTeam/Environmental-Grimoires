package net.thedragonteam.environmentalgrimoires.base;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thedragonteam.environmentalgrimoires.EnvironmentalGrimoires;

import javax.annotation.Nonnull;

import static net.thedragonteam.environmentalgrimoires.utils.Utilities.setName;

/**
 * Created by ΑΛΕΧ on 18/4/2017.
 */
public class BaseArmor extends ItemArmor implements ISpecialArmor {

    public BaseArmor(String name, ArmorMaterial material, EntityEquipmentSlot equipSlot) {
        super(material, 1, equipSlot);
        switch (equipSlot) {
            case FEET:
                this.setUnlocalizedName(setName(name + "_boots"));
                this.setRegistryName(name + "_boots");
                break;
            case LEGS:
                this.setUnlocalizedName(setName(name + "_leggings"));
                this.setRegistryName(name + "_leggings");
                break;
            case CHEST:
                this.setUnlocalizedName(setName(name + "_chestplate"));
                this.setRegistryName(name + "_chestplate");
                break;
            case HEAD:
                this.setUnlocalizedName(setName(name + "_helmet"));
                this.setRegistryName(name + "_helmet");
                break;
        }
        this.setCreativeTab(EnvironmentalGrimoires.TAB);
        GameRegistry.register(this);
    }

    @Override
    public ArmorProperties getProperties(EntityLivingBase player, @Nonnull ItemStack armor, DamageSource source, double damage, int slot) {
        return null;
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, @Nonnull ItemStack armor, int slot) {
        return 0;
    }

    @Override
    public void damageArmor(EntityLivingBase entity, @Nonnull ItemStack stack, DamageSource source, int damage, int slot) {

    }
}
