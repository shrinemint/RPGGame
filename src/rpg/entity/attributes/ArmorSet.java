package src.rpg.entity.attributes;

import src.rpg.items.armor.Armor;
import src.rpg.items.armor.ArmorList;

/**
 * Handles the armor slots for an entity
 * 
 */

public class ArmorSet {
    private Armor helmet;
    private Armor chestplate;
    private Armor leggings;
    private Armor boots;

    public ArmorSet() {
        equip(new Armor(ArmorList.EMPTY_HELMET));
        equip(new Armor(ArmorList.EMPTY_CHESTPLATE));
        equip(new Armor(ArmorList.EMPTY_LEGGINGS));
        equip(new Armor(ArmorList.EMPTY_BOOTS));
    }

    public ArmorSet(Armor helmet, Armor chestplate, Armor leggings, Armor boots) {
        equip(helmet);
        equip(chestplate);
        equip(leggings);
        equip(boots);
    }

    public ArmorSet(ArmorList helmet, ArmorList chestplate, ArmorList leggings, ArmorList boots) {
        equip(new Armor(helmet));
        equip(new Armor(chestplate));
        equip(new Armor(leggings));
        equip(new Armor(boots));
    }

    public Armor equip(Armor armorPiece) { //basically every set method here condensed into one method.
        switch (armorPiece.getType()) {
            case HELMET:
                this.helmet = armorPiece;
                break;
            case CHESTPLATE:
                this.chestplate = armorPiece;
                break;
            case LEGGINGS:
                this.leggings = armorPiece;
                break;
            case BOOTS:
                this.boots = armorPiece;
                break;
        }
        return armorPiece;
    }

    public Armor getHelmet() {return helmet;}
    public Armor getChestplate() {return chestplate;}
    public Armor getLeggings() {return leggings;}
    public Armor getBoots() {return boots;}
    
    //returns the combines result from all armor pieces
    public int getMaxHP() {return helmet.getStats().getMaxHP() + chestplate.getStats().getMaxHP() + leggings.getStats().getMaxHP() + boots.getStats().getMaxHP();}
    public int getAttack() {return helmet.getStats().getAttack() + chestplate.getStats().getAttack() + leggings.getStats().getAttack() + boots.getStats().getAttack();}
    public int getDefense() {return helmet.getStats().getDefense() + chestplate.getStats().getDefense() + leggings.getStats().getDefense() + boots.getStats().getDefense();}
    public int getSpeed() {return helmet.getStats().getSpeed() + chestplate.getStats().getSpeed() + leggings.getStats().getSpeed() + boots.getStats().getSpeed();}
}
