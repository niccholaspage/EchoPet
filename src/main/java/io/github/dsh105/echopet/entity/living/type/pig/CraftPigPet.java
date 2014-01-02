package io.github.dsh105.echopet.entity.living.type.pig;

import io.github.dsh105.echopet.entity.Pet;
import io.github.dsh105.echopet.entity.living.CraftAgeablePet;
import io.github.dsh105.echopet.entity.living.EntityLivingPet;
import org.bukkit.craftbukkit.v1_7_R1.CraftServer;
import org.bukkit.entity.Pig;

public class CraftPigPet extends CraftAgeablePet implements Pig {

    public CraftPigPet(CraftServer server, EntityLivingPet entity) {
        super(server, entity);
    }

    @Override
    public boolean hasSaddle() {
        Pet p = this.getPet();
        if (p instanceof PigPet) {
            return ((PigPet) p).hasSaddle();
        }
        return false;
    }

    @Override
    public void setSaddle(boolean b) {
        /*Pet p = this.getPet();
        if (p instanceof PigPet) {
            ((PigPet) p).setSaddle(b);
        }*/
    }
}