package src.rpg.entity;

import src.rpg.entity.attributes.ArmorSet;
import src.rpg.entity.attributes.Leveller;
import src.rpg.entity.attributes.StatList;
import src.rpg.items.Inventory;
import src.rpg.items.weapons.Weapon;

public class Player extends Entity {
    public Player(String name, Leveller leveller, StatList stats, Inventory inv) {
        super(name, leveller, stats, inv);
    }
}
