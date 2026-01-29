import java.util.*;

class Vehicle {
    String number;
    String owner;

    Vehicle(String number, String owner) {
        this.number = number;
        this.owner = owner;
    }
}

public class Main {

    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Vehicle> parking = new HashMap<>();
    static int maxSlots = 5;

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n--- Smart Parking System ---");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. View Parked Vehicles");
            System.out.println("4. Available Slots");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1: parkVehicle(); break;
                case 2: removeVehicle(); break;
                case 3: viewVehicles(); break;
                case 4: availableSlots(); break;
                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    static void parkVehicle() {

        if (parking.size() == maxSlots) {
            System.out.println("Parking Full");
            return;
        }

        System.out.print("Enter Slot Number (1-5): ");
        int slot = sc.nextInt();

        if (parking.containsKey(slot)) {
            System.out.println("Slot already occupied");
            return;
        }

        sc.nextLine();
        System.out.print("Enter Vehicle Number: ");
        String num = sc.nextLine();

        System.out.print("Enter Owner Name: ");
        String owner = sc.nextLine();

        parking.put(slot, new Vehicle(num, owner));
        System.out.println("Vehicle Parked Successfully");
    }

    static void removeVehicle() {

        System.out.print("Enter Slot to remove: ");
        int slot = sc.nextInt();

        if (parking.remove(slot) != null)
            System.out.println("Vehicle Removed");
        else
            System.out.println("Slot Empty");
    }

    static void viewVehicles() {

        if (parking.isEmpty()) {
            System.out.println("No Vehicles Parked");
            return;
        }

        for (Map.Entry<Integer, Vehicle> e : parking.entrySet()) {
            Vehicle v = e.getValue();
            System.out.println("Slot " + e.getKey() + " : " + v.number + " - " + v.owner);
        }
    }

    static void availableSlots() {
        System.out.println("Available Slots: " + (maxSlots - parking.size()));
    }
}