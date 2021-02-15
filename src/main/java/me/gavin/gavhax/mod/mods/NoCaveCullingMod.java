package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import me.gavin.gavhax.util.BooleanHooks;

public class NoCaveCullingMod extends Module {
    public NoCaveCullingMod() {
        super("NoCaveCulling", "stops cave culling", Category.Render);
    }

    public void onEnable() {
        BooleanHooks.DO_CAVE_CULLING = false;
        if (mc.world == null)
            return;

        mc.renderGlobal.loadRenderers();
    }

    public void onDisable() {
        BooleanHooks.DO_CAVE_CULLING = true;
        if (mc.world == null)
            return;

        mc.renderGlobal.loadRenderers();
    }
}
