package src.rpg.main;

import src.rpg.entity.Entity;

/**
 * Where everything is executed
 * Probably should create a player and enemy class first
 */

public class Main {
    public Main() {
        Entity guardian = GameLogic.createPlayer();
        System.out.println(guardian.getName());
    }

    public static void main(String args[]) { //little bitch boy static void main here lmaaaoooo
        new Main();
    }
    
}
