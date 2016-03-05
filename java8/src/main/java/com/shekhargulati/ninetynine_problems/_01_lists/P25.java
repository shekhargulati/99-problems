package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.List;

/**
 * (*) Generate a random permutation of the elements of a list.
 */
public class P25 {

    public static <T> List<T> randomPermutation(List<T> list) {
        return P23.randomSelectR(list, list.size());
    }
}
