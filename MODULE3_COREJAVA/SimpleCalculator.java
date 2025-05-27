import java.util.Scanner; // Import the Scanner class to read user input

public class SimpleCalculator {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        System.out.println("Simple Calculator");
        System.out.println("-----------------");

        // Prompt user for the first number
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble(); // Read the first number (allowing decimal values)

        // Prompt user for the second number
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble(); // Read the second number

        // Prompt user to choose an operation
        System.out.println("\nChoose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.print("Enter your choice (1/2/3/4): ");
        int choice = scanner.nextInt(); // Read the user's choice

        double result = 0; // Initialize result variable
        boolean isValidOperation = true; // Flag to check if the operation is valid

        // Perform the chosen operation using a switch statement
        switch (choice) {
            case 1:
                result = num1 + num2;
                System.out.println("Result: " + num1 + " + " + num2 + " = " + result);
                break;
            case 2:
                result = num1 - num2;
                System.out.println("Result: " + num1 + " - " + num2 + " = " + result);
                break;
            case 3:
                result = num1 * num2;
                System.out.println("Result: " + num1 + " * " + num2 + " = " + result);
                break;
            case 4:
                // Handle division by zero
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    isValidOperation = false; // Set flag to false for invalid operation
                }
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                isValidOperation = false; // Set flag to false for invalid operation
                break;
        }

        // Close the scanner to release resources
        scanner.close();
    }
}