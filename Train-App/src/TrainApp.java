import java.util.LinkedHashSet;
import java.util.Set;

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC5: Preserving Order with Unique Bogies ---");


        Set<String> trainFormation = new LinkedHashSet<>();

        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        System.out.println("Initial Formation attached: " + trainFormation);

        System.out.println("\n--- Safety Check: Attempting to attach duplicate 'Sleeper' ---");
        boolean isAdded = trainFormation.add("Sleeper");

        if (!isAdded) {
            System.out.println("System Alert: Duplicate bogie 'Sleeper' rejected! Integrity maintained.");
        }

        System.out.println("\n--- Final Verified Train Formation ---");
        System.out.println("Consist Sequence: " + trainFormation);

        System.out.println("Final Bogie Count: " + trainFormation.size());

        System.out.println("\nUC5 Operations Completed. Order preserved and Duplicates eliminated.");
    }
}