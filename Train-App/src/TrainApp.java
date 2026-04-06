import java.util.HashMap;
import java.util.Map;

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC6: Mapping Bogies to Capacity ---");


        Map<String, Integer> bogieCapacityMap = new HashMap<>();


        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 56);
        bogieCapacityMap.put("First Class", 24);
        bogieCapacityMap.put("Cargo", 1000);

        System.out.println("Bogie capacities successfully registered.\n");

        System.out.println("Quick Lookup: Capacity of 'Sleeper' is " + bogieCapacityMap.get("Sleeper") + " seats.");


        System.out.println("\n--- Train Capacity Registry Summary ---");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println("Bogie Type: " + entry.getKey() + " | Capacity: " + entry.getValue());
        }

        System.out.println("\nTotal Bogie Types Registered: " + bogieCapacityMap.size());
        System.out.println("UC6 Operations Completed. Attribute mapping successful.");
    }
}