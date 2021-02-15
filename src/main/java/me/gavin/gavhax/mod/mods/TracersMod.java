package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import me.gavin.gavhax.util.render.JColor;
import me.gavin.gavhax.util.render.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TracersMod extends Module {
    public TracersMod() {
        super("Tracers", "draw lines to player", Category.Render);
    }

    @SubscribeEvent
    public void onRender3d(RenderWorldLastEvent event) {
        mc.world.loadedEntityList.stream()
                .filter(e->e instanceof EntityPlayer)
                .filter(e->e != mc.player)
                .forEach(e->{
                    drawLineToEntityPlayer(e, getDistanceColor((int)mc.player.getDistance(e)));
                });
    }

    public void drawLineToEntityPlayer(Entity e, JColor color) {
        double[] xyz = interpolate(e);
        drawLine1(xyz[0],xyz[1],xyz[2], e.height, color, e);
    }

    public static double[] interpolate(Entity entity) {
        double posX = interpolate(entity.posX, entity.lastTickPosX);
        double posY = interpolate(entity.posY, entity.lastTickPosY);
        double posZ = interpolate(entity.posZ, entity.lastTickPosZ);
        return new double[] { posX, posY, posZ };
    }

    public static double interpolate(double now, double then) {
        return then + (now - then) * Minecraft.getMinecraft().getRenderPartialTicks();
    }

    public void drawLine1(double posx, double posy, double posz, double up, JColor color, Entity e) {
        Vec3d eyes= ActiveRenderInfo.getCameraPosition().add(mc.getRenderManager().viewerPosX,mc.getRenderManager().viewerPosY,mc.getRenderManager().viewerPosZ);
        RenderUtil.prepare();
        RenderUtil.drawLineWidth(eyes.x, eyes.y, eyes.z, posx, posy, posz, getDistanceColor((int) mc.player.getDistance(e)), 2.5);
        RenderUtil.release();
    }

    private JColor getDistanceColor(int distance) {
        if (distance > 50) {
            distance = 50;
        }

        int red = (int) (255 - (distance * 5.1));
        int green = 255 - red;

        return new JColor(red, green, 0, 255);
    }
}
