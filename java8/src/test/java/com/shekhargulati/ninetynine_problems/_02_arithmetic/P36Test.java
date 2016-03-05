package com.shekhargulati.ninetynine_problems._02_arithmetic;

import org.junit.Test;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class P36Test {

    @Test
    public void shouldProduceAListOfGoldbachCompositions() throws Exception {
        List<SimpleEntry<Integer, List<Integer>>> compositions = P36.goldbach_list(IntStream.rangeClosed(9, 20));
        assertThat(compositions, hasSize(6));
        assertThat(compositions, hasItems(
                new SimpleEntry<>(10, Arrays.asList(3, 7)),
                new SimpleEntry<>(12, Arrays.asList(5, 7)),
                new SimpleEntry<>(14, Arrays.asList(3, 11)),
                new SimpleEntry<>(16, Arrays.asList(3, 13)),
                new SimpleEntry<>(18, Arrays.asList(5, 13)),
                new SimpleEntry<>(20, Arrays.asList(3, 17))
        ));
    }

    @Test
    public void shouldProduceAListOfGoldbachCompositionsWhereBothPrimeNumbersAreGreaterThan50() throws Exception {
        List<SimpleEntry<Integer, List<Integer>>> compositions = P36.goldbach_list1(IntStream.rangeClosed(1, 2000), 50);
        assertThat(compositions, hasSize(4));
        assertThat(compositions, hasItems(
                new SimpleEntry<>(992, Arrays.asList(73, 919)),
                new SimpleEntry<>(1382, Arrays.asList(61, 1321)),
                new SimpleEntry<>(1856, Arrays.asList(67, 1789)),
                new SimpleEntry<>(1928, Arrays.asList(61, 1867))
        ));
    }
}