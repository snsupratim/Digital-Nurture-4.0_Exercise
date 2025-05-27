// File: MyClass.java
public class MyClass {

    // A method that adds two integers
    public int addNumbers(int a, int b) {
        int sum = a + b; // Line 6
        return sum;      // Line 7
    }

    // The main method of the program
    public static void main(String[] args) {
        MyClass obj = new MyClass();        // Line 12
        int result = obj.addNumbers(10, 20); // Line 13
        System.out.println("Result: " + result); // Line 14
    }
}