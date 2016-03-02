package com.shekhargulati.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */
public class Problem01 {

    public static int[] twoSum(int[] numbers, int target) {
        /*
            Algorithm:
            1. Create a new array with filtering all the numbers less than the target.
            2. Iterate over the filtered array to find a pair which sum equal to target
         */
        int[] numbersLessThanTarget = Arrays.stream(numbers).filter(i -> i < target).toArray();

        for (int i = 0; i < numbersLessThanTarget.length - 1; i++) {
            for (int j = i + 1; j < numbersLessThanTarget.length; j++) {
                if ((numbersLessThanTarget[i] + numbersLessThanTarget[j]) == target) {
                    return new int[]{numbersLessThanTarget[i], numbersLessThanTarget[j]};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoSumIndexes(int[] numbers, int target) {
        /*
            Algorithm:
            1. Create a new array with filtering all the numbers less than the target.
            2. Iterate over the filtered array to find a pair which sum equal to target
         */

        Map<Integer, Integer> numberAndIndex = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            numberAndIndex.put(numbers[i], i);
        }

        int[] numbersLessThanTarget = Arrays.stream(numbers).filter(i -> i < target).toArray();

        for (int i = 0; i < numbersLessThanTarget.length - 1; i++) {
            for (int j = i + 1; j < numbersLessThanTarget.length; j++) {
                if ((numbersLessThanTarget[i] + numbersLessThanTarget[j]) == target) {
                    return new int[]{numberAndIndex.get(numbersLessThanTarget[i]), numberAndIndex.get(numbersLessThanTarget[j])};
                }
            }
        }
        return new int[0];
    }
}
