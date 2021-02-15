package me.gavin.gavhax.injection.mixins;

import me.gavin.gavhax.event.events.EntityRenderEvent;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderManager.class)
public class MixinRenderManager {

    @Inject(method = "renderEntity", at = @At("HEAD"), cancellable = true)
    public void renderEntityHook(Entity entityIn, double x, double y, double z, float yaw, float partialTicks, boolean p_188391_10_, CallbackInfo callbackInfo) {
        EntityRenderEvent event = new EntityRenderEvent(entityIn);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()) {
            callbackInfo.cancel();
        }
    }

}
