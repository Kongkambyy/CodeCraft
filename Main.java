public class Main {
    public static void main(String[] args){
        lasseTest();
        Menu.start();
    }
    public static void lasseTest() {

        Player player = new Player("h", "h");

        Inv inv = new Inv();
        player.setUserInventory(inv);

        Lager.addPlayerToArray(player);

    }
}