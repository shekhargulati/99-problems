package com.shekhargulati.ninetynine_problems._02_arithmetic;

/**
 * (**) Determine the greatest common divisor of two positive integer numbers.
 */
public class P37 {

    public static int gcd(int first, int second) {
        if (first == 0) {
            return second;
        } else if (second == 0) {
            return first;
        } else if (first > second) {
            return gcd(first - second, second);
        } else {
            return gcd(first, second - first);
        }

    }
}
