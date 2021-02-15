package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;

public class FullbrightMod extends Module {
    public FullbrightMod() {
        super("Fullbright", "makes it bright", Category.Render);
    }

    public void onEnable() {
        mc.gameSettings.gammaSetting = 100;
    }

    public void onDisable() {
        mc.gameSettings.gammaSetting = 1;
    }
}
