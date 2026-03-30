import java.util.ArrayList;
import java.util.List;

public class TrainApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create ArrayList for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display bogies after insertion
        System.out.println("Passenger Bogies after adding:");
        System.out.println(passengerBogies);

        // Remove a bogie (AC Chair)
        passengerBogies.remove("AC Chair");

        System.out.println("After removing AC Chair:");
        System.out.println(passengerBogies);

        // Check existence of Sleeper
        if (passengerBogies.contains("Sleeper")) {
            System.out.println("Sleeper bogie is present in the train.");
        } else {
            System.out.println("Sleeper bogie is NOT present in the train.");
        }

        // Final state
        System.out.println("Final Passenger Bogie List:");
        System.out.println(passengerBogies);
    }
}