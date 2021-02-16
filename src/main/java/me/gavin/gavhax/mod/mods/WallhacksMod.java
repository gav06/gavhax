package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import me.gavin.gavhax.util.BooleanHooks;

public class WallhacksMod extends Module {
    public WallhacksMod() {
        super("Wallhacks", "see thru walls", Category.Render);
    }

    public void onEnable() {
        if (mc.world == null)
            return;
        BooleanHooks.DO_WALLHACKS = true;
        mc.renderGlobal.loadRenderers();
    }

    public void onDisable() {
        BooleanHooks.DO_WALLHACKS = false;
        mc.renderGlobal.loadRenderers();
    }
}
