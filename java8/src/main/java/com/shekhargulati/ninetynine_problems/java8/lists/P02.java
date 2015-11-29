package com.shekhargulati.ninetynine_problems.java8.lists;

import java.util.LinkedList;
import java.util.List;

public class P02 {

    public static <T> T secondLast(List<T> list) {
        if (list.size() < 2) {
            throw new IllegalArgumentException("Can't find secondLast element from a list with less than 2 elements");
        }
        return list.get(list.size() - 2);
    }

    public static <T> T secondLastRecursion(LinkedList<T> list) {
        if (list.size() < 2) {
            throw new IllegalArgumentException("Can't find secondLast element from a list with less than 2 elements");
        }
        if (list.size() == 2) {
            return list.get(0);
        }
        return secondLastRecursion(new LinkedList<>(list.subList(1, list.size())));

    }
}
