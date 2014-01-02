package io.github.dsh105.echopet.entity.living;

import io.github.dsh105.echopet.entity.CraftPet;
import io.github.dsh105.echopet.entity.EntityPet;
import io.github.dsh105.echopet.entity.Pet;
import net.minecraft.server.v1_7_R1.World;

public abstract class EntityLivingPet extends EntityPet {

    public EntityLivingPet(World world) {
        super(world);
    }

    public EntityLivingPet(World world, LivingPet pet) {
        super(world, pet);
    }

    @Override
    public LivingPet getPet() {
        Pet p = super.getPet();
        if (p instanceof LivingPet) {
            return (LivingPet) super.getPet();
        }
        return null;
    }

    @Override
    public CraftLivingPet getBukkitEntity() {
        if (this.bukkitEntity == null || !(this.bukkitEntity instanceof CraftLivingPet)) {
            CraftPet craftPet = this.getPet().getPetType().getNewCraftInstance(this);
            if (craftPet instanceof CraftLivingPet) {
                this.bukkitEntity = craftPet;
            }
        }
        return (CraftLivingPet) this.bukkitEntity;
    }
}