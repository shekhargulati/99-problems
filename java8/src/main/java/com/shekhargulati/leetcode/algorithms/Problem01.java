package com.shekhargulati.leetcode.algorithms;

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

    /*
    This solution is O(n)
     */
    public static int[] twoSum(int[] numbers, int target) {
        /*
            Algorithm:
            1. Store all the number and their indexes in a Map
            2. Create a new array with filtering all the numbers less than the target.
            3. Iterate over the filtered array.
            4. For each number find the second number by subtracting it from the target
            5. If Map contains the second number then we have found the pair
            6. Short circuit the loop and return the result.
         */
        Map<Integer, Integer> numberAndIndex = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            numberAndIndex.put(numbers[i], i);
        }

        int[] numbersLessThanTarget = Arrays.stream(numbers).filter(i -> i < target).toArray();

        for (int i = 0; i < numbersLessThanTarget.length - 1; i++) {
            int first = numbersLessThanTarget[i];
            int second = target - first;
            if (numberAndIndex.containsKey(second)) {
                return new int[]{i, numberAndIndex.get(second)};
            }

        }
        return new int[0];
    }

    /*
    Assume array is sorted then you can do it O(n)
     */
    public static int[] twoSum_binarySearch(int[] numbers, int target) {
        /*
        Algorithm:
        1. Iterate over all the numbers and find the second number by subtracting the first from target
        2. Find the second number from the sorted array.
        3. If second number is found then return index of first and second and second else move to the next number.
         */
        for (int i = 0; i < numbers.length; i++) {
            int first = numbers[0];
            if (first < target) {
                int second = target - first;
                int secondElementIndex = Arrays.binarySearch(numbers, second);
                if (secondElementIndex >= 0) {
                    return new int[]{i, secondElementIndex};
                }
            }
        }
        return new int[0];
    }


    /*
    This solution in O(n^2)
     */
    public static int[] twoSum_2(int[] numbers, int target) {
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
