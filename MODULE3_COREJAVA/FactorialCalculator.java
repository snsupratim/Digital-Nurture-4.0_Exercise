import java.util.Scanner; // Import the Scanner class to read user input

public class FactorialCalculator {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        System.out.println("Factorial Calculator");
        System.out.println("--------------------");

        int number; // Declare a variable to store the user's input

        // Loop to ensure valid non-negative integer input
        while (true) {
            System.out.print("Enter a non-negative integer: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number >= 0) {
                    break; // Exit loop if input is a non-negative integer
                } else {
                    System.out.println("Error: Please enter a non-negative integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // Consume the invalid input to prevent infinite loop
            }
        }

        long factorial = 1; // Use long to handle larger factorial results, as int can overflow quickly

        // Calculate factorial based on input number
        if (number == 0) {
            factorial = 1; // Factorial of 0 is 1
        } else {
            // Use a for loop to calculate the factorial
            for (int i = 1; i <= number; i++) {
                factorial *= i; // Same as factorial = factorial * i;
            }
        }

        // Display the result
        System.out.println("The factorial of " + number + " is: " + factorial);

        // Close the scanner to release resources
        scanner.close();
    }
}