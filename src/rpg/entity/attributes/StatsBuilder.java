package src.rpg.entity.attributes;

/* The point of builder classes is to help with classes with constructors that have a lot of parameters.
 * You set the variables here and the build() method should compile then return a StatList class
 */

public class StatsBuilder {
    private int maxHP;
    private int attack;
    private int defense;
    private int speed;

    public StatsBuilder setMaxHP(int maxHP) {
        this.maxHP = maxHP;
        return this;
    }

    public StatsBuilder setAttack(int attack) {
        this.attack = attack;
        return this;
    }

    public StatsBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    public StatsBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public StatList build() {
        return new StatList(maxHP, attack, defense, speed);
    }
}
