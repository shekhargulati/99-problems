package com.shekhargulati.random;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class RandomProblem003Test {

    @Test
    public void performMatrixMultiplicationOfTwoArrays() throws Exception {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] b = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        int[][] result = {
                {58, 64},
                {139, 154}
        };

        int[][] c = RandomProblem003.matrixMultiplication(a, b);
        assertThat(c, equalTo(result));
    }
}