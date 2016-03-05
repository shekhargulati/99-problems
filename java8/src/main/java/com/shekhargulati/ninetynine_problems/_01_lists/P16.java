package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <b><(**) Drop every N'th element from a list/b>
 */
public class P16 {

    public static <T> List<T> dropEveryNth(List<T> list, int n) {
        if (n == 0) {
            return list;
        }
        return IntStream.range(0, list.size())
                .mapToObj(i -> new SimpleEntry<>(list.get(i), i))
                .filter(entry -> (entry.getValue() + 1) % n != 0)
                .map(SimpleEntry::getKey)
                .collect(Collectors.toList());
    }
}
