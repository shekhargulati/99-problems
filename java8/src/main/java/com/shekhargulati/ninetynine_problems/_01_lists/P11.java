package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * <b>(*) Modified run-length encoding</b>
 * <pre>
 *      encode_modified(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
 * </pre>
 */
public class P11 {

    public static <T> List<Object> encode_modified(List<T> list) {
        return P09.pack(list).stream().map(l -> {
            if (l.size() == 1) {
                return l.get(0);
            }
            return new SimpleEntry<>(l.size(), l.get(0));
        }).collect(toList());
    }
}
