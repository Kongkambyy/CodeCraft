public class Main {
    public static void main(String[] args) {
        lasseTest();
    }
    public static void lasseTest(){
        Player player = new Player("Shillerx", "Shillerx");
        Item item = new Item(01, "HeadArmor", 33,333,"Armor");
        Inv inv = new Inv();

        inv.addItem(item);
        player.setUserInventory(inv);


    }
}