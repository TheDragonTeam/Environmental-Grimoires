package net.thedragonteam.environmentalgrimoires.utils;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;

import static net.thedragonteam.environmentalgrimoires.utils.Utilities.setLocation;

/**
 * Created by sokratis12GR on 4/18/2017.
 */
public class EnumUtils {

    public static ArmorMaterial addArmorMaterial(String name, String textureName, int durability, int[] protection, int enchantability, SoundEvent soundOnEquip, float toughness) {
        return EnumHelper.addArmorMaterial(name, setLocation(textureName), durability, protection, enchantability, soundOnEquip, toughness);
    }

    /**
     * Only used in cases where the name and the texture name are both the same
     */
    public static ArmorMaterial addArmorMaterial(String name, int durability, int[] protection, int enchantability, SoundEvent soundOnEquip, float toughness) {
        return addArmorMaterial(name, name, durability, protection, enchantability, soundOnEquip, toughness);
    }

}
