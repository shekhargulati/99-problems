package com.shekhargulati.ninetynine_problems.java8.lists;

import java.util.List;

/**
 * (**) Extract a slice from a list
 */
public class P18 {

    public static <T> List<T> slice(List<T> list, int start, int end) {
        return list.subList(start - 1, end);
    }
}
