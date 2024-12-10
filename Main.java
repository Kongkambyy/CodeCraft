public class Main {
    public static void main(String[] args) {
        lasseTest();
    }
    public static void lasseTest(){
        Item item = new Item();

        Player player = new Player("Shillerx", "Shillerx");
        Item item0 = new Item(1, "HeadArmor", 33,333,"Armor");
        Item item1 = new Item(1, "Sword", 15, 500, "Weapon");
        Item item2 = new Item(2, "Axe", 20, 450, "Weapon");
        Item item3 = new Item(3, "Spear", 18, 400, "Weapon");
        Item item4 = new Item(4, "Shield", 25, 550, "Weapon");
        Item item5 = new Item(5, "Dagger", 10, 300, "Weapon");
        Item item6 = new Item(6, "HeadArmor", 8, 200, "Armor");
        Item item7 = new Item(7, "ChestArmor", 20, 800, "Armor");
        Item item8 = new Item(8, "LegArmor", 15, 600, "Armor");
        Item item9 = new Item(9, "FootArmor", 10, 400, "Armor");
        Item item10 = new Item(10, "Healing Potin", 5, 150, "Consumable");

        Inv inv = new Inv();

        inv.addItem(item0);
        inv.addItem(item1);
        inv.addItem(item2);
        inv.addItem(item3);
        inv.addItem(item4);
        inv.addItem(item5);
        inv.addItem(item6);
        inv.addItem(item7);
        inv.addItem(item8);
        inv.addItem(item9);
        inv.addItem(item10);

        inv.showInventory();

        System.out.println(inv.convertWholeInvToString());

        Item item11 = item.convertStringToItem("101333330");

        System.out.println("dekrypteret Item:");
        item4.displayItem();




    }
}