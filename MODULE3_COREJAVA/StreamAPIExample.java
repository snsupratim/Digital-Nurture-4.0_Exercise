import java.util.ArrayList;   // For creating a dynamic list
import java.util.Arrays;      // For easily creating a list from an array
import java.util.List;        // For the List interface
import java.util.stream.Collectors; // For the Collectors utility class

public class StreamAPIExample {

    public static void main(String[] args) {
        System.out.println("Java Stream API Demonstration (Filtering Even Numbers)");
        System.out.println("-----------------------------------------------------");

        // 1. Create a List of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Alternatively:
        // List<Integer> numbers = new ArrayList<>();
        // numbers.add(1); numbers.add(2); // ... and so on

        System.out.println("Original List of Numbers:");
        System.out.println(numbers);
        System.out.println();

        // 2. Use the Stream API to filter even numbers
        //    - .stream(): Converts the List into a Stream.
        //    - .filter(n -> n % 2 == 0): An intermediate operation that keeps only elements
        //      for which the lambda expression returns true (i.e., even numbers).
        //    - .collect(Collectors.toList()): A terminal operation that gathers the elements
        //      of the stream into a new List.
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0) // Lambda expression for the filtering condition
                .collect(Collectors.toList());

        // 3. Display the result
        System.out.println("Filtered Even Numbers (using Stream API):");
        System.out.println(evenNumbers);
        System.out.println();

        // Another example: Filter even numbers and then double them before collecting
        System.out.println("Even Numbers Doubled (using Stream API):");
        List<Integer> doubledEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0) // Filter for even numbers
                .map(n -> n * 2)       // Map: transform each even number by doubling it
                .collect(Collectors.toList());
        System.out.println(doubledEvenNumbers);
        System.out.println();


        System.out.println("Program finished.");
    }
}