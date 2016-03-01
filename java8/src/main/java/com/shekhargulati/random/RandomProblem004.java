package com.shekhargulati.random;

/**
 * Functions corresponding to loops
 */
public class RandomProblem004 {

    /**
     * f(n) = n*(n+1)/2
     */
    public static int sumOfNNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }


    /**
     * f(n) = n*n
     */
    public static int squareOfANumber(int n) {
        int square = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                square += 1;
            }
        }
        return square;
    }

    /**
     * f(n) = n*(n+1)/2
     */
    public static int sumOfNNumbers1(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                sum += 1;
            }
        }

        return sum;
    }

}
