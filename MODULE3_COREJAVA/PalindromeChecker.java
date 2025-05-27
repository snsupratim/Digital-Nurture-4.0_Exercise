import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Palindrome Checker");
        System.out.println("------------------");

        System.out.print("Enter a string: ");
        String originalString = scanner.nextLine(); // Read the entire line

        // 1. Pre-process the string: remove non-alphanumeric characters and convert to lowercase
        String cleanedString = originalString.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // 2. Reverse the cleaned string using StringBuilder
        StringBuilder stringBuilder = new StringBuilder(cleanedString);
        String reversedString = stringBuilder.reverse().toString();

        // 3. Check if the string reads the same forwards and backwards
        boolean isPalindrome = cleanedString.equals(reversedString);

        // 4. Display the result
        System.out.println("\nOriginal String: \"" + originalString + "\"");
        System.out.println("Cleaned String (for comparison): \"" + cleanedString + "\"");
        System.out.println("Reversed Cleaned String: \"" + reversedString + "\"");

        if (isPalindrome) {
            System.out.println("Result: The string is a PALINDROME.");
        } else {
            System.out.println("Result: The string is NOT a palindrome.");
        }

        scanner.close();
    }
}