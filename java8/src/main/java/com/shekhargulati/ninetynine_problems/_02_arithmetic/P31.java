package com.shekhargulati.ninetynine_problems._02_arithmetic;

import java.util.stream.LongStream;

/**
 * (**) Determine whether a given integer number is prime.
 */
public class P31 {

    public static boolean isPrime(long number) {
        return !LongStream.rangeClosed(2, Math.round(Math.sqrt(number))).anyMatch(n -> number % n == 0);
    }
}
