package io.github.dsh105.echopet.entity.living.type.ocelot;

import io.github.dsh105.echopet.entity.Pet;
import io.github.dsh105.echopet.entity.living.CraftAgeablePet;
import io.github.dsh105.echopet.entity.living.EntityLivingPet;
import org.bukkit.craftbukkit.v1_7_R1.CraftServer;
import org.bukkit.entity.Ocelot;

public class CraftOcelotPet extends CraftAgeablePet implements Ocelot {

    public CraftOcelotPet(CraftServer server, EntityLivingPet entity) {
        super(server, entity);
    }

    @Override
    public Type getCatType() {
        Pet p = this.getPet();
        if (p instanceof OcelotPet) {
            return ((OcelotPet) p).getCatType();
        }
        return null;
    }

    @Override
    public void setCatType(Type type) {
        /*Pet p = this.getPet();
        if (p instanceof OcelotPet) {
            ((OcelotPet) p).setCatType(type);
        }*/
    }

    @Override
    public boolean isSitting() {
        return false;
    }

    @Override
    public void setSitting(boolean b) {
        // Doesn't apply to Pets
    }
}