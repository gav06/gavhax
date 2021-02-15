package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.event.events.PlayerUpdateEvent;
import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FastPlaceMod extends Module {
    public FastPlaceMod() {
        super("FastPlace", "place faster", Category.World);
    }

    @SubscribeEvent
    public void onTick(PlayerUpdateEvent event) {
        mc.rightClickDelayTimer = 0;
    }
}
