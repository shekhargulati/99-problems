package com.shekhargulati.random;

/**
 * Given a text and a string pattern check if pattern exist in the text.
 */
public class RandomProblem002 {

    public static boolean patternExistInText(String text, String pattern) {
        /*
            Algorithm:
            1. Find length of text n
            2. Find length of pattern m
            3. Iterate over length of text
            4. For each character of the text check if the pattern exist from the index to index + m
            5. If number of characters equal the length of m, we have found the pattern.
         */
        int n = text.length();
        int m = pattern.length();
        for (int i = 0; i < n - m; i++) {
            int j = 0;
            while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }
            if (j == m) return true;
        }
        return false;
    }
}
