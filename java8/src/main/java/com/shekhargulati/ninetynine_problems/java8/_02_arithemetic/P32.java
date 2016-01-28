package com.shekhargulati.ninetynine_problems.java8._02_arithemetic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * (**) Determine the prime factors of a given positive integer.
 */
public class P32 {

    public static List<Integer> primeFactors(int number) {
        List<Integer> fs = new ArrayList<>();
        IntStream.rangeClosed(2, number / 2).filter(P31::isPrime).forEach(f -> {
            int n = number;
            while (n % f == 0) {
                n = n / f;
                fs.add(f);
            }
        });
        return fs;
    }
}
