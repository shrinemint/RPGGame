package src.rpg.main;

/**
 * Some standard game logic functions which do things like initialize item and enemy lists, initializing the player, doing console prompts, etc.
 * 
 */

import java.util.Scanner;

import src.rpg.entity.Player;
import src.rpg.entity.attributes.LevellerBuilder;
import src.rpg.entity.attributes.StatsBuilder;
import src.rpg.items.Inventory;

public class GameLogic {
    private static Scanner kbReader = new Scanner(System.in);

    public static String promptString(String question) {
        System.out.print("> " + question + "\n> ");
        return kbReader.nextLine();
    }

    public static int promptInt(String question) {
        System.out.print("> " + question + "\n> ");
        return kbReader.nextInt();
    }

    public static double promptDouble(String question) {
        System.out.print("> " + question + "\n> ");
        return kbReader.nextDouble();
    }

    public static int askSimpleQuestion(String question) { //tired of programming yes-no questions over and over again
        boolean choosing = true;
        int choice = 0;
        while (choosing) {
            System.out.print("> " + question + "\n 1. Yes.\n 2. No\n> ");
            choice = kbReader.nextInt();
            if (choice == 1 || choice == 2) {
                choosing = false;
            }
            else {
                System.out.println("Invalid input.");
            }
        }
        return choice;
    }

    public static Player createPlayer() { //just creates a player on start-up
        Player player = new Player(GameLogic.promptString("What is your name, guardian?"), 
            new LevellerBuilder()
                .setHPGrowth(4)
                .setAtkGrowth(2)
                .setDefGrowth(3)
                .setSpdGrowth(2)
                .build(),
            new StatsBuilder()
                .setMaxHP(100)
                .setAttack(20)
                .setDefense(30)
                .setSpeed(25)
                .build(),
            new Inventory(10));
        
        return player;
    }
}
