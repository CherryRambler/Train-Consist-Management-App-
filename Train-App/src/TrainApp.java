class Bogie {
    private String type;
    private int capacity;

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
        return type + " (" + capacity + ")";
    }
}

import java.util.*;

public class TrainApp {

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("First Class", 40));

        int totalSeats = bogies.stream()
                .map(b -> b.getCapacity())     
                .reduce(0, Integer::sum);      

        System.out.println("Total Seating Capacity: " + totalSeats);
    }
}
.map(b -> b.getCapacity())
.reduce(0, Integer::sum)
