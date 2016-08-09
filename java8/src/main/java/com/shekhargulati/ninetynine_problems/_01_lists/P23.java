package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * (**) Extract a given number of randomly selected elements from a list
 */
public class P23 {

    public static <T> List<T> randomSelect(List<T> list, int n) {
        return new Random().ints(n, 0, list.size()).mapToObj(list::get).collect(Collectors.toList());
    }

    public static <T> List<T> randomSelectR(List<T> list, int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        Object[] objects = P20.removeAt0(list, new Random().nextInt(list.size()));
        List<T> remaining = (List<T>) objects[0];
        T t = (T) objects[1];
        List<T> result = new ArrayList<>();
        result.add(t);
        result.addAll(randomSelectR(remaining, n - 1));
        return result;
    }

    public static <T> List<T> randomSelect_imperative(List<T> list, int n) {
        List<T> result = new ArrayList<>();

        Random random = new Random();
        List<T> remaining = list;
        while (result.size() < n) {
            Object[] objects = P20.removeAt0(remaining, random.nextInt(remaining.size()));
            remaining = (List<T>) objects[0];
            T t = (T) objects[1];
            result.add(t);
        }
        return result;
    }


}
