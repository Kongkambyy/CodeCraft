public class Lager {

    public static Player [] users = new Player[200];
    public static Inv [] invS = new Inv[64];
    public static Player loggedInPlayer = null;

    public static void addPlayerToArray(Player player){
        for (int i = 0 ; i < users.length ; i++){
            if (users[i] == null) {
                users[i] = player;
                System.out.println("\u001B[32mBruger registreret med succes!\u001B[0m");
                break;
            }
        }
    }
}

