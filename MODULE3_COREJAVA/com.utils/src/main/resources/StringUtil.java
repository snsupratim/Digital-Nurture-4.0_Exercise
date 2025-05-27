// File: java-modules-example/com.utils/src/com.utils/StringUtil.java
package com.utils;

public class StringUtil {
    public static String reverseString(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return new StringBuilder(text).reverse().toString();
    }

    public static String capitalize(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        if (text.length() == 1) {
            return text.toUpperCase();
        }
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }
}