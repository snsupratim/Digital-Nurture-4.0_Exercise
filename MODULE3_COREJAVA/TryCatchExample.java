import java.util.InputMismatchException; // For handling non-integer input
import java.util.Scanner;             // For reading user input

public class TryCatchExample {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        System.out.println("Division Calculator with Exception Handling");
        System.out.println("-----------------------------------------");

        int numerator = 0;
        int denominator = 0;
        boolean validInput;

        // Get numerator with input validation
        validInput = false;
        while (!validInput) {
            System.out.print("Enter the numerator (an integer): ");
            try {
                numerator = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for the numerator.");
                scanner.next(); // Consume the invalid input to prevent an infinite loop
            }
        }

        // Get denominator with input validation
        validInput = false;
        while (!validInput) {
            System.out.print("Enter the denominator (an integer): ");
            try {
                denominator = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for the denominator.");
                scanner.next(); // Consume the invalid input to prevent an infinite loop
            }
        }

        // --- Core logic: Attempt division within a try-catch block ---
        try {
            // Attempt to perform the division
            int result = numerator / denominator;
            System.out.println("Result of division: " + numerator + " / " + denominator + " = " + result);
        } catch (ArithmeticException e) {
            // Catch block: This code executes if an ArithmeticException occurs
            System.out.println("\n--- An error occurred! ---");
            System.out.println("Error: " + e.getMessage()); // e.getMessage() gives a brief description (e.g., "/ by zero")
            System.out.println("You attempted to divide by zero, which is not allowed.");
            System.out.println("Please run the program again and provide a non-zero denominator.");
        } catch (Exception e) {
            // Generic catch block for any other unexpected exceptions
            System.out.println("\n--- An unexpected error occurred! ---");
            System.out.println("Error details: " + e.getMessage());
            System.out.println("Please contact support with the error details.");
        } finally {
            // The finally block always executes, regardless of whether an exception occurred or not.
            // It's often used for cleanup tasks, like closing resources.
            System.out.println("\nDivision attempt finished.");
            scanner.close(); // Close the scanner here to ensure it's always closed
        }

        // Code here continues execution after the try-catch-finally block,
        // unless an unhandled exception occurred or the program exited within the blocks.
        System.out.println("Program finished.");
    }
}