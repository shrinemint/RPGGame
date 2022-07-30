package src.rpg.entity;

import src.rpg.main.GameLogic;
import src.rpg.entity.attributes.Leveller;
import src.rpg.entity.attributes.StatList;
import src.rpg.items.Inventory;
import src.rpg.entity.attributes.BattleAction;

/**
 * Basic preset for all entities in the game such as the player and enemies.
 * On second thought, it's only used for those classes...
 * oh well
 * For the most part, you're probably only gonna be editing the parent class.
 * You edit the child classes if there are specific actions that the specific child class can do.
 */

public class Entity {
    
    private String name;
    private Leveller leveller;
    private StatList stats;
    private Inventory inv;
    private BattleAction action;

    public Entity(String name, Leveller leveller, StatList stats, Inventory inv) {
        this.name = name;
        this.leveller = leveller;
        this.stats = stats;
        this.inv = inv;
    }

    public void selectItem() {
        boolean choosing = true;
        while (choosing) {
            int i = 0;
            while (i < inv.getMaxSize()) {
                System.out.println((i + 1) + " : " + inv.get(i).getName());
                i++;
            }

            int choice = GameLogic.promptInt("Which item will you use?");
            if (choice < 1 || choice > inv.getMaxSize()) {
                System.out.println("Choice out of range.");
            }
            else {
                inv.use(choice - 1, this);
                choosing = false;
            }
        }
        


    }

    public void attack(Entity target) {

    }

    public void defend(Entity target) {

    }

    public void executeAction() {
        switch (action.getType()) {
            case ATTACK:
                attack(action.getTarget());
                break;
            
            case ITEM:
                
                break;
            
            case DEFEND:
                defend(action.getTarget());
                break;
        }
    }

    public String setName(String name) { //i like adding a return statement even tho this is a set method and you can't make me stop
        this.name = name;
        return name;
    }
    
    public Leveller setLeveller(Leveller leveller) {
        this.leveller = leveller;
        return leveller;
    }
    
    public StatList setStats(StatList stats) {
        this.stats = stats;
        return stats;
    }
    
    public Inventory setInventory(Inventory inv) {
        this.inv = inv;
        return inv;
    }

    public BattleAction setAction(BattleAction action) {
        this.action = action;
        return action;
    }

    public void getInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Level: " + getLeveller().getLevel());
        System.out.println("XP: " + getLeveller().getXP() + "/" + getLeveller().getMaxXP());
        System.out.println("HP: " + getStats().getHP() + "/" + getStats().getMaxHP());
        System.out.println("Attack: " + getStats().getAttack());
        System.out.println("Defense: " + getStats().getDefense());
        System.out.println("Speed: " + getStats().getSpeed());
        System.out.println("Held Weapon: " + getInventory().getWeaponSlot().getName());
        System.out.println("Helmet: " + getInventory().getArmorSet().getHelmet().getName());
        System.out.println("Chestplate: " + getInventory().getArmorSet().getChestplate().getName());
        System.out.println("Leggings: " + getInventory().getArmorSet().getLeggings().getName());
        System.out.println("Boots: " + getInventory().getArmorSet().getBoots().getName());
        System.out.println("Inventory Size: " + getInventory().getMaxSize());
        int i = 0;
        while (i < getInventory().getMaxSize()) {
            System.out.println((i + 1) + " : " + getInventory().get(i).getName() + " x" + getInventory().get(i).getQuantity());
            i++;
        }
    }

    public String getName() {return name;}
    public Leveller getLeveller() {return leveller;}
    public StatList getStats() {return stats;}
    public Inventory getInventory() {return inv;}
    public BattleAction getAction() {return action;}
}
