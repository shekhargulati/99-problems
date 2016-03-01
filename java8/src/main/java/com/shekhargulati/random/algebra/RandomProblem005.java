package com.shekhargulati.random.algebra;

/**
 * Write a program that can evaluate a polynomial
 * p(x) = ao + a1x^1 + a2x^2 + .... + anx^n
 * <p>
 * https://en.wikipedia.org/wiki/Horner%27s_method
 */
public class RandomProblem005 {

    public static int evaluatePolynomialAt(int n, int a, int x) {
        int result = a;
        for (int i = 1; i <= n; i++) {
            result = result + Double.valueOf(a * Math.pow(x, i)).intValue();
        }
        return result;
    }

    public static int eval(int n, int a, int x) {
        int res = 0;
        for (int i = n; i >= 0; i--) {
            res = (res * x) + a;
        }
        return res;
    }
}
