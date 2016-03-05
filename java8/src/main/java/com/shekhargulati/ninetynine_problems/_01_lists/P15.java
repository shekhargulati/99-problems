package com.shekhargulati.ninetynine_problems._01_lists;


import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * (**) Duplicate the elements of a list a given number of times.
 * <pre>
 *          duplicate(Arrays.asList("a", "b", "c", "d"))
 * </pre>
 */
public class P15 {

    public static <T> List<T> duplicate(final List<T> list, final int times) {
        return list.stream().flatMap(e -> Collections.nCopies(times, e).stream()).collect(toList());
    }
}
