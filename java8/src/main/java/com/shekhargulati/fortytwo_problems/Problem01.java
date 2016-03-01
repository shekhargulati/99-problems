package com.shekhargulati.fortytwo_problems;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Taken an input a sequence of 2n real numbers.
 * Design an O(nlogn) algorithm that partitions the numbers into n pairs,
 * with the property that the partition minimizes the sum of maximum sum of a pair.
 */
public class Problem01 {

    public static List<SimpleEntry<Integer, Integer>> pairs(int[] numbers) {
        /*
        Algorithm:
        1. Sort the numbers
        2. Iterate over half the list and put first number and last in a pair

        Other algorithm feasible
        1. Sort numbers
        2. Create reverse numbers
        3. Take first half of zip of numbers and reverse
        let l = sort [1,9,5,3]
        let r = reverse l
        take (length l `div` 2) (zip l r)
         */
        Arrays.sort(numbers);
        List<SimpleEntry<Integer, Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < numbers.length / 2; i++) {
            pairs.add(new SimpleEntry<>(numbers[i], numbers[(numbers.length - i) - 1]));
        }
        return pairs;
    }
}
