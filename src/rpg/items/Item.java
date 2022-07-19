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

public abstract class Item {
    private String name;
    private String description;
    private int quantity; //the current stack number in the inventory
    private int maxStack; //The highest an item can be stacked within the inventory (like minecraft).
    //idk if items should be stackable yet
    private ItemType type;
    private int id; //The item id is initialized once the method setItemList is ran. probably only useful later on when there is an actual game

    public Item(String name, String description, int maxStack, int id) {
        this.name = name;
        this.description = description;
        this.maxStack = maxStack;
        this.id = id;
    }
    
    public enum ItemType {
        WEAPON, ARMOR, CONSUMABLE, MISC
    }

    public abstract boolean use(Entity e);
    
    public boolean is(Item i) { //alternative to equals i guess
        return name == i.getName() && description == i.getDescription() && maxStack == i.getMaxStack();
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
        if (quantity > maxStack) {this.quantity = maxStack;}
        else {this.quantity = quantity;}
        return quantity;
    }
    
    public int setMaxStack(int maxStack) {
        this.maxStack = maxStack;
        return maxStack;
    }

    public ItemType setType(ItemType type) {
        this.type = type;
        return type;
    }
    
    public int setID(int id) {
        this.id = id;
        return id;
    }

    public String getName() {return name;}
    public String getDescription() {return description;}
    public int getQuantity() {return quantity;}
    public int getMaxStack() {return maxStack;}
    public ItemType getType() {return type;}
    public int getID() {return id;}
}
