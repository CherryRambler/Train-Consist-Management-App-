import java.util.HashSet;
import java.util.Set;

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC3: Tracking Unique Bogie IDs ---");

        Set<String> bogieIds = new HashSet<>();

        System.out.println("Registering Bogies: BG101, BG102, BG101, BG103...");

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG101");
        bogieIds.add("BG103");
        bogieIds.add("BG102");

        System.out.println("\n--- Registration Summary ---");

        System.out.println("Unique Bogie IDs in System: " + bogieIds);
        System.out.println("Total Unique Count: " + bogieIds.size());

        if (bogieIds.size() < 5) {
            System.out.println("System Note: Duplicate IDs were detected and automatically rejected.");
        }

        System.out.println("\nUC3 Operations Completed. Integrity maintained.");
    }
}