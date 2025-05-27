public class DataTypeDemonstration {

    public static void main(String[] args) {
        System.out.println("Java Primitive Data Type Demonstration");
        System.out.println("------------------------------------");

        // 1. int (Integer): Stores whole numbers (no decimals), from -2 billion to +2 billion approximately.
        int age = 30;
        int yearOfBirth = 1995;
        System.out.println("int (Integer):");
        System.out.println("  Age: " + age);
        System.out.println("  Year of Birth: " + yearOfBirth);
        System.out.println(); // Prints a blank line for better readability

        // 2. float (Floating-point number): Stores fractional numbers.
        //    Suffix 'f' or 'F' is required for float literals.
        float temperature = 98.6f;
        float pi_approx = 3.14159f;
        System.out.println("float (Floating-point):");
        System.out.println("  Temperature: " + temperature + " °F");
        System.out.println("  Pi (approx): " + pi_approx);
        System.out.println();

        // 3. double (Double-precision floating-point number): Stores fractional numbers with higher precision than float.
        //    This is the default for decimal numbers.
        double speedOfLight = 299792458.0; // Meters per second
        double bankBalance = 1234567.89;
        System.out.println("double (Double-precision Floating-point):");
        System.out.println("  Speed of Light: " + speedOfLight + " m/s");
        System.out.println("  Bank Balance: $" + bankBalance);
        System.out.println();

        // 4. char (Character): Stores a single character. Enclosed in single quotes.
        char grade = 'A';
        char initial = 'J';
        char currencySymbol = '$';
        System.out.println("char (Character):");
        System.out.println("  Grade: " + grade);
        System.out.println("  Initial: " + initial);
        System.out.println("  Currency Symbol: " + currencySymbol);
        System.out.println();

        // 5. boolean (Boolean): Stores true or false values.
        boolean isJavaFun = true;
        boolean hasPassedExam = false;
        System.out.println("boolean (Boolean):");
        System.out.println("  Is Java fun? " + isJavaFun);
        System.out.println("  Has passed exam? " + hasPassedExam);
        System.out.println();
    }
}