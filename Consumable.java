public class Consumable extends Item {
    static final Consumable HEALING_POTION = new Consumable(9, "Healing Potion", 5, 25);
    static final Consumable DAMAGE_POTION = new Consumable(10, "Damage Potion", 5, 25);

    public Consumable(int id, String name, int weight, int value) {
        super(id, name, weight, value);
    }


}
