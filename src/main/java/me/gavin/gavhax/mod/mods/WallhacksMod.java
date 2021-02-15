package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;

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
}
