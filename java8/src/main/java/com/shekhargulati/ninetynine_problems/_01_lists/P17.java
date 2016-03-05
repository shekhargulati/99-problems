package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

/**
 * <b>(*) Split a list into two parts; the length of the first part is given</b>
 */
public class P17 {

    public static <T> Map<Boolean, List<T>> split(List<T> list, int n) {
        return IntStream
                .range(0, list.size())
                .mapToObj(i -> new SimpleEntry<>(i, list.get(i)))
                .collect(partitioningBy(entry -> entry.getKey() < n, mapping(SimpleEntry::getValue, toList())));
    }
}
