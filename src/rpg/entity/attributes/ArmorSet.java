package src.rpg.entity.attributes;

import src.rpg.items.armor.Armor;
import src.rpg.items.armor.ArmorList;
import src.rpg.items.armor.Armor.ArmorType;

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
        helmet = new Armor(ArmorList.EMPTY_SLOT);
        chestplate = new Armor(ArmorList.EMPTY_SLOT);
        leggings = new Armor(ArmorList.EMPTY_SLOT);
        boots = new Armor(ArmorList.EMPTY_SLOT);
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
    
    /**
     * A set method for any armor piece.
     * This does not work for unequipping, where it needs to "equip" an empty armor slot.
     */
    public Armor equip(Armor armorPiece) { 
        switch (armorPiece.getArmorType()) {
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

    public Armor unequip(ArmorType type) {
        Armor unequippedPiece = null;
        switch (type) {
            case HELMET:
                unequippedPiece = this.helmet;
                this.helmet = new Armor(ArmorList.EMPTY_SLOT);
                break;

            case CHESTPLATE:
                unequippedPiece = this.chestplate;
                this.chestplate = new Armor(ArmorList.EMPTY_SLOT);
                break;

            case LEGGINGS:
                unequippedPiece = this.leggings;
                this.leggings = new Armor(ArmorList.EMPTY_SLOT);
                break;

            case BOOTS:
                unequippedPiece = this.boots;
                this.boots = new Armor(ArmorList.EMPTY_SLOT);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized armor type.");
        }
        return unequippedPiece;
    }

    public Armor setHelmet(Armor helmet) {
        this.helmet = helmet;
        return helmet;
    }

    public Armor setChestplate(Armor chestplate) {
        this.chestplate = chestplate;
        return chestplate;
    }

    public Armor setLeggings(Armor leggings) {
        this.leggings = leggings;
        return leggings;
    }

    public Armor setBoots(Armor boots) {
        this.boots = boots;
        return boots;
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
