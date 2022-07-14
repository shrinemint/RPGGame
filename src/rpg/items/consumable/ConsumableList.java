package src.rpg.items.consumable;

public enum ConsumableList {
    POTION("Potion", "A normal potion - Heals 15 points", 99, 15, 0),
    HALF_MAX_POTION("Half-Max Potion", "Has a thick and viscous consistency. - Heals 50% of target's maximum HP.", 99, 0, 50),
    ;

    private String name;
    private String description;
    private int maxStacks;
    private int resPoints;
    private int resPercent;

    private ConsumableList(String name, String description, int maxStacks, int resPoints, int resPercent) {
        this.name = name;
        this.description = description;
        this.maxStacks = maxStacks;
        this.resPoints = resPoints;
        this.resPercent = resPercent;
    }

    public String getName() {return name;}
    public String getDescription() {return description;}
    public int getMaxStacks() {return maxStacks;}
    public int getResPoints() {return resPoints;}
    public int getResPercent() {return resPercent;}
}
