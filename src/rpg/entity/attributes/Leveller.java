package src.rpg.entity.attributes;

/* Handles levelling up an entity
 * 
 */

public class Leveller {
    private int level;
    private int hpGrowth;
    private int atkGrowth;
    private int defGrowth;
    private int spdGrowth;

    public Leveller(int hpGrowth, int atkGrowth, int defGrowth, int spdGrowth) {
        this.hpGrowth = hpGrowth;
        this.atkGrowth = atkGrowth;
        this.defGrowth = defGrowth;
        this.spdGrowth = spdGrowth;
    }

    public int setLevel(int level) {
        this.level = level;
        return level;
    }

    public int getLevel() {
        return level;
    }

    public int setHpGrowth(int hpGrowth) {
        this.hpGrowth = hpGrowth;
        return hpGrowth;
    }

    public int getHpGrowth() {
        return hpGrowth;
    }

    public int setAtkGrowth(int atkGrowth) {
        this.atkGrowth = atkGrowth;
        return atkGrowth;
    }

    public int getAtkGrowth() {
        return atkGrowth;
    }

    public int setDefGrowth(int defGrowth) {
        this.defGrowth = defGrowth;
        return defGrowth;
    }

    public int getDefGrowth() {
        return defGrowth;
    }

    public int setSpdGrowth(int spdGrowth) {
        this.spdGrowth = spdGrowth;
        return spdGrowth;
    }

    public int getSpdGrowth() {
        return spdGrowth;
    }
}