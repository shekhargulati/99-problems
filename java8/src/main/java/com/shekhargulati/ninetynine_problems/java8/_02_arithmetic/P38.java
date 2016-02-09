package com.shekhargulati.ninetynine_problems.java8._02_arithmetic;

/**
 * (*) Determine whether two positive integer numbers are coprime.
 */
public class P38 {

    public static boolean coprime(int first, int second) {
        return P37.gcd(first, second) == 1;
    }
}
