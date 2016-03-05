package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.List;
import java.util.Map;

/**
 * (*) Insert an element at a given position into a list
 */
public class P21 {

    public static <T> List<T> insertAt(List<T> list, int pos, T t) throws IllegalArgumentException {
        if (pos < 1) {
            throw new IllegalArgumentException("pos can't be less than 1");
        }
        list.add((pos - 1), t);
        return list;
    }


    public static <T> List<T> insertAt_split(List<T> list, int pos, T t) throws IllegalArgumentException {
        if (pos < 1) {
            throw new IllegalArgumentException("pos can't be less than 1");
        }

        Map<Boolean, List<T>> split = P17.split(list, pos);
        List<T> first = split.get(true);
        List<T> second = split.get(false);
        first.add(pos - 1, t);

        first.addAll(second);
        return first;
    }


}
