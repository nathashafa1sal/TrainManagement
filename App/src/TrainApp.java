import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainApp {

    // Regex patterns
    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Step 1: User input
        System.out.print("Enter Train ID: ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode = scanner.nextLine();

        // Step 2: Compile patterns
        Pattern trainPattern = Pattern.compile(TRAIN_ID_REGEX);
        Pattern cargoPattern = Pattern.compile(CARGO_CODE_REGEX);

        // Step 3: Create matchers
        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        // Step 4: Validate using matches()
        boolean isTrainValid = trainMatcher.matches();
        boolean isCargoValid = cargoMatcher.matches();

        // Step 5: Display results
        System.out.println("\nValidation Results:");

        if (isTrainValid) {
            System.out.println("Train ID is VALID");
        } else {
            System.out.println("Train ID is INVALID (Expected format: TRN-1234)");
        }

        if (isCargoValid) {
            System.out.println("Cargo Code is VALID");
        } else {
            System.out.println("Cargo Code is INVALID (Expected format: PET-AB)");
        }

        scanner.close();
    }
}