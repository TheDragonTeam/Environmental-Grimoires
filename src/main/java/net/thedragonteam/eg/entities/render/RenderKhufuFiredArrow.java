package net.thedragonteam.eg.entities.render;

import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.thedragonteam.eg.entities.EntityKhufuFiredArrow;

import javax.annotation.Nullable;

/**
 * Created by sokratis12GR on 4/20/2017.
 */
public class RenderKhufuFiredArrow extends RenderArrow<EntityKhufuFiredArrow> {

    public static final ResourceLocation RES_ARROW = new ResourceLocation("textures/entity/projectiles/arrow.png");

    public RenderKhufuFiredArrow(RenderManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityKhufuFiredArrow entity) {
        return RES_ARROW;
    }
}
