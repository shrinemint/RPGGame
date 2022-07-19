package src.rpg.items;

import java.util.ArrayList;
import java.util.List;

import src.rpg.entity.Entity;
import src.rpg.items.Item.ItemType;
import src.rpg.items.armor.Armor;
import src.rpg.items.consumable.Consumable;
import src.rpg.items.misc.Misc;
import src.rpg.items.misc.MiscList;
import src.rpg.items.weapons.Weapon;
import src.rpg.items.weapons.WeaponList;
import src.rpg.main.GameLogic;

/**
 * A glorified ArrayList but I totally promise to you that this is necessary
 * You see, you can set a maximum size be able to change it.
 * That's honestly bout it...
 */

public class Inventory {
    private int maxSize;
    private List<Item> inv;

    public Inventory() {
        this.maxSize = 10;
        inv = new ArrayList<Item>();
        clear();
    }

    public Inventory(int maxSize) {
        this.maxSize = maxSize;
        inv = new ArrayList<Item>();
        clear();
    }

    public void use(int i, Entity e) { //might need to pass index to item so it can handle being equipped or used by itself
        switch (get(i).getType()) {
            case WEAPON:
                boolean slotOpen = e.getWeaponSlot().is(new Weapon(WeaponList.EMPTY));
                boolean weaponEquipped; //tests if the weapon is successfully equipped or not
                if (slotOpen) {

                }
                else {

                }

                if (weaponEquipped) {
                    remove(i);
                    System.out.println("You equipped the " + get(i).getName() + ".");
                }


                if () { //if entity has no weapon equipped, equip weapon
                    get(i).use(e);
                    
                }
                else {
                    int choice = GameLogic.askSimpleQuestion("Do you want to equip the " + get(i).getName() + "?");
                    if (choice == 1) {
                        Weapon temp = e.getWeaponSlot();
                        get(i).use(e);
                        System.out.println("You equipped the " + get(i).getName() + ".");
                        remove(i);
                        e.getInventory().add(temp);
                    }
                    else {
                        System.out.println("You did not equip the " + get(i).getName());
                    }
                }
                break;

            case ARMOR:
                break;

            case CONSUMABLE:
                break;

            case MISC:
                break;
        }
    }

    /**
     * These next few methods below share a name with a method from the ArrayList class but are different as it needs to work for the inventory,
     * which doesn't function exactly the same
     */
    public Item add(Item item) { //Adds an item to the inventory in the first availible slot.
        //Ensures an item cannot be added to a full inventory on the programmer's end
        if (isFull()) {throw new IllegalArgumentException("Inventory is full.");}
        else {
            int i = 0;
            while (i < maxSize) {
                if (inv.get(i).is(new Misc(MiscList.EMPTY_SLOT))) {
                    inv.set(i, item);
                    break;
                }
                i++;
            }
            return item;
        }
    }

    public boolean remove(int i) { //Removing an item without using it
        inv.set(i, new Misc(MiscList.EMPTY_SLOT));
        return inv.get(i).is(new Misc(MiscList.EMPTY_SLOT));
    }
    
    public boolean clear() { //Clears the inventory and returns true since it should always be cleared after using this method.
        int i = 0;
        while (i < maxSize) {
            inv.add(i, new Misc(MiscList.EMPTY_SLOT));
            i++;
        }
        return !isFull();
    }

    public Item get(int i) {return inv.get(i);}

    public int setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        return maxSize;
    }

    public int getSize() {
        int size = 0;
        int i = 0;
        
        while (i < maxSize) {
            if (!get(i).is(new Misc(MiscList.EMPTY_SLOT))) {
                size++;
            }
            i++;
        }
        return size;
    }
    
    public int getMaxSize() {return maxSize;}
    public boolean isFull() {return getSize() == maxSize;} //Returns if logical size is equal to physical size

}
