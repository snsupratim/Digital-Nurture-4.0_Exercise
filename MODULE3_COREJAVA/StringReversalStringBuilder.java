import java.util.Scanner;

public class StringReversalStringBuilder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("String Reversal (using StringBuilder)");
        System.out.println("-------------------------------------");

        System.out.print("Enter a string: ");
        String originalString = scanner.nextLine(); // Read the entire line

        // Create a StringBuilder object with the original string
        StringBuilder stringBuilder = new StringBuilder(originalString);

        // Use the reverse() method of StringBuilder
        stringBuilder.reverse();

        // Convert the StringBuilder back to a String
        String reversedString = stringBuilder.toString();

        System.out.println("Original string: " + originalString);
        System.out.println("Reversed string: " + reversedString);

        scanner.close();
    }
}