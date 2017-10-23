package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.LinkedList;
import java.util.List;

/**
 * (*) Find the last element of a list.
 * <p>
 * Check P01Test class for test cases related to this problem.
 */

public class P01_MySolution {

    public static <T> T lastElement(List<T> elements) {

        return elements.get(elements.size()-1);

    }

    public static <T> T lastElementLL(LinkedList<T> elements) {

        return elements.getLast();

    }
}
