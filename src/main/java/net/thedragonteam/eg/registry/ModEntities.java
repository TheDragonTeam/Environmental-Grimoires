package net.thedragonteam.eg.registry;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.eg.entities.EntityKhufuFiredArrow;
import net.thedragonteam.eg.entities.render.RenderKhufuFiredArrow;

import static net.thedragonteam.eg.EnvironmentalGrimoires.instance;
import static net.thedragonteam.eg.utils.Utilities.setResourceLocation;

/**
 * Created by sokratis12GR on 4/20/2017.
 */
public class ModEntities {

    private static final int KHUFU_FIRED_ARROW = 1; //arrow fired from a khufu bow

    public static void initEntities() {
        EntityRegistry.registerModEntity(setResourceLocation("khufu_fired_arrow"), EntityKhufuFiredArrow.class, "khufu_fired_arrow", KHUFU_FIRED_ARROW, instance, 64, 1, true);
    }

    @SideOnly(Side.CLIENT)
    public static void renderModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntityKhufuFiredArrow.class, RenderKhufuFiredArrow::new);
    }
}
