package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Find the Kth element of a list.
 */
public class P03 {

    public static <T> T kth(final List<T> list, final int k) {
        return list.get(k);
    }

    public static <T> T kthRecursive(final LinkedList<T> list, final int k) {
        if (k == 0) {
            return list.getFirst();
        }
        return kthRecursive(new LinkedList<>(list.subList(1, list.size())), k - 1);
    }

    public static <T> T kthStream(final List<T> list, final int k) {
        return list.stream().limit(k + 1).collect(Collectors.toCollection(LinkedList::new)).getLast();
    }

}
