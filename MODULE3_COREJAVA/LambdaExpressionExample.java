import java.util.ArrayList;   // For creating a dynamic list
import java.util.Collections; // For the sort() method
import java.util.List;        // For the List interface

public class LambdaExpressionExample {

    public static void main(String[] args) {
        System.out.println("Java Lambda Expressions Demonstration (List Sorting)");
        System.out.println("--------------------------------------------------");

        // 1. Create a List of strings
        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Cherry");
        fruits.add("Date");
        fruits.add("Grape");

        System.out.println("Original List of Fruits:");
        System.out.println(fruits);
        System.out.println();

        // 2. Use Collections.sort() with a lambda expression to sort the list
        // The Collections.sort() method that takes a List and a Comparator.
        // The Comparator is a functional interface (single abstract method: compare(T o1, T o2)).
        // We provide a lambda expression that implements this compare method.
        Collections.sort(fruits, (s1, s2) -> {
            // This lambda implements the compare method of Comparator
            // For alphabetical sorting, we can use String's compareTo method.
            return s1.compareTo(s2);
        });

        System.out.println("Sorted List of Fruits (Alphabetical - default):");
        System.out.println(fruits);
        System.out.println();

        // Example: Sorting in reverse alphabetical order using a lambda
        System.out.println("Sorting in Reverse Alphabetical Order:");
        Collections.sort(fruits, (String fruit1, String fruit2) -> fruit2.compareTo(fruit1));
        // You can often omit explicit type declarations (String fruit1, String fruit2)
        // and the 'return' keyword with single-line body lambdas.

        System.out.println("Reverse Sorted List of Fruits:");
        System.out.println(fruits);
        System.out.println();

        // Example: Sorting by length using a lambda
        System.out.println("Sorting by Length of String:");
        Collections.sort(fruits, (f1, f2) -> f1.length() - f2.length());
        // If lengths are equal, their relative order might not be stable
        // For stable sort by length then alphabetically:
        // Collections.sort(fruits, (f1, f2) -> {
        //     int lengthCompare = Integer.compare(f1.length(), f2.length());
        //     if (lengthCompare != 0) {
        //         return lengthCompare;
        //     }
        //     return f1.compareTo(f2);
        // });


        System.out.println("Sorted List of Fruits (by length):");
        System.out.println(fruits);
        System.out.println();

        System.out.println("Program finished.");
    }
}