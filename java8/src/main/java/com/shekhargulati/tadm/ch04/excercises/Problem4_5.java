package com.shekhargulati.tadm.ch04.excercises;

import java.util.Arrays;

public class Problem4_5 {

    public static int mode(int[] numbers) {
        Arrays.sort(numbers);
        int modeCount = 0;
        int mode = 0;
        int prev = numbers[0];
        int currentCount = 0;
        for (int i = 1; i < numbers.length; i++) {
            int cur = numbers[i];
            if (prev == cur) {
                currentCount++;
            } else {
                if (currentCount > modeCount) {
                    modeCount = currentCount;
                    mode = prev;
                }
                prev = cur;
                currentCount = 0;
            }
        }
        return mode;
    }
}
