package src.rpg.items.consumable;

import src.rpg.entity.Entity;
import src.rpg.items.Item;

/* eatables nom nom nom
 * 
 */

public class Consumable extends Item {
    private int resPoints; //The amount of flat restoration points given
    private int resPercent; //The amount of restoration points given based on the target's max health. i.e. "Heals 50% of target's maximum health." (like genshin)

    public Consumable(ConsumableList consumable) {
        super(consumable.getName(), consumable.getDescription(), consumable.getMaxStacks());
        this.resPoints = consumable.getResPoints();
        this.resPercent = consumable.getResPercent();
    }

    public Consumable(String name, String description, int maxStacks, int resPoints, int resPercent) {
        super(name, description, maxStacks);
        this.resPoints = resPoints;
        this.resPercent = resPercent;
    }

    public int setResPoints(int resPoints) {
        this.resPoints = resPoints;
        return resPoints;
    }

    public int getResPoints() {return resPoints;}

    public int setResPercent(int resPercent) {
        this.resPercent = resPercent;
        return resPercent;
    }

    public int getResPercent() {return resPercent;}

    public void use(Entity target) { //Adds the potion's restoration points and restoration percentage to the target's current HP
        target.getStats().setHP((int)(target.getStats().getHP() + resPoints + (target.getStats().getMaxHP() * (resPercent / 100.0))));
    }
}
