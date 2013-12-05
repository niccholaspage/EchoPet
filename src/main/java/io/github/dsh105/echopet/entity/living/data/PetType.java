package io.github.dsh105.echopet.entity.living.data;

import io.github.dsh105.echopet.EchoPet;
import io.github.dsh105.echopet.entity.living.EntityLivingPet;
import io.github.dsh105.echopet.entity.living.LivingPet;
import io.github.dsh105.echopet.entity.living.type.bat.BatPet;
import io.github.dsh105.echopet.entity.living.type.bat.EntityBatPet;
import io.github.dsh105.echopet.entity.living.type.blaze.BlazePet;
import io.github.dsh105.echopet.entity.living.type.blaze.EntityBlazePet;
import io.github.dsh105.echopet.entity.living.type.cavespider.CaveSpiderPet;
import io.github.dsh105.echopet.entity.living.type.cavespider.EntityCaveSpiderPet;
import io.github.dsh105.echopet.entity.living.type.chicken.ChickenPet;
import io.github.dsh105.echopet.entity.living.type.chicken.EntityChickenPet;
import io.github.dsh105.echopet.entity.living.type.cow.CowPet;
import io.github.dsh105.echopet.entity.living.type.cow.EntityCowPet;
import io.github.dsh105.echopet.entity.living.type.creeper.CreeperPet;
import io.github.dsh105.echopet.entity.living.type.creeper.EntityCreeperPet;
import io.github.dsh105.echopet.entity.living.type.enderdragon.EnderDragonPet;
import io.github.dsh105.echopet.entity.living.type.enderdragon.EntityEnderDragonPet;
import io.github.dsh105.echopet.entity.living.type.enderman.EndermanPet;
import io.github.dsh105.echopet.entity.living.type.enderman.EntityEndermanPet;
import io.github.dsh105.echopet.entity.living.type.ghast.EntityGhastPet;
import io.github.dsh105.echopet.entity.living.type.ghast.GhastPet;
import io.github.dsh105.echopet.entity.living.type.giant.EntityGiantPet;
import io.github.dsh105.echopet.entity.living.type.giant.GiantPet;
import io.github.dsh105.echopet.entity.living.type.horse.EntityHorsePet;
import io.github.dsh105.echopet.entity.living.type.horse.HorsePet;
import io.github.dsh105.echopet.entity.living.type.human.EntityHumanPet;
import io.github.dsh105.echopet.entity.living.type.human.HumanPet;
import io.github.dsh105.echopet.entity.living.type.irongolem.EntityIronGolemPet;
import io.github.dsh105.echopet.entity.living.type.irongolem.IronGolemPet;
import io.github.dsh105.echopet.entity.living.type.magmacube.EntityMagmaCubePet;
import io.github.dsh105.echopet.entity.living.type.magmacube.MagmaCubePet;
import io.github.dsh105.echopet.entity.living.type.mushroomcow.EntityMushroomCowPet;
import io.github.dsh105.echopet.entity.living.type.mushroomcow.MushroomCowPet;
import io.github.dsh105.echopet.entity.living.type.ocelot.EntityOcelotPet;
import io.github.dsh105.echopet.entity.living.type.ocelot.OcelotPet;
import io.github.dsh105.echopet.entity.living.type.pig.EntityPigPet;
import io.github.dsh105.echopet.entity.living.type.pig.PigPet;
import io.github.dsh105.echopet.entity.living.type.pigzombie.EntityPigZombiePet;
import io.github.dsh105.echopet.entity.living.type.pigzombie.PigZombiePet;
import io.github.dsh105.echopet.entity.living.type.sheep.EntitySheepPet;
import io.github.dsh105.echopet.entity.living.type.sheep.SheepPet;
import io.github.dsh105.echopet.entity.living.type.silverfish.EntitySilverfishPet;
import io.github.dsh105.echopet.entity.living.type.silverfish.SilverfishPet;
import io.github.dsh105.echopet.entity.living.type.skeleton.EntitySkeletonPet;
import io.github.dsh105.echopet.entity.living.type.skeleton.SkeletonPet;
import io.github.dsh105.echopet.entity.living.type.slime.EntitySlimePet;
import io.github.dsh105.echopet.entity.living.type.slime.SlimePet;
import io.github.dsh105.echopet.entity.living.type.snowman.EntitySnowmanPet;
import io.github.dsh105.echopet.entity.living.type.snowman.SnowmanPet;
import io.github.dsh105.echopet.entity.living.type.spider.EntitySpiderPet;
import io.github.dsh105.echopet.entity.living.type.spider.SpiderPet;
import io.github.dsh105.echopet.entity.living.type.squid.EntitySquidPet;
import io.github.dsh105.echopet.entity.living.type.squid.SquidPet;
import io.github.dsh105.echopet.entity.living.type.villager.EntityVillagerPet;
import io.github.dsh105.echopet.entity.living.type.villager.VillagerPet;
import io.github.dsh105.echopet.entity.living.type.witch.EntityWitchPet;
import io.github.dsh105.echopet.entity.living.type.witch.WitchPet;
import io.github.dsh105.echopet.entity.living.type.wither.EntityWitherPet;
import io.github.dsh105.echopet.entity.living.type.wither.WitherPet;
import io.github.dsh105.echopet.entity.living.type.wolf.EntityWolfPet;
import io.github.dsh105.echopet.entity.living.type.wolf.WolfPet;
import io.github.dsh105.echopet.entity.living.type.zombie.EntityZombiePet;
import io.github.dsh105.echopet.entity.living.type.zombie.ZombiePet;
import io.github.dsh105.echopet.logger.Logger;
import net.minecraft.server.v1_7_R1.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public enum PetType {

	/*
	 * Enumeration of valid pet types
	 * Stores valid pet data types
	 */

    // Aggressive mobs
    BLAZE(EntityBlazePet.class, BlazePet.class, 61, "Blaze Pet", 20D, 6D, EntityType.BLAZE, PetData.FIRE),
    CAVESPIDER(EntityCaveSpiderPet.class, CaveSpiderPet.class, 59, "Cave Spider Pet", 12D, 5D, EntityType.CAVE_SPIDER),
    CREEPER(EntityCreeperPet.class, CreeperPet.class, 50, "Creeper Pet", 20D, 6D, EntityType.CREEPER, PetData.POWER),
    ENDERDRAGON(EntityEnderDragonPet.class, EnderDragonPet.class, 63, "EnderDragon Pet", 200D, 0D, EntityType.ENDER_DRAGON),
    ENDERMAN(EntityEndermanPet.class, EndermanPet.class, 58, "Enderman Pet", 40D, 6D, EntityType.ENDERMAN, PetData.SCREAMING),
    GHAST(EntityGhastPet.class, GhastPet.class, 56, "Ghast Pet", 10D, 7D, EntityType.GHAST),
    GIANT(EntityGiantPet.class, GiantPet.class, 53, "Giant Pet", 100D, 0D, EntityType.GIANT),
    MAGMACUBE(EntityMagmaCubePet.class, MagmaCubePet.class, 62, "Magma Cube Pet", 20D, 5D, EntityType.MAGMA_CUBE, PetData.SMALL, PetData.MEDIUM, PetData.LARGE),
    PIGZOMBIE(EntityPigZombiePet.class, PigZombiePet.class, 57, "Pig Zombie Pet", 20D, 6D, EntityType.PIG_ZOMBIE, PetData.BABY, PetData.VILLAGER),
    SILVERFISH(EntitySilverfishPet.class, SilverfishPet.class, 60, "Silverfish Pet", 8D, 4D, EntityType.SILVERFISH),
    SKELETON(EntitySkeletonPet.class, SkeletonPet.class, 51, "Skeleton Pet", 20D, 5D, EntityType.SKELETON, PetData.WITHER),
    SLIME(EntitySlimePet.class, SlimePet.class, 55, "Slime Pet", 20D, 4D, EntityType.SLIME, PetData.SMALL, PetData.MEDIUM, PetData.LARGE),
    SPIDER(EntitySpiderPet.class, SpiderPet.class, 52, "Spider Pet", 16D, 5D, EntityType.SPIDER),
    WITCH(EntityWitchPet.class, WitchPet.class, 66, "Witch Pet", 26D, 5D, EntityType.WITCH),
    WITHER(EntityWitherPet.class, WitherPet.class, 64, "Wither Pet", 300D, 8D, EntityType.WITHER, PetData.SHIELD),
    ZOMBIE(EntityZombiePet.class, ZombiePet.class, 54, "Zombie Pet", 20D, 5D, EntityType.ZOMBIE, PetData.BABY, PetData.VILLAGER),

    // Passive mobs
    BAT(EntityBatPet.class, BatPet.class, 65, "Bat Pet", 6D, 3D, EntityType.BAT),
    CHICKEN(EntityChickenPet.class, ChickenPet.class, 93, "Chicken Pet", 4D, 3D, EntityType.CHICKEN, PetData.BABY),
    COW(EntityCowPet.class, CowPet.class, 92, "Cow Pet", 10D, 4D, EntityType.COW, PetData.BABY),
    HORSE(EntityHorsePet.class, HorsePet.class, 100, "Horse Pet", 30D, 4D, EntityType.HORSE, PetData.BABY, PetData.CHESTED, PetData.SADDLE,
            PetData.NORMAL, PetData.DONKEY,
            PetData.MULE, PetData.SKELETON, PetData.ZOMBIE, PetData.WHITE,
            PetData.CREAMY, PetData.CHESTNUT, PetData.BROWN, PetData.BLACK,
            PetData.GRAY, PetData.DARKBROWN, PetData.NONE, PetData.SOCKS,
            PetData.WHITEPATCH, PetData.WHITESPOT, PetData.BLACKSPOT,
            PetData.NOARMOUR, PetData.IRON, PetData.GOLD, PetData.DIAMOND),
    IRONGOLEM(EntityIronGolemPet.class, IronGolemPet.class, 99, "Iron Golem Pet", 100D, 7D, EntityType.IRON_GOLEM),
    MUSHROOMCOW(EntityMushroomCowPet.class, MushroomCowPet.class, 96, "Mushroom Cow Pet", 10D, 3D, EntityType.MUSHROOM_COW, PetData.BABY),
    OCELOT(EntityOcelotPet.class, OcelotPet.class, 98, "Ocelot Pet", 10D, 4D, EntityType.OCELOT, PetData.BABY, PetData.BLACK, PetData.RED, PetData.SIAMESE, PetData.WILD),
    PIG(EntityPigPet.class, PigPet.class, 90, "Pig Pet", 10D, 3D, EntityType.PIG, PetData.BABY, PetData.SADDLE),
    SHEEP(EntitySheepPet.class, SheepPet.class, 91, "Sheep Pet", 8D, 3D, EntityType.SHEEP, PetData.BABY, PetData.SHEARED,
            PetData.BLACK, PetData.BLUE, PetData.BROWN,
            PetData.CYAN, PetData.GRAY, PetData.GREEN,
            PetData.LIGHTBLUE, PetData.LIME, PetData.MAGENTA,
            PetData.ORANGE, PetData.PINK, PetData.PURPLE, PetData.RED,
            PetData.SILVER, PetData.WHITE, PetData.YELLOW),
    SNOWMAN(EntitySnowmanPet.class, SnowmanPet.class, 97, "Snowman Pet", 4D, 4D, EntityType.SNOWMAN),
    SQUID(EntitySquidPet.class, SquidPet.class, 94, "Squid Pet", 10D, 4D, EntityType.SQUID),
    VILLAGER(EntityVillagerPet.class, VillagerPet.class, 120, "Villager Pet", 20D, 4D, EntityType.VILLAGER, PetData.BABY, PetData.BLACKSMITH, PetData.BUTCHER, PetData.FARMER, PetData.LIBRARIAN, PetData.PRIEST),
    WOLF(EntityWolfPet.class, WolfPet.class, 95, "Wolf Pet", 20D, 6D, EntityType.WOLF, PetData.BABY, PetData.TAMED, PetData.ANGRY,
            PetData.BLACK, PetData.BLUE, PetData.BROWN,
            PetData.CYAN, PetData.GRAY, PetData.GREEN,
            PetData.LIGHTBLUE, PetData.LIME, PetData.MAGENTA,
            PetData.ORANGE, PetData.PINK, PetData.PURPLE, PetData.RED,
            PetData.SILVER, PetData.WHITE, PetData.YELLOW),

    HUMAN(EntityHumanPet.class, HumanPet.class, 54, "Human Pet", 20D, 6D, EntityType.UNKNOWN),
    ;

    private Class<? extends EntityLivingPet> entityClass;
    private Class<? extends LivingPet> craftClass;
    private String defaultName;
    private double maxHealth;
    private double attackDamage;
    private EntityType entityType;
    private List<PetData> allowedData;
    private int id;

    PetType(Class<? extends EntityLivingPet> entityClass, Class<? extends LivingPet> craftClass, int registrationId, String defaultName, double maxHealth, double attackDamage, EntityType entityType, PetData... allowedData) {
        this.entityClass = entityClass;
        this.craftClass = craftClass;
        this.id = registrationId;
        this.allowedData = Arrays.asList(allowedData);
        this.maxHealth = maxHealth;
        this.attackDamage = attackDamage;
        this.entityType = entityType;
        this.defaultName = defaultName;
    }

    public int getRegistrationId() {
        return this.id;
    }

    public double getMaxHealth() {
        return this.maxHealth;
    }

    public String getDefaultName(String name) {
        return EchoPet.getInstance().getMainConfig().getString("pets." + this.toString().toLowerCase().replace("_", " ") + ".defaultName", this.defaultName).replace("(user)", name).replace("(userApos)", name + "'s");
    }

    public String getDefaultName() {
        return this.defaultName;
    }

    public double getAttackDamage() {
        return EchoPet.getInstance().getMainConfig().getDouble("pets." + this.toString().toLowerCase().replace("_", " ") + ".attackDamage", this.attackDamage);
    }

    public EntityType getEntityType() {
        return this.entityType;
    }

    public List<PetData> getAllowedDataTypes() {
        return this.allowedData;
    }

    public boolean isDataAllowed(PetData data) {
        return getAllowedDataTypes().contains(data);
    }

    public EntityLivingPet getNewEntityInstance(World world, LivingPet pet) {
        EntityLivingPet ePet = null;
        try {
            Object o = entityClass.getConstructor(World.class, LivingPet.class).newInstance(world, pet);
            if (o instanceof EntityLivingPet) {
                ePet = (EntityLivingPet) o;
            }
        } catch (Exception e) {
            Logger.log(Logger.LogLevel.SEVERE, "Failed to create new EntityLivingPet instance.", e, true);
        }
        return ePet;
    }

    public LivingPet getNewPetInstance(Player owner, PetType pt) {
        LivingPet p = null;
        try {
            Object o = craftClass.getConstructor(Player.class, PetType.class).newInstance(owner, pt);
            if (o instanceof LivingPet) {
                p = (LivingPet) o;
            }
        } catch (Exception e) {
            Logger.log(Logger.LogLevel.SEVERE, "Failed to create new LivingPet instance [" + pt.toString() + "].", e, true);
        }
        return p;
    }

    public Class<? extends EntityLivingPet> getEntityClass() {
        return this.entityClass;
    }

    public Class<? extends LivingPet> getPetClass() {
        return this.craftClass;
    }
}