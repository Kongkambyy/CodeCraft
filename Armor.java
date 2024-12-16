public class Armor extends Item {
     static final Armor SWORD = new Armor(0, "Sword", 30, 25);
    public static final Armor AXE = new Armor(1, "Axe", 25, 12);
    public static final Armor SPEAR = new Armor(2, "Spear", 15, 10);
    public static final Armor DAGGER = new Armor(3, "Dagger", 10, 10);

    public Armor(int id, String name, int weight, int value) {
        super(id, name, weight, value);
    }
}
