package src.rpg.items;

/**
 * Base for all items in the game.
 * Items should be split based on their function:
 * 1. Weapons
 * 2. Armor
 * 3. Consumables (Healing items)
 * 4. Misc
 * 5. Battle Items? (Items that only have function in battle)
 */

public class Item {
    private String name;
    private String description;
    private int maxStack; //The highest an item can be stacked within the inventory (like minecraft).

    public Item(String name, String description, int maxStack) {
        this.name = name;
        this.description = description;
        this.maxStack = maxStack;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String getName() {return name;}

    public String setDescription(String description) {
        this.description = description;
        return description;
    }

    public String getDescription() {return description;}

    public int setMaxStack(int maxStack) {
        this.maxStack = maxStack;
        return maxStack;
    }

    public int getMaxStack() {return maxStack;}

    public void use() { //The function of an item when used. But since this is the parent class, this probably shouldn't be used.
        System.out.println("this shouldn't be seen...");
    }
}
