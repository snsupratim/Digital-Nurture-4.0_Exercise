import java.util.ArrayList;

public class PatternMatchingSwitchExample {

    /**
     * Determines the type of the given object using pattern matching for switch
     * and prints a corresponding message.
     *
     * @param obj The input object to inspect.
     */
    public static void describeObject(Object obj) {
        System.out.print("Processing object of type " + (obj != null ? obj.getClass().getSimpleName() : "null") + ": ");

        String description = switch (obj) {
            case Integer i -> "It's an Integer with value: " + i;
            case String s  -> "It's a String with length: " + s.length() + " and value: \"" + s + "\"";
            case Double d  -> "It's a Double with value: " + d + " (twice its value is: " + (d * 2) + ")";
            case Boolean b -> "It's a Boolean with value: " + b;
            case null      -> "It's a null object. Cannot determine type."; // New in Java 17 for switch
            default        -> "It's an unknown type: " + obj.getClass().getName();
        };
        System.out.println(description);
    }

    public static void main(String[] args) {
        System.out.println("Java 21: Pattern Matching for Switch Expressions");
        System.out.println("-------------------------------------------------\n");

        // Test with different types of objects
        describeObject(10);                    // Integer
        describeObject("Hello, Java!");        // String
        describeObject(3.14);                  // Double
        describeObject(true);                  // Boolean
        describeObject(new ArrayList<>());     // Another object type
        describeObject(null);                  // Null object
        describeObject(20.0f);                 // Float (will hit 'default' or a specific Float case if added)
        describeObject("123");                 // String (even if it looks like a number)
    }
}