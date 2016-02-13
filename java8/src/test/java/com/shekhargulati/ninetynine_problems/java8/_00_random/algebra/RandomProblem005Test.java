package com.shekhargulati.ninetynine_problems.java8._00_random.algebra;

import org.junit.Test;

public class RandomProblem005Test {

    @Test
    public void shouldEvaluateAPolynomial() throws Exception {
        System.out.println(RandomProblem005.eval(10, 5, 2));
        System.out.println(RandomProblem005.evaluatePolynomialAt(10, 5, 2));
    }
}