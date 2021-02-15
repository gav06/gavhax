package me.gavin.gavhax.hud;

import me.gavin.gavhax.GavHax;
import me.gavin.gavhax.mod.Module;
import me.gavin.gavhax.mod.ModuleManager;
import me.gavin.gavhax.util.TpsUtil;
import me.gavin.gavhax.util.render.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.network.NetworkPlayerInfo;

import java.util.Objects;

public class HUD {

    static Minecraft mc = Minecraft.getMinecraft();
    static FontRenderer fr = mc.fontRenderer;

    static NetworkPlayerInfo np;

    public static void draw_hud() {
        np = Objects.requireNonNull(mc.getConnection()).getPlayerInfo(mc.player.getName());
        int ping = np != null ? np.getResponseTime() : -1;
        final String tickrate = String.format("TPS: %.2f", TpsUtil.INSTANCE.getTickRate());
        fr.drawStringWithShadow(GavHax.MOD_NAME + " " + GavHax.VERSION, 2, 2, -1);
        fr.drawStringWithShadow(tickrate + " FPS: " +Minecraft.getDebugFPS() + " Ping: " + ping, 2, 12, -1);

        int offset = 0;
        for (Module m : ModuleManager.modules) {
            if (m.enabled) {
                fr.drawStringWithShadow(">" + m.name, 2, 22 + offset, RenderUtil.getRGBWave(8, 1, 0.5f, offset * 25));
                offset += 10;
            }
        }
    }
}
