import api.HotelResource;
import model.reservation.Reservation;
import model.room.IRoom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {

    private static final String DEFAULT_DATE_FORMAT = "mm/dd/yyyy";
    private static final HotelResource hotelResource = HotelResource.getSingleton();

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
                            findAndReserveRoom();
                            break;
                        case '2':
                            seeMyReservation();
                            break;
                        case '3':
                            createAccount();
                            break;
                        case '4':
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
                    System.out.println("Error: Invalid action\n");
                }
            } while (line.charAt(0) != '5' || line.length() != 1);
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("Empty input received. Exiting program...");
        }
    }

    private static void findAndReserveRoom() {
        final Scanner scanner = new Scanner(System.in);

        Date checkIn = null;
        Date checkOut = null;

        try {
            System.out.println("Enter CheckIn Date mm/dd/yyyy example 02/01/2020");
            checkIn = new SimpleDateFormat(DEFAULT_DATE_FORMAT).parse(scanner.nextLine());
        } catch (ParseException ex) {
            System.out.println("Invalid check-in date");
            findAndReserveRoom();
        }

        try {
            System.out.println("Enter CheckOut Date mm/dd/yyyy example 02/21/2020");
            checkOut = new SimpleDateFormat(DEFAULT_DATE_FORMAT).parse(scanner.nextLine());
        } catch (ParseException ex) {
            System.out.println("Invalid check-out date");
            findAndReserveRoom();
        }

        if (checkIn != null && checkOut != null) {
            Collection<IRoom> availableRooms = hotelResource.findARoom(checkIn, checkOut);
            printRooms(availableRooms);

            if(!availableRooms.isEmpty()) {
                System.out.println("Would you like to book a room? y/n");
                final String bookRoom = scanner.nextLine();

                if ("y".equals(bookRoom)) {
                    System.out.println("Do you have an account with us? y/n");
                    final String haveAccount = scanner.nextLine();

                    if ("y".equals(haveAccount)) {
                        reserveRoom(scanner, checkIn, checkOut);
                    } else {
                        System.out.println("Please, create an account.");
                        printMainMenu();
                    }
                } else {
                    printMainMenu();
                }
            } else {
                printMainMenu();
            }
        }
    }

    private static void reserveRoom(final Scanner scanner, final Date checkInDate, final Date checkOutDate) {
        System.out.println("Enter Email format: name@domain.com");
        final String customerEmail = scanner.nextLine();

        System.out.println("What room number would you like to reserve?");
        final String roomNumber = scanner.nextLine();

        final IRoom room = hotelResource.getRoom(roomNumber);

        final Reservation reservation = hotelResource.bookARoom(customerEmail, room, checkInDate, checkOutDate);
        System.out.println(reservation);

        printMainMenu();
    }

    private static void printRooms(Collection<IRoom> rooms) {
        if (rooms.isEmpty()) {
            System.out.println("No rooms found.");
        } else {
            System.out.println(rooms);
        }
    }

    private static void seeMyReservation() {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your Email format: name@domain.com");
        final String customerEmail = scanner.nextLine();

        printReservations(hotelResource.getCustomersReservations(customerEmail));
    }

    private static void printReservations(Collection<Reservation> reservations) {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            System.out.println(reservations);
        }
    }

    private static void createAccount() {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Email format: name@domain.com");
        final String email = scanner.nextLine();

        System.out.println("First Name:");
        final String firstName = scanner.nextLine();

        System.out.println("Last Name:");
        final String lastName = scanner.nextLine();

        try {
            hotelResource.createACustomer(email, firstName, lastName);
            System.out.println("Account created successfully!");

            printMainMenu();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getLocalizedMessage());
            createAccount();
        }
    }

    public static void printMainMenu()
    {
        System.out.print("\nWelcome to the Hotel Reservation Application\n" +
                "--------------------------------------------\n" +
                "1. Find and reserve a room\n" +
                "2. See my reservations\n" +
                "3. Create an Account\n" +
                "4. Admin\n" +
                "5. Exit\n" +
                "--------------------------------------------\n" +
                "Please select a number for the menu option:\n");
    }
}
