import java.util.Scanner; // Import the Scanner class for user input

public class RecursiveFibonacci {

    /**
     * Recursive method to calculate the nth Fibonacci number.
     *
     * @param n The position in the Fibonacci sequence (non-negative integer).
     * @return The nth Fibonacci number.
     */
    public static long fibonacci(int n) {
        // Base cases
        if (n == 0) {
            return 0; // The 0th Fibonacci number is 0
        } else if (n == 1) {
            return 1; // The 1st Fibonacci number is 1
        }
        // Recursive step: Fn = F(n-1) + F(n-2)
        else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        System.out.println("Recursive Fibonacci Number Calculator");
        System.out.println("-------------------------------------");

        int n; // Variable to store the user's input for 'n'

        // Loop to ensure valid positive integer input
        while (true) {
            System.out.print("Enter a non-negative integer (n) to find the nth Fibonacci number: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n >= 0) {
                    break; // Exit loop if input is a non-negative integer
                } else {
                    System.out.println("Error: Please enter a non-negative integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // Consume the invalid input to prevent an infinite loop
            }
        }

        // Calculate the Fibonacci number using the recursive method
        // Using 'long' for result as Fibonacci numbers grow very quickly
        long result = fibonacci(n);

        // Display the result
        System.out.println("The " + n + "th Fibonacci number is: " + result);

        // Close the scanner
        scanner.close();
    }
}