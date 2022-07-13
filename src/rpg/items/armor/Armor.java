package src.rpg.items.armor;

/* all armor pieces should be divided into four types:
 * 1. helmets
 * 2. chestplates
 * 3. leggings
 * 4. boots
 * otherwise known as the minecraft armor slots
 */

public class Armor {
    private String name;
    private String description;
    private int defensePoints; //the armor's defense points should be added to the entity's defense points
    private ArmorType type;

    public Armor(ArmorList armorPiece) {
        this.name = armorPiece.getName();
        this.description = armorPiece.getDescription();
        this.defensePoints = armorPiece.getDefensePoints();
        this.type = armorPiece.getType();
    }

    public Armor(String name, String description, int defensePoints, ArmorType type) {
        this.name = name;
        this.description = description;
        this.defensePoints = defensePoints;
        this.type = type;
    }
    
    enum ArmorType {
        HELMET, CHESTPLATE, LEGGINGS, BOOTS
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }
    
    public String getName() {
        return name;
    }

    public String setDescription(String description) {
        this.description = description;
        return description;
    }

    public String getDescription() {
        return description;
    }

    public int setDefense(int defensePoints) {
        this.defensePoints = defensePoints;
        return defensePoints;
    }

    public int getDefense() {
        return defensePoints;
    }

    public ArmorType setType(ArmorType type) {
        this.type = type;
        return type;
    }

    public ArmorType getType() {
        return type;
    }
}
