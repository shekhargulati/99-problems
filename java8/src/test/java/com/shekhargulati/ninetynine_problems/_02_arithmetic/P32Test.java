package com.shekhargulati.ninetynine_problems._02_arithmetic;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class P32Test {

    @Test
    public void shouldFindPrimeFactorsOf315() throws Exception {
        List<Integer> primeFactors = P32.primeFactors(315);
        assertThat(primeFactors, hasItems(3, 3, 5, 7));
    }

    @Test
    public void shouldFindPrimeFactorsOf33() throws Exception {
        List<Integer> primeFactors = P32.primeFactors(33);
        assertThat(primeFactors, hasItems(3, 11));
    }
}