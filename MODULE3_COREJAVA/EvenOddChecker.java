

import java.util.Scanner; // Import the Scanner class

public class EvenOddChecker {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        System.out.println("Even or Odd Checker");
        System.out.println("-------------------");

        // Prompt the user to enter an integer
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt(); // Read the integer from the user

        // Use the modulus operator to check for even or odd
        // A number is even if it is perfectly divisible by 2 (remainder is 0)
        // Otherwise, it is odd
        if (number % 2 == 0) {
            System.out.println(number + " is an EVEN number.");
        } else {
            System.out.println(number + " is an ODD number.");
        }

        // Close the scanner to release resources
        scanner.close();
    }
}