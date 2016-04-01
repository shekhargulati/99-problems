package com.shekhargulati.leetcode.algorithms;

/**
 * Longest substring without repeating characters
 */
public class Problem03 {

    public static String substring(final String input) {
        StringBuilder subStr = new StringBuilder();
        String[] chars = input.split("");
        for (String ch : chars) {
            int indexCh = subStr.indexOf(ch);
            if (indexCh == -1) {
                subStr.append(ch);
            } else {
                subStr = new StringBuilder(subStr.substring(indexCh + 1));
                subStr.append(ch);
            }
        }
        return subStr.toString();
    }
}
