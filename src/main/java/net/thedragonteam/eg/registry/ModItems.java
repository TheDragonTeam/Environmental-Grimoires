package net.thedragonteam.eg.registry;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.eg.armor.KhufuArmor;
import net.thedragonteam.eg.items.*;
import net.thedragonteam.eg.utils.Utilities;

import java.util.Arrays;

import static java.util.Arrays.setAll;
import static net.minecraft.inventory.EntityEquipmentSlot.*;
import static net.minecraftforge.fml.common.Loader.isModLoaded;
import static net.thedragonteam.eg.utils.Utilities.registerItemRender;

/**
 * Created by ΑΛΕΧ on 18/4/2017.
 */
public class ModItems {

    public static EntityEquipmentSlot[] armorSlots = new EntityEquipmentSlot[]{HEAD, CHEST, LEGS, FEET};
    public static KhufuArmor[] khufuSet = new KhufuArmor[4];
    public static KhufuShield khufuShield;
    public static KhufuBow khufuBow;
    public static ItemKhufuFiredArrow khufuFiredArrow;
    public static ItemGoldenString goldenString;
    public static KhufuSword khufuSword;
    //For after ModOff
    public static AnkhAmulet ankhAmulet;

    public static void initItems() {
        setAll(khufuSet, i -> new KhufuArmor(armorSlots[i]));
        khufuShield = new KhufuShield();
        khufuBow = new KhufuBow();
        khufuFiredArrow = new ItemKhufuFiredArrow();
        goldenString = new ItemGoldenString();
        khufuSword = new KhufuSword();
        if (isModLoaded("baubles")) {
            ankhAmulet = new AnkhAmulet();
        }
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels() {
        initArmorModel(khufuSet);
        registerItemRender(khufuShield);
        registerItemRender(khufuBow);
        registerItemRender(khufuFiredArrow);
        registerItemRender(goldenString);
        registerItemRender(khufuSword);
        if (isModLoaded("baubles")) {
            registerItemRender(ankhAmulet);
        }
    }

    @SideOnly(Side.CLIENT)
    public static void initArmorModel(ItemArmor[] armorSet) {
        Arrays.stream(armorSet).forEach(Utilities::registerItemRender);
    }
}
