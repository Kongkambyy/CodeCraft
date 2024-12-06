public class Login {

    public static Player loggedInPlayer = null;

    public static boolean auth(String username, String password) {
        boolean authenticated = false;
        boolean userNameFound = false;
        boolean passWordCorrect = false;

        //Søger efter brugernavn i Users array fra Lager classen
        for (int i = 0 ; i < Lager.users.length ; i++){
            //Hvis brugernavnet findes ændres usernameFound til true
            if (username.equals(Lager.users[i].getUsername())){
                userNameFound = true;
                //Tjekker om det indtasted password er det som er knyttet til user[i]. if true password ændres til true.
                if (password.equals(Lager.users[i].getPassword())){
                    passWordCorrect = true;
                    //loggedInPlayer bliver nu ændret så systemet ved hvem der er Logged in
                    loggedInPlayer = Lager.users[i];
                }else {
                    //hvis password ikke er rigtigt udskrives "Forkert password"
                    System.out.println("Forkert password");
                }
                //Hvis brugernavnet ikke kan findes i array udskrives
            }else {System.out.println("Brugernavn ikke fundet");}
        }
        return authenticated;
    }
}
