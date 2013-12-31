package io.github.dsh105.echopet.api.event;

import io.github.dsh105.echopet.entity.Pet;
import io.github.dsh105.echopet.entity.living.LivingPet;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

/**
 * Called when a {@link io.github.dsh105.echopet.entity.Pet} damages another {@link org.bukkit.entity.Entity}
 */

public class PetDamageEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled = true; // cancelled by default

    private Pet pet;
    private double damage;
    private DamageCause damageCause;

    public PetDamageEvent(Pet pet, DamageCause damageCause, final double damage) {
        this.pet = pet;
        this.damage = damage;
        this.damageCause = damageCause;
    }

    /**
     * Gets the damage dealt by the {@link io.github.dsh105.echopet.entity.Pet}
     *
     * @return damage dealt
     */
    public double getDamage() {
        return this.damage;
    }

    /**
     * Sets the damage of the event
     *
     * @param damage amount of health to take off
     */
    public void setDamage(double damage) {
        this.damage = damage;
    }

    /**
     * Gets the {@link io.github.dsh105.echopet.entity.Pet} involved in this event
     *
     * @return the {@link io.github.dsh105.echopet.entity.Pet} involved
     */
    public Pet getPet() {
        return this.pet;
    }

    public DamageCause getDamageCause() {
        return this.damageCause;
    }

    /**
     * Gets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins
     *
     * @return true if this event is cancelled
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Sets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins
     *
     * @param cancel true if you wish to cancel this event
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return this.handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}