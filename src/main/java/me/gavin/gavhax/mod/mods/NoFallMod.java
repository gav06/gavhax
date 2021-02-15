package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.event.events.PlayerUpdateEvent;
import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NoFallMod extends Module {
    public NoFallMod() {
        super("NoFall", "tries to stop fall damage", Category.Movement);
    }

    @SubscribeEvent
    public void onUpdate(PlayerUpdateEvent event) {
        if (mc.player.fallDistance > 4.0F) {
            mc.player.capabilities.isFlying = true;
            mc.getConnection().sendPacket(new CPacketPlayer(true));
            mc.player.velocityChanged = true;
            mc.player.capabilities.isFlying = false;
        }
    }
}
