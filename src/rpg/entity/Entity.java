package src.rpg.entity;

import src.rpg.attributes.StatList;

/* Basic preset for all entities in the game such as the player and enemies.
 * On second thought, it's only used for those classes...
 * oh well
 * For the most part, you're probably only gonna be editing the parent class.
 * You edit the child classes if there are specific actions that the specific child class can do.
 */

public class Entity {
    
    private String name;

    public Entity(String name, StatList stats) {
        this.name = name;
    }

    public String setName(String name) { //i like adding a return statement even tho this is a set method and you can't make me stop
        this.name = name;
        return name;
    }

    public String getName() {
        return name;
    }
}
