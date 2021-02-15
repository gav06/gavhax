package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.event.events.PacketEvent;
import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CriticalsMod extends Module {
    public CriticalsMod() {
        super("Criticals", "hit crits", Category.Combat);
    }

    @SubscribeEvent
    public void onPacket(PacketEvent.Send event) {
        if (event.getPacket() instanceof CPacketUseEntity
                && ((CPacketUseEntity) event.getPacket()).getAction() == CPacketUseEntity.Action.ATTACK
                && mc.player.onGround) {
            mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.1f, mc.player.posZ, false));
            mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY, mc.player.posZ, false));
        }
    }
}
