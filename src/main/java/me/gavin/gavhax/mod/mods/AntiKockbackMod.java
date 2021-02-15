package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.event.events.PacketEvent;
import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AntiKockbackMod extends Module {
    public AntiKockbackMod() {
        super("AntiKockback", "take no knockback", Category.Movement);
    }

    @SubscribeEvent
    public void onPacket(PacketEvent.Receive event) {
        Packet p = event.getPacket();
        if (p instanceof SPacketEntityVelocity && ((SPacketEntityVelocity) p).getEntityID() == mc.player.getEntityId()) {
            event.setCanceled(true);
        }
        if (p instanceof SPacketExplosion) {
            event.setCanceled(true);
        }
    }
}
