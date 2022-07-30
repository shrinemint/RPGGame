package src.rpg.items;

import java.util.ArrayList;
import java.util.List;

import src.rpg.entity.Entity;
import src.rpg.entity.attributes.ArmorSet;
import src.rpg.items.Item.ItemType;
import src.rpg.items.armor.Armor;
import src.rpg.items.armor.ArmorList;
import src.rpg.items.misc.Misc;
import src.rpg.items.misc.MiscList;
import src.rpg.items.weapons.Weapon;
import src.rpg.items.weapons.WeaponList;

/**
 * A glorified ArrayList but with special modifications for adding, removing, clearing, etc since empty slots use a specific object rather than using null.
 * This class handles the inventory, armor sets, and the equipped weapon
 * (sorry i don't know how to sort these damn methods in a sensible way.)
 */

public class Inventory {
    private int maxSize;
    private List<Item> inv;
    private ArmorSet armorSet = new ArmorSet();
    private Weapon weaponSlot = new Weapon(WeaponList.EMPTY_SLOT);

    //This constructor creates an inventory with a default size of 10
    public Inventory() {
        inv = new ArrayList<Item>(10);
        setMaxSize(10);
    }

    /**
     * The maximum size of the inventory is passed here.
     * @param maxSize the inventory's maximum size
     */
    public Inventory(int maxSize) {
        inv = new ArrayList<Item>(maxSize);
        setMaxSize(maxSize);
    }

    /**
     * Adds an inventory to the first availible slot as long as the inventory has the space for it to be added.
     * In game, only one item will be added at a time unless buying from a shop.
     * If buying from a shop, the player will not be able to buy more than the item's maximum stack.
     * @param item The item to be added.
     * @param x The quantity to be added.
     */
    public Item add(Item item, int x) {
        if (!canBeAdded(item, x)) {throw new IllegalArgumentException("Inventory does not have enough space for quantity of " + x + ". " + item.getName() + " could not be added.");}
        //If the item is an empty weapon or armor slot, it adds an empty inventory slot instead. This is meant to handle unequipping gear.
        if (item.equals(new Weapon(WeaponList.EMPTY_SLOT))
            || item.equals(new Armor(ArmorList.EMPTY_SLOT))
        ) {
            item = new Misc(MiscList.EMPTY_SLOT);
            x = 1;
        }
        /**
         * Assume that if it's at this points, that canBeAdded works and there is enough allocated space for the item to be added.
         * Runs while x is still greater than 0.
         * If the same item is already in the inventory, then it will always add to that first before adding to an empty slot since
         * it should be impossible for an empty slot to appear before an item in the inventory.
         */
        
        int i = 0;
        while (i < maxSize && x > 0) {
            if (get(i).equals(item)) {
                int quantityToAdd = Math.min(get(i).getMaxStack() - get(i).getQuantity(), x); 
                get(i).addQuantity(quantityToAdd);
                x -= quantityToAdd;
            }
            else if (isEmptySlot(i)) {
                //Sets the empty slot as the item being added
                try {
                    /**
                     * Note: Do not set it as the item passed. They have the same reference.
                     * Instead, use the ItemLibrary.get(); method to get a clone of the object.
                     */
                    inv.set(i, ItemLibrary.get(item.getID()));
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                } 
                int quantityToAdd = Math.min(get(i).getMaxStack(), x); 
                get(i).addQuantity(quantityToAdd);
                x -= quantityToAdd;
            }
            i++;
        }
        
        return item;
    }

    public void remove(int i, int x) { //Removes an item without "using" it. i is the index of the item in the inventory and x is the quantity to remove.
        get(i).addQuantity(-x);
        //If after removing x number of items from the quantity, the quantity becomes zero or less, then remove the item and add an empty slot to the end.
        if (get(i).getQuantity() <= 0) {
            inv.remove(i); //Removes the item at index i.
            inv.add(ItemLibrary.getEmptySlot()); //Readds an empty slot to the end.
        }
    }
    
    /**
     * This clear method will clear the actual ArrayList directly.
     * After doing so, it will "add" empty slots to the inventory.
     */
    public void clear() {
        inv.clear();
        int i = 0;
        while (i < maxSize) {
            inv.add(i, ItemLibrary.getEmptySlot());
            i++;
        }
    }

    public void use(int i, Entity e) {
        if (i > getMaxSize() || i < 0) {throw new IllegalArgumentException("Index is out of range of the inventory's bounds.");}
        switch (get(i).getType()) {
            case WEAPON:
                Weapon tempWeapon = weaponSlot;
                get(i).use(e);
                System.out.println("You equipped the " + get(i).getName() + ".");
                remove(i, 1);
                add(tempWeapon, 1);
                break;

            case ARMOR:
                /**
                 * Equips the armor piece at index i.
                 * First checks the armor type of the armor piece to be equipped.
                 * Then grabs the armor piece in that slot already and stores it into a temporary variable.
                 * Finally equip the piece.
                 */
                Armor tempArmorPiece = new Armor(ArmorList.EMPTY_SLOT);
                switch (((Armor)get(i)).getArmorType()) {
                    case HELMET: 
                        tempArmorPiece = armorSet.getHelmet();
                        break;

                    case CHESTPLATE:
                        tempArmorPiece = armorSet.getChestplate();
                        break;

                    case LEGGINGS:
                        tempArmorPiece = armorSet.getLeggings();
                        break;

                    case BOOTS:
                        tempArmorPiece = armorSet.getBoots();
                        break;
                }
                get(i).use(e);
                System.out.println("You equipped the " + get(i).getName() + ".");
                remove(i, 1);
                add(tempArmorPiece, 1);
                break;

            case CONSUMABLE:
                get(i).use(e);
                remove(i, 1);
                break;

            case MISC:
                get(i).use(e);
                break;
            
            default:

                break;
        }
    }

    /**
     * If setting to a maxSize larger than it is currently, it should add empty slots to accomodate the new space.
     * You probably don't need to do anything if making it smaller and just let whatever item is left there stay there.
     */
    public int setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        int x = maxSize - inv.size();
        for (int i = 0; i < x; i++) {
            inv.add(ItemLibrary.getEmptySlot());
        }
        return maxSize;
    }
    
    public ArmorSet setArmorSet(ArmorSet armorSet) {
        this.armorSet = armorSet;
        return armorSet;
    }

    public Weapon setWeaponSlot(Weapon weaponSlot) {
        this.weaponSlot = weaponSlot;
        return weaponSlot;
    }

    //This method returns whether or not the inventory has all slots occupied, but doesn't check stackable items.
    public boolean isFull() {return size() == maxSize;}

    public boolean canBeAdded(Item item, int x) {
        int i = 0;
        while (i < maxSize) {
            int quantityToAdd;
            if (get(i).equals(item)) {
                quantityToAdd = Math.min(get(i).getMaxStack() - get(i).getQuantity(), x);
                x -= quantityToAdd;
            }
            else if (isEmptySlot(i)) {
                quantityToAdd = Math.min(item.getMaxStack(), x);
                x -= quantityToAdd;
            }
            i++;
        }
        return x <= 0;
    }

    public boolean isEmptySlot(int i) {
        return get(i).equals(ItemLibrary.getEmptySlot());
    }

    /**
     * Returns the logical size of the inventory, but doesn't count the empty slots since they are technically objects.
     */
    public int size() {
        int size = 0;
        int i = 0;
        while (i < maxSize) {
            if (!get(i).equals(new Misc(MiscList.EMPTY_SLOT))) {size++;}
            i++;
        }
        return size;
    }

    public int getMaxSize() {return maxSize;}
    public Item get(int i) {return inv.get(i);}
    public ArmorSet getArmorSet() {return armorSet;}
    public Weapon getWeaponSlot() {return weaponSlot;}

}
