package src.rpg.items.armor;

import src.rpg.entity.attributes.StatList;
import src.rpg.entity.attributes.StatsBuilder;
import src.rpg.items.armor.Armor.ArmorType;

public enum ArmorList {
    //It'd probably be nicer if all the "empty slots" were combined and worked for any of the armor types
    //If you figure that out, then perhaps you should do that
    EMPTY_SLOT("EMPTY ARMOR SLOT", "", null, null),

    RAGGED_BOOTS("Ragged Boots", "A pair of unkempt leather boots.", 
        new StatsBuilder()
            .setMaxHP(0)
            .setAttack(0)
            .setDefense(2)
            .setSpeed(0)
            .build(),
        ArmorType.BOOTS),

    HIGH_HEELS("High Heels", "She wears high-heels...", //these stupid little things are the only thing keepin g me going.
        new StatsBuilder()
            .setMaxHP(0)
            .setAttack(10)
            .setDefense(3)
            .setSpeed(0)
            .build(),
        ArmorType.BOOTS),

    SNEAKERS("Sneakers", "...and I wear sneakers.", 
        new StatsBuilder()
            .setMaxHP(0)
            .setAttack(0)
            .setDefense(5)
            .setSpeed(8)
            .build(),
        ArmorType.BOOTS),
    ;

    private String name;
    private String description;
    private StatList stats;
    private ArmorType type;

    private ArmorList(String name, String description, StatList stats, ArmorType type) {
        this.name = name;
        this.description = description;
        this.stats = stats;
        this.type = type;
    }

    public String getName() {return name;}
    public String getDescription() {return description;}
    public StatList getStats() {return stats;}
    public ArmorType getType() {return type;}
}
