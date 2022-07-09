package src.rpg.entity.attributes;

/* The point of builder classes is to help with classes with constructors that have a lot of parameters.
 * You set the variables here and the build() method should compile then return a StatList class
 */

public class StatBuilder {
    private int maxHP;
    private int hp;
    private int attack;
    private int defense;
    private int speed;

    public StatBuilder setMaxHP(int maxHP) {
        this.maxHP = maxHP;
        return this;
    }
    
    public StatBuilder setHP(int hp) {
        this.hp = hp;
        return this;
    }

    public StatBuilder setAttack(int attack) {
        this.attack = attack;
        return this;
    }

    public StatBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    public StatBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public StatList build() {
        return new StatList(maxHP, hp, attack, defense, speed);
    }
}
