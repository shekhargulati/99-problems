package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * <b> (*) Run-length encoding of a list.</b>
 */
public class P10 {

    public static <T> List<SimpleEntry<Integer, T>> encode(List<T> list) {
        return P09.pack(list).stream().map(l -> new SimpleEntry<>(l.size(), l.get(0))).collect(toList());
    }
}
