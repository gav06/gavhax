package me.gavin.gavhax.injection.mixins;

import me.gavin.gavhax.event.events.RenderBlockLayerEvent;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RenderGlobal.class)
public class MixinRenderGlobal {

    @Inject(method = "renderBlockLayer(Lnet/minecraft/util/BlockRenderLayer;DILnet/minecraft/entity/Entity;)I", at = @At("HEAD"), cancellable = true)
    public void preRenderHook(BlockRenderLayer blockLayerIn, double partialTicks, int pass, Entity entityIn, CallbackInfoReturnable<Integer> cir) {
        RenderBlockLayerEvent.Pre event = new RenderBlockLayerEvent.Pre(blockLayerIn, partialTicks);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()) {
            cir.cancel();
        }
    }

    @Inject(method = "renderBlockLayer(Lnet/minecraft/util/BlockRenderLayer;DILnet/minecraft/entity/Entity;)I", at= @At("TAIL"))
    public void postRenderHook(BlockRenderLayer blockLayerIn, double partialTicks, int pass, Entity entityIn, CallbackInfoReturnable<Integer> cir) {
        MinecraftForge.EVENT_BUS.post(new RenderBlockLayerEvent.Post(blockLayerIn, partialTicks));
    }
}
