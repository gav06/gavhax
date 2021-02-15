package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.event.events.PlayerUpdateEvent;
import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FastXPMod extends Module {
    public FastXPMod() {
        super("FastXP", "fastplace but for xp", Category.Combat);
    }

    @SubscribeEvent
    public void onTick(PlayerUpdateEvent event) {
        if (mc.player.getHeldItemMainhand().getItem() == Items.EXPERIENCE_BOTTLE || mc.player.getHeldItemOffhand().getItem() == Items.EXPERIENCE_BOTTLE) {
            mc.rightClickDelayTimer = 0;
        }
    }
}