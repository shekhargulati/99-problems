package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public abstract class CollectionUtils {

    public static <T> LinkedList<T> linkedList(T... elements) {
        return Stream.of(elements).collect(toCollection(LinkedList::new));
    }

    public static <T> ArrayDeque<T> arrayDeque(T... elements) {
        return Stream.of(elements).collect(toCollection(ArrayDeque::new));
    }
}
