package src.rpg.entity;

import src.rpg.attributes.StatList;
import src.rpg.attributes.StatBuilder;

/* This is an enum which can kind of act like a library of presets for classes.
 * Attributes of an enemy is stored here
 * Basically, if you want to create a snake enemy, you can use this and do "Enemy snake = new Enemy(EnemyList.SNAKE);" and
 * not have to do "new Enemy(name: "Snake", level: 1, etc...)" each time you want a snake enemy.
 * 
 */

public enum EnemyList {
    //since these are all constants, the names should be in all caps.
    //Add a coma in between each instance you add here and end the list with a semicolon. 
    //You can only add a constructor after the semicolon.
    SNAKE("Snake", new StatBuilder()
        .setMaxHP(0)
        .setHP(0)
        .setAttack(0)
        .setDefense(0)
        .setSpeed(0)
        .build()),

    GOTH("Goth Kid", new StatBuilder()
        .setMaxHP(0)
        .setHP(0)
        .setAttack(0)
        .setDefense(0)
        .setSpeed(0)
        .build())
    ;
    
    private String name;
    private StatList stats;

    private EnemyList(String name, StatList stats) { //The constructor for any enum can only be private
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public StatList getStats() {
        return stats;
    }
}
