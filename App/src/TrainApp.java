import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public String toString() {
        return type + " Bogie | Capacity: " + capacity;
    }
}

public class TrainApp {

    public static void main(String[] args) {

        // Step 1: Create large dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Sleeper", 50 + (i % 40))); // capacities between 50–89
        }

        // -------------------------------
        // Loop-Based Filtering
        // -------------------------------
        long loopStart = System.nanoTime();

        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopFiltered.add(b);
            }
        }

        long loopEnd = System.nanoTime();
        long loopTime = loopEnd - loopStart;

        // -------------------------------
        // Stream-Based Filtering
        // -------------------------------
        long streamStart = System.nanoTime();

        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        long streamEnd = System.nanoTime();
        long streamTime = streamEnd - streamStart;

        // -------------------------------
        // Results
        // -------------------------------
        System.out.println("Loop Filtered Count: " + loopFiltered.size());
        System.out.println("Stream Filtered Count: " + streamFiltered.size());

        System.out.println("\nExecution Time (nanoseconds):");
        System.out.println("Loop Time   : " + loopTime);
        System.out.println("Stream Time : " + streamTime);

        // Optional: verify correctness
        System.out.println("\nResults Match: " +
                (loopFiltered.size() == streamFiltered.size()));
    }
}