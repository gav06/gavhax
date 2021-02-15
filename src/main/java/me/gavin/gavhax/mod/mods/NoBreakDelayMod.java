package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.event.events.PlayerUpdateEvent;
import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NoBreakDelayMod extends Module {

    public NoBreakDelayMod() {
        super("NoBreakDelay", "removes the break delay", Category.World);
    }

    @SubscribeEvent
    public void onTick(PlayerUpdateEvent event) {
        mc.playerController.blockHitDelay = 0;
    }
}
