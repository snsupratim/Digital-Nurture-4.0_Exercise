public class MethodOverloadingDemo {

    // Method 1: add with two integers
    public int add(int a, int b) {
        System.out.println("Calling add(int a, int b)");
        return a + b;
    }

    // Method 2: add with two doubles
    // This overloads Method 1 because the parameter types are different
    public double add(double a, double b) {
        System.out.println("Calling add(double a, double b)");
        return a + b;
    }

    // Method 3: add with three integers
    // This overloads Method 1 and Method 2 because the number of parameters is different
    public int add(int a, int b, int c) {
        System.out.println("Calling add(int a, int b, int c)");
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println("Java Method Overloading Demonstration");
        System.out.println("-------------------------------------");

        // Create an instance of the class to call the methods
        MethodOverloadingDemo calculator = new MethodOverloadingDemo();

        // Call Method 1: add(int, int)
        int sumInt = calculator.add(10, 20);
        System.out.println("Sum of two integers (10, 20): " + sumInt);
        System.out.println(); // Blank line for readability

        // Call Method 2: add(double, double)
        double sumDouble = calculator.add(15.5, 25.3);
        System.out.println("Sum of two doubles (15.5, 25.3): " + sumDouble);
        System.out.println();

        // Call Method 3: add(int, int, int)
        int sumThreeInt = calculator.add(5, 10, 15);
        System.out.println("Sum of three integers (5, 10, 15): " + sumThreeInt);
        System.out.println();

        // Example of how the compiler chooses the correct method:
        // If you pass int literals to a double method, Java will perform widening conversion
        double mixedSum = calculator.add(100, 200.5); // 100 will be promoted to 100.0 (double)
        System.out.println("Sum with mixed types (100, 200.5): " + mixedSum);
        System.out.println("Explanation: Java automatically promotes '100' to a double (100.0) to match the add(double, double) signature.");
        System.out.println();
    }
}