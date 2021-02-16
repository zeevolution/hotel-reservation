import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        String line = "";
        Scanner scanner = new Scanner(System.in);

        printMainMenu();

        try {
            do {
                line = scanner.nextLine();

                if (line.length() == 1) {
                    switch (line.charAt(0)) {
                        case '1':
                            System.out.println("Find and reserve a room");
                            break;
                        case '2':
                            System.out.println("See my reservations");
                            break;
                        case '3':
                            System.out.println("Create an Account");
                            break;
                        case '4':
                            System.out.println("Admin");
                            AdminMenu.adminMenu();
                            break;
                        case '5':
                            System.out.println("Exit");
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

    public static void printMainMenu()
    {
        System.out.print("Welcome to the Hotel Reservation Application\n" +
                "--------------------------------------------\n" +
                "1. Find and reserve a room\n" +
                "2. See my reservations\n" +
                "3. Create an Account\n" +
                "4. Admin\n" +
                "5. Exit\n" +
                "--------------------------------------------\n" +
                "Please select a number for the menu option\n");
    }
}
