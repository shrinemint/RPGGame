package src.rpg.items.armor;

import src.rpg.items.Item;

/* all armor pieces should be divided into four types:
 * 1. helmets
 * 2. chestplates
 * 3. leggings
 * 4. boots
 * otherwise known as the minecraft armor slots
 */

public class Armor extends Item {
    private int defensePoints; //the armor's defense points should be added to the entity's defense points
    private ArmorType type;

    public Armor(ArmorList armorPiece) {
        super(armorPiece.getName(), armorPiece.getDescription(), 1);
        this.defensePoints = armorPiece.getDefensePoints();
        this.type = armorPiece.getType();
    }

    public Armor(String name, String description, int defensePoints, ArmorType type) {
        super(name, description, 1);
        this.defensePoints = defensePoints;
        this.type = type;
    }
    
    enum ArmorType { //i like this better than assigning each armor piece type an integer id
        HELMET, CHESTPLATE, LEGGINGS, BOOTS
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
