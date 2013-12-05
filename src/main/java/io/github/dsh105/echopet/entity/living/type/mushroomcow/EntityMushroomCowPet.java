package io.github.dsh105.echopet.entity.living.type.mushroomcow;

import io.github.dsh105.echopet.entity.living.EntityAgeablePet;
import io.github.dsh105.echopet.entity.living.LivingPet;
import net.minecraft.server.v1_7_R1.World;


public class EntityMushroomCowPet extends EntityAgeablePet {

    public EntityMushroomCowPet(World world) {
        super(world);
    }

    public EntityMushroomCowPet(World world, LivingPet pet) {
        super(world, pet);
        this.a(0.9F, 1.3F);
        this.fireProof = true;
    }

    @Override
    protected void makeStepSound() {
        this.makeSound("mob.cow.step", 0.15F, 1.0F);
    }

    @Override
    protected String getIdleSound() {
        return "mob.cow.say";
    }

    @Override
    protected String getDeathSound() {
        return "mob.cow.death";
    }
}