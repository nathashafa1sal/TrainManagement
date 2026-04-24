import java.util.*;

// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// Goods Bogie Class
class GoodsBogie {
    private String type;   // Cylindrical, Rectangular
    private String cargo;

    public GoodsBogie(String type) {
        this.type = type;
    }

    public void assignCargo(String cargo) {
        try {
            // Safety Rule:
            // Rectangular bogie should NOT carry Petroleum
            if (type.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe assignment: Rectangular bogie cannot carry Petroleum"
                );
            }

            // If safe, assign cargo
            this.cargo = cargo;
            System.out.println(type + " bogie assigned with cargo: " + cargo);

        } catch (CargoSafetyException e) {
            // Handle unsafe condition
            System.out.println("Error: " + e.getMessage());

        } finally {
            // Always executes
            System.out.println("Cargo assignment attempt completed for " + type + " bogie\n");
        }
    }

    @Override
    public String toString() {
        return type + " Bogie | Cargo: " + (cargo == null ? "Not Assigned" : cargo);
    }
}

// Main Application
public class TrainApp {

    public static void main(String[] args) {

        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Cylindrical"));
        bogies.add(new GoodsBogie("Rectangular"));
        bogies.add(new GoodsBogie("Rectangular"));

        // Safe assignment
        bogies.get(0).assignCargo("Petroleum");

        // Unsafe assignment (handled safely)
        bogies.get(1).assignCargo("Petroleum");

        // Another safe assignment
        bogies.get(2).assignCargo("Coal");

        // Program continues
        System.out.println("Final Bogie Status:");
        for (GoodsBogie b : bogies) {
            System.out.println(b);
        }
    }
}