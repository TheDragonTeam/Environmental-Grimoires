package net.thedragonteam.eg.base;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thedragonteam.eg.EnvironmentalGrimoires;
import net.thedragonteam.eg.utils.Utility;

import static net.thedragonteam.eg.utils.Utilities.setName;
import static net.thedragonteam.eg.utils.UtilityType.ITEM;

/**
 * Created by ΑΛΕΧ on 18/4/2017.
 */
@Utility(ITEM)
public class BaseArmor extends ItemArmor {

    public BaseArmor(String name, ArmorMaterial material, EntityEquipmentSlot equipSlot) {
        super(material, 1, equipSlot);
        switch (equipSlot) {
            case HEAD:
                this.setUnlocalizedName(setName(name + "_helmet"));
                this.setRegistryName(name + "_helmet");
                break;
            case CHEST:
                this.setUnlocalizedName(setName(name + "_chestplate"));
                this.setRegistryName(name + "_chestplate");
                break;
            case LEGS:
                this.setUnlocalizedName(setName(name + "_leggings"));
                this.setRegistryName(name + "_leggings");
                break;
            case FEET:
                this.setUnlocalizedName(setName(name + "_boots"));
                this.setRegistryName(name + "_boots");
                break;
        }
        this.setCreativeTab(EnvironmentalGrimoires.TAB);
        GameRegistry.register(this);
    }
}
