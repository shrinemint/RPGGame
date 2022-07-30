package src.rpg.items.misc;

import src.rpg.entity.Entity;
import src.rpg.items.Item;

public class Misc extends Item {
    public Misc(MiscList misc) {
        super(misc.getName(), misc.getDescription(), misc.getMaxStack(), ItemType.MISC);
    }
    
    public Misc(String name, String description, int maxStack) {
        super(name, description, maxStack, ItemType.MISC);
    }

    @Override
    public void use(Entity e) { //i don't imagine this will be needed unless you can add custom functionality for each Misc item
        
    }
}
