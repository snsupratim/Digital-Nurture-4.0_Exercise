import java.util.Scanner;

public class StringReversalLoop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("String Reversal (using loop)");
        System.out.println("----------------------------");

        System.out.print("Enter a string: ");
        String originalString = scanner.nextLine(); // Read the entire line

        String reversedString = ""; // Initialize an empty string to store the reversed result

        // Iterate from the last character to the first
        for (int i = originalString.length() - 1; i >= 0; i--) {
            reversedString = reversedString + originalString.charAt(i); // Append each character
        }

        System.out.println("Original string: " + originalString);
        System.out.println("Reversed string: " + reversedString);

        scanner.close();
    }
}