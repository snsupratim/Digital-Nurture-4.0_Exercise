// File: java-modules-example/com.greetings/src/com.greetings/Main.java
package com.greetings;

import com.utils.StringUtil; // Import StringUtil from the 'com.utils' module

public class Main {
    public static void main(String[] args) {
        String original = "hello modules";
        String reversed = StringUtil.reverseString(original);
        String capitalized = StringUtil.capitalize(original);

        System.out.println("Original string: " + original);
        System.out.println("Reversed string (from com.utils): " + reversed);
        System.out.println("Capitalized string (from com.utils): " + capitalized);

        System.out.println("\nGreetings from the com.greetings module!");
    }
}