package com.shekhargulati.leetcode.algorithms;

import java.util.ArrayList;
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
        ListNode first = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode second = new ListNode(5, new ListNode(6, new ListNode(4, null)));

        List<Integer> result = new ArrayList<>();
        int rem = 0;
        while (first != null && second != null) {
            int a = first.val;
            int b = second.val;
            first = first.next;
            second = second.next;
            int sum = a + b + rem;
            if (sum >= 10) {
                sum = sum % 10;
                rem = 1;
            } else {
                rem = 0;
            }
            result.add(sum);
        }

        System.out.println(result);
        long end = System.currentTimeMillis();
        System.out.println(String.format("Total time taken %d millis", (end - start)));

    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
