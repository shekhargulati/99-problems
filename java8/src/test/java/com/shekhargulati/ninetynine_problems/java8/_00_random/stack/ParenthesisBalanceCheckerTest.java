package com.shekhargulati.ninetynine_problems.java8._00_random.stack;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class ParenthesisBalanceCheckerTest {

    private final ParenthesisBalanceChecker checker = new ParenthesisBalanceChecker();

    @Test
    public void shouldSayTrueForEmptyString() throws Exception {
        final String input = "";
        boolean balanced = checker.isBalancedString(input);
        assertTrue(balanced);
    }

    @Test
    public void shouldSayTrueWhenStringIsBalanced() throws Exception {
        final String input = "((())())()";
        boolean balanced = checker.isBalancedString(input);
        assertTrue(balanced);
    }

    @Test
    public void shouldSayFalseWhenStringIsNotBalanced() throws Exception {
        final String input = ")()(";
        boolean balanced = checker.isBalancedString(input);
        assertFalse(balanced);
    }

    @Test
    public void shouldSayFalseWhenStringIsNotBalanced_anotherInput() throws Exception {
        final String input = "())";
        boolean balanced = checker.isBalancedString(input);
        assertFalse(balanced);
    }

    @Test
    public void shouldFindPositionOfFirstOffendingParenthesis() throws Exception {
        final String input = ")()(";
        int position = checker.firstOffendingParenthesis(input);
        assertThat(position, equalTo(0));
    }

    @Test
    public void shouldFindPositionOfFirstOffendingParenthesis_input2() throws Exception {
        final String input = "(())(";
        int position = checker.firstOffendingParenthesis(input);
        assertThat(position, equalTo(4));
    }

    @Test
    public void shouldFindPositionOfFirstOffendingParenthesis_input3() throws Exception {
        final String input = "())";
        int position = checker.firstOffendingParenthesis(input);
        assertThat(position, equalTo(2));
    }

}