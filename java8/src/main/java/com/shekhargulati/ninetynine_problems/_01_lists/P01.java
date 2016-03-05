package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * (*) Find the last element of a list.
 * <p>
 * Check P01Test class for test cases related to this problem.
 */
public class P01 {

    /*
    You could solve this using many different approaches.
    If you work with List interface then you can find the last element using List size as shown below.
     */
    public static <T> T last(List<T> elements) {
        int numberOfElements = elements.size();
        return elements.get(numberOfElements - 1);
    }

    /*
    Another way to solve this is by using LinkedList instead of a List.
    LinkedList provides a builtin getLast method.
     */
    public static <T> T last(LinkedList<T> elements) {
        return elements.getLast();
    }


    /*
    A functional approach could be to use recursion.  We call the function recusively with a sub list which ignores the 0th element.
    When we reach the end i.e. size of the list is 1 then we return that element.
    */
    public static <T> T lastRecursive(List<T> elements) {
        if (elements == null || elements.isEmpty()) {
            throw new NoSuchElementException();
        }
        if (elements.size() == 1) {
            return elements.get(0);
        }
        return lastRecursive(elements.subList(1, elements.size()));
    }


}
