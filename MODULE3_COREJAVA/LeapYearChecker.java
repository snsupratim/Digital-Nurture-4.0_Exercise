import java.util.Scanner; // Import the Scanner class to read user input

public class LeapYearChecker {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        System.out.println("Leap Year Checker");
        System.out.println("-----------------");

        // Prompt the user to enter a year
        System.out.print("Enter a year: ");
        int year = scanner.nextInt(); // Read the integer year from the user

        boolean isLeapYear; // Declare a boolean variable to store the result

        // Apply the leap year rules:
        // A year is a leap year if:
        // 1. It is divisible by 4 (year % 4 == 0)
        // AND
        // 2. (It is NOT divisible by 100 (year % 100 != 0)
        //    OR
        //    It IS divisible by 400 (year % 400 == 0))

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            isLeapYear = true;
        } else {
            isLeapYear = false;
        }

        // Display the result
        if (isLeapYear) {
            System.out.println(year + " is a LEAP YEAR.");
        } else {
            System.out.println(year + " is NOT a leap year.");
        }

        // Close the scanner to release resources
        scanner.close();
    }
}