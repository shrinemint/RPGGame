package src.rpg.items.armor;

import src.rpg.items.armor.Armor.ArmorType;

/**
 * Handles the armor slots in a fixed array of size 4.
 * 
 */

public class ArmorSet {
    private Armor helmet;
    private Armor chestplate;
    private Armor leggings;
    private Armor boots;

    public ArmorSet() { //
        this.helmet = new Armor(ArmorList.EMPTY_HELMET);
        this.chestplate = new Armor(ArmorList.EMPTY_CHESTPLATE);
        this.leggings = new Armor(ArmorList.EMPTY_LEGGINGS);
        this.boots = new Armor(ArmorList.EMPTY_BOOTS);
    }

    public ArmorSet(Armor helmet, Armor chestplate, Armor leggings, Armor boots) throws ArmorTypeMismatchException {
        if (isHelmet(helmet)) {this.helmet = helmet;}
        else {throw new ArmorTypeMismatchException("Cannot put a non-helmet armor piece into the helmet piece slot.");}

        if (isChestplate(chestplate)) {this.chestplate = chestplate;}
        else {throw new ArmorTypeMismatchException("Cannot put a non-chestplate armor piece into the chestplate piece slot.");}

        if (isLeggings(leggings)) {this.leggings = leggings;}
        else {throw new ArmorTypeMismatchException("Cannot put a non-leggings armor piece into the leggings piece slot.");}

        if (isBoots(boots)) {this.boots = boots;}
        else {throw new ArmorTypeMismatchException("Cannot put a non-boots armor piece into the boots slot.");}
    }

    class ArmorTypeMismatchException extends Exception { //I made a class in case you try to put an armor piece in the wrong spot (on the programmer's end).
        public ArmorTypeMismatchException(String message) {
            super(message);
        }
    }

    public Armor setHelmet(Armor helmet) throws ArmorTypeMismatchException {
        if (isHelmet(helmet)) {this.helmet = helmet;}
        else {throw new ArmorTypeMismatchException("Cannot put a non-helmet armor piece into the helmet piece slot.");}
        return helmet;
    }

    public Armor getHelmet() {return helmet;}

    public Armor setChestplate(Armor chestplate) throws ArmorTypeMismatchException {
        if (isChestplate(chestplate)) {this.chestplate = chestplate;}
        else {throw new ArmorTypeMismatchException("Cannot put a non-chestplate armor piece into the chestplate piece slot.");}
        return chestplate;
    }

    public Armor getChestplate() {return chestplate;}

    public Armor setLeggings(Armor leggings) throws ArmorTypeMismatchException {
        if (isLeggings(leggings)) {this.leggings = leggings;}
        else {throw new ArmorTypeMismatchException("Cannot put a non-leggings armor piece into the leggings piece slot.");}
        return leggings;
    }

    public Armor getLeggings() {return leggings;}
    
    public Armor setBoots(Armor boots) throws ArmorTypeMismatchException {
        if (isBoots(boots)) {this.boots = boots;}
        else {throw new ArmorTypeMismatchException("Cannot put a non-boots armor piece into the boots slot.");}
        return boots;
    }

    public Armor getBoots() {return boots;}

    public int getDefense() {
        return helmet.getDefense() + chestplate.getDefense() + leggings.getDefense() + boots.getDefense();
    }

    private boolean isHelmet(Armor helmet) {
        if (helmet.getType() == ArmorType.HELMET) {return true;}
        else {return false;}
    }

    private boolean isChestplate(Armor chestplate) {
        if (chestplate.getType() == ArmorType.CHESTPLATE) {return true;}
        else {return false;}
    }

    private boolean isLeggings(Armor leggings) {
        if (leggings.getType() == ArmorType.LEGGINGS) {return true;}
        else {return false;}
    }

    private boolean isBoots(Armor boots) {
        if (boots.getType() == ArmorType.BOOTS) {return true;}
        else {return false;}
    }
}
