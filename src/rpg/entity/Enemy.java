package src.rpg.entity;

import src.rpg.entity.attributes.ArmorSet;
import src.rpg.entity.attributes.Leveller;
import src.rpg.entity.attributes.StatList;
import src.rpg.items.Inventory;
import src.rpg.items.weapons.Weapon;

public class Enemy extends Entity {
    public Enemy(EnemyList enemy) { //Preferably, you would use this one for the most part.
        super(enemy.getName(), enemy.getLeveller(), enemy.getStats(), enemy.getInventory());
    }

    public Enemy(String name, Leveller leveller, StatList stats, ArmorSet armorSet, Weapon weaponSlot, Inventory inv) { //This constructor is only needed if you want a specific and unique enemy not listed in EnemyList.java
        super(name, leveller, stats, inv);
    }
}
