package com.shekhargulati.ninetynine_problems._02_arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * (*) A list of prime numbers.
 */
public class P34 {

    public static List<Integer> primeNumbers(IntStream range) {
        return range.filter(P31::isPrime).boxed().collect(Collectors.toList());
    }

    public static List<Integer> primeNumbers_sieve(final int start, final int end) {
        boolean[] primes = new boolean[end + 1];
        Arrays.fill(primes, true);
        for (int i = 2; i < primes.length; i++) {
            for (int j = i + 1; j < primes.length; j++) {
                primes[j] = !primes[j] || j % i == 0 ? false : true;
            }
        }

        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = start; i < primes.length; i++) {
            if (primes[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }


}
