import java.util.LinkedList;

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC4: Maintaining Physical Bogie Sequence ---");

        LinkedList<String> trainConsist = new LinkedList<>();

        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Coach");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Sequence: " + trainConsist);

        System.out.println("\n--- Operational Update: Attaching Pantry Car ---");
        trainConsist.add(2, "Pantry Car");
        System.out.println("Sequence after adding Pantry: " + trainConsist);

        System.out.println("\n--- Maintenance: Detaching Head and Tail ---");
        String removedFirst = trainConsist.removeFirst();
        String removedLast = trainConsist.removeLast();

        System.out.println("Detached: " + removedFirst + " (Front) and " + removedLast + " (Rear)");

        System.out.println("\n--- Final Train Formation ---");
        System.out.println("Final Consist: " + trainConsist);
        System.out.println("Total Bogies: " + trainConsist.size());

        System.out.println("\nUC4 Operations Completed. Sequence maintained via Chaining.");
    }
}