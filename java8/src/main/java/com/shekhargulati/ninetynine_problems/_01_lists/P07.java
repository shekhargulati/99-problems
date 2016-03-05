package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * <b>(**) Flatten a nested list structure</b>
 * <p>
 * Transform a list, possibly holding lists as elements into a 'flat' list by replacing each list with its elements (recursively).
 * </p>
 */
public class P07 {

    public static <T> List<T> flatten(List<?> list, Class<T> elementType) {
        List<T> flatten = new ArrayList<>();
        list.forEach(e -> {
            if (e instanceof List) {
                flatten.addAll(flatten((List<?>) e, elementType));
            } else {
                flatten.add((T) e);
            }
        });
        return flatten;
    }

    public static <T> List<T> flatten_stream(List<?> list, Class<T> elementType) {
        return list
                .stream()
                .flatMap(e -> e instanceof List ? flatten_stream(((List<?>) e), elementType).stream() : Stream.of(e))
                .map(e -> (T) e)
                .collect(toList());
    }
}
