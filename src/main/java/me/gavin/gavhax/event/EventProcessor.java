package me.gavin.gavhax.event;

import me.gavin.gavhax.event.events.PlayerUpdateEvent;
import me.gavin.gavhax.hud.HUD;
import me.gavin.gavhax.hud.gui.ClickGUI;
import me.gavin.gavhax.util.TpsUtil;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class EventProcessor {

    public static void register_events() {
        MinecraftForge.EVENT_BUS.register(new EventProcessor());
        MinecraftForge.EVENT_BUS.register(new TpsUtil());
    }

    @SubscribeEvent
    public void onKey(InputEvent.KeyInputEvent event) {
        if (Keyboard.getEventKeyState()) {
            if (Keyboard.getEventKey() == Keyboard.KEY_RSHIFT) {
                Minecraft.getMinecraft().displayGuiScreen(ClickGUI.INSTANCE);
            }
        }
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Text event) {
        if (Minecraft.getMinecraft().gameSettings.showDebugInfo)
            return;

        HUD.draw_hud();
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (Minecraft.getMinecraft().player == null || Minecraft.getMinecraft().world == null)
            return;

        MinecraftForge.EVENT_BUS.post(new PlayerUpdateEvent());
    }
}
