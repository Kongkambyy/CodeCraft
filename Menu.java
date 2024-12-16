import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    public static void start() {
        boolean authenticated = false;

        while (!authenticated) {
            printHeader("--- Velkommen til CodeCraft Inventory System ---");
            System.out.println("1. Log ind");
            System.out.println("2. Registrer");
            System.out.println("3. Afslut");
            System.out.print("Vælg en af ovenstående muligheder: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    printProgressBar("");
                    printHeader("Log ind");
                    System.out.print("Brugernavn: ");
                    String username = scanner.nextLine();
                    System.out.print("Adgangskode: ");
                    String password = scanner.nextLine();


                    Player loggedInPlayer = null;
                    for (Player user : Lager.users) {
                        if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {
                            loggedInPlayer = user;
                            break;
                        }
                    }

                    if (loggedInPlayer != null) {
                        Lager.loggedInPlayer = loggedInPlayer;
                        authenticated = true;
                        System.out.println("\u001B[32mLogin succesfuldt! Velkommen, " + loggedInPlayer.getUsername() + ".\u001B[0m");
                        printProgressBar("Logger ind");
                        mainMenu();
                    } else {
                        System.out.println("\u001B[31mForkert brugernavn eller adgangskode. Prøv igen.\u001B[0m");
                        promptEnterKey();
                    }

                    }
                    case 2 -> {
                        printProgressBar("");
                        printHeader("Registrer ny bruger");
                        System.out.print("Nyt brugernavn: ");
                        String newUsername = scanner.nextLine();
                        System.out.print("Ny adgangskode: ");
                        String newPassword = scanner.nextLine();

                        Player thisNewPLayer = new Player(newUsername, newPassword);
                        Lager.addPlayerToArray(thisNewPLayer);
                        promptEnterKey();
                    }
                    case 3 -> {
                        printProgressBar("Afslutter");
                        System.exit(0);
                    }
                    default -> System.out.println("\u001B[31mUgyldigt valg. Prøv igen.\u001B[0m");
                }
        }
    }

    public static void mainMenu() {
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("1. Se dit nuværende inventory");
            System.out.println("2. Tilføj item til dit inventory");
            System.out.println("3. Fjern item fra dit inventory");
            System.out.println("4. Søg efter et item");
            System.out.println("5. Sorter inventory");
            System.out.println("6. Log ud ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    printProgressBar("Henter inventory");

                    Lager.loggedInPlayer.getInv().showInventory();
                    System.out.println("Inventory er hentet!");
                    promptEnterKey();

                }
                case 2 -> {
                    printProgressBar("Åbner tilføjelsesmenu");
                    System.out.println("Tilføjelsesmenu er klar.");
                    udskrivAlleItems();
                    System.out.println("Indtast ID på item: ");
                    int id = scanner.nextInt();
                    Lager.loggedInPlayer.getInv().addItem(Lager.itemListe[id]);
                    promptEnterKey();
                }
                case 3 -> {
                    printProgressBar("Åbner fjernelsesmenu");
                    System.out.println("Fjernelsesmenu er klar.");
                    Lager.loggedInPlayer.getInv().showInventory();
                    System.out.println("Indtast ID på item du vil fjerne: ");
                    int thisUserInputId = scanner.nextInt();
                    Lager.loggedInPlayer.getInv().deleteItemFromInventory(thisUserInputId);
                    promptEnterKey();
                }
                case 4 -> {
                    printProgressBar("Åbner søgemenu");
                    System.out.println("Søgemenu er klar.");
                    promptEnterKey();
                }
                case 5 -> {
                    printProgressBar("Åbner sorteringsmenu");
                    System.out.println("Sorteringsmenu er klar.");
                    promptEnterKey();
                    System.out.println("Hvordan vil du sortere dit inventory.");
                    System.out.println("1. ID");
                    System.out.println("2. Navn");
                    System.out.println("3. Antal");
                    System.out.println();

                    int sorteringsValgMenu = Menu.scanner.nextInt();

                    Lager.loggedInPlayer.getInv().sort(sorteringsValgMenu);

                }
                case 6 -> {
                    printProgressBar("Logger ud");
                    continueRunning = false;
                }
                case 7 -> {
                    Item item0 = new Item(0, "HeadArmor", 33,333,"Armor");
                    Item item1 = new Item(3, "Sword", 15, 500, "Weapon");
                    Item item2 = new Item(2, "Axe", 20, 450, "Weapon");
                    Item item3 = new Item(1, "Spear", 18, 400, "Weapon");
                    Item item4 = new Item(10, "Shield", 25, 550, "Weapon");
                    Item item5 = new Item(7, "Dagger", 10, 300, "Weapon");
                    Item item6 = new Item(61, "HeadArmor", 8, 200, "Armor");
                    Item item7 = new Item(45, "ChestArmor", 20, 800, "Armor");
                    Item item8 = new Item(8, "LegArmor", 15, 600, "Armor");
                    Item item9 = new Item(9, "FootArmor", 10, 400, "Armor");
                    Item item10 = new Item(4, "Healing Potin", 5, 150, "Consumable");

                    Inv thisInv = new Inv ();
                    thisInv.addItem(item0);
                    thisInv.addItem(item1);
                    thisInv.addItem(item2);
                    thisInv.addItem(item3);
                    thisInv.addItem(item4);
                    thisInv.addItem(item5);
                    thisInv.addItem(item6);
                    thisInv.addItem(item7);
                    thisInv.addItem(item8);
                    thisInv.addItem(item9);
                    thisInv.addItem(item10);

                    Lager.loggedInPlayer.setUserInventory(thisInv);
                }
                default -> System.out.println("\u001B[31mUgyldigt valg. Prøv igen.\u001B[0m");
            }
        }
    }

    private static void printHeader(String header) {
        System.out.println("\u001B[34m=== " + header + " ===\u001B[0m\n");
    }

    private static void promptEnterKey() {
        System.out.println("\nTryk Enter for at fortsætte...");
        scanner.nextLine();
    }

    private static void printProgressBar(String message) {
        System.out.print(message + "[");
        for (int i = 0; i < 8; i++) {
            System.out.print("=");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("] Fuldført!");
        System.out.println("");
        rensTerminal();
        }

    private static void rensTerminal() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
    private static void udskrivAlleItems(){
        for (int i = 0; i < Lager.itemListe.length; i++) {
            Lager.itemListe[i].displayItem();
        }
    }

}
