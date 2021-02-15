package me.gavin.gavhax.injection.mixins;

import me.gavin.gavhax.util.BooleanHooks;
import net.minecraft.client.renderer.chunk.VisGraph;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VisGraph.class)
public class MixinVisGraph {

    @Inject(method = "setOpaqueCube", at = @At("HEAD"), cancellable = true)
    public void caveCullingHook(BlockPos bPos, CallbackInfo ci) {
        if (!BooleanHooks.DO_CAVE_CULLING) {
            ci.cancel();
        }
    }
}
