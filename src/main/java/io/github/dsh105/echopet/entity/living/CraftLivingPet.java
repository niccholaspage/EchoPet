package io.github.dsh105.echopet.entity.living;

import io.github.dsh105.echopet.entity.ICraftPet;
import net.minecraft.server.v1_7_R1.EntityCreature;
import net.minecraft.server.v1_7_R1.EntityLiving;
import org.bukkit.craftbukkit.v1_7_R1.CraftServer;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftCreature;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftLivingEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Vehicle;

public class CraftLivingPet extends CraftCreature implements ICraftPet {

    private EntityLivingPet entityPet;

    public CraftLivingPet(CraftServer server, EntityLivingPet entity) {
        super(server, entity);
        this.entityPet = entity;
    }

    @Override
    public EntityLivingPet getHandle() {
        return this.entityPet;
    }

    @Override
    public EntityType getType() {
        return this.entityPet.getPet().getPetType().getEntityType();
    }

    public void remove() {
        super.remove();
    }

    public LivingPet getPet() {
        return entityPet.getPet();
    }

    public CraftLivingEntity getTarget() {
        if (getHandle().target == null) return null;
        if (!(getHandle().target instanceof EntityLiving)) return null;
        return (CraftLivingEntity) getHandle().target.getBukkitEntity();
    }

    public void setTarget(LivingEntity target) {
        EntityCreature entity = getHandle();
        if (target == null) {
            entity.target = null;
        } else if (target instanceof CraftLivingEntity) {
            entity.target = ((CraftLivingEntity) target).getHandle();
            entity.pathEntity = entity.world.findPath(entity, entity.target, 16.0F, true, false, false, true);
        }
    }

    public void _INVALID_damage(int amount) {
        damage((double) amount);
    }

    public void _INVALID_damage(int amount, Entity source) {
        damage((double) amount, source);
    }

    public int _INVALID_getHealth() {
        return (int) getHealth();
    }

    public int _INVALID_getLastDamage() {
        return (int) getLastDamage();
    }

    public int _INVALID_getMaxHealth() {
        return (int) getMaxHealth();
    }

    public void _INVALID_setHealth(int health) {
        setHealth((double) health);
    }

    public void _INVALID_setLastDamage(int damage) {
        setLastDamage((double) damage);
    }

    public void _INVALID_setMaxHealth(int health) {
    }

    @Override
    public void setHealth(double health) {
        if (health < 0) {
            health = 0;
        }
        if (health > getMaxHealth()) {
            health = getMaxHealth();
        }
        super.setHealth(health);
    }

}
