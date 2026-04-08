import java.util.*;

class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return type + " | Capacity: " + capacity;
    }
}

public class TrainApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<PassengerBogie> bogieList = new ArrayList<>();

        System.out.print("Enter number of passenger bogies: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            try {
                System.out.println("\nEnter details for Bogie " + (i + 1));

                System.out.print("Enter Bogie Type (Sleeper/AC/First Class): ");
                String type = scanner.nextLine();

                System.out.print("Enter Capacity: ");
                int capacity = scanner.nextInt();
                scanner.nextLine(); // consume newline

                PassengerBogie bogie = new PassengerBogie(type, capacity);
                bogieList.add(bogie);

                System.out.println("✅ Bogie added successfully!");

            } catch (InvalidCapacityException e) {
                System.out.println("❌ Error: " + e.getMessage());
                System.out.println("Bogie NOT added. Please enter valid data.");
            } catch (Exception e) {
                System.out.println("❌ Invalid input. Try again.");
                scanner.nextLine();
            }
        }


        System.out.println("\n--- Valid Passenger Bogies ---");

        if (bogieList.isEmpty()) {
            System.out.println("No valid bogies added.");
        } else {
            for (PassengerBogie b : bogieList) {
                System.out.println(b);
            }
        }

        scanner.close();
        System.out.println("\nProgram executed successfully.");
    }
}