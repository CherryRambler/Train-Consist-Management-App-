import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return String.format("%-15s | Capacity: %d seats", name, capacity);
    }
}

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC7: Sorting Bogies by Capacity ---");

        List<Bogie> passengerBogies = new ArrayList<>();

        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("General", 90));

        System.out.println("\nOriginal Consist (Unsorted):");
        passengerBogies.forEach(System.out::println);


        passengerBogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nSorted Consist (By Capacity - Ascending):");
        System.out.println("-------------------------------------------");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        passengerBogies.sort(Comparator.comparingInt((Bogie b) -> b.capacity).reversed());
        System.out.println("\nPlanning View (High Capacity First):");
        passengerBogies.forEach(System.out::println);

        System.out.println("\nUC7 Operations Completed. Business logic applied to sorting.");
    }
}