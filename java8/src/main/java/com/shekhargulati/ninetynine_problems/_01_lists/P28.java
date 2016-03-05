package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * (**) Sorting a list of lists according to length of sublists
 */
public class P28 {

    public static <T> List<List<T>> lsort(List<List<T>> list) {
        list.sort((xs1, xs2) -> xs1.size() - xs2.size());
        return list;
    }

    public static List<List<String>> lfsort(List<List<String>> list) {
        Map<Integer, Integer> freqs = new HashMap<>();
        list.stream().map(List::size).forEach(l -> freqs.put(l, freqs.compute(l, (k, v) -> v == null ? 1 : v + 1)));
        return list
                .stream()
                .sorted((xs1, xs2) -> freqs.get(xs1.size()) - freqs.get(xs2.size()))
                .collect(toList());
    }

    /*
    Same as scala code. This code does not works correctly because elements with same length are at different position
     */
    public static List<List<String>> lfsort1(List<List<String>> list) {
        return lsort(
                lsort(list)
                        .stream()
                        .collect(groupingBy(List::size))
                        .values().stream().collect(toList()))
                .stream()
                .flatMap(Collection::stream)
                .collect(toList());
    }


}
