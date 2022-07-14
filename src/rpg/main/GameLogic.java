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
import src.rpg.items.armor.ArmorSet;
import src.rpg.items.weapons.Weapon;
import src.rpg.items.weapons.WeaponList;

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

    public static Player createPlayer() {
        Player player = new Player(GameLogic.promptString("What is your name, guardian?"), 
            new LevellerBuilder()
                .setHPGrowth(0)
                .setAtkGrowth(0)
                .setDefGrowth(0)
                .setSpdGrowth(0)
                .build(),
            new StatsBuilder()
                .setMaxHP(0)
                .setAttack(0)
                .setDefense(0)
                .setSpeed(0)
                .build(),
            new ArmorSet(),
            new Weapon(WeaponList.EMPTY),
            new Inventory());
        
        return player;
    }
}
