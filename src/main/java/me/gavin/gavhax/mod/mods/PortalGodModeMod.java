package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.event.events.PacketEvent;
import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PortalGodModeMod extends Module {
    public PortalGodModeMod() {
        super("PortalGodMode", "be a god in portals", Category.World);
    }

    @SubscribeEvent
    public void onPacket(PacketEvent.Send event) {
        if (event.getPacket() instanceof CPacketConfirmTeleport) {
            event.setCanceled(true);
        }
    }
}
