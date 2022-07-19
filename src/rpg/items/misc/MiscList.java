package src.rpg.items.misc;

public enum MiscList {
    EMPTY_SLOT("EMPTY SLOT", "", 1)
    ;

    private String name;
    private String description;
    private int maxStack;

    private MiscList(String name, String description, int maxStack) {
        this.name = name;
        this.description = description;
        this.maxStack = maxStack;
    }

    public String getName() {return name;}
    public String getDescription() {return description;}
    public int getMaxStack() {return maxStack;}
}
