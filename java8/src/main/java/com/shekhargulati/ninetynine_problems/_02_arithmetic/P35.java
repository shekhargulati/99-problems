package com.shekhargulati.ninetynine_problems._02_arithmetic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * (**) Goldbach's conjecture
 * <p>
 * Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers.
 * Example: 28 = 5 + 23. It is one of the most famous facts in number theory that has not been proved to be correct
 * in the general case. It has been numerically confirmed up to very large numbers.
 * Write a predicate to find the two prime numbers that sum up to a given even integer.
 */
public class P35 {

    public static List<Integer> goldbach(int number) {
        if (number == 2) {
            return Collections.emptyList();
        } else if (number % 2 != 0) {
            return Collections.emptyList();
        }

        List<Integer> primeNumbers = P34.primeNumbers(IntStream.rangeClosed(2, number));
        for (Integer primeNumber : primeNumbers) {
            if (primeNumbers.contains(number - primeNumber)) {
                return Arrays.asList(primeNumber, number - primeNumber);
            }
        }
        throw new RuntimeException("Should not have happened!!");
    }

}
