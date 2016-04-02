package com.shekhargulati.leetcode.algorithms;

import java.util.Arrays;
import java.util.Objects;

/**
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class Problem05 {

    public static String longestPalindrome(final String input) {
        /*
         Algorithm:
         1. Start from left and go toward right
         2. For each char, pick the right most element if they are equal then take substring and compare both sides
         3. If they are equal then we have the match.
         4. Else move to next combination

         This algorithm has O(n^3) complexity.
         */
        String[] chars = input.split("");
        String palindrome = null;
        for (int i = 0; i < chars.length; i++) {
            String left = chars[i];
            for (int j = chars.length - 1; j > i; j--) {
                String right = chars[j];
                if (Objects.equals(left, right)) {
                    String first = input.substring(i, j + 1);
                    if (Objects.equals(first, reverse(first))) {
                        if (palindrome == null || first.length() > palindrome.length()) {
                            palindrome = first;
                        }
                    }
                }
            }
        }
        return palindrome;
    }

    private static String reverse(String in) {
        char[] chrs = new char[in.length()];
        for (int i = 0; i < in.length(); i++) {
            chrs[in.length() - i - 1] = in.charAt(i);
        }
        return String.valueOf(chrs);
    }


    public static String longestPalindrome1(final String input) {
        /*
           Algorithm:
           1. Start with the second element and compare (i-1) with (i+1)
           if they are equal then we have palindrome so continue comparing (i-1-1) to (i+1+1) till we find palindrome
           else move to the next character and repeat the process.
           http://articles.leetcode.com/longest-palindromic-substring-part-i/
         */

        char[] chars = input.toCharArray();
        String longest = String.valueOf(chars[0]);
        for (int middle = 1; middle < input.length(); middle++) {
            int left = middle - 1;
            int right = middle + 1;
            if (left >= 0 && right < input.length() && chars[left] == chars[right]) {
                String possibleLongest = findLongest(chars, left, right);
                if (longest.length() < possibleLongest.length()) {
                    longest = possibleLongest;
                }
            }
            if (middle >= 0 && right < input.length() && chars[middle] == chars[right]) {
                String possibleLongest = findLongest(chars, middle, right);
                if (longest.length() < possibleLongest.length()) {
                    longest = possibleLongest;
                }
            }
        }

        return longest;
    }

    private static String findLongest(char[] chars, int left, int right) {
        int pLeft = left - 1;
        int pRight = right + 1;
        if (pLeft >= 0 && pRight < chars.length && chars[pLeft] == chars[pRight]) {
            return findLongest(chars, pLeft, pRight);
        }
        return String.valueOf(Arrays.copyOfRange(chars, left, pRight));
    }


}
