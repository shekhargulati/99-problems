package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Find out whether a list is a palindrome.
 */
public class P06 {

    public static <T> boolean isPalindrome(List<T> list) {
        List<T> original = new ArrayList<>(list);
        P05.reverse(list);
        return Objects.equals(list, original);
    }

    public static <T> boolean isPalindrome_IntStream(List<T> list) {
        List<T> reversed = P05.reverse_IntStream(list);
        return Objects.equals(list, reversed);
    }

}
