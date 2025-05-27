import java.io.BufferedReader; // For efficient reading of text from a character-input stream
import java.io.FileReader;    // For reading character files
import java.io.IOException;   // For handling input/output exceptions
import java.io.FileNotFoundException; // Specific exception for file not found

public class FileReadingExample {

    public static void main(String[] args) {
        String fileName = "output.txt"; // The name of the file to read from

        System.out.println("File Reading Example");
        System.out.println("--------------------");
        System.out.println("Attempting to read from: '" + fileName + "'");
        System.out.println("----------------------------------------");

        // Use try-with-resources for automatic closing of FileReader and BufferedReader
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line; // Variable to hold each line read from the file

            // Read each line from the file until the end of the file (readLine() returns null)
            while ((line = bufferedReader.readLine()) != null) {
                // Display each line on the console
                System.out.println(line);
            }

            System.out.println("\n----------------------------------------");
            System.out.println("Success: Finished reading from '" + fileName + "'.");

        } catch (FileNotFoundException e) {
            // Catch block for when the specified file does not exist
            System.err.println("\nError: The file '" + fileName + "' was not found.");
            System.err.println("Please make sure the file exists in the correct directory.");
            System.err.println("Details: " + e.getMessage());
        } catch (IOException e) {
            // Catch block for other I/O errors that might occur during reading
            System.err.println("\nError: An I/O error occurred while reading from the file.");
            System.err.println("Details: " + e.getMessage());
            // e.printStackTrace(); // Uncomment for detailed stack trace for debugging
        } finally {
            // This block will execute regardless of whether an exception occurred.
            // Resources are automatically closed by try-with-resources, so
            // this 'finally' block is more for final messages or non-resource cleanup.
            System.out.println("Program finished.");
        }
    }
}