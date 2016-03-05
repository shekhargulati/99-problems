package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * (*) Remove the K'th element from a list
 */
public class P20 {

    public static <T> Object[] removeAt(List<T> list, int k) {
        List<T> input = new ArrayList<>(list);
        T kth = input.remove(k - 1);
        return new Object[]{input, kth};
    }

    public static <T> Object[] removeAt0(List<T> list, int k) {
        List<T> input = new ArrayList<>(list);
        T kth = input.remove(k);
        return new Object[]{input, kth};
    }

    public static <T> Object[] removeAt_splitAt(List<T> list, int k) {
        Map<Boolean, List<T>> split = P17.split(list, k);
        List<T> first = split.get(true);
        List<T> second = split.get(false);
        T kth = first.remove(k - 1);
        first.addAll(second);
        return new Object[]{first, kth};

    }
}

