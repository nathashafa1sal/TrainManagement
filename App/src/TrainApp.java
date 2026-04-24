import java.util.*;

class Bogie {
    private String type;
    private int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + " Bogie | Capacity: " + capacity;
    }
}

public class TrainApp {

    public static void main(String[] args) {

        // Step 1: Reuse bogie list
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 50));
        bogies.add(new Bogie("Sleeper", 80));
        bogies.add(new Bogie("AC Chair", 65));

        // Step 2: Display original list
        System.out.println("Original Bogie List:");
        bogies.forEach(System.out::println);

        // Step 3: Stream → map → reduce
        int totalSeats = bogies.stream()
                .map(b -> b.getCapacity())     // Extract capacity
                .reduce(0, Integer::sum);      // Aggregate sum

        // Step 4: Display total seating capacity
        System.out.println("\nTotal Seating Capacity: " + totalSeats);

        // Step 5: Verify original list unchanged
        System.out.println("\nOriginal List After Aggregation:");
        bogies.forEach(System.out::println);
    }
}