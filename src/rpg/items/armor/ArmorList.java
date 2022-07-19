package src.rpg.items.armor;

import src.rpg.entity.attributes.StatList;
import src.rpg.entity.attributes.StatsBuilder;
import src.rpg.items.armor.Armor.ArmorType;

public enum ArmorList {
    //It'd probably be nicer if all the "empty slots" were combined and worked for any of the armor types
    //If you figure that out, then perhaps you should do that
    EMPTY_HELMET("Empty", "No helmet worn.", 
        new StatsBuilder()
            .setMaxHP(0)
            .setAttack(0)
            .setDefense(0)
            .setSpeed(0)
            .build(), 
        ArmorType.HELMET),
    EMPTY_CHESTPLATE("Empty", "No chestplate worn.", 
        new StatsBuilder()
            .setMaxHP(0)
            .setAttack(0)
            .setDefense(0)
            .setSpeed(0)
            .build(), 
        ArmorType.CHESTPLATE),
    EMPTY_LEGGINGS("Empty", "No leggings worn.", 
        new StatsBuilder()
            .setMaxHP(0)
            .setAttack(0)
            .setDefense(0)
            .setSpeed(0)
            .build(), 
        ArmorType.LEGGINGS),
    EMPTY_BOOTS("Empty", "No boots worn.", 
        new StatsBuilder()
            .setMaxHP(0)
            .setAttack(0)
            .setDefense(0)
            .setSpeed(0)
            .build(), 
        ArmorType.BOOTS),

    RAGGED_BOOTS("Ragged Boots", "A pair of unkempt leather boots.", 
        new StatsBuilder()
            .setMaxHP(0)
            .setAttack(0)
            .setDefense(2)
            .setSpeed(0)
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
