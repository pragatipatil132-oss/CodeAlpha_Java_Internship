import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String category;
    boolean booked;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.booked = false;
    }
}

public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Deluxe"));
        rooms.add(new Room(103, "Suite"));

        while (true) {
            System.out.println("\n1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (Room r : rooms) {
                        System.out.println("Room " + r.roomNumber + 
                                           " | " + r.category + 
                                           " | Booked: " + r.booked);
                    }
                    break;

                case 2:
                    System.out.print("Enter room number: ");
                    int bookRoom = sc.nextInt();
                    for (Room r : rooms) {
                        if (r.roomNumber == bookRoom && !r.booked) {
                            r.booked = true;
                            System.out.println("Room booked successfully!");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter room number: ");
                    int cancelRoom = sc.nextInt();
                    for (Room r : rooms) {
                        if (r.roomNumber == cancelRoom && r.booked) {
                            r.booked = false;
                            System.out.println("Booking cancelled!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
