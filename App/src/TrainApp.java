import java.util.*;
import java.util.stream.Collectors;

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
        return type + " Bogie | Capacity: " + capacity;
    }
}

public class TrainApp {

    public static void main(String[] args) {

        // Step 1: Reuse bogie list (from UC7/UC8)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 50));
        bogies.add(new Bogie("Sleeper", 80));
        bogies.add(new Bogie("AC Chair", 65));

        // Step 2: Display original list
        System.out.println("Original Bogie List:");
        bogies.forEach(System.out::println);

        // Step 3: Convert to stream and group by type
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.getType()));

        // Step 4: Display grouped result
        System.out.println("\nGrouped Bogies (By Type):");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nType: " + entry.getKey());
            entry.getValue().forEach(System.out::println);
        }

        // Step 5: Verify original list unchanged
        System.out.println("\nOriginal List After Grouping:");
        bogies.forEach(System.out::println);
    }
}