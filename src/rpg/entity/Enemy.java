package src.rpg.entity;

import src.rpg.attributes.StatList;

public class Enemy extends Entity {
    public Enemy(EnemyList enemy) { //Preferably, you would use this one for the most part.
        super(enemy.getName(), enemy.getStats());
    }

    public Enemy(String name, StatList stats) { //This constructor is only needed if you want a specific and unique enemy not listed in EnemyList.java
        super(name, stats);
    }
}
