package src.rpg.main;

import java.io.*;
import java.util.*;

import src.rpg.battle.BattleLogic;
import src.rpg.entity.Enemy;
import src.rpg.entity.EnemyList;
import src.rpg.entity.Entity;
import src.rpg.entity.Player;
import src.rpg.items.ItemLibrary;
import src.rpg.items.weapons.*;
import src.rpg.items.armor.*;
import src.rpg.items.armor.Armor.ArmorType;
import src.rpg.items.consumable.*;
import src.rpg.items.misc.*;

/**
 * Where everything is executed
 * Probably should create a player and enemy class first
 */

public class Main {
    public Main() {
        init();

        Player player = GameLogic.createPlayer();
        player.getInventory().add(new Consumable(ConsumableList.POTION), 10);
        player.getInventory().add(new Armor(ArmorList.SNEAKERS), 1);
        Enemy enemy = new Enemy(EnemyList.SNAKE);
        Enemy enemy2 = new Enemy(EnemyList.SNAKE);

        ArrayList<Enemy> enemyParty = new ArrayList<Enemy>();
        enemyParty.add(enemy);
        enemyParty.add(enemy2);

        BattleLogic.startEncounter(player, enemyParty);
    }

    public static void main(String args[]) throws IOException { //little bitch boy static void main here lmaaaoooo
        new Main();
    }
    
    public void init() { //a method activating all the initialization methods
        try {
            ItemLibrary.initItemList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //ItemLibrary.printItems();
        
    }

    

}
