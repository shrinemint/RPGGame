package src.rpg.battle;

import java.util.List;
import java.util.ArrayList;

import src.rpg.entity.Player;
import src.rpg.entity.Enemy;
import src.rpg.entity.Entity;

/**
 * another logic class for handling a battle encounter, which is supposed to be turn-based.
 */

public class BattleLogic {
    private static boolean running; //A boolean determining if a battle is on-going.
    private static Player player;
    private static Enemy [] enemyParty;
    private static List<Entity> turnQueue;
    
    public static void startEncounter(Player p, Enemy [] e) {
        player = p;
        enemyParty = e;
        running = true;

        while (running) {
            setPlayerTurn();
            setEnemyTurn();
            setTurnQueue();
            executeTurn();
        }
    }

    public static void setPlayerTurn() {
        boolean choosing = true;
        while (choosing) {

        }
    }

    public static void setEnemyTurn() { //i have no idea how to program enemy ai to make choices in battle

    }

    public static void setTurnQueue() {
        turnQueue = new ArrayList<Entity>();
    }

    public static void executeTurn() {

    }

    public static void endEncounter() {
        running = false;
    }

    public static boolean isRunningEncounter() {return running;} //returns if a battle is occuring
}
