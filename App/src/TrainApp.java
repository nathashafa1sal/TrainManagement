import java.util.*;

// Custom Exception
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Passenger Bogie Class
class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
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

// Main Application
public class TrainApp {

    public static void main(String[] args) {

        List<PassengerBogie> bogies = new ArrayList<>();

        // Creating bogies safely
        try {
            bogies.add(new PassengerBogie("Sleeper", 72));
            bogies.add(new PassengerBogie("AC Chair", 60));
            bogies.add(new PassengerBogie("First Class", 50));

            // Invalid cases
            bogies.add(new PassengerBogie("Sleeper", 0));   // will throw exception
            bogies.add(new PassengerBogie("AC Chair", -10)); // will throw exception

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Display valid bogies
        System.out.println("\nValid Bogies in Train:");
        for (PassengerBogie b : bogies) {
            System.out.println(b);
        }
    }
}