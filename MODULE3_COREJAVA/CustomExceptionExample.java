import java.util.InputMismatchException; // For handling non-integer input
import java.util.Scanner;             // For reading user input

// 1. Define the Custom Exception Class
// It's good practice to make custom exceptions checked exceptions
// by extending the 'Exception' class. This forces the calling code
// (like the main method here) to handle it.
class InvalidAgeException extends Exception {
    // Constructor that accepts a message
    public InvalidAgeException(String message) {
        super(message); // Call the constructor of the parent Exception class
    }
}

public class CustomExceptionExample {

    /**
     * Method to check age and throw InvalidAgeException if age is less than 18.
     * @param age The age to be checked.
     * @throws InvalidAgeException if age is less than 18.
     */
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // 2. Throw the custom exception
            throw new InvalidAgeException("Age cannot be less than 18. You must be at least 18 years old.");
        } else {
            System.out.println("Age " + age + " is valid. Welcome!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = 0;
        boolean validInput = false;

        System.out.println("Age Validation with Custom Exception");
        System.out.println("------------------------------------");

        // Input validation for age
        while (!validInput) {
            System.out.print("Please enter your age: ");
            try {
                age = scanner.nextInt();
                validInput = true; // Input is an integer
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number for age.");
                scanner.next(); // Consume the invalid input
            }
        }

        // 3. Call the method that might throw the custom exception within a try-catch block
        try {
            checkAge(age); // This method might throw InvalidAgeException
        } catch (InvalidAgeException e) {
            // 4. Catch the custom exception and display an appropriate message
            System.out.println("\n--- Age Validation Error! ---");
            System.out.println("Caught Custom Exception: " + e.getMessage());
            System.out.println("Application requires users to be 18 or older.");
        } catch (Exception e) {
            // Generic catch for any other unexpected exceptions (e.g., if there were others)
            System.out.println("\n--- An unexpected error occurred! ---");
            System.out.println("Error details: " + e.getMessage());
        } finally {
            scanner.close(); // Ensure scanner is closed
            System.out.println("\nAge validation process completed.");
        }
    }
}