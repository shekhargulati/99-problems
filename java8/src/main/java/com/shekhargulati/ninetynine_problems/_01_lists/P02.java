package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class P02 {

    public static <T> T secondLast(List<T> list) {
        if (list.size() < 2) {
            throw new NoSuchElementException("Can't find secondLast element from a list with less than 2 elements");
        }
        return list.get(list.size() - 2);
    }

    public static <T> T secondLastRecursion(LinkedList<T> list) {
        if (list.size() < 2) {
            throw new NoSuchElementException("Can't find secondLast element from a list with less than 2 elements");
        }
        if (list.size() == 2) {
            return list.getFirst();
        }
        return secondLastRecursion(new LinkedList<>(list.subList(1, list.size())));

    }
}
