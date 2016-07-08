package com.shekhargulati.tadm.ch04.examples;

public class SelectionSort {

    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = findMinIndex(arr, i);
            swap(arr, i, min);
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int min) {
        int tmp = arr[i];
        arr[i] = arr[min];
        arr[min] = tmp;
    }

    private static int findMinIndex(int[] arr, int i) {
        int min = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[min]) {
                min = j;
            }
        }
        return min;
    }
}
