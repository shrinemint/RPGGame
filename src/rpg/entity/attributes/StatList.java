package src.rpg.entity.attributes;

/* This class is used to handle an entity's stats.
 * tbh im making this a class because i googled it and some other dudes said to in a forum so im trusting those dudes
 */

public class StatList {
    //These are just generic RPG stats
    private int maxHP;
    private int hp;
    private int attack, tempAtk; //The temp variables are to help with modifying these stats in battle without changing the value once the battle has ended.
    private int defense, tempDef; //Outside of battle, temp variables should be zero
    private int speed, tempSpd;

    public StatList(int maxHP, int attack, int defense, int speed) {
        this.maxHP = maxHP;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        hp = maxHP;
        tempAtk = 0;
        tempDef = 0;
        tempSpd = 0;
    }

    public int setMaxHP(int maxHP) {
        this.maxHP = maxHP;
        return maxHP;
    }
    
    public int setHP(int hp) {
        if (hp > maxHP) {this.hp = maxHP;}
        else {this.hp = hp;}
        return hp;
    }
    
    public int setAttack(int attack) {
        this.attack = attack;
        return attack;
    }
    
    public int setTempAtk(int tempAtk) {
        this.tempAtk = tempAtk;
        return tempAtk;
    }
    
    public int setDefense(int defense) {
        this.defense = defense;
        return defense;
    }
    
    public int setTempDef(int tempDef) {
        this.tempDef = tempDef;
        return tempDef;
    }
    
    public int setSpeed(int speed) {
        this.speed = speed;
        return speed;
    }
    
    public int setTempSpd(int tempSpd) {
        this.tempSpd = tempSpd;
        return tempSpd;
    }

    public int getMaxHP() {return maxHP;}
    public int getHP() {return hp;}
    public int getAttack() {return attack;}
    public int getTempAtk() {return tempAtk;}
    public int getDefense() {return defense;}
    public int getTempDef() {return tempDef;}
    public int getSpeed() {return speed;}
    public int getTempSpd() {return tempSpd;}
}
