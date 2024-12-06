public class Player {

    private String username;
    private String password;
    private Inv userInventory;
    public Player(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public Inv getUserInventory() {
        return userInventory;
    }
    public void setUserInventory(Inv userInventory) {
        this.userInventory = userInventory;
    }
    public Inv getInv() {
        return userInventory;
    }
}
