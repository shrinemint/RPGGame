package src.rpg.main;

import src.rpg.entity.Entity;
import src.rpg.items.armor.*;
import src.rpg.items.weapons.Weapon;
import src.rpg.items.weapons.WeaponList;

/**
 * Where everything is executed
 * Probably should create a player and enemy class first
 */

public class Main {
    public Main() {
        init();
        
        
        Entity tester = GameLogic.createPlayer();
        tester.setWeaponSlot(new Weapon(WeaponList.GUN));
        tester.getInventory().add(new Weapon(WeaponList.WOODEN_SWORD));
        System.out.println(tester.getInventory().getSize());
        System.out.println(tester.getInventory().getMaxSize());

        System.out.println("Held Weapon: " + tester.getWeaponSlot().getName());
        for (int i = 0; i < tester.getInventory().getMaxSize(); i++) { //prints inventory
            System.out.println((i + 1) + " : " + tester.getInventory().get(i).getName());
        }
        

        //tester.getInventory().remove(0);
        //System.out.println(tester.getInventory().getSize());
        tester.getInventory().use(0, tester);

        System.out.println("Held Weapon: " + tester.getWeaponSlot().getName());
        for (int i = 0; i < tester.getInventory().getMaxSize(); i++) { //prints inventory
            System.out.println((i + 1) + " : " + tester.getInventory().get(i).getName());
        }
    }

    public static void main(String args[]) { //little bitch boy static void main here lmaaaoooo
        new Main();
    }
    
    public void init() { //a method activating all the initialization methods
        GameLogic.initItemList();
    }

}
