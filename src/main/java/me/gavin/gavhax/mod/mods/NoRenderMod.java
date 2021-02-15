package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.event.events.EntityRenderEvent;
import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NoRenderMod extends Module {
    public NoRenderMod() {
        super("NoRender", "stops rendering ground items", Category.Render);
    }

    @SubscribeEvent
    public void onRender(EntityRenderEvent event) {
        if (event.getEntity() instanceof EntityItem) {
            event.setCanceled(true);
        }
    }
}
