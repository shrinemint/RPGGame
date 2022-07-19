package src.rpg.entity.attributes;

import src.rpg.entity.Entity;

/**
 * A class to store the action an entity takes in battle.
 */

public class BattleAction {
    private ActionType type;
    private int priority;

    private Entity target;
    private int selectedItem;

    public BattleAction(ActionType type) {
        this.type = type;
        priority = type.getPriority();
    }

    public enum ActionType {
        ATTACK(0), 
        ITEM(3), 
        DEFEND(1)
        ;

        private int priority;
        private ActionType(int priority) {
            this.priority = priority;
        }
        public int getPriority() {return priority;}
    }

    public ActionType setType(ActionType type) {
        this.type = type;
        return type;
    }

    public int setPriority(int priority) {
        this.priority = priority;
        return priority;
    }

    public Entity setTarget(Entity target) {
        this.target = target;
        return target;
    }

    public int setSelectedItem(int selectedItem) {
        this.selectedItem = selectedItem;
        return selectedItem;
    }

    public ActionType getType() {return type;}
    public int getPriority() {return priority;}
    public Entity getTarget() {return target;}
    public int getSelectedItem() {return selectedItem;}
}
