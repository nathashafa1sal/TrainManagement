import java.util.Scanner;

public class TrainApp {

    public static void main(String[] args) {

        // Step 1: Bogie IDs (unsorted array)
        String[] bogieIds = {
                "BG101",
                "BG205",
                "BG309",
                "BG412",
                "BG550"
        };

        // Display available bogies
        System.out.println("Bogie IDs in Train:");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }

        System.out.println();

        // Step 2: Input search key
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Bogie ID to search: ");
        String searchKey = scanner.nextLine();

        // Step 3: Linear Search
        boolean found = false;

        for (String id : bogieIds) {
            if (id.equals(searchKey)) {
                found = true;
                break; // Early termination
            }
        }

        // Step 4: Display result
        if (found) {
            System.out.println("Result: Bogie ID " + searchKey + " FOUND in train consist.");
        } else {
            System.out.println("Result: Bogie ID " + searchKey + " NOT FOUND.");
        }

        scanner.close();
    }
}