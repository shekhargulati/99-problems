package com.shekhargulati.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class Problem02 {

    public static void main(String[] args) {
        /*
        1. Iterate over two lists together
        2. Add the two numbers at ith position
        3. If numbers add upto greater than equal to 10 then store the remainder at current position and store 1 as next
        4. When you are adding up next number add one
         */

        long start = System.currentTimeMillis();
        List<Integer> first = Arrays.asList(2, 4, 3);
        List<Integer> second = Arrays.asList(5, 6, 4);

        List<Integer> result = new ArrayList<>();

        int rem = 0;
        for (int i = 0; i < first.size(); i++) {
            int a = first.get(i);
            int b = second.get(i);
            int sum = a + b;
            if (a + b >= 10) {
                result.add(rem + sum % 10);
                rem = 1;
            } else {
                result.add(rem + sum);
                rem = 0;
            }
        }

        System.out.println(result);
        long end = System.currentTimeMillis();
        System.out.println(String.format("Total time taken %d millis", (end - start)));

    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
