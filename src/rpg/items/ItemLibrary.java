package src.rpg.items;

import java.io.*;
import java.util.*;

import src.rpg.entity.attributes.StatsBuilder;
import src.rpg.items.Item.ItemType;
import src.rpg.items.armor.Armor;
import src.rpg.items.armor.ArmorList;
import src.rpg.items.armor.Armor.ArmorType;
import src.rpg.items.consumable.Consumable;
import src.rpg.items.consumable.ConsumableList;
import src.rpg.items.misc.Misc;
import src.rpg.items.misc.MiscList;
import src.rpg.items.weapons.Weapon;
import src.rpg.items.weapons.WeaponList;

/**
 * This is a library meant to hold all the items within the game. Only the items in this list will have an ID assigned to them.
 * All items will be assigned an ID upon starting the game.
 * This allows custom items to be added and to also have their own IDs.
 * need to add way to read custom files from res/custom items and to ensure that there isn't any duplication happening.
 */

public class ItemLibrary {
    private static List<Item> itemList;
    //private static HashMap<Integer, Item> itemList;

    /**
     * Creates a universal item list of all items.
     * The items will be ordered by their type from weapons, armor, consumables, and lastly misc.
     * It will first add the pre-built items of one type from its enum and then add the custom item of the same type.
     */
    public static void initItemList() throws IOException {
        itemList = new ArrayList<Item>();

        //Lists seperated by item type. The enum values are passed first, then the custom item files.
        List<Weapon> weapon_list = new ArrayList<Weapon>();
        List<Armor> armor_list = new ArrayList<Armor>();
        List<Consumable> consumable_list = new ArrayList<Consumable>();
        List<Misc> misc_list = new ArrayList<Misc>();

        for (int i = 0; i < WeaponList.values().length; i++) {
            weapon_list.add(new Weapon(WeaponList.values()[i]));
        }
        for (int i = 0; i < ArmorList.values().length; i++) {
            armor_list.add(new Armor(ArmorList.values()[i]));
        }
        for (int i = 0; i < ConsumableList.values().length; i++) {
            consumable_list.add(new Consumable(ConsumableList.values()[i]));
        }
        for (int i = 0; i < MiscList.values().length; i++) {
            misc_list.add(new Misc(MiscList.values()[i]));
        }

        //Creates a list of all the files in the items folder
        String location = "res\\custom\\items";
        File directory = new File(location);
        File [] itemFiles = directory.listFiles();

        /**
         * For each file in the directory, create a scanner to scan it.
         * Get the custom item's type, then the get the information relevant to that item's properties.
         * Custom items should not have properties unrelated to their type.
         * Or at the very least, don't leave it blank.
         */
        for (File file : itemFiles) {
            //If the file does not have the .itm extension, then skip over it.
            //This isn't a bad solution actually tbh
            if (!file.getName().substring(file.getName().length() - 5).equals(".item")) {continue;}
            
            /**
             * The sf scanner reads the line and info
             * The sf2 scanner breaks the command and information passed apart
             */
            Scanner sf = new Scanner(new File(location + "\\" + file.getName())); //A scanner 
            sf.useDelimiter(",|\\n");
            
            //Temporary variables to hold the properties of the custom item
            String name = null, description = null;
            int maxStack = 0;
            ItemType type = null;
            int power = 0;
            int attack = 0, defense = 0, speed = 0;
            ArmorType armorType = null;
            int resPoints = 0, resPercent = 0;

            while (sf.hasNext()) {
                Scanner sf2 = new Scanner(sf.next());
                sf2.useDelimiter(":|,|\\n");
                String command = sf2.next();
                String commandInfo;
                
                //Ensures that a command from the .itm file cannot be empty
                if (sf2.hasNext()) {commandInfo = sf2.next();}
                else {
                    sf2.close();
                    throw new IllegalArgumentException("Cannot pass null values to a parameter.");
                }

                if (command.equals("nme")) {
                    if (commandInfo.equals("")) {
                        sf2.close();
                        throw new IllegalArgumentException("Items must have a name.");
                    }
                    name = commandInfo.substring(1, commandInfo.length() - 1);
                }
                else if (command.equals("des")) {
                    description = commandInfo.substring(1, commandInfo.length() - 1);
                }
                else if (command.equals("m_stk")) {
                    if (Integer.parseInt(commandInfo) < 1) {
                        sf2.close();
                        throw new IllegalArgumentException("An item cannot be given a maximum stack of " + commandInfo);
                    }
                    maxStack = Integer.parseInt(commandInfo);
                }
                else if (command.equals("typ")) {
                    switch (commandInfo) {
                        case "weapon":
                            type = ItemType.WEAPON;
                            break;
                        case "armor":
                            type = ItemType.ARMOR;
                            break;
                        case "consumable":
                            type = ItemType.CONSUMABLE;
                            break;
                        case "misc":
                            type = ItemType.MISC;
                            break;
                        default:
                            sf.close();
                            throw new IllegalArgumentException("Item has an invalid item type. Item must be a weapon, armor, consumable, or misc.");
                    }
                }
                else if (command.equals("pwr")) {
                    if (type != ItemType.WEAPON) {
                        sf2.close();
                        throw new IllegalArgumentException("Item type mismatch. A non-weapon item cannot be given the attribute: " + command);
                    }
                    power = Integer.parseInt(commandInfo);
                }
                else if (command.equals("a")) {
                    if (type != ItemType.ARMOR) {
                        sf2.close();
                        throw new IllegalArgumentException("Item type mismatch. A non-armor item cannot be given the attribute: " + command);
                    }
                    attack = Integer.parseInt(commandInfo);
                }
                else if (command.equals("d")) {
                    if (type != ItemType.ARMOR) {
                        sf2.close();
                        throw new IllegalArgumentException("Item type mismatch. A non-armor item cannot be given the attribute: " + command);
                    }
                    defense = Integer.parseInt(commandInfo);
                }
                else if (command.equals("s")) {
                    if (type != ItemType.ARMOR) {
                        sf2.close();
                        throw new IllegalArgumentException("Item type mismatch. A non-armor item cannot be given the attribute: " + command);
                    }
                    speed = Integer.parseInt(commandInfo);
                }
                else if (command.equals("a_piece")) {
                    if (type != ItemType.ARMOR) {
                        sf2.close();
                        throw new IllegalArgumentException("Item type mismatch. A non-armor item cannot be given the attribute: " + command);
                    }
                    switch (commandInfo) {
                        case "helmet":
                            armorType = ArmorType.HELMET;
                            break;
                        case "chestplate":
                            armorType = ArmorType.CHESTPLATE;
                            break;
                        case "leggings":
                            armorType = ArmorType.LEGGINGS;
                            break;
                        case "boots":
                            armorType = ArmorType.BOOTS;
                            break;
                    }
                }
                else if (command.equals("r_pts")) {
                    if (type != ItemType.ARMOR) {
                        sf2.close();
                        throw new IllegalArgumentException("Item type mismatch. A non-consumable item cannot be given the attribute: " + command);
                    }
                    resPoints = Integer.parseInt(commandInfo);
                }
                else if (command.equals("r_pct")) {
                    if (type != ItemType.ARMOR) {
                        sf2.close();
                        throw new IllegalArgumentException("Item type mismatch. A non-consumable item cannot be given the attribute: " + command);
                    }
                    resPercent = Integer.parseInt(commandInfo);
                }
                else {
                    sf2.close();
                    throw new IllegalArgumentException("The command " + command + " is not recognized.");
                }
            }

            //Adds the newly constructed custom item to a temporary list of items so they can be ordered later.
            switch (type) {
                case WEAPON:
                    weapon_list.add(new Weapon(name, description, power));
                    break;
                case ARMOR:
                    armor_list.add(new Armor(name, description, new StatsBuilder().setAttack(attack).setDefense(defense).setSpeed(speed).build(), armorType));
                    break;
                case CONSUMABLE:
                    consumable_list.add(new Consumable(name, description, maxStack, resPoints, resPercent));
                    break;
                case MISC:
                    misc_list.add(new Misc(name, description, maxStack));
                    break;
            }
        }
        /**
         * Combines the four lists above into one array and assigns each an ID upon initialization
         * i is the index in which to start adding items. It also works as the item's ID.
         * j is added to the temporary list's length so the size will stay the same.
         * i - j is the index for the temporary list to get the item from.
         */
        for (int k = 0; k < 4; k++) {
            //Probably makes sense to use generic List here
            List temp_list = null;

            switch (k) {
                case 0:
                    temp_list = weapon_list;
                    break;
                case 1:
                    temp_list = armor_list;
                    break;
                case 2:
                    temp_list = consumable_list;
                    break;
                case 3:
                    temp_list = misc_list;
                    break;
            }

            int i = itemList.size(), j = itemList.size();
            while (i < temp_list.size() + j) {
                itemList.add((Item)temp_list.get(i - j));
                i++;
            }
        }
        
    }
    
    public static void printItems() {
        int i = 0;
        while (i < itemList.size()) {
            System.out.println("ID: " + i + " Item Name: " + itemList.get(i).getName());
            i++;
        }
    }

    public static Item get(int ID) throws CloneNotSupportedException {
        return get(itemList.get(ID));
    }

    public static Item get(Item item) throws CloneNotSupportedException {
        return (Item)itemList.get(item.getID()).clone();
    }

    public static Item getEmptySlot() {return itemList.get(new Misc(MiscList.EMPTY_SLOT).getID());}

    public static List<Item> getItemList() {return itemList;}
}