package src.rpg.items.armor;

/* Handles the armor slots in a fixed array of size 4.
 * 
 */

public class ArmorSet {
    private Armor slot1;
    private Armor slot2;
    private Armor slot3;
    private Armor slot4;

    public ArmorSet(Armor slot1, Armor slot2, Armor slot3, Armor slot4) {
        this.slot1 = slot1;
        this.slot2 = slot2;
        this.slot3 = slot3;
        this.slot4 = slot4;
    }
}
