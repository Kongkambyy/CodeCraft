public class Login {

    public static boolean auth(String username, String password) {
        for (Player account : Lager.users) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                Lager.loggedInPlayer = account;
                return true;
            }
        }
        return false;
    }
}

