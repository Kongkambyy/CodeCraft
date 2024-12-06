public class Lager {

    public static Player [] users = new Player[200];
    public static Inv [] invS = new Inv[64];

    public static void addPlayerToArray(Player player){
        for (int i = 0 ; i < users.length ; i++){
            if (users[i] == null) {
                users[i] = player;
            }
        }
    }
    

}
