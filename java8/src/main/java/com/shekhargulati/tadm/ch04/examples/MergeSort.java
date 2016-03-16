package com.shekhargulati.tadm.ch04.examples;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{3, 2, 1, 4})));
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int middle = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, middle));
        int[] right = mergeSort(Arrays.copyOfRange(arr, middle, arr.length));
        return merge(left, right, arr.length);
    }

    private static int[] merge(int[] left, int[] right, int length) {
        int[] sorted = new int[length];
        int[] smaller = ((left.length < right.length) ? left : right);
        for (int i = 0; i < smaller.length; i++) {
            if (left[i] <= right[i]) {
                sorted[i] = left[i];
            } else {
                sorted[i] = right[i];
            }
        }
        int[] greater = ((left.length > right.length) ? left : right);
        for (int i = smaller.length; i < greater.length; i++) {
            sorted[i] = greater[i];
        }
        return sorted;
    }
}
