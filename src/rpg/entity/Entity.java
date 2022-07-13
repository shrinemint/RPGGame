package src.rpg.entity;

import src.rpg.entity.attributes.Leveller;
import src.rpg.entity.attributes.StatList;
import src.rpg.items.armor.ArmorSet;
import src.rpg.items.weapons.Weapon;
import src.rpg.items.Inventory;

/* Basic preset for all entities in the game such as the player and enemies.
 * On second thought, it's only used for those classes...
 * oh well
 * For the most part, you're probably only gonna be editing the parent class.
 * You edit the child classes if there are specific actions that the specific child class can do.
 */

public class Entity {
    
    private String name;
    private Leveller leveller;
    private StatList stats;
    private ArmorSet armorSet;
    private Weapon weaponSlot;
    private Inventory inv;

    public Entity(String name, Leveller leveller, StatList stats) {
        this.name = name;
        this.leveller = leveller;
        this.stats = stats;
    }

    public String setName(String name) { //i like adding a return statement even tho this is a set method and you can't make me stop
        this.name = name;
        return name;
    }

    public String getName() {return name;}

    public Leveller setLeveller(Leveller leveller) {
        this.leveller = leveller;
        return leveller;
    }

    public Leveller getLeveller() {return leveller;}

    public StatList setStats(StatList stats) {
        this.stats = stats;
        return stats;
    }

    public StatList getStats() {return stats;}

    public ArmorSet setArmorSet(ArmorSet armorSet) {
        this.armorSet = armorSet;
        return armorSet;
    }

    public ArmorSet getArmorSet() {return armorSet;}

    public Weapon setWeaponSlot(Weapon weaponSlot) {
        this.weaponSlot = weaponSlot;
        return weaponSlot;
    }

    public Weapon getWeaponSlot() {return weaponSlot;}

    public Inventory setInventory(Inventory inv) {
        this.inv = inv;
        return inv;
    }

    public Inventory getInventory() {return inv;}
}
