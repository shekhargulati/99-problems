package com.shekhargulati.ninetynine_problems._02_arithmetic;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * (**) A list of Goldbach compositions.
 */
public class P36 {

    public static List<SimpleEntry<Integer, List<Integer>>> goldbach_list(IntStream range) {
        return range
                .filter(n -> n % 2 == 0)
                .filter(even -> even > 2)
                .mapToObj(even -> new SimpleEntry<>(even, P35.goldbach(even)))
                .collect(toList());
    }

    public static List<SimpleEntry<Integer, List<Integer>>> goldbach_list1(IntStream range, int greaterThan) {
        return goldbach_list(range)
                .stream()
                .filter(g -> g.getValue().get(0) > greaterThan && g.getValue().get(1) > greaterThan)
                .collect(toList());

    }
}
