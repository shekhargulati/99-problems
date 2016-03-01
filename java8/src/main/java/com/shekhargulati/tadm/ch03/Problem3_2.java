package com.shekhargulati.tadm.ch03;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Write a program to reverse the direction of a given singly-linked list.
 * In other words, after the reversal all pointers should now point backwards.
 * Your algorithm should take linear time.
 */
public class Problem3_2 {

    public <T> List<T> reverse(List<T> list) {
        /*
        Algorithm:
            1. Maintain a stack
            2. Iterate over all the elements in a list and put that on the stack
            3. Then empty the stack into a new LinkedList
         */
        Stack<T> stack = new Stack<>();
        list.forEach(stack::push);
        List<T> reversed = new LinkedList<>();
        while (!stack.isEmpty()) {
            reversed.add(stack.pop());
        }
        return reversed;
    }
}
