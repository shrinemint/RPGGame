package src.rpg.items.weapons;

public enum WeaponList {
    EMPTY("None", "No weapon equipped.", 0),
    WOODEN_SWORD("Wooden Sword", "A hand-crafted sword.", 1),
    GUN("Gun", "A classic RPG weapon.", 100 )
    ;

    private String name;
    private String description;
    private double power;

    private WeaponList(String name, String description, double power) {
        this.name = name;
        this.description = description;
        this.power = power;    
    }

    public String getName() {return name;}
    public String getDescription() {return description;}
    public double getPower() {return power;}
}
