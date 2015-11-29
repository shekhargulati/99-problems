package com.shekhargulati.ninetynine_problems.java8.lists;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

/**
 * Reverse a list
 */
public class P05 {

    public static <T> List<T> reverse(List<T> list) {
        Collections.reverse(list);
        return list;
    }

    public static <T> List<T> reverse1(List<T> list) {
        List<T> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }


    public static <T> List<T> reverseIntStream(List<T> list) {
        int size = list.size();
        return IntStream.iterate(size - 1, el -> el - 1).limit(size).mapToObj(list::get).collect(toList());
    }

    public static <T> List<T> reverseStream(ArrayDeque<T> list) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(list.descendingIterator(), Spliterator.ORDERED), false).collect(toList());
    }
}

