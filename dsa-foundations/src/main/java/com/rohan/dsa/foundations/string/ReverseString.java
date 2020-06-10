package com.rohan.dsa.foundations.string;

/**
 * Using String and StringBuilder
 */
public class ReverseString {

    public static String reverse(String s) {
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }
        return reversed;
    }

    public static String reverseUsingStringBuilder(String s) {
        StringBuilder reversedSb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reversedSb.append(s.charAt(i));
        }
        return reversedSb.toString();
    }
}
