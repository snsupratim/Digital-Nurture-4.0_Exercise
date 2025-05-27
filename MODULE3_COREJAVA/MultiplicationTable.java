import java.util.Scanner; // Import the Scanner class to read user input

public class MultiplicationTable {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        System.out.println("Multiplication Table Generator");
        System.out.println("------------------------------");

        // Prompt the user to enter a number
        System.out.print("Enter a number to generate its multiplication table: ");
        int number = scanner.nextInt(); // Read the integer from the user

        System.out.println("\nMultiplication Table for " + number + ":");
        System.out.println("----------------------------------");

        // Use a for loop to iterate from 1 to 10
        for (int i = 1; i <= 10; i++) {
            // Calculate the product
            int product = number * i;

            // Display the result in the format: number x i = product
            System.out.println(number + " x " + i + " = " + product);
        }

        // Close the scanner to release resources
        scanner.close();
    }
}