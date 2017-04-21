package net.thedragonteam.environmentalgrimoires.registry;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.environmentalgrimoires.armor.KhufuArmor;
import net.thedragonteam.environmentalgrimoires.base.BaseArmor;
import net.thedragonteam.environmentalgrimoires.compat.KhufusGrimoire;

import java.util.Arrays;

import static net.minecraft.inventory.EntityEquipmentSlot.*;
import static net.thedragonteam.environmentalgrimoires.utils.Utilities.registerItemRender;

/**
 * Created by ΑΛΕΧ on 18/4/2017.
 */
public class ModItems {

    public static EntityEquipmentSlot[] armorSlots = new EntityEquipmentSlot[]{HEAD, CHEST, LEGS, FEET};
    public static KhufuArmor[] khufu = new KhufuArmor[4];
    public static KhufusGrimoire khufusGrimoire;

    public static void init() {
        Arrays.setAll(khufu, i -> new KhufuArmor(armorSlots[i]));
        khufusGrimoire.buildBook();
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels() {
        initArmorModel(khufu);
    }

    @SideOnly(Side.CLIENT)
    public static void initArmorModel(BaseArmor[] armorSet) {
        for (BaseArmor armorPiece : armorSet) {
            registerItemRender(armorPiece);
        }
    }
}
