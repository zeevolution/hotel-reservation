import java.util.Scanner;

public class AdminMenu {

    public static void adminMenu() {
        String line = "";
        Scanner scanner = new Scanner(System.in);

        printMenu();

        try {
            do {
                line = scanner.nextLine();

                if (line.length() == 1) {
                    switch (line.charAt(0)) {
                        case '1':
                            System.out.println("See all Customers");

                            break;
                        case '2':
                            System.out.println("See all Rooms");
                            break;
                        case '3':
                            System.out.println("See all Reservations");
                            break;
                        case '4':
                            System.out.println("Add a Room");
                            break;
                        case '5':
                            System.out.println("Back to Main Menu");
                            MainMenu.printMainMenu();
                            break;
                        default:
                            System.out.println("Unknown action\n");
                            break;
                    }
                } else {
                    System.out.println("Invalid action\n");
                }
            } while (line.charAt(0) != '5' || line.length() != 1);
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("Empty input received. Exiting program...");
        }
    }

    private static void printMenu() {
        System.out.print("Admin Menu\n" +
                "--------------------------------------------\n" +
                "1. See all Customers\n" +
                "2. See all Rooms\n" +
                "3. See all Reservations\n" +
                "4. Add a Room\n" +
                "5. Back to Main Menu\n" +
                "--------------------------------------------\n" +
                "Please select a number for the menu option\n");
    }
}
