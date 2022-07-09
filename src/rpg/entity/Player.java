package src.rpg.entity;

import src.rpg.entity.attributes.Leveller;
import src.rpg.entity.attributes.StatList;

public class Player extends Entity {
    public Player(String name, Leveller leveller, StatList stats) {
        super(name, leveller, stats);
    }
}
