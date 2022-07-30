package src.rpg.battle;

import java.util.List;
import java.util.ArrayList;

import src.rpg.entity.Player;
import src.rpg.entity.attributes.BattleAction;
import src.rpg.entity.attributes.BattleAction.ActionType;
import src.rpg.main.GameLogic;
import src.rpg.entity.Enemy;
import src.rpg.entity.Entity;

/**
 * another logic class for handling a battle encounter, which is supposed to be turn-based.
 */

public class BattleLogic {
    private static boolean running; //A boolean determining if a battle is on-going.
    private static Player player;
    private static List<Enemy> enemyParty;
    private static List<Entity> turnQueue;
    
    public static void startEncounter(Player p, ArrayList<Enemy> e) {
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

    /**
     * Prompts the player on which action they will take.
     * This will run so long as the player has not made a decision.
     */
    public static void setPlayerTurn() {
        boolean choosing = true;
        while (choosing) {
            int choice = GameLogic.promptInt("What will you do?\n 1. Attack\n 2. Defend\n 3. Item");
            switch (choice) {
                case 1:
                    player.setAction(new BattleAction(ActionType.ATTACK));
                    //If attacking and the party size is greater than 1, the player will have to select from the list of enemies in enemyParty
                    if (enemyParty.size() > 1) {
                        boolean choosingTarget = true;
                        //This next loop runs until the player either chooses a target or exits from choosing a target/
                        while (choosingTarget) {
                            //When choosing the target from multiple, it needs to compile the names and health of each into a string to pass into the promptInt method.
                            String targetList = "";
                            int i = 0;
                            while (i < enemyParty.size()) {
                                targetList += (i + 1) + ": " + enemyParty.get(i).getName() + " " + enemyParty.get(i).getStats().getHP() + "/" + enemyParty.get(i).getStats().getMaxHP() +  "\n ";
                                i++;
                            }
                            int target = GameLogic.promptInt("Which enemy will you target?\n " + targetList + "0: Exit");
                            //If exiting, breaks this while-loop but not the outer while-loop.
                            if (target == 0) {
                                choosingTarget = false;
                            }
                            else if (0 < target && target <= enemyParty.size()) {
                                player.getAction().setTarget(enemyParty.get(target - 1));
                                choosingTarget = false;
                                choosing = false;
                            }
                        }
                    }
                    else {
                        player.getAction().setTarget(enemyParty.get(0));
                        choosing = false;
                    }
                    
                    break;
                case 2:
                    player.setAction(new BattleAction(ActionType.DEFEND));
                    player.getAction().setTarget(player);
                    choosing = false;
                    break;
                case 3:
                    player.setAction(new BattleAction(ActionType.ITEM));
                    //Runs similarily to when choosing an enemy to attack, but replaced with choosing an item from the inventory instead.
                    boolean choosingItem = true;
                    while (choosingItem) {
                        String inventoryList = "";
                        int i = 0;
                        //This only compiles the list of non-empty slots in the inventory to make the look less clunky.
                        while (i < player.getInventory().size()) {
                            String invLine = (i + 1) + ": ";
                            if (!player.getInventory().isEmptySlot(i)) {
                                invLine += player.getInventory().get(i).getName() + " x" + player.getInventory().get(i).getQuantity();
                            }
                            inventoryList += invLine + "\n ";
                            i++;
                        }
                        int targetItem = GameLogic.promptInt("Which item will you use?\n " + inventoryList + "0: Exit");
                        //Again, if the player chooses to exit, this while-loop breaks but not the outer loop.
                        if (targetItem == 0) {
                            choosingItem = false;
                        }
                        else if (0 < targetItem && targetItem <= player.getInventory().size()) {
                            player.getAction().setSelectedItem(targetItem - 1);
                            choosingItem = false;
                            choosing = false;
                        }
                    }
                    break;
            }
        }
    }
    
    /**
     * Note: i do not know how to program ai, nor do i think i want to learn just for this game.
     * Instead, it'll most likely be semi-random.
     * If the enemy's health is high, then attack with a low chance of choosing to defend.
     * If the enemy's health is low, then increase the chance of defending.
     * If the enemy has any items in its inventory and finds a good time to use it (i.e. consuming a potion when low on health),
     * then use the item.
     */
    public static void setEnemyTurn() {
        System.out.println("SETTING ENEMY TURN");
        int i = 0;
        while (i < enemyParty.size()) {
            enemyParty.get(i).setAction(new BattleAction(ActionType.ATTACK));
            i++;
        }
    }

    public static void setTurnQueue() {
        System.out.println("SETTING TURN QUEUE");
        turnQueue = new ArrayList<Entity>();
    }

    public static void executeTurn() {
        System.out.println("EXECUTING TURN");

    }

    public static void endEncounter() {
        running = false;
    }

    public static boolean isRunningEncounter() {return running;} //returns if a battle is occuring
}
