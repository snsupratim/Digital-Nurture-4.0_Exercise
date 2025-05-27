import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// Corrected: Removed 'public' keyword from the record declaration
// This makes the 'Person' record package-private, allowing it to be
// in the same file as 'RecordsExample.java' without a compile error.
record Person(String name, int age) {
    // You can add custom constructors, methods, or even compact constructors
    // For instance, a custom validation in the compact constructor:
    public Person {
        Objects.requireNonNull(name, "Name cannot be null"); // Ensures name is not null
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    // You can also add custom instance methods
    public String getGreeting() {
        return "Hello, my name is " + name + " and I am " + age + " years old.";
    }
}

public class RecordsExample {

    public static void main(String[] args) {
        System.out.println("Java Records Demonstration (Java 16+)");
        System.out.println("-------------------------------------\n");

        // 2. Create instances of the Person record
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Bob", 25);
        Person person3 = new Person("Charlie", 35);
        Person person4 = new Person("Diana", 40);
        Person person5 = new Person("Eve", 28);

        // 3. Print instances (demonstrates automatically generated toString() and accessors)
        System.out.println("--- Created Person Instances ---");
        System.out.println("Person 1: " + person1); // Uses default toString()
        System.out.println("Person 2: " + person2.name() + " is " + person2.age() + " years old."); // Uses accessors
        System.out.println("Person 3 greeting: " + person3.getGreeting()); // Uses custom method
        System.out.println();

        // Demonstrate equals() and hashCode()
        Person person1Copy = new Person("Alice", 30);
        System.out.println("Are person1 and person1Copy equal? " + person1.equals(person1Copy)); // Should be true
        System.out.println("Are person1 and person2 equal? " + person1.equals(person2));     // Should be false
        System.out.println();

        // 4. Use records in a List
        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);

        System.out.println("--- Original List of People ---");
        people.forEach(p -> System.out.println("  " + p.name() + " (" + p.age() + ")"));
        System.out.println();

        // 5. Filter based on age using Streams (e.g., people older than 30)
        List<Person> olderPeople = people.stream()
                .filter(person -> person.age() > 30) // Filter using the 'age()' accessor
                .collect(Collectors.toList());

        // 6. Display the filtered list
        System.out.println("--- People Older Than 30 (Filtered using Streams) ---");
        if (olderPeople.isEmpty()) {
            System.out.println("No people found older than 30.");
        } else {
            olderPeople.forEach(p -> System.out.println("  " + p.name() + " (" + p.age() + ")"));
        }
        System.out.println();

        // Example: Using a custom constructor with validation
        try {
            Person invalidAgePerson = new Person("Invalid", -5);
            System.out.println("This won't be printed: " + invalidAgePerson);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception for invalid age: " + e.getMessage());
        }
        System.out.println("\nProgram finished.");
    }
}