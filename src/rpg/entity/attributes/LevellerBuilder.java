package src.rpg.entity.attributes;

public class LevellerBuilder {
    private int hpGrowth;
    private int atkGrowth;
    private int defGrowth;
    private int spdGrowth;

    public LevellerBuilder setHPGrowth(int hpGrowth) {
        this.hpGrowth = hpGrowth;
        return this;
    }

    public LevellerBuilder setAtkGrowth(int atkGrowth) {
        this.atkGrowth = atkGrowth;
        return this;
    }

    public LevellerBuilder setDefGrowth(int defGrowth) {
        this.defGrowth = defGrowth;
        return this;
    }

    public LevellerBuilder setSpdGrowth(int spdGrowth) {
        this.spdGrowth = spdGrowth;
        return this;
    }

    public Leveller build() {
        return new Leveller(hpGrowth, atkGrowth, defGrowth, spdGrowth);
    }
}
