package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.event.events.PacketEvent;
import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import net.minecraft.network.play.client.CPacketCloseWindow;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class XCarryMod extends Module {
    public XCarryMod() {
        super("XCarry", "carry more stuf", Category.World);
    }

    @SubscribeEvent
    public void onPacket(PacketEvent.Send event) {
        if (event.getPacket() instanceof CPacketCloseWindow) {
            event.setCanceled(true);
        }
    }
}
