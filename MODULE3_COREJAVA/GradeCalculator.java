import java.util.Scanner; // Import the Scanner class to read user input

public class GradeCalculator {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Grade Calculator");
        System.out.println("------------------------");

        // Prompt the user to enter marks
        System.out.print("Enter marks (out of 100): ");
        int marks = scanner.nextInt(); // Read the integer marks from the user

        String grade; // Declare a String variable to store the assigned grade

        // Use if-else if-else statements to assign grades
        if (marks >= 90 && marks <= 100) {
            grade = "A";
        } else if (marks >= 80 && marks < 90) { // marks 80 to 89
            grade = "B";
        } else if (marks >= 70 && marks < 80) { // marks 70 to 79
            grade = "C";
        } else if (marks >= 60 && marks < 70) { // marks 60 to 69
            grade = "D";
        } else if (marks >= 0 && marks < 60) { // marks 0 to 59
            grade = "F";
        } else {
            // Handle invalid input (marks outside 0-100 range)
            grade = "Invalid Marks! Please enter marks between 0 and 100.";
        }

        // Display the assigned grade
        System.out.println("Assigned Grade: " + grade);

        // Close the scanner to release resources
        scanner.close();
    }
}