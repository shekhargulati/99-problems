package com.shekhargulati.tadm.ch04.excercises;

import com.shekhargulati.IntPair;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Problem4_2 {

    public static IntPair maximize_unsorted(int[] numbers) {
        OptionalInt min = IntStream.of(numbers).min();
        OptionalInt max = IntStream.of(numbers).max();
        return new IntPair(min.getAsInt(), max.getAsInt());
    }

    public static IntPair maximize_sorted(int[] numbers) {
        return new IntPair(numbers[0], numbers[numbers.length - 1]);
    }

    public static IntPair minimize_unsorted(int[] numbers) {
        int[] sorted = IntStream.of(numbers).sorted().toArray();
        return minimize_sorted(sorted);
    }

    public static IntPair minimize_sorted(int[] sorted) {
        int diff = sorted[1] - sorted[0];
        IntPair pair = null;
        for (int i = 1; i < sorted.length - 1; i++) {
            int first = sorted[i];
            int second = sorted[i + 1];
            if (diff > (second - first)) {
                diff = second - first;
                pair = new IntPair(first, second);
            }
        }
        return pair;
    }

}
