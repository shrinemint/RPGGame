package src.rpg.items.armor;

import src.rpg.items.armor.Armor.ArmorType;

public enum ArmorList {
    //It'd probably be nicer if all the "empty slots" were combined and worked for any of the armor types
    //If you figure that out, then perhaps you should do that
    EMPTY_HELMET("Empty", "No helmet worn.", 0, ArmorType.HELMET),
    EMPTY_CHESTPLATE("Empty", "No chestplate worn.", 0, ArmorType.CHESTPLATE),
    EMPTY_LEGGINGS("Empty", "No leggings worn.", 0, ArmorType.LEGGINGS),
    EMPTY_BOOTS("Empty", "No boots worn.", 0, ArmorType.BOOTS),

    RAGGED_BOOTS("Ragged Boots", "A pair of unkempt leather boots.", 2, ArmorType.BOOTS),
    ;

    private String name;
    private String description;
    private int defensePoints;
    private ArmorType type;

    private ArmorList(String name, String description, int defensePoints, ArmorType type) {
        this.name = name;
        this.description = description;
        this.defensePoints = defensePoints;
        this.type = type;
    }

    public String getName() {return name;}

    public String getDescription() {return description;}

    public int getDefensePoints() {return defensePoints;}

    public ArmorType getType() {return type;}
}
