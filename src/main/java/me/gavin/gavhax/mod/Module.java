package me.gavin.gavhax.mod;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public abstract class Module {
    // default key bind
    public int keyCode = 0;

    public String name;
    public String desc;
    public Category category;
    public boolean enabled;

    protected Minecraft mc = Minecraft.getMinecraft();

    public Module(String name, String desc, Category c) {
        this.name = name;
        this.desc = desc;
        this.category = c;
    }

    public void enable() {
        enabled = true;
        onEnable();
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void disable() {
        enabled = false;
        onDisable();
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    public void onEnable() {

    }

    public void onDisable() {

    }

    public void toggle() {
        if (enabled) {
            disable();
        } else {
            enable();
        }
    }
}
