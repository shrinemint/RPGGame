package src.rpg.entity;

import src.rpg.entity.attributes.ArmorSet;
import src.rpg.entity.attributes.Leveller;
import src.rpg.entity.attributes.LevellerBuilder;
import src.rpg.entity.attributes.StatsBuilder;
import src.rpg.items.Inventory;
import src.rpg.items.weapons.Weapon;
import src.rpg.items.weapons.WeaponList;
import src.rpg.entity.attributes.StatList;

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
    SNAKE("Snake", 
        new LevellerBuilder()
            .setHPGrowth(2)
            .setAtkGrowth(4)
            .setDefGrowth(1)
            .setSpdGrowth(3)
            .build(),
        new StatsBuilder()
            .setMaxHP(60)
            .setAttack(25)
            .setDefense(10)
            .setSpeed(20)
            .build(),
        new Inventory()),
    ;
    
    private String name;
    private Leveller leveller;
    private StatList stats;
    private Inventory inv;

    private EnemyList(String name, Leveller leveller, StatList stats, Inventory inv) { //The constructor for any enum can only be private
        this.name = name;
        this.leveller = leveller;
        this.stats = stats;
        this.inv = inv;
    }

    public String getName() {return name;}
    public Leveller getLeveller() {return leveller;}
    public StatList getStats() {return stats;}
    public Inventory getInventory() {return inv;}
}
