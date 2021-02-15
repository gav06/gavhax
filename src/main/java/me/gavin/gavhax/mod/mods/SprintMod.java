package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.event.events.PlayerUpdateEvent;
import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SprintMod extends Module {
    public SprintMod() {
        super("Sprint", "sprints for u", Category.Movement);
    }

    @SubscribeEvent
    public void onUpdate(PlayerUpdateEvent event) {
        if (mc.player.moveForward > 0 && !mc.player.collidedHorizontally) {
            mc.player.setSprinting(true);
        }
    }
}
