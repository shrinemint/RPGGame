package src.rpg.items;

import src.rpg.entity.Entity;

/**
 * Base for all items in the game.
 * Items should be split based on their function:
 * 1. Weapons
 * 2. Armor
 * 3. Consumables (Healing items)
 * 4. Misc
 * 5. Battle Items? (Items that only have function in battle)
 */

public abstract class Item implements Cloneable {
    private String name;
    private String description;
    private int quantity; //the current stack number in the inventory
    private int maxStack; //The highest an item can be stacked within the inventory (like minecraft).
    //idk if items should be stackable yet
    private ItemType type;

    public Item(String name, String description, int maxStack, ItemType type) {
        this.name = name;
        this.description = description;
        this.maxStack = maxStack;
        this.type = type;
    }
    
    public enum ItemType {
        WEAPON, ARMOR, CONSUMABLE, MISC
    }

    public abstract void use(Entity e);
    
    /**
     * I remade the equals method to compare item IDs generated upon program start-up.
     * This was probably not needed.
     * at least items have an id now
     */
    public boolean equals(Item i) {return i.getID() == this.getID();}

    public int getID() {
        int pos = 0;
        int i = 0;
        while (i < ItemLibrary.getItemList().size()) {
            if (ItemLibrary.getItemList().get(i).getName().equals(name) 
                && ItemLibrary.getItemList().get(i).getDescription().equals(description)
                && ItemLibrary.getItemList().get(i).getType().equals(type)) {
                pos = i;
            }
            i++;
        }
        return pos;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }
    
    public String setDescription(String description) {
        this.description = description;
        return description;
    }

    public int setQuantity(int quantity) {
        this.quantity = quantity;
        return quantity;
    }

    /**
     * Unlike setQuantity, this is an easier version which adds to the quantity without doing setQuantity(getQuantity() + x);
     * @param x the quantity to be added
     * @return
     */
    public int addQuantity(int x) {
        setQuantity(getQuantity() + x);
        return x;
    }
    
    public int setMaxStack(int maxStack) {
        this.maxStack = maxStack;
        return maxStack;
    }

    public ItemType setType(ItemType type) {
        this.type = type;
        return type;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {return name;}
    public String getDescription() {return description;}
    public int getQuantity() {return quantity;}
    public int getMaxStack() {return maxStack;}
    public ItemType getType() {return type;}
}
