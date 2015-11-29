package com.shekhargulati.ninetynine_problems.java8.lists;

import java.util.LinkedList;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public abstract class LinkedListUtils {

    public static <T> LinkedList<T> linkedList(T... elements) {
        return Stream.of(elements).collect(toCollection(LinkedList::new));
    }
}
