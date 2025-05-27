import java.util.HashMap;       // Import the HashMap class
import java.util.InputMismatchException; // For handling non-integer input
import java.util.Map;           // Import Map interface (good practice for type declaration)
import java.util.Scanner;       // Import the Scanner class for user input

public class HashMapExample {

    public static void main(String[] args) {
        // Create a HashMap with Integer keys (for student IDs) and String values (for student names)
        Map<Integer, String> studentRecords = new HashMap<>();

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Record Manager (HashMap Demonstration)");
        System.out.println("----------------------------------------------");

        // --- Part 1: Allow the user to add entries ---
        System.out.println("Part 1: Adding Student Records");
        System.out.println("Enter student ID and Name. Enter ID '0' to stop adding records.");

        int studentId;
        String studentName;
        boolean addingRecords = true;

        while (addingRecords) {
            System.out.print("\nEnter Student ID (integer, 0 to finish): ");
            // Input validation for ID
            if (scanner.hasNextInt()) {
                studentId = scanner.nextInt();
                scanner.nextLine(); // Consume the remaining newline character

                if (studentId == 0) {
                    addingRecords = false; // Set flag to exit loop
                    continue; // Skip to the next iteration (which will then exit)
                }

                System.out.print("Enter Student Name: ");
                studentName = scanner.nextLine();

                // Add the entry to the HashMap
                studentRecords.put(studentId, studentName);
                System.out.println("Record added: ID " + studentId + " -> Name: " + studentName);

            } else {
                System.out.println("Invalid input. Please enter an integer for Student ID.");
                scanner.next(); // Consume the invalid input
                scanner.nextLine(); // Consume the rest of the line
            }
        }

        System.out.println("\n--- All Records Entered ---");
        if (studentRecords.isEmpty()) {
            System.out.println("No student records were added.");
        } else {
            System.out.println("Current student records:");
            // Iterate and display all entries in the HashMap
            for (Map.Entry<Integer, String> entry : studentRecords.entrySet()) {
                System.out.println("  ID: " + entry.getKey() + ", Name: " + entry.getValue());
            }
        }


        // --- Part 2: Retrieve and display a name based on an entered ID ---
        System.out.println("\nPart 2: Retrieving Student Names by ID");
        System.out.println("Enter '0' for ID to exit retrieval mode.");

        int searchId;
        boolean retrievingNames = true;

        while (retrievingNames) {
            System.out.print("\nEnter ID to search for (integer, 0 to exit): ");
            if (scanner.hasNextInt()) {
                searchId = scanner.nextInt();
                scanner.nextLine(); // Consume the remaining newline character

                if (searchId == 0) {
                    retrievingNames = false; // Set flag to exit loop
                    continue; // Skip to the next iteration (which will then exit)
                }

                // Retrieve the name using the get() method
                String retrievedName = studentRecords.get(searchId);

                // Display the result
                if (retrievedName != null) {
                    System.out.println("Found! Student Name for ID " + searchId + ": " + retrievedName);
                } else {
                    System.out.println("Student with ID " + searchId + " not found in records.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer for the ID.");
                scanner.next(); // Consume the invalid input
                scanner.nextLine(); // Consume the rest of the line
            }
        }

        // Close the scanner
        scanner.close();
        System.out.println("\nProgram finished.");
    }
}