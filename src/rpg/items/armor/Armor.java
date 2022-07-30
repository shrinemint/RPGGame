package src.rpg.items.armor;

import src.rpg.entity.Entity;
import src.rpg.entity.attributes.StatList;
import src.rpg.items.Item;

public class Armor extends Item {
    /**
     * note: i will not add a leveller to this
     */
    private StatList stats; //the armor shouldn't use the temporary stats because that's like too much for me to handle
    private ArmorType type;

    public Armor(ArmorList armorPiece) {
        super(armorPiece.getName(), armorPiece.getDescription(), 1, ItemType.ARMOR);
        this.stats = armorPiece.getStats();
        this.type = armorPiece.getType();
    }

    public Armor(String name, String description, StatList stats, ArmorType type) {
        super(name, description, 1, ItemType.ARMOR);
        this.stats = stats;
        this.type = type;
    }
    
    public enum ArmorType { //i like this better than assigning each armor piece type an integer id
        HELMET, CHESTPLATE, LEGGINGS, BOOTS
    }

    @Override
    public void use(Entity e) {
        e.getInventory().getArmorSet().equip(this);
    }

    public StatList setStats(StatList stats) {
        this.stats = stats;
        return stats;
    }
    
    public ArmorType setType(ArmorType type) {
        this.type = type;
        return type;
    }

    public StatList getStats() {return stats;}
    public ArmorType getArmorType() {return type;}
}
