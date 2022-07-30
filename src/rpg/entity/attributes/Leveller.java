package src.rpg.entity.attributes;

/* Handles levelling up an entity
 * 
 */

public class Leveller {
    private static final int maxLevel = 100; //This should be the maximum level for all entities.

    private int level = 1;
    private int xp;
    private int maxXP;
    private int hpGrowth;
    private int atkGrowth;
    private int defGrowth;
    private int spdGrowth;

    public Leveller(int hpGrowth, int atkGrowth, int defGrowth, int spdGrowth) {
        this.hpGrowth = hpGrowth;
        this.atkGrowth = atkGrowth;
        this.defGrowth = defGrowth;
        this.spdGrowth = spdGrowth;
        maxXP = level * 100;
    }

    public void levelUp(StatList stats) {
        addLevel(1);
        maxXP = level * 100;

        /**
         * A little thing here where the HP grows proportionally to the max HP gained upon levelling up.
         * Effectively, if the entity was at 96% HP when levelling up, it should stay at 96% after the max HP increase.
         */
        double hpPct = (double)stats.getHP() / (double)stats.getMaxHP();
        stats.addMaxHP(hpGrowth);
        stats.setHP((int)(hpPct * stats.getMaxHP()));
        stats.addAttack(atkGrowth);
        stats.addDefense(defGrowth);
        stats.addSpeed(spdGrowth);
    }
    
    //Increment an entity's level by x
    public int addLevel(int x) {
        setLevel(getLevel() + x); //use set level to make sure level doesn't surpass the max
        return x;
    }

    //Increment xp by x
    public int addXP(int x, StatList stats) {
        setXP(getXP() + x, stats);
        return x;
    }

    public int setLevel(int level) {
        if (level > maxLevel) {this.level = maxLevel;}
        else {this.level = level;}
        return level;
    }

    /**
     * Just in case the xp surpasses the maximum xp, this should be able to handle levelling up too.
     * @param xp the xp to set
     * @param stats the entity's stats
     * @return
     */
    public int setXP(int xp, StatList stats) {
        /**
         * If the new xp quantity is greater than the max XP, and the level is less than the max level, then recalculate the XP and level up.
         * If the level is at the max, then set xp to be the maxXP.
         * Otherwise, set XP as xp.
         */
        this.xp = xp;
        while (this.xp >= maxXP && level < maxLevel) {
            this.xp -= maxXP;
            levelUp(stats);
        }
        if (level == maxLevel) {
            maxXP = maxLevel * 100;
            this.xp = maxXP;
        }
        return xp;
    }

    public int setMaxXP(int maxXP) {
        this.maxXP = maxXP;
        return maxXP;
    }

    public int setHpGrowth(int hpGrowth) {
        this.hpGrowth = hpGrowth;
        return hpGrowth;
    }
    
    public int setAtkGrowth(int atkGrowth) {
        this.atkGrowth = atkGrowth;
        return atkGrowth;
    }
    
    public int setDefGrowth(int defGrowth) {
        this.defGrowth = defGrowth;
        return defGrowth;
    }

    public int setSpdGrowth(int spdGrowth) {
        this.spdGrowth = spdGrowth;
        return spdGrowth;
    }

    public int getMaxLevel() {return maxLevel;}
    public int getLevel() {return level;}
    public int getXP() {return xp;}
    public int getMaxXP() {return maxXP;}
    public int getHpGrowth() {return hpGrowth;}
    public int getAtkGrowth() {return atkGrowth;}
    public int getDefGrowth() {return defGrowth;}
    public int getSpdGrowth() {return spdGrowth;}
}
