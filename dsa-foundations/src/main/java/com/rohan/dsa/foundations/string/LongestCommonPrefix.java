package com.rohan.dsa.foundations.string;

public class LongestCommonPrefix {
    public static int lcp(String s, String t) {
        int N = Math.max(s.length(), t.length());
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return i;
            }
        }
        return N;
    }
}
