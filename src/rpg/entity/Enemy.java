package src.rpg.entity;

import src.rpg.entity.attributes.Leveller;
import src.rpg.entity.attributes.StatList;

public class Enemy extends Entity {
    public Enemy(EnemyList enemy) { //Preferably, you would use this one for the most part.
        super(enemy.getName(), enemy.getLeveller(), enemy.getStats());
    }

    public Enemy(String name, Leveller leveller, StatList stats) { //This constructor is only needed if you want a specific and unique enemy not listed in EnemyList.java
        super(name, leveller, stats);
    }
}
