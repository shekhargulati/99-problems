package com.shekhargulati.ninetynine_problems._02_arithmetic;

/**
 * (**) Calculate Euler's totient function phi(m) (2).
 */
public class P40 {

    public static int phi(int m) {
        return P33.primeFactorsMult(m)
                .stream()
                .map(entry -> (entry.getKey() - 1) * Math.pow(entry.getKey(), entry.getValue() - 1))
                .mapToInt(Double::intValue)
                .reduce(1, (i1, i2) -> i1 * i2);
    }
}
