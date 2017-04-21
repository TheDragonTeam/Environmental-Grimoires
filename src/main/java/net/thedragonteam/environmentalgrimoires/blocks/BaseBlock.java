package net.thedragonteam.environmentalgrimoires.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thedragonteam.environmentalgrimoires.EnvironmentalGrimoires;

import static net.thedragonteam.environmentalgrimoires.utils.Utilities.setName;

/**
 * Created by KewaiiGamer on 15/04/2017.
 */
public class BaseBlock extends Block {

    public BaseBlock(String name, Material material, float hardness, float resistance, ToolType tool, ToolLevel level) {
        super(material);
        this.setUnlocalizedName(setName(name));
        this.setRegistryName(name);
        this.setCreativeTab(EnvironmentalGrimoires.TAB);
        this.setResistance(resistance);
        this.setHardness(hardness);
        this.setHarvestLevel(tool.getTool(), level.getLevel());
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this), getRegistryName());
    }

    public BaseBlock(String name, Material material, float hardness, float resistance) {
        this(name, material, hardness, resistance, null, ToolLevel.ZERO);
    }

    public BaseBlock(String name, Material material, float hardness) {
        this(name, material, hardness, 1.0F);
    }

    public enum ToolType {
        AXE("axe"),
        PICKAXE("pickaxe"),
        SHOVEL("shovel"),;

        private final String name;

        ToolType(String tool) {
            name = tool;
        }

        public String getTool() {
            return name;
        }

    }

    public enum ToolLevel {
        ZERO(0), // Wood Level
        WOOD(0),
        ONE(1), // Stone & Gold Level
        STONE(1),
        SECOND(2), // Iron Level
        IRON(2),
        THIRD(3), // Diamond Level
        DIAMOND(3),;

        private final int level;

        ToolLevel(int tool) {
            level = tool;
        }

        public int getLevel() {
            return level;
        }
    }
}
