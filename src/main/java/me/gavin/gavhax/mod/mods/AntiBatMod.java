package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.event.events.EntityRenderEvent;
import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import net.minecraft.entity.passive.EntityBat;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AntiBatMod extends Module {
    public AntiBatMod() {
        super("AntiBats", "removes bats", Category.Render);
    }

    @SubscribeEvent
    public void onRender(EntityRenderEvent event) {
        if (event.getEntity() instanceof EntityBat) {
            event.setCanceled(true);
        }
    }
}
