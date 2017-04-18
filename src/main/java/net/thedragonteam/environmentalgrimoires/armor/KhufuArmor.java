package net.thedragonteam.environmentalgrimoires.armor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.thedragonteam.environmentalgrimoires.base.BaseArmor;

import static net.minecraft.init.SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
import static net.thedragonteam.environmentalgrimoires.utils.EnumUtils.addArmorMaterial;

/**
 * Created by ΑΛΕΧ on 18/4/2017.
 */
public class KhufuArmor extends BaseArmor {

    public static final ArmorMaterial KHUFU = addArmorMaterial("khufu", "khufu", 120, new int[]{4, 7, 9, 4}, 16, ITEM_ARMOR_EQUIP_DIAMOND, 1.0F);

    public KhufuArmor(EntityEquipmentSlot slot) {
        super("khufu", KHUFU, slot);
    }
}
