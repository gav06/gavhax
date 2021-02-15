package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.event.events.PlayerUpdateEvent;
import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class KillAuraMod extends Module {
    public KillAuraMod() {
        super("KillAura", "attacks for you", Category.Combat);
    }

    @SubscribeEvent
    public void onTick(PlayerUpdateEvent event) {
        List<Entity> targets = mc.world.loadedEntityList.stream()
                .filter(Objects::nonNull)
                .filter(entity -> entity != mc.player)
                .filter(entity -> mc.player.getDistance(entity) <= 4.0)
                .filter(entity -> !entity.isDead)
                .filter(Entity::isEntityAlive)
                .filter(this::attackCheck)
                .sorted(Comparator.comparing(entity -> mc.player.getDistance(entity)))
                .collect(Collectors.toList());
        if (targets.size() == 0)
            return;

        targets.forEach(this::attack);
    }

    private Entity target = null;

    public void attack(Entity entity) {
        if (entity.isDead)
            return;

        if (mc.player.getCooledAttackStrength(0) >= 1) {
            mc.playerController.attackEntity(mc.player, entity);
            mc.player.swingArm(EnumHand.MAIN_HAND);
        }
        target = entity;
    }


    public boolean attackCheck(Entity entity) {
        if (entity instanceof EntityPlayer) {
            if (((EntityPlayer) entity).getHealth() > 0)
                return true;
        } else if (entity instanceof EntityMob) {
            if (((EntityMob) entity).getHealth() > 0)
                return true;
        } else if (entity instanceof EntityAnimal) {
            if (((EntityAnimal) entity).getHealth() > 0)
                return true;
        }
        return false;
    }
}
