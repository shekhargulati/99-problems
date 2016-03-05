package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * (*) Create a list containing all integers within a given range
 */
public class P22 {

    public static List<Integer> range(int start, int end) {
        return IntStream.rangeClosed(start, end).boxed().collect(toList());
    }
}
