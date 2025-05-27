public class TypeCastingExample {

    public static void main(String[] args) {
        System.out.println("Java Type Casting Example");
        System.out.println("-------------------------");

        // --- Part 1: Casting double to int (Narrowing Conversion) ---
        // This conversion can result in loss of precision (the decimal part is truncated).
        double myDouble = 123.45;
        System.out.println("Original double value: " + myDouble);

        // Explicitly cast double to int
        int myIntFromDouble = (int) myDouble;
        System.out.println("Casting double to int:");
        System.out.println("  Resulting int value: " + myIntFromDouble); // Decimal part is lost (truncated)
        System.out.println(); // Blank line for readability

        // Another example with a different value
        double pi = 3.14159;
        System.out.println("Original double value (Pi): " + pi);
        int piAsInt = (int) pi;
        System.out.println("Casting Pi (double) to int: " + piAsInt); // Output will be 3
        System.out.println();

        // --- Part 2: Casting int to double (Widening Conversion) ---
        // This conversion is safe and does not result in loss of data.
        int myInt = 100;
        System.out.println("Original int value: " + myInt);

        // Implicitly or explicitly cast int to double
        // (int to double is a widening conversion, so explicit cast is not strictly required but good for clarity)
        double myDoubleFromInt = (double) myInt;
        System.out.println("Casting int to double (explicit):");
        System.out.println("  Resulting double value: " + myDoubleFromInt); // Will be 100.0
        System.out.println();

        // Example of implicit casting (compiler does it automatically because it's safe)
        int score = 75;
        double scoreAsDouble = score; // Implicit casting happens here
        System.out.println("Original int value (score): " + score);
        System.out.println("Casting int to double (implicit): " + scoreAsDouble); // Will be 75.0
        System.out.println();
    }
}