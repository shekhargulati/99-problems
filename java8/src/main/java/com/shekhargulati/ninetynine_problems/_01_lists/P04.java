package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.List;

/**
 * Find the number of elements of a list
 */
public class P04 {

    public static <T> int length(List<T> list) {
        return list.size();
    }

    public static <T> long lengthStream(List<T> list) {
        return list.stream().count();
    }

    public static <T> long lengthStream1(List<T> list) {
        return list.stream().mapToInt(x -> 1).sum();
    }

    public static <T> int lengthRecursive(List<T> list) {
        return _lengthRecursive(list, 0);
    }

    private static <T> int _lengthRecursive(List<T> list, int i) {
        if (list.isEmpty()) {
            return i;
        }
        return _lengthRecursive(list.subList(1, list.size()), ++i);
    }
}
