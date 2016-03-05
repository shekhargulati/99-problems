package com.shekhargulati.ninetynine_problems._01_lists;

import org.junit.Test;

import java.util.Arrays;

import static com.shekhargulati.ninetynine_problems._01_lists.P06.isPalindrome;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class P06Test {

    @Test
    public void shouldReturnTrueWhenListIsPalindrome() throws Exception {
        assertTrue(isPalindrome(Arrays.asList("x", "a", "m", "a", "x")));
    }

    @Test
    public void shouldReturnFalseWhenListIsNotPalindrome() throws Exception {
        assertFalse(isPalindrome(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    public void shouldReturnTrueWhenListIsPalindrome_IntStream() throws Exception {
        assertTrue(isPalindrome(Arrays.asList("x", "a", "m", "a", "x")));
    }

    @Test
    public void shouldReturnFalseWhenListIsNotPalindrome_IntStream() throws Exception {
        assertFalse(isPalindrome(Arrays.asList(1, 2, 3, 4, 5)));
    }
}