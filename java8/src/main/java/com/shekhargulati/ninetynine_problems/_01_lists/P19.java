package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.List;
import java.util.Map;

/**
 * (**) Rotate a list N places to the left
 */
public class P19 {

    public static <T> List<T> rotate(List<T> list, int n) {
        n = n < 0 ? list.size() + n : n;
        Map<Boolean, List<T>> split = P17.split(list, n);
        List<T> result = split.get(false);
        result.addAll(split.get(true));
        return result;
    }
}
