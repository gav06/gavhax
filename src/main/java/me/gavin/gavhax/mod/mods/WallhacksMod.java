package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.event.events.RenderBlockInLayerEvent;
import me.gavin.gavhax.event.events.RenderBlockLayerEvent;
import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WallhacksMod extends Module {
    public WallhacksMod() {
        super("Wallhacks", "see thru walls", Category.Render);
    }

    public void onEnable() {
        if (mc.world == null)
            return;
        mc.renderGlobal.loadRenderers();
    }

    public void onDisable() {
        mc.renderGlobal.loadRenderers();
    }

    private boolean isInternalCall = false;

    @SubscribeEvent
    public void onPreRenderBlockLayer(RenderBlockLayerEvent.Pre event) {
        /*if (!isInternalCall) {
            if (!event.getRenderLayer().equals(BlockRenderLayer.TRANSLUCENT)) {
                event.setCanceled(true);
            } else if (event.getRenderLayer().equals(BlockRenderLayer.TRANSLUCENT)) {
                isInternalCall = true;
                Entity renderEntity = mc.getRenderViewEntity();
                GlStateManager.disableAlpha();
                mc.renderGlobal.renderBlockLayer(
                        BlockRenderLayer.SOLID, event.getPartialTicks(), 0, renderEntity);
                GlStateManager.enableAlpha();
                mc.renderGlobal.renderBlockLayer(
                        BlockRenderLayer.CUTOUT_MIPPED, event.getPartialTicks(), 0, renderEntity);
                mc.getTextureManager()
                        .getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE)
                        .setBlurMipmap(false, false);
                mc.renderGlobal.renderBlockLayer(
                        BlockRenderLayer.CUTOUT, event.getPartialTicks(), 0, renderEntity);
                mc.getTextureManager()
                        .getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE)
                        .restoreLastBlurMipmap();
                GlStateManager.disableAlpha();
                isInternalCall = false;
            }
        }*/
    }

    @SubscribeEvent
    public void onRenderBlockInLayer(RenderBlockInLayerEvent event) {
        if (event.getCompareToLayer().equals(BlockRenderLayer.TRANSLUCENT)) {
            event.setLayer(event.getCompareToLayer());
        }
    }
}
