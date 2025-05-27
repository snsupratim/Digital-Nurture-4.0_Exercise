import java.util.ArrayList; // Import the ArrayList class
import java.util.Scanner;   // Import the Scanner class for user input

public class ArrayListExample {

    public static void main(String[] args) {
        // Create an ArrayList to store student names (Strings)
        ArrayList<String> studentNames = new ArrayList<>();

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Name Manager (ArrayList Demonstration)");
        System.out.println("----------------------------------------------");
        System.out.println("Enter student names. Type 'done' (case-insensitive) and press Enter to finish.");

        String nameInput; // Variable to store user's input for name

        // Loop to allow the user to add names
        while (true) {
            System.out.print("Enter student name (or 'done' to finish): ");
            nameInput = scanner.nextLine(); // Read the entire line of input

            // Check if the user wants to stop
            if (nameInput.equalsIgnoreCase("done")) { //equalsIgnoreCase ignores case for comparison
                break; // Exit the loop
            }

            // Check if the input is not empty before adding
            if (!nameInput.trim().isEmpty()) { // trim() removes leading/trailing whitespace
                studentNames.add(nameInput.trim()); // Add the cleaned name to the ArrayList
                System.out.println("'" + nameInput.trim() + "' added to the list.");
            } else {
                System.out.println("Name cannot be empty. Please enter a valid name or 'done'.");
            }
        }

        // Display all names entered
        System.out.println("\n--- List of Student Names ---");
        if (studentNames.isEmpty()) {
            System.out.println("No names were entered.");
        } else {
            // Option 1: Using a basic for loop
            System.out.println("Names (using for loop):");
            for (int i = 0; i < studentNames.size(); i++) {
                System.out.println((i + 1) + ". " + studentNames.get(i));
            }

            // Option 2: Using an enhanced for-each loop (more concise for iteration)
            System.out.println("\nNames (using for-each loop):");
            int counter = 1;
            for (String name : studentNames) {
                System.out.println(counter++ + ". " + name);
            }
        }
        System.out.println("-----------------------------");

        // Close the scanner
        scanner.close();
        System.out.println("Program finished.");
    }
}