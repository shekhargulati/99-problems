package com.shekhargulati.ninetynine_problems._02_arithmetic;

import org.junit.Test;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class P33Test {

    @Test
    public void shouldFindPrimeFactorsOf315() throws Exception {
        List<SimpleEntry<Integer, Integer>> primeFactors = P33.primeFactorsMult(315);
        assertThat(primeFactors, hasItems(new SimpleEntry<>(3, 2), new SimpleEntry<>(5, 1), new SimpleEntry<>(7, 1)));
    }

    @Test
    public void shouldFindPrimeFactorsOf33() throws Exception {
        List<SimpleEntry<Integer, Integer>> primeFactors = P33.primeFactorsMult(33);
        assertThat(primeFactors, hasItems(new SimpleEntry<>(3, 1), new SimpleEntry<>(11, 1)));
    }
}