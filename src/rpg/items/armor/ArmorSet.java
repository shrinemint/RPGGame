package src.rpg.items.armor;

import src.rpg.items.armor.Armor.ArmorType;

/* Handles the armor slots in a fixed array of size 4.
 * 
 */

public class ArmorSet {
    private Armor helmet;
    private Armor chestplate;
    private Armor leggings;
    private Armor boots;

    public ArmorSet() {
        this.helmet = new Armor(ArmorList.EMPTY_HELMET);
    }

    public ArmorSet(Armor helmet, Armor chestplate, Armor leggings, Armor boots) {
        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.boots = boots;
    }

    public Armor setHelmet(Armor helmet) {
        this.helmet = helmet;
        return helmet;
    }

    public Armor getHelmet() {
        return helmet;
    }

    public Armor setChestplate(Armor chestplate) {
        this.chestplate = chestplate;
        return chestplate;
    }

    public Armor getChestplate() {
        return chestplate;
    }

    public Armor setLeggings(Armor leggings) {
        this.leggings = leggings;
        return leggings;
    }

    public Armor getLeggings() {
        return leggings;
    }
    
    public Armor setBoots(Armor boots) {
        this.boots = boots;
        return boots;
    }

    public Armor getBoots() {
        return boots;
    }

    private boolean checkHelmet(Armor helmet) {
        if (helmet.getType() == ArmorType.HELMET) {return true;}
        else {return false;}
    }

    private boolean checkChestplate(Armor chestplate) {
        if (chestplate.getType() == ArmorType.CHESTPLATE) {return true;}
        else {return false;}
    }

    private boolean checkLeggings(Armor leggings) {
        if (leggings.getType() == ArmorType.LEGGINGS) {return true;}
        else {return false;}
    }

    private boolean checkBoots(Armor boots) {
        if (boots.getType() == ArmorType.BOOTS) {return true;}
        else {return false;}
    }
}
