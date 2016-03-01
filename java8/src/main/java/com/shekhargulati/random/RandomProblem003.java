package com.shekhargulati.random;

/**
 * Perform matrix multiplication of two arrays.
 * Matrix multiplication of array A of size nxm and array B of size mxp is an array of size nxp
 */
public class RandomProblem003 {

    public static int[][] matrixMultiplication(int[][] a, int[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Can't perform matrix calculation on matrix with given sizes");
        }
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                int fValue = 0;
                for (int k = 0; k < colsA; k++) {
                    fValue += a[i][k] * b[k][j];
                }
                result[i][j] = fValue;
            }
        }
        return result;
    }
}
