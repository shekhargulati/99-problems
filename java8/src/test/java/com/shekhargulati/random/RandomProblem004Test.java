package com.shekhargulati.random;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class RandomProblem004Test {

    @Test
    public void sumOfFirst10NumbersIs55() throws Exception {
        int sumOfNNumbers = RandomProblem004.sumOfNNumbers(10);
        assertThat(sumOfNNumbers, equalTo(55));
    }

    @Test
    public void squareOf10Is100() throws Exception {
        int square = RandomProblem004.squareOfANumber(10);
        assertThat(square, equalTo(100));
    }

    @Test
    public void sumOfFirst10NumbersIs55_1() throws Exception {
        int sum = RandomProblem004.sumOfNNumbers1(10);
        assertThat(sum, equalTo(55));

    }
}