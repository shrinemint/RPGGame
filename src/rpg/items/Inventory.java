package src.rpg.items;

/**
 * A glorified ArrayList but I totally promise to you that this is necessary
 * You see, you can set a maximum size be able to change it.
 * That's honestly bout it...
 */

public class Inventory {
    private int maxSize;
    private Item [] itemList;

    public Inventory() {
        this.maxSize = 10;
        itemList = new Item[maxSize];
    }

    public Inventory(int maxSize) {
        this.maxSize = maxSize;
        itemList = new Item[maxSize];
    }

    public Item add(Item item) { //Adds an item to the inventory in the first availible slot.
        if (isFull()) {
            return null;
        }
        else {
            for (int i = 0; i < itemList.length; i++) {
                if (itemList[i] == null) {
                    itemList[i] = item;
                    break;
                }
            }
            return item;
        }
    }

    public void use(int index) {
        itemList[index].use();
    }

    public boolean clear() { //Clears the inventory and returns true since it should always be cleared after using this method.
        for (int i = 0; i < itemList.length; i++) {
            itemList[i] = null;
        }
        return isEmpty();
    }

    /**
     * For this to work, the old inventory array must be copied over to a list of the new maxSize value. 
     * If maxSize is larger, copy all elements from previous array to new array.
     * If maxSize is smaller, copy all elements with an index smaller than the new array's length.
     */
    public int setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        Item [] tempItemList = itemList; //A copy of the old inventory
        itemList = new Item[maxSize]; //New inventory
        System.arraycopy(tempItemList, 0, itemList, 0, Math.min(tempItemList.length, itemList.length));
        return maxSize;
    }

    public int getMaxSize() {return itemList.length;}

    public int getSize() { //Returns the logical size of the inventory
        int size = 0;
        for (int i = 0; i < itemList.length; i++) {
            if (itemList[i] != null) {
                size++;
            }
        }
        return size;
    }

    public boolean isFull() { //Returns if logical size is equal to physical size
        return getSize() == itemList.length;
    }

    public boolean isEmpty() { //Returns if logical size is 0
        return getSize() == 0;
    }
}
