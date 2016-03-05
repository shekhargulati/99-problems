package com.shekhargulati.ninetynine_problems._02_arithmetic;

import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class P34Test {

    @Test
    public void shouldGiveAllPrimeNumbersBetween2And10() throws Exception {
        List<Integer> primeNumbers = P34.primeNumbers(IntStream.rangeClosed(2, 10));
        assertThat(primeNumbers, hasSize(4));
        assertThat(primeNumbers, hasItems(2, 3, 5, 7));
    }

    @Test
    public void shouldGiveAllPrimeNumbersBetween7And31() throws Exception {
        List<Integer> primeNumbers = P34.primeNumbers(IntStream.rangeClosed(7, 31));
        assertThat(primeNumbers, hasSize(8));
        assertThat(primeNumbers, hasItems(7, 11, 13, 17, 19, 23, 29, 31));
    }

    @Test
    public void shouldGiveAllPrimeNumbersBetween2And10_sieve() throws Exception {
        List<Integer> primeNumbers = P34.primeNumbers_sieve(2, 10);
        assertThat(primeNumbers, hasSize(4));
        assertThat(primeNumbers, hasItems(2, 3, 5, 7));
    }

    @Test
    public void shouldGiveAllPrimeNumbersBetween7And31_sieve() throws Exception {
        List<Integer> primeNumbers = P34.primeNumbers_sieve(7, 31);
        assertThat(primeNumbers, hasSize(8));
        assertThat(primeNumbers, hasItems(7, 11, 13, 17, 19, 23, 29, 31));
    }
}