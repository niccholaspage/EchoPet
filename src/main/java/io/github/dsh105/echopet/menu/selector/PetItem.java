package io.github.dsh105.echopet.menu.selector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.github.dsh105.echopet.EchoPet;
import io.github.dsh105.echopet.entity.living.data.PetType;
import io.github.dsh105.echopet.mysql.SQLPetHandler;
import io.github.dsh105.echopet.util.PetUtil;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;


public enum PetItem {

<<<<<<< HEAD
	BAT(PetType.BAT, Material.getMaterial(383), 1, (short) 65,  "Bat Pet"),
	BLAZE(PetType.BLAZE, Material.getMaterial(383), 1, (short) 61,  "Blaze Pet"),
	CAVESPIDER(PetType.CAVESPIDER, Material.getMaterial(383), 1, (short) 59,  "Cave Spider Pet"),
	CHICKEN(PetType.CHICKEN, Material.getMaterial(383), 1, (short) 93,  "Chicken Pet"),
	COW(PetType.COW, Material.getMaterial(383), 1, (short) 92,  "Cow Pet"),
	CREEPER(PetType.CREEPER, Material.getMaterial(383), 1, (short) 50,  "Creeper Pet"),
	ENDERDRAGON(PetType.ENDERDRAGON, Material.getMaterial(122), 1, (short) 0,  "EnderDragon Pet"),
	ENDERMAN(PetType.ENDERMAN, Material.getMaterial(383), 1, (short) 58,  "Enderman Pet"),
	GHAST(PetType.GHAST, Material.getMaterial(383), 1, (short) 56,  "Ghast Pet"),
	GIANT(PetType.GIANT, Material.getMaterial(383), 1, (short) 54,  "Giant Pet"),
	HORSE(PetType.HORSE, Material.getMaterial(383), 1, (short) 100,  "Horse Pet"),
	HUMAN(PetType.HUMAN, Material.SKULL, 1, (short) 3, "Human Pet"),
	IRONGOLEM(PetType.IRONGOLEM, Material.getMaterial(86), 1, (short) 0,  "Iron Golem Pet"),
	MAGMACUBE(PetType.MAGMACUBE, Material.getMaterial(383), 1, (short) 62,  "Magma Cube Pet"),
	MUSHROOMCOW(PetType.MUSHROOMCOW, Material.getMaterial(383), 1, (short) 96,  "Mushroom Cow Pet"),
	OCELOT(PetType.OCELOT, Material.getMaterial(383), 1, (short) 98,  "Ocelot Pet"),
	PIG(PetType.PIG, Material.getMaterial(383), 1, (short) 90,  "Pig Pet"),
	PIGZOMBIE(PetType.PIGZOMBIE, Material.getMaterial(383), 1, (short) 57,  "PigZombie Pet"),
	SHEEP(PetType.SHEEP, Material.getMaterial(383), 1, (short) 91,  "Sheep Pet"),
	SILVERFISH(PetType.SILVERFISH, Material.getMaterial(383), 1, (short) 60,  "Silverfish Pet"),
	SKELETON(PetType.SKELETON, Material.getMaterial(383), 1, (short) 51,  "Skeleton Pet"),
	SLIME(PetType.SLIME, Material.getMaterial(383), 1, (short) 55,  "Slime Pet"),
	SNOWMAN(PetType.SNOWMAN, Material.getMaterial(332), 1, (short) 0,  "Snowman Pet"),
	SPIDER(PetType.SPIDER, Material.getMaterial(383), 1, (short) 52,  "Spider Pet"),
	SQUID(PetType.SQUID, Material.getMaterial(383), 1, (short) 94,  "Squid Pet"),
	VILLAGER(PetType.VILLAGER, Material.getMaterial(383), 1, (short) 120,  "Villager Pet"),
	WITCH(PetType.WITCH, Material.getMaterial(383), 1, (short) 66,  "Witch Pet"),
	WITHER(PetType.WITHER, Material.getMaterial(399), 1, (short) 0,  "Wither Pet"),
	WOLF(PetType.WOLF, Material.getMaterial(383), 1, (short) 95,  "Wolf Pet"),
	ZOMBIE(PetType.ZOMBIE, Material.getMaterial(383), 1, (short) 54,  "Zombie Pet");

	public PetType petType;
	private Material mat;
	private int amount;
	private short data;
	private String name;

	PetItem(PetType petType, Material mat, int amount, short data, String name) {
		this.petType = petType;
		this.mat = mat;
		this.amount = amount;
		this.data = data;
		this.name = name;
	}

	public ItemStack getItem(Player p) {
		ItemStack i = new ItemStack(this.mat, this.amount, this.data);
		ItemMeta meta = i.getItemMeta();
		boolean hasPerm = p.hasPermission("echopet.*") || p.hasPermission("echopet.pet.*") || p.hasPermission("echopet.pet.type.*") || p.hasPermission("echopet.pet.type." + PetUtil.getPetPerm(this.petType));

		ChatColor color = (hasPerm ? ChatColor.GREEN : ChatColor.RED);

		meta.setDisplayName(color + this.name);

		ArrayList<String> lore = new ArrayList<String>();

		EchoPet plugin = EchoPet.getPluginInstance();

		String loreDesc = plugin.options.getLore(petType);

		if (loreDesc != null && loreDesc.length() > 0){
			loreDesc = loreDesc.replace("&", "\u00A7");

			lore.add(color + loreDesc);
		}

		boolean hasNoPayPerm = p.hasPermission("echopet.nopay.*") || p.hasPermission("echopet.pet.nopay.*") || p.hasPermission("echopet.pet.nopay.type.*") || p.hasPermission("echopet.pet.nopay.type." + PetUtil.getPetPerm(this.petType));

		if (SQLPetHandler.getInstance().isBought(p, petType) || hasNoPayPerm){
			lore.add(ChatColor.GREEN + "Purchased");
		}else if (!hasNoPayPerm){
			double cost = plugin.options.getCost(petType);

			if (plugin.getEconomy() != null && cost > 0){
				lore.add(ChatColor.YELLOW + plugin.getEconomy().format(cost));
			}
		}

		meta.setLore(lore);

		i.setItemMeta(meta);
		return i;
	}

	public static PetItem[] valuesByCost(final Player p){
		List<PetItem> petItems = new ArrayList<PetItem>(Arrays.asList(values()));

		final EchoPet plugin = EchoPet.getPluginInstance();
		
		Collections.sort(petItems, new Comparator<PetItem>() {
			@Override
			public int compare(PetItem p1, PetItem p2) {
				PetType type1 = p1.petType;
				
				PetType type2 = p2.petType;
				
				double cost1 = plugin.options.getCost(type1);
				
				boolean hasNoPayPerm = p.hasPermission("echopet.nopay.*") || p.hasPermission("echopet.pet.nopay.*") || p.hasPermission("echopet.pet.nopay.type.*") || p.hasPermission("echopet.pet.nopay.type." + PetUtil.getPetPerm(type1));
				
				if (SQLPetHandler.getInstance().isBought(p, type1) || hasNoPayPerm){
					cost1 = 0;
				}
				
				double cost2 = plugin.options.getCost(type2);
				
				return (int) (cost1 - cost2);
			}
		});
		
		return (PetItem[]) petItems.toArray(new PetItem[petItems.size()]);
	}
=======
    BAT(PetType.BAT, Material.getMaterial(383), 1, (short) 65,  "Bat Pet"),
    BLAZE(PetType.BLAZE, Material.getMaterial(383), 1, (short) 61,  "Blaze Pet"),
    CAVESPIDER(PetType.CAVESPIDER, Material.getMaterial(383), 1, (short) 59,  "Cave Spider Pet"),
    CHICKEN(PetType.CHICKEN, Material.getMaterial(383), 1, (short) 93,  "Chicken Pet"),
    COW(PetType.COW, Material.getMaterial(383), 1, (short) 92,  "Cow Pet"),
    CREEPER(PetType.CREEPER, Material.getMaterial(383), 1, (short) 50,  "Creeper Pet"),
    ENDERDRAGON(PetType.ENDERDRAGON, Material.getMaterial(122), 1, (short) 0,  "EnderDragon Pet"),
    ENDERMAN(PetType.ENDERMAN, Material.getMaterial(383), 1, (short) 58,  "Enderman Pet"),
    GHAST(PetType.GHAST, Material.getMaterial(383), 1, (short) 56,  "Ghast Pet"),
    GIANT(PetType.GIANT, Material.getMaterial(383), 1, (short) 54,  "Giant Pet"),
    HORSE(PetType.HORSE, Material.getMaterial(383), 1, (short) 100,  "Horse Pet"),
    HUMAN(PetType.HUMAN, Material.SKULL_ITEM, 1, (short) 3, "Human Pet"),
    IRONGOLEM(PetType.IRONGOLEM, Material.getMaterial(86), 1, (short) 0,  "Iron Golem Pet"),
    MAGMACUBE(PetType.MAGMACUBE, Material.getMaterial(383), 1, (short) 62,  "Magma Cube Pet"),
    MUSHROOMCOW(PetType.MUSHROOMCOW, Material.getMaterial(383), 1, (short) 96,  "Mushroom Cow Pet"),
    OCELOT(PetType.OCELOT, Material.getMaterial(383), 1, (short) 98,  "Ocelot Pet"),
    PIG(PetType.PIG, Material.getMaterial(383), 1, (short) 90,  "Pig Pet"),
    PIGZOMBIE(PetType.PIGZOMBIE, Material.getMaterial(383), 1, (short) 57,  "PigZombie Pet"),
    SHEEP(PetType.SHEEP, Material.getMaterial(383), 1, (short) 91,  "Sheep Pet"),
    SILVERFISH(PetType.SILVERFISH, Material.getMaterial(383), 1, (short) 60,  "Silverfish Pet"),
    SKELETON(PetType.SKELETON, Material.getMaterial(383), 1, (short) 51,  "Skeleton Pet"),
    SLIME(PetType.SLIME, Material.getMaterial(383), 1, (short) 55,  "Slime Pet"),
    SNOWMAN(PetType.SNOWMAN, Material.getMaterial(332), 1, (short) 0,  "Snowman Pet"),
    SPIDER(PetType.SPIDER, Material.getMaterial(383), 1, (short) 52,  "Spider Pet"),
    SQUID(PetType.SQUID, Material.getMaterial(383), 1, (short) 94,  "Squid Pet"),
    VILLAGER(PetType.VILLAGER, Material.getMaterial(383), 1, (short) 120,  "Villager Pet"),
    WITCH(PetType.WITCH, Material.getMaterial(383), 1, (short) 66,  "Witch Pet"),
    WITHER(PetType.WITHER, Material.getMaterial(399), 1, (short) 0,  "Wither Pet"),
    WOLF(PetType.WOLF, Material.getMaterial(383), 1, (short) 95,  "Wolf Pet"),
    ZOMBIE(PetType.ZOMBIE, Material.getMaterial(383), 1, (short) 54,  "Zombie Pet");

    public PetType petType;
    private Material mat;
    private int amount;
    private short data;
    private String name;

    PetItem(PetType petType, Material mat, int amount, short data, String name) {
        this.petType = petType;
        this.mat = mat;
        this.amount = amount;
        this.data = data;
        this.name = name;
    }

    public ItemStack getItem(Player p) {
        ItemStack i = new ItemStack(this.mat, this.amount, this.data);
        ItemMeta meta = i.getItemMeta();
        boolean hasPerm = p.hasPermission("echopet.*") || p.hasPermission("echopet.pet.*") || p.hasPermission("echopet.pet.type.*") || p.hasPermission("echopet.pet.type." + PetUtil.getPetPerm(this.petType));
        meta.setDisplayName((hasPerm ? ChatColor.GREEN : ChatColor.RED) + this.name);
        //meta.setLore(this.lore);
        i.setItemMeta(meta);

        if (this == PetItem.HUMAN) {
            SkullMeta sm = (SkullMeta) i.getItemMeta();
            sm.setOwner(p.getName());
            i.setItemMeta(sm);
        }
        return i;
    }
>>>>>>> upstream/master
}