package net.thedragonteam.eg.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thedragonteam.eg.EnvironmentalGrimoires;
import net.thedragonteam.eg.entities.EntityKhufuFiredArrow;

import static net.thedragonteam.eg.utils.Utilities.setName;

/**
 * Created by sokratis12GR on 4/20/2017.
 */
public class ItemKhufuFiredArrow extends ItemArrow {

    public ItemKhufuFiredArrow() {
        this.setUnlocalizedName(setName("khufu_fired_arrow"));
        this.setRegistryName("khufu_fired_arrow");
        this.setCreativeTab(EnvironmentalGrimoires.TAB);
        GameRegistry.register(this);
    }

    @Override
    public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter) {
        return new EntityKhufuFiredArrow(worldIn, shooter);
    }
}
