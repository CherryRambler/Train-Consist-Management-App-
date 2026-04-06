import java.util.ArrayList;
import java.util.List;

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<String> passengerBogies = new ArrayList<>();
        System.out.println("Initial Bogie Count: " + passengerBogies.size());

        System.out.println("\n--- Adding Passenger Bogies ---");

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("Current Consist: " + passengerBogies);

        System.out.println("\n--- Removing AC Chair ---");
        passengerBogies.remove("AC Chair");
        System.out.println("Consist after removal: " + passengerBogies);

        System.out.print("\nChecking for Sleeper bogie... ");
        if (passengerBogies.contains("Sleeper")) {
            System.out.println("Result: Sleeper is present in the consist.");
        } else {
            System.out.println("Result: Sleeper not found.");
        }

        System.out.println("\nFinal Consist State: " + passengerBogies);
        System.out.println("Final Bogie Count: " + passengerBogies.size());

        System.out.println("\nUC2 Operations Completed successfully.");
    }
}