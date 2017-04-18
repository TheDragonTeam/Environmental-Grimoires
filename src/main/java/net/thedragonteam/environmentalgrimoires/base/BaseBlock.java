package net.thedragonteam.environmentalgrimoires.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static net.thedragonteam.environmentalgrimoires.utils.Utilities.setName;

/**
 * Created by KewaiiGamer on 15/04/2017.
 */
public class BaseBlock extends Block {
    public BaseBlock(String modId, String name, CreativeTabs tab, Material material, float resistance, float hardness, ToolClass toolClass, ToolLevel level) {
        super(material);
        this.setUnlocalizedName(setName(name));
        this.setRegistryName(name);
        this.setCreativeTab(tab);
        this.setResistance(resistance);
        this.setHardness(hardness);
        this.setHarvestLevel(toolClass.getName(), level.getLevel());
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this), getRegistryName());
    }

    public enum ToolClass {
        AXE("axe"),
        PICKAXE("pickaxe"),
        SHOVEL("shovel"),;

        private final String name;

        ToolClass(String tool) {
            name = tool;
        }

        public String getName() {
            return name;
        }

    }

    public enum ToolLevel {
        WOOD(0),
        STONE(1),
        GOLD(1),
        IRON(2),
        DIAMOND(3),;

        private final int level;

        ToolLevel(int tool) { level = tool; }

        public int getLevel() { return level;}
    }
}
