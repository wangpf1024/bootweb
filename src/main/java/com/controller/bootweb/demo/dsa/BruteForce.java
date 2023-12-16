package com.controller.bootweb.demo.dsa;

public class BruteForce {
    public static int bruteForceSearch(String text, String pattern) {
        int m = text.length();
        int n = pattern.length();

        for (int i = 0; i <= m - n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == n) {
                return i; // Pattern found at index i
            }
        }
        return -1; // Pattern not found
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        int index = bruteForceSearch(text, pattern);
        if (index != -1) {
            System.out.println("Pattern found at index " + index);
        } else {
            System.out.println("Pattern not found");
        }
    }
}
