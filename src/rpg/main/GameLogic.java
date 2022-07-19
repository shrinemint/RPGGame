package src.rpg.main;

/**
 * Some standard game logic functions which do things like initialize item and enemy lists, initializing the player, doing console prompts, etc.
 * 
 */

import java.util.Scanner;
import src.rpg.entity.Player;
import src.rpg.entity.attributes.ArmorSet;
import src.rpg.entity.attributes.LevellerBuilder;
import src.rpg.entity.attributes.StatsBuilder;
import src.rpg.items.Inventory;
import src.rpg.items.Item;
import src.rpg.items.armor.Armor;
import src.rpg.items.armor.ArmorList;
import src.rpg.items.consumable.Consumable;
import src.rpg.items.consumable.ConsumableList;
import src.rpg.items.misc.Misc;
import src.rpg.items.misc.MiscList;
import src.rpg.items.weapons.Weapon;
import src.rpg.items.weapons.WeaponList;

public class GameLogic {
    private static Scanner kbReader = new Scanner(System.in);
    private static Item [] itemLibrary;

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

    public static void initItemList() {
        /** 
         * FUCK THIS METHOD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         * (don't delete this tho)
         */
        itemLibrary = new Item[WeaponList.values().length + ArmorList.values().length + ConsumableList.values().length + MiscList.values().length];

        final WeaponList [] WEAPON_LIST = WeaponList.values();
        final ArmorList [] ARMOR_LIST = ArmorList.values();
        final ConsumableList [] CONSUMABLE_LIST = ConsumableList.values();
        final MiscList [] MISC_LIST = MiscList.values();

        //oh my fucking god
        //i hate this what the fuck

        /**
         * Combines the four lists above into one array and assigns each an ID upon initialization
         * It also takes the enum values and turns them into Item objects.
         */
        for (int i = 0; i < WEAPON_LIST.length; i++) {
            itemLibrary[i] = new Weapon(WEAPON_LIST[i]);
        }

        for (int i = WEAPON_LIST.length; i < WEAPON_LIST.length + ARMOR_LIST.length; i++) {
            itemLibrary[i] = new Armor(ARMOR_LIST[i - WEAPON_LIST.length]);
        }
        
        for (int i = WEAPON_LIST.length + ARMOR_LIST.length; i < WEAPON_LIST.length + ARMOR_LIST.length + CONSUMABLE_LIST.length; i++) {
            itemLibrary[i] = new Consumable(CONSUMABLE_LIST[i - (WEAPON_LIST.length + ARMOR_LIST.length)]);
        }

        for (int i = WEAPON_LIST.length + ARMOR_LIST.length + CONSUMABLE_LIST.length; i < WEAPON_LIST.length + ARMOR_LIST.length + CONSUMABLE_LIST.length + MISC_LIST.length; i++) {
            itemLibrary[i] = new Misc(MISC_LIST[i - (WEAPON_LIST.length + ARMOR_LIST.length + CONSUMABLE_LIST.length)]);
        }

        for (int i = 0; i < itemLibrary.length; i++) {
            itemLibrary[i].setID(i);
        }
    }

    public static Item getItem(int i) {
        return itemLibrary[i];
    }

    public static int getItemLibrarySize() { //This is just a method for testing if all items are put into the itemLibrary
        return itemLibrary.length;
    }
}
