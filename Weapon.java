public class Weapon extends Item{

    static final Weapon Sword = new Weapon(0, "Sword", 30,25);
    static final Weapon AXE = new Weapon(1, "Axe", 25, 12);
    static final Weapon SPEAR = new Weapon(2, "Spear", 15, 10);
    static final Weapon DAGGER = new Weapon(3, "Dagger", 10, 10);

    public Weapon(int id, String name, int weight, int value) {
        super(id, name, weight, value);
    }
}
