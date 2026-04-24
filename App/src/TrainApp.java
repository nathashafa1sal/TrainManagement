public class TrainApp {

    public static void main(String[] args) {

        // Step 1: Passenger bogie capacities (unsorted)
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Original Capacities:");
        printArray(capacities);

        // Step 2: Bubble Sort Logic
        int n = capacities.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                // Compare adjacent elements
                if (capacities[j] > capacities[j + 1]) {

                    // Swap logic
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;

                    swapped = true;
                }
            }

            // Optimization: stop if already sorted
            if (!swapped) {
                break;
            }
        }

        // Step 3: Display sorted result
        System.out.println("\nSorted Capacities (Ascending Order):");
        printArray(capacities);
    }

    // Utility method to print array
    private static void printArray(int[] arr) {
        for (int cap : arr) {
            System.out.print(cap + " ");
        }
        System.out.println();
    }
}