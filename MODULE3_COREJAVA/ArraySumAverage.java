import java.util.Scanner; // Import the Scanner class for user input

public class ArraySumAverage {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        System.out.println("Array Sum and Average Calculator");
        System.out.println("--------------------------------");

        int numberOfElements;

        // Loop to ensure valid positive integer for number of elements
        while (true) {
            System.out.print("Enter the number of elements for the array: ");
            if (scanner.hasNextInt()) {
                numberOfElements = scanner.nextInt();
                if (numberOfElements > 0) {
                    break; // Exit loop if input is a positive integer
                } else {
                    System.out.println("Error: Please enter a positive number of elements.");
                }
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // Consume the invalid input
            }
        }

        // Declare an array of the specified size
        int[] numbers = new int[numberOfElements];

        // Read elements into the array
        System.out.println("Enter " + numberOfElements + " integer elements:");
        for (int i = 0; i < numberOfElements; i++) {
            while (true) { // Loop for robust input for each element
                System.out.print("Enter element " + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    numbers[i] = scanner.nextInt();
                    break; // Exit inner loop if valid integer is entered
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // Consume the invalid input
                }
            }
        }

        // Calculate the sum of elements
        long sum = 0; // Use long to prevent potential overflow for large sums
        for (int i = 0; i < numberOfElements; i++) {
            sum += numbers[i]; // sum = sum + numbers[i];
        }

        // Calculate the average
        // Cast sum to double to ensure floating-point division
        double average = (double) sum / numberOfElements;

        // Display the results
        System.out.println("\n--- Results ---");
        System.out.println("Array elements: ");
        // Optional: print array elements for verification
        System.out.print("[");
        for (int i = 0; i < numberOfElements; i++) {
            System.out.print(numbers[i]);
            if (i < numberOfElements - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average of elements: " + String.format("%.2f", average)); // Format to 2 decimal places

        // Close the scanner
        scanner.close();
    }
}