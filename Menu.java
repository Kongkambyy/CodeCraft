import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static Scanner scanner = new Scanner(System.in);

    public static void rensTerminal(){
        for (int i = 0 ; i < 100 ; i++){
            System.out.println(" ");
        }
    }
    public static void startScreen(){

        boolean run = true;

        while (run){
            System.out.println
                    ("   ____          _       ____            __ _   \n" +
                    "  / ___|___   __| | ___ / ___|_ __ __ _ / _| |_ \n" +
                    " | |   / _ \\ / _` |/ _ \\ |   | '__/ _` | |_| __|\n" +
                    " | |__| (_) | (_| |  __/ |___| | | (_| |  _| |_ \n" +
                    "  \\____\\___/ \\__,_|\\___|\\____|_|  \\__,_|_|  \\__|\n" +
                    "                                                ");
            System.out.println("1. Login");
            System.out.println("2. Registrer");
            System.out.println("3. Afslut programmet");
            int valg = scanner.nextInt();
            switch (valg){

                //Første case hvor brugeren logger ind til CodeCraft systemet
                case 1:
                    System.out.println("\n--- CodeCraft Login System ---");
                    System.out.println("Indtast brugernavn");
                    String thisUsername = scanner.next();
                    System.out.println("Indtast password");
                    String thisUserPassword = scanner.next();

                    if (Login.auth(thisUserPassword, thisUsername)){
                        mainMenu();
                    }

                    break;

                //Anden case hvor brugeren kan oprette sin konto til systemet.
                case 2:
                    System.out.println("\n--- Velkommen til CodeCrafts registrering ---");
                    System.out.println("Indtast brugernavn");
                    String thisUsername1 = scanner.next();

                    boolean gentagErRigtigt = true;
                    while (gentagErRigtigt){
                        System.out.println("Indtast password");
                        String thisUserPassword1 = scanner.next();

                        System.out.println("Genindtast dit password");
                        String thisUserPassword2 = scanner.next();

                        if (thisUserPassword1.equals(thisUserPassword2)){
                            Player player = new Player(thisUsername1, thisUserPassword1);
                            gentagErRigtigt = false;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Programmet afsluttes...");
                    run = false;
                    break;
            }
        }

    }

    public static void mainMenu () {

        Boolean valg = true;

        while (valg == true) {
            System.out.println("\n--- Velkommen til CodeCraft inventory system ---");
            System.out.println("1. Se dit nuværende inventory");
            System.out.println("2. Tilføj item til dit inventory");
            System.out.println("3. Fjern item fra dit inventory");
            System.out.println("4. Log ud af systemet");
            System.out.println("Vælg en af ovenstående muligheder");

            int choice = scanner.nextInt();



            try {
                switch (choice) {
                    case 1 -> {
                        System.out.println("\n--- Her kan du se dit nuværende inventory ---");
                        System.out.println("1. Søg inventory efter item");
                        System.out.println("2. Sorter dit inventory");
                    }
                    case 2 -> {
                        System.out.println("\n--- Her kan du tilføje items til dit inventory ---");
                        System.out.println("1. Søg efter item med navn");
                        System.out.println("2. Søg efter item med itemID");
                    }
                    case 3 -> {
                        System.out.println("\n--- Her kan du fjerne items fra dit inventory ---");
                    }
                    case 4 -> {
                        valg = false;

                    }
                    default -> System.out.println("Du har indtastet en ugyldig valgmulighed. Prøv igen.");

                }
                valg = false;
            } catch (Exception e) {
                System.out.println("Der opstod en fejl..." + e.getMessage());
                scanner.nextLine();
            }
        }
    }
}