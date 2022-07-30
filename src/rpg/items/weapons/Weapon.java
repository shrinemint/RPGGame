package src.rpg.items.weapons;

import src.rpg.entity.Entity;
import src.rpg.items.Item;

public class Weapon extends Item {
    private double power; //Power is a slight adjustment to an entity's attack

    public Weapon(WeaponList weapon) {
        super(weapon.getName(), weapon.getDescription(), 1, ItemType.WEAPON);
        this.power = weapon.getPower();
    }

    public Weapon(String name, String description, double power) {
        super(name, description, 1, ItemType.WEAPON);
        this.power = power;
    }

    @Override
    public void use(Entity e) {
        e.getInventory().setWeaponSlot(this);
    }

    public double setPower(double power) {
        this.power = power;
        return power;
    }

    public double getPower() {return power;}
}
