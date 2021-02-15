package me.gavin.gavhax.event.events;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.eventhandler.Event;

public class EntityRenderEvent extends Event {

    @Override
    public boolean isCancelable() {
        return true;
    }

    private final Entity entity;

    public EntityRenderEvent(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }
}
