public class Bogie {
    String type;
    int capacity;

    public Bogie(String type, int capacity) {
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
        return "Bogie Type: " + type + ", Capacity: " + capacity;
    }
}
import java.util.*;
import java.util.stream.Collectors;

public class TrainApp{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Bogie> bogies = new ArrayList<>();

        System.out.println("Enter number of bogies:");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter bogie type:");
            String type = scanner.nextLine();

            System.out.println("Enter capacity:");
            int capacity = scanner.nextInt();
            scanner.nextLine();

            bogies.add(new Bogie(type, capacity));
        }

        System.out.println("Enter capacity threshold:");
        int threshold = scanner.nextInt();

        List<Bogie> filteredBogies = filterHighCapacityBogies(bogies, threshold);

        System.out.println("\nFiltered Bogies (Capacity > " + threshold + "):");

        if (filteredBogies.isEmpty()) {
            System.out.println("No bogies match the condition.");
        } else {
            filteredBogies.forEach(System.out::println);
        }

        scanner.close();
    }

    public static List<Bogie> filterHighCapacityBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }
}
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementTest {

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 50)
        );

        List<Bogie> result = TrainConsistManagement.filterHighCapacityBogies(bogies, 70);

        assertEquals(1, result.size());
        assertEquals(72, result.get(0).getCapacity());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("AC Chair", 70)
        );

        List<Bogie> result = TrainConsistManagement.filterHighCapacityBogies(bogies, 70);

        assertEquals(0, result.size());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("First Class", 50)
        );

        List<Bogie> result = TrainConsistManagement.filterHighCapacityBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 60)
        );

        List<Bogie> result = TrainConsistManagement.filterHighCapacityBogies(bogies, 60);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("First Class", 40),
                new Bogie("AC Chair", 50)
        );

        List<Bogie> result = TrainConsistManagement.filterHighCapacityBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 75),
                new Bogie("Sleeper", 80)
        );

        List<Bogie> result = TrainConsistManagement.filterHighCapacityBogies(bogies, 60);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = TrainConsistManagement.filterHighCapacityBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));

        int originalSize = bogies.size();

        TrainConsistManagement.filterHighCapacityBogies(bogies, 60);

        assertEquals(originalSize, bogies.size());
    }
}
