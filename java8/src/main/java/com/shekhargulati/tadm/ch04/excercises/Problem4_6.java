package com.shekhargulati.tadm.ch04.excercises;

import java.util.Arrays;

public class Problem4_6 {

    public static boolean findPair(int[] s1, int[] s2, int x) {
        /*
            Sort one array let say s2
            for each el in s1
               do a binary search in s2 for x-el
               if found return el and (x-el)
         */
        Arrays.sort(s2);
        for (int f : s1) {
            int s = x - f;
            if (Arrays.binarySearch(s2, s) >= 0) {
                return true;
            }
        }
        return false;
    }
}
