package com.shekhargulati.ninetynine_problems._02_arithmetic;

import com.shekhargulati.ninetynine_problems._01_lists.P10;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * (**) Determine the prime factors of a given positive integer (2)
 */
public class P33 {

    public static List<SimpleEntry<Integer, Integer>> primeFactorsMult(int number) {
        return P10.encode(P32.primeFactors(number))
                .stream()
                .map(e -> new SimpleEntry<>(e.getValue(), e.getKey()))
                .collect(toList());
    }
}
