package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.event.events.PacketEvent;
import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NoRotateMod extends Module {
    public NoRotateMod() {
        super("NoRotate", "stops rotations", Category.World);
    }

    @SubscribeEvent
    public void onPacket(PacketEvent.Receive event) {
        if (event.getPacket() instanceof SPacketPlayerPosLook) {
            ((SPacketPlayerPosLook) event.getPacket()).pitch = mc.player.rotationPitch;
            ((SPacketPlayerPosLook)event.getPacket()).yaw = mc.player.rotationYaw;
        }
    }
}
