import java.util.*;

class GoodsBogie {
    private String type;   // Cylindrical, Open, Box
    private String cargo;  // Petroleum, Coal, Grain, etc.

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return type + " Bogie | Cargo: " + cargo;
    }
}

public class TrainApp {

    public static void main(String[] args) {

        // Step 1: Create goods bogies
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        // Uncomment below to test failure case
        // bogies.add(new GoodsBogie("Cylindrical", "Coal"));

        // Step 2: Display bogies
        System.out.println("Goods Bogie List:");
        bogies.forEach(System.out::println);

        // Step 3: Safety validation using allMatch()
        boolean isSafe = bogies.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical") ||
                                b.getCargo().equalsIgnoreCase("Petroleum")
                );

        // Step 4: Display result
        System.out.println("\nSafety Compliance Status:");
        if (isSafe) {
            System.out.println("Train is SAFE for operation");
        } else {
            System.out.println("Train is UNSAFE! Invalid cargo detected");
        }
    }
}