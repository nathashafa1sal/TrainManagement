import java.util.LinkedList;

public class TrainApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create LinkedList for train consist
        LinkedList<String> train = new LinkedList<>();

        // Add bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(train);

        // Insert Pantry Car at position 2 (index starts from 0)
        train.add(2, "Pantry");

        System.out.println("After adding Pantry at position 2:");
        System.out.println(train);

        // Remove first and last bogie
        train.removeFirst();
        train.removeLast();

        System.out.println("After removing first and last bogie:");
        System.out.println(train);

        // Final consist
        System.out.println("Final Train Consist:");
        System.out.println(train);
    }
}