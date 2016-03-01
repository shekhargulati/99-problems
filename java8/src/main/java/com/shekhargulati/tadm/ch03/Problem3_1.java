package com.shekhargulati.tadm.ch03;

import java.util.Stack;

/**
 * A common problem for compilers and text editors is determining whether the parentheses in a string are balanced and properly nested.
 * For example, the string ((())())() contains properly nested pairs of parentheses, which the strings )()( and ()) do not.
 * Give an algorithm that returns true if a string contains properly nested and balanced parentheses, and false if otherwise.
 * For full credit, identify the position of the first offending parenthesis if the string is not properly nested and balanced.
 */
public class Problem3_1 {

    public boolean isBalancedString(final String input) {
        /*
        Algorithm:
            1. Iterate over all the characters in a String
            2. if stack is not empty and character is ')' then pop the element from the stack
            3. else push the element into the stack
            4. After iteration if stack is empty then return true else return false.
         */
        Stack<Character> stack = new Stack<>();
        char[] chars = input.toCharArray();
        for (char ch : chars) {
            if (ch == ')' && !stack.empty()) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public int firstOffendingParenthesis(String input) {
        /*
        Algorithm:
            1. Iterate over all the characters of input String
            2. If character is ')' and stack is not empty then remove element from stack
            3. Else add the position into the stack
            4. After iteration, if stack is empty then return -1 else get the first element and return its value.
         */
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ')' && !stack.empty()) {
                stack.pop();
            } else {
                stack.push(i);
            }
        }
        return stack.empty() ? -1 : stack.elementAt(0);
    }
}
