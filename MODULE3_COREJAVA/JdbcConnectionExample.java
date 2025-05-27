import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectionExample {

    // JDBC URL for SQLite database. Assumes javatest.db is in the project directory.
    // If it's elsewhere, provide the full path: "jdbc:sqlite:/path/to/javatest.db"
    private static final String JDBC_URL = "jdbc:sqlite:javatest.db";

    public static void main(String[] args) {
        System.out.println("Basic JDBC Connection and Data Retrieval Example (SQLite)");
        System.out.println("-------------------------------------------------------\n");

        // The try-with-resources statement ensures that Connection, Statement, and ResultSet
        // objects are automatically closed when the try block exits, preventing resource leaks.
        try (Connection connection = DriverManager.getConnection(JDBC_URL); // 1. Create a connection
             Statement statement = connection.createStatement();             // 2. Create a statement object
             ResultSet resultSet = statement.executeQuery("SELECT id, name, age, grade FROM students")) { // 3. Execute query

            System.out.println("--- Student Records ---");
            System.out.println("ID\tName\t\tAge\tGrade");
            System.out.println("---------------------------------------");

            // 4. Process the ResultSet and print results
            while (resultSet.next()) { // Iterate through each row in the result set
                int id = resultSet.getInt("id");             // Get data by column name
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String grade = resultSet.getString("grade");

                // Print the retrieved data
                System.out.printf("%d\t%-15s\t%d\t%s%n", id, name, age, grade);
            }
            System.out.println("---------------------------------------");
            System.out.println("\nSuccessfully retrieved data from the database.");

        } catch (SQLException e) {
            // 5. Handle any SQL exceptions (e.g., connection issues, query errors)
            System.err.println("Database error occurred!");
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            // e.printStackTrace(); // Uncomment for full stack trace during debugging
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.println("JDBC connection example finished.");
        }
    }
}