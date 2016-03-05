package com.shekhargulati.ninetynine_problems._02_arithmetic;

import java.util.stream.IntStream;

/**
 * (**) Calculate Euler's totient function phi(m).
 */
public class P39 {

    public static long phi(int m) {
        return IntStream.rangeClosed(1, m).filter(r -> P38.coprime(r, m)).count();
    }
}
