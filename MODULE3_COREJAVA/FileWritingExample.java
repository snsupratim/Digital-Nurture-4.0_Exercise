import java.io.FileWriter; // For writing characters to a file
import java.io.IOException; // For handling input/output exceptions
import java.util.Scanner;  // For reading user input

public class FileWritingExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "output.txt"; // The name of the file to write to

        System.out.println("File Writing Example");
        System.out.println("--------------------");

        // 1. Prompt the user for a string
        System.out.print("Enter the text you want to write to '" + fileName + "':\n> ");
        String userInput = scanner.nextLine(); // Read the entire line of input

        // 2. Use try-with-resources for automatic closing of FileWriter
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            // 3. Write the string to the file
            fileWriter.write(userInput);
            // Optionally, write a new line character if you want subsequent writes to start on a new line
            // fileWriter.write("\n"); 

            // 4. Confirm that the data has been written
            System.out.println("\nSuccess: The text has been written to '" + fileName + "'");
            System.out.println("File path: " + new java.io.File(fileName).getAbsolutePath()); // Show full path

        } catch (IOException e) {
            // 5. Catch any IOException and display an appropriate message
            System.err.println("\nError: An I/O error occurred while writing to the file.");
            System.err.println("Details: " + e.getMessage());
            // e.printStackTrace(); // Uncomment for detailed stack trace for debugging
        } finally {
            // The scanner should be closed here regardless of whether an exception occurred
            scanner.close();
            System.out.println("Program finished.");
        }
    }
}