public class OperatorPrecedence {

    public static void main(String[] args) {
        System.out.println("Java Operator Precedence Demonstration");
        System.out.println("------------------------------------");

        // Expression 1: Multiplication before Addition
        // Expected: 10 + (5 * 2) = 10 + 10 = 20
        int result1 = 10 + 5 * 2;
        System.out.println("Expression 1: int result1 = 10 + 5 * 2;");
        System.out.println("Result 1: " + result1);
        System.out.println("Explanation: Multiplication (*) has higher precedence than addition (+).");
        System.out.println("  So, 5 * 2 is evaluated first (10), then 10 + 10 is calculated.");
        System.out.println();

        // Expression 2: Division and Modulus before Addition/Subtraction
        // Expected: 20 - (6 / 3) + (15 % 4)
        //         = 20 - 2 + 3
        //         = 18 + 3 = 21
        int result2 = 20 - 6 / 3 + 15 % 4;
        System.out.println("Expression 2: int result2 = 20 - 6 / 3 + 15 % 4;");
        System.out.println("Result 2: " + result2);
        System.out.println("Explanation: Division (/) and Modulus (%) have higher precedence than addition (+) and subtraction (-).");
        System.out.println("  They are evaluated from left to right. Then addition/subtraction from left to right.");
        System.out.println("  1. 6 / 3 = 2");
        System.out.println("  2. 15 % 4 = 3 (remainder of 15 divided by 4)");
        System.out.println("  3. 20 - 2 = 18");
        System.out.println("  4. 18 + 3 = 21");
        System.out.println();

        // Expression 3: Using Parentheses to Override Precedence
        // Expected: (10 + 5) * 2 = 15 * 2 = 30
        int result3 = (10 + 5) * 2;
        System.out.println("Expression 3: int result3 = (10 + 5) * 2;");
        System.out.println("Result 3: " + result3);
        System.out.println("Explanation: Parentheses () have the highest precedence. Operations inside them are evaluated first.");
        System.out.println("  So, (10 + 5) is evaluated first (15), then 15 * 2 is calculated.");
        System.out.println();

        // Expression 4: Combined with logical operators (conceptual, results in boolean)
        // Note: Arithmetic operators (like +) have higher precedence than comparison operators (like >),
        // which have higher precedence than logical operators (like &&).
        boolean booleanResult = (10 + 5 > 12) && (7 * 2 != 15);
        System.out.println("Expression 4: boolean booleanResult = (10 + 5 > 12) && (7 * 2 != 15);");
        System.out.println("Result 4: " + booleanResult);
        System.out.println("Explanation:");
        System.out.println("  1. Parentheses are evaluated first:");
        System.out.println("     - (10 + 5) = 15");
        System.out.println("     - (7 * 2) = 14");
        System.out.println("  2. Comparison operators (>, !=) are evaluated:");
        System.out.println("     - 15 > 12 is true");
        System.out.println("     - 14 != 15 is true");
        System.out.println("  3. Logical AND (&&) is evaluated: true && true = true");
        System.out.println();

        // Expression 5: Increment/Decrement and Assignment
        int a = 5;
        int b = 10;
        int result5 = ++a + b--; // Pre-increment 'a', then add, then post-decrement 'b'
        // Expected: a becomes 6. b remains 10 for the addition, then becomes 9.
        // Result: 6 + 10 = 16
        System.out.println("Expression 5: int a = 5; int b = 10; int result5 = ++a + b--;");
        System.out.println("Initial a: 5, Initial b: 10");
        System.out.println("Result 5: " + result5);
        System.out.println("Final a: " + a);
        System.out.println("Final b: " + b);
        System.out.println("Explanation:");
        System.out.println("  1. Pre-increment '++a': 'a' becomes 6 before the addition.");
        System.out.println("  2. Addition: 6 + (current value of b, which is 10) = 16.");
        System.out.println("  3. Post-decrement 'b--': 'b' is decremented to 9 AFTER its value (10) is used in the addition.");
        System.out.println();
    }
}