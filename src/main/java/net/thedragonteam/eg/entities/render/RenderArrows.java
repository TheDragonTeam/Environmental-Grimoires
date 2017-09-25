package net.thedragonteam.eg.entities.render;

import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.ResourceLocation;

/**
 * Created by sokratis12GR on 4/20/2017.
 */
public class RenderArrows extends RenderArrow<EntityArrow> {

    public static final ResourceLocation RES_ARROW = new ResourceLocation("textures/entity/projectiles/arrow.png");

    public RenderArrows(RenderManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityArrow entity) {
        return RES_ARROW;
    }
}
